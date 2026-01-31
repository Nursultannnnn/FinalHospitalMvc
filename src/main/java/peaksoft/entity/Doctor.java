package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctor_gen")
    @SequenceGenerator(name = "doctor_gen", sequenceName = "doctor_seq", allocationSize = 1)
    Long id;

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;

    @Column(nullable = false)
    String position;

    @Column(unique = true, nullable = false) // Уникальный email
    String email;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinTable( // Для ManyToMany лучше явно указать таблицу связи
            name = "doctors_departments",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id")
    )
    List<Department> departments;

    @OneToMany(mappedBy = "doctor", cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    List<Appointment> appointments;

    // ВАЖНО: Связь с больницей
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "hospital_id")
    Hospital hospital;
}