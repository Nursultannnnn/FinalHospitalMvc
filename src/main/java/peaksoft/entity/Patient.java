package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import peaksoft.enums.Gender;

import java.util.List;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_gen")
    @SequenceGenerator(name = "patient_gen", sequenceName = "patient_seq", allocationSize = 1)
    Long id;

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;

    @Column(name = "phone_number", nullable = false)
    String phoneNumber;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @Column(unique = true, nullable = false) // Email тоже желательно уникальный
    String email;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "hospital_id")
    Hospital hospital;

    @OneToMany(mappedBy = "patient", cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
    List<Appointment> appointments;
}