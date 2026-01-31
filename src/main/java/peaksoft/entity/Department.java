package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "departments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_gen")
    @SequenceGenerator(name = "department_gen", sequenceName = "department_seq", allocationSize = 1)
    Long id; // Лучше использовать Long id, а не String name как ID, но генератор у тебя настроен. Давай сделаем стандартно id.

    @Column(unique = true, nullable = false) // Уникальное имя + не null
    String name;

    @ManyToMany(mappedBy = "departments", cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    List<Doctor> doctors;

    // ВАЖНО: Связь с больницей
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "hospital_id") // Имя колонки в базе
            Hospital hospital;
}