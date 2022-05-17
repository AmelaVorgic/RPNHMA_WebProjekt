package com.rpnhma.rpnhma_webApplication.dto.DtoConverter;

import com.rpnhma.rpnhma_webApplication.dto.CommentDto;
import com.rpnhma.rpnhma_webApplication.dto.PostDto;
import com.rpnhma.rpnhma_webApplication.dto.UserDto;
import com.rpnhma.rpnhma_webApplication.model.Comment;
import com.rpnhma.rpnhma_webApplication.model.Post;
import com.rpnhma.rpnhma_webApplication.model.User;

public final class ToDtoConverter {

    public static CommentDto commentToDto(final Comment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getContent(),
                comment.getDateTimeOfComment(),
                comment.getUser(),
                comment.getPost()
        );
    }

    public static PostDto postToDto(final Post post) {
        return new PostDto(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getDateTimeOfPost(),
                post.getImageUrl(),
                post.getCategories(),
                post.getRatingPoints(),
                userToDto(post.getUser())
        );
    }

    public static UserDto userToDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getIsActive(),
                user.getAvatarUrl(),
                user.getDateOfSignUp(),
                user.getRoles()
        );
    }

}