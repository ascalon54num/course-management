package fr.idmc.sid.coursesmanagement.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "SESSION",schema = "COURSESMANAGEMENT")
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class Session {
    @Nullable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @Nullable
    @ManyToMany
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private List<Room> rooms;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

}
