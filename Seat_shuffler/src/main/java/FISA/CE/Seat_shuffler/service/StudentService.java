package FISA.CE.Seat_shuffler.service;

import FISA.CE.Seat_shuffler.entity.Student;
import FISA.CE.Seat_shuffler.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

}
