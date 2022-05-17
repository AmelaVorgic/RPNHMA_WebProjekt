package com.rpnhma.rpnhma_webApplication.repositpry;

import com.rpnhma.rpnhma_webApplication.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Collection<Comment> findByPost_Id(final Long postId);
}
