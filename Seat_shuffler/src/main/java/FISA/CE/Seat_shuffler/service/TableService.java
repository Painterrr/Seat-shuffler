package FISA.CE.Seat_shuffler.service;

import FISA.CE.Seat_shuffler.entity.Student;
import FISA.CE.Seat_shuffler.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {
    @Autowired
    private StudentService studentService;

    public Student[][] create(int row, int col) {
        Student[][] table = new Student[row][col];
        List<Student> students = (List<Student>) studentService.getAllStudents();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int index = i * col + j;
                if (index < students.size()) {
                    table[i][j] = students.get(index);
                }
            }


        }
        return table;
    }

}

