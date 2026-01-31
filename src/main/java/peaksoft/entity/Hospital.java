package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "hospitals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Hospital {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "appointment_gen"
    )
    @SequenceGenerator(
            name = "appointment_gen",
            sequenceName = "appointment_seq",
            allocationSize = 1
    )
    Long id;
    String name;
    String address;
    @OneToMany(mappedBy = "hospital", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    List<Doctor> doctors;
    @OneToMany(mappedBy = "hospital", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    List<Patient> patients;
    @OneToMany(mappedBy = "hospital", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    List<Department> departments;
    @OneToMany(mappedBy = "hospital", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    List<Appointment> appointments;

}
