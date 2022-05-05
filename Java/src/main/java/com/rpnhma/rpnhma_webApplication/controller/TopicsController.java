package com.rpnhma.rpnhma_webApplication.controller;


import com.rpnhma.rpnhma_webApplication.model.Topic;
import com.rpnhma.rpnhma_webApplication.repositpry.AnswerRepository;
import com.rpnhma.rpnhma_webApplication.repositpry.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TopicsController {

    private final TopicRepository topicRepository;
    private final AnswerRepository answerRepository;



    @GetMapping("topics")
    public String displayAllTopics(Model model) {


        List<Topic> topics = topicRepository.findAll();
        String header = setHeader("all");
        model.addAttribute("topics", topics);
        model.addAttribute("header", header);
        model.addAttribute("answerRepository", answerRepository);
        return "topics";
    }

    @GetMapping("topics/{category}")
    public String displayTopicsByCategory(@PathVariable String category, Model model) {
        List<Topic> topics = topicRepository.findTopicsByCategoryOrderByCreatedDateDesc(category);
        String header = setHeader(category);
        model.addAttribute("topics", topics);
        model.addAttribute("header", header);
        model.addAttribute("answerRepository", answerRepository);
        return "topics";
    }

    @GetMapping("topics/user/{id}")
    public String displayTopicsByUser(@PathVariable String id, Model model) {
        List<Topic> topics = topicRepository.findTopicsByUser_IdOrderByCreatedDateDesc(Long.valueOf(id));
        String header = setHeader("user");
        model.addAttribute("topics", topics);
        model.addAttribute("header", header);
        model.addAttribute("answerRepository", answerRepository);
        return "topics";
    }

    private String setHeader(String category) {
        switch (category) {
            case "all":
                return "All topics";
            default:
                return "User's topics";
        }
    }
}