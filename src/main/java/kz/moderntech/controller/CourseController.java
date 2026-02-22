package kz.moderntech.controller;

import kz.moderntech.model.Course;
import kz.moderntech.model.Lesson;
import kz.moderntech.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public void createCourse(@RequestBody Course course) {
        courseService.createCourse(course);
    }

    @PostMapping("/{courseId}/lessons")
    public void createLesson(@PathVariable int courseId, @RequestBody Lesson lesson) {
        courseService.addLesson(courseId, lesson);
    }

    @GetMapping("/{courseId}")
    public Course getCourse(@PathVariable long courseId) {
        return courseService.getCourseById(courseId);
    }

}
