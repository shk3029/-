package me.js.springjpaprojectdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;

    @Test
    public void crud() {
   /*     Comment comment = new Comment();
        comment.setComment("Hello Comment");
        commentRepository.save(comment);

        List<Comment> all = commentRepository.findAll();
*//*
        Optional<Comment> byId =  commentRepository.findById(100l);
        assertThat(byId).isEmpty();
        Comment comment = byId.orElseThrow(IllegalAccessError::new);*/

        Comment comment = new Comment();
        comment.setComment("spring data jpa");
        commentRepository.save(comment);

        List<Comment> comments = commentRepository.findByCommentContains("spring");
        assertThat(comments.size()).isEqualTo(1);
    }

}