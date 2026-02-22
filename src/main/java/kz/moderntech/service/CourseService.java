package kz.moderntech.service;

import kz.moderntech.model.Course;
import kz.moderntech.model.Lesson;
import kz.moderntech.repository.CourseRepository;
import kz.moderntech.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final LessonRepository lessonRepository;

    @Transactional
    public void createCourse(Course course) {
        courseRepository.save(course);
        var lessons = course.getLessons();
        lessons.forEach(lesson -> lesson.setCourse(course));
        lessonRepository.saveAll(lessons);
    }

    public void addLesson(long courseId, Lesson lesson) {
        var course = courseRepository.findById(courseId).orElseThrow();
        lesson.setCourse(course);
        lessonRepository.save(lesson);
    }

    public Course getCourseById(long courseId) {
        return courseRepository.findById(courseId).orElse(null);
    }

}
