package kz.moderntech.controller;

import jakarta.validation.constraints.NotBlank;
import kz.moderntech.controller.base.BaseController;
import kz.moderntech.model.Comment;
import kz.moderntech.repository.CommentRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
@Validated
public class CommentController extends BaseController<Comment, Long> {

    private final CommentRepository commentRepository;

    public CommentController(CommentRepository repository) {
        super(repository);
        this.commentRepository = repository;
    }

    @PatchMapping("/update-text/{id}/{text}")
    public void updateTextById(@PathVariable long id, @PathVariable @NotBlank String text) {
        var comment = super.findById(id);
        comment.setText(text);
        commentRepository.save(comment);
    }

}