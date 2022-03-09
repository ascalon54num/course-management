package fr.idmc.sid.coursesmanagement.services;

import fr.idmc.sid.coursesmanagement.entities.Person;
import fr.idmc.sid.coursesmanagement.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonsService {
    private final PersonRepository repo;

    public Person findByIdentifiant(String name){
        return repo.findByIdentifiant(name);
    }
}
