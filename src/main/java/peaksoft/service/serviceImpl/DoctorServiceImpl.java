package peaksoft.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Doctor;
import peaksoft.repo.DoctorRepo;
import peaksoft.service.DoctorService;

import java.util.List;
@Service//add this annotation
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepo doctorRepo;
    @Override
    public void saveDoctor(Doctor doctor) {

    }

    @Override
    public List<Doctor> getAllDoctors() {
        return null;
    }

    @Override
    public Doctor getById(Long id) {
        return null;
    }

    @Override
    public void updateDoctor(Long id, Doctor newDoctor) {

    }

    @Override
    public void deleteDoctor(Long id) {

    }
}
