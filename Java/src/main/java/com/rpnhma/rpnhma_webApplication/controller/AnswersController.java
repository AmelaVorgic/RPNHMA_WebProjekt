package com.rpnhma.rpnhma_webApplication.controller;

import com.rpnhma.rpnhma_webApplication.model.Answer;
import com.rpnhma.rpnhma_webApplication.repositpry.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class AnswersController {

    private final AnswerRepository answerRepository;



    @GetMapping("answers/{id}")
    public String displayAnswersByUser(@PathVariable String id, Model model) {
        List<Answer> answers = answerRepository.findAnswerByUser_IdOrderByCreatedDateDesc(Long.parseLong(id));
        model.addAttribute("answers", answers);
        return "answers";
    }

    @GetMapping("answers/useful/{id}")
    public String displayUsefulAnswersByUser(@PathVariable String id, Model model) {
        List<Answer> answers = answerRepository.findAnswerByUser_IdAndUsefulOrderByCreatedDateDesc(Long.parseLong(id), true);
        model.addAttribute("answers", answers);
        return "answers";
    }
}
