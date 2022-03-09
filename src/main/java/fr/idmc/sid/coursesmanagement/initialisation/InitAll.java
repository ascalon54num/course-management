package fr.idmc.sid.coursesmanagement.initialisation;

import fr.idmc.sid.coursesmanagement.courses.domain.entity.Classroom;
import fr.idmc.sid.coursesmanagement.courses.domain.entity.Professor;
import fr.idmc.sid.coursesmanagement.courses.domain.entity.Student;
import fr.idmc.sid.coursesmanagement.courses.infra.hibernate.ClassroomRepository;
import fr.idmc.sid.coursesmanagement.courses.infra.hibernate.ProfessorRepository;
import fr.idmc.sid.coursesmanagement.courses.infra.hibernate.StudentRepository;
import fr.idmc.sid.coursesmanagement.entities.*;
import fr.idmc.sid.coursesmanagement.repositories.PersonRepository;
import fr.idmc.sid.coursesmanagement.repositories.RoleRepository;
import fr.idmc.sid.coursesmanagement.repositories.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class InitAll {
    Logger logger = LoggerFactory.getLogger(InitAll.class);
    final RoomRepository classroomRepository;
    final PersonRepository personRepository;
    final RoleRepository roleRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initialisation() {
        final Role student = new Role().setLibelle("student");
        final Role teacher = new Role().setLibelle("teacher");
        final Building b = new Building().setNom("principal").setAdresse("13 rue Michel Neil");
        final Room r1 = new Room().setNumero("227").setBuilding(b);
        final Room r2 = new Room().setNumero("228").setBuilding(b);
        final Training t = new Training().setLibelle("DUT");
        Person teach = new Person().setIdentifiant("user");
        Session s1 =new Session().setRooms(new ArrayList<>(){{ add(r1);}}).setStartDate(LocalDateTime.of(LocalDate.of(2022,02,12), LocalTime.of(8,00,00)));
        Course course = new Course().setLabel("math").setSessions(new ArrayList<>(){
            {add(s1);}
        }).setTraining(t).setTeachers(new ArrayList<>(){{add(teach);}});
        Person s = new Person().setCourses(new ArrayList<>(){{add(course);}});


        logger.info("Initialisation des données terminée");
    }
}
