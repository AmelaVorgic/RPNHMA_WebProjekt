package com.rpnhma.rpnhma_webApplication.dto;

import com.rpnhma.rpnhma_webApplication.commons.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
public class PostDto {
    private Long id;

    private String title;

    private String content;

    private LocalDateTime dateTimeOfPost;

    private String imageUrl;

    private Collection<Category> categories;

    private Integer ratingPoints;

    private UserDto user;
}
