package fr.idmc.sid.coursesmanagement.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "ROLE",schema = "COURSESMANAGEMENT")
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class Role {
    @Nullable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String libelle;
}
