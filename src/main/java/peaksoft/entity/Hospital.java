package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Set;

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
            generator = "hospital_gen"
    )
    @SequenceGenerator(
            name = "hospital_gen",
            sequenceName = "hospital_seq",
            allocationSize = 1
    )
    Long id;
    String name;
    String address;
    @OneToMany(mappedBy = "hospital", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    Set<Doctor> doctors;
    @OneToMany(mappedBy = "hospital", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    Set<Patient> patients;
    @OneToMany(mappedBy = "hospital", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    List<Department> departments;
    @OneToMany(mappedBy = "hospital", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    List<Appointment> appointments;

}
