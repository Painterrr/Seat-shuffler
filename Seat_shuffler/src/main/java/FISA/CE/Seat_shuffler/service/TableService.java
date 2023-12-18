package FISA.CE.Seat_shuffler.service;

import FISA.CE.Seat_shuffler.entity.Student;
import FISA.CE.Seat_shuffler.entity.UnavailableSeat;
import FISA.CE.Seat_shuffler.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;

@Service
public class TableService {
    @Autowired
    private StudentRepository studentRepository;

    public Student[][] table = null;

    public Student[][] createTable(int row, int col) {
        table = new Student[row][col];

        return table;
    }

    public void setUnavailableSeat(int row, int col){
        UnavailableSeat unavailableSeat = new UnavailableSeat();
        if (table != null && row < table.length && col < table[row].length) {
            table[row][col] = unavailableSeat;
        } else {
            throw new ArrayIndexOutOfBoundsException("유효하지 않은 행 또는 열입니다.");
        }
    }

    @Transactional
    public void setFixedSeat(int row, int col, long id){
        Student fixedStudent = new Student();
        if (table != null && row < table.length && col < table[row].length) {
            table[row][col] = studentRepository.findOne(id);
        } else {
            throw new ArrayIndexOutOfBoundsException("유효하지 않은 행 또는 열입니다.");
        }
    }
}

