package fr.idmc.sid.coursesmanagement.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COURSE",schema = "COURSESMANAGEMENT")
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class Course {
    @Nullable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String label;
    @Nullable
    @ManyToMany
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private List<Person> teachers;

    @Nullable
    @OneToMany
    @JoinColumn(name = "session_id", referencedColumnName = "id")
    private List<Session>  sessions;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "training_id", referencedColumnName = "id")
    private Training training;
}
