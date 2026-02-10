package kz.moderntech.controller;

import kz.moderntech.controller.base.BaseController;
import kz.moderntech.model.Task;
import kz.moderntech.repository.TaskRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todo")
@Validated
public class TodoController extends BaseController<Task, Long> {

    private final TaskRepository taskRepository;

    public TodoController(TaskRepository repository) {
        super(repository);
        this.taskRepository = repository;
    }

    @GetMapping("/find-unfinished-tasks")
    public List<Task> findUnfinishedTasks() {
        return taskRepository.findTasksByCompletedIsFalse();
    }

}
