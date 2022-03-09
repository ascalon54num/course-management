package fr.idmc.sid.coursesmanagement.services;

import fr.idmc.sid.coursesmanagement.entities.Course;
import fr.idmc.sid.coursesmanagement.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoursesService {
    private final CourseRepository courseRepository;

    private Optional<Course> findById(Long id){
        return courseRepository.findById(id);
    }
}
