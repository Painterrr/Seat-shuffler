package FISA.CE.Seat_shuffler.service;

import FISA.CE.Seat_shuffler.entity.FixedStudent;
import FISA.CE.Seat_shuffler.entity.People;
import FISA.CE.Seat_shuffler.entity.UnavailableSeat;
import FISA.CE.Seat_shuffler.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;

@Service
public class TableService {
    @Autowired
    private StudentRepository studentRepository;

    public People[][] table = null;

    public People[][] createTable(int row, int col) {
        table = new People[row][col];

        return table;
    }

    public void setUnavailableSeat(int row, int col, Integer id, String name){
        UnavailableSeat unavailableSeat = new UnavailableSeat(id, name);
        table[row][col] = unavailableSeat;
    }

    @Transactional
    public void setFixedSeat(int row, int col, Integer id, String name){
        FixedStudent fixedStudent = new FixedStudent(id, name);
        if (table != null && row < table.length && col < table[row].length) {
            table[row][col] = fixedStudent;
            studentRepository.deleteById(id);
        } else {
            throw new ArrayIndexOutOfBoundsException("유효하지 않은 행 또는 열입니다.");
        }
    }
}

