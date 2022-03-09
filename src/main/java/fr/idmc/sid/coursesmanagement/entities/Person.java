package fr.idmc.sid.coursesmanagement.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PERSON",schema = "COURSESMANAGEMENT")
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class Person {
    @Nullable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String identifiant;
    private String lastname;
    private String firstname;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "training_id", referencedColumnName = "id")
    private Training training;

    @Nullable
    @ManyToMany
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private List<Course> courses;

}
