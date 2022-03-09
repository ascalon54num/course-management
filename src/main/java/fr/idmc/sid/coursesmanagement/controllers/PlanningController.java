package fr.idmc.sid.coursesmanagement.controllers;

import fr.idmc.sid.coursesmanagement.entities.Course;
import fr.idmc.sid.coursesmanagement.entities.Form;
import fr.idmc.sid.coursesmanagement.entities.Session;
import fr.idmc.sid.coursesmanagement.repositories.CourseRepository;
import fr.idmc.sid.coursesmanagement.services.PersonsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.security.Principal;
import java.util.List;

@RestController
// https://www.freecodecamp.org/news/rest-api-best-practices-rest-endpoint-design-examples/
@RequestMapping("planning")
@RequiredArgsConstructor
public class PlanningController {
    private final PersonsService pservice;

    @GetMapping
    public ResponseEntity<?> findPlanning(Principal principal, @RequestBody Form form) {
        List<Course> courses = pservice.findByName(principal.getName()).getCourses();
        List<Session> coursesFiltered = null;
        for (Course c: courses) {
            int i = 0;
            boolean found = false;
            List<Session> sessions = c.getSessions();
            while(i < sessions.size() && !found){
                if(form.getDateStart() != null && sessions.get(i).getStartDate().equals(form.getDateStart())){
                    found = true;
                    coursesFiltered.add(sessions.get(i));
                } else {
                    i++;
                }
            }
        }
        return ResponseEntity.ok(coursesFiltered);
    }

}
