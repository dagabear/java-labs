package kz.moderntech.controller;

import kz.moderntech.controller.base.BaseController;
import kz.moderntech.model.News;
import kz.moderntech.repository.NewsRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
@Validated
public class NewsController extends BaseController<News, Long> {

    private final NewsRepository newsRepository;

    public NewsController(NewsRepository repository) {
        super(repository);
        this.newsRepository = repository;
    }

    @GetMapping("/published")
    public List<News> getPublished() {
        return newsRepository.findNewsByPublishedIsTrue();
    }

}
