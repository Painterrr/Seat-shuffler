package FISA.CE.Seat_shuffler.service;

import FISA.CE.Seat_shuffler.entity.Student;
import FISA.CE.Seat_shuffler.entity.UnavailableSeat;
import FISA.CE.Seat_shuffler.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

@Service
public class TableService {
    @Autowired
    private StudentRepository studentRepository;

    private UnavailableSeat unavailableSeat = new UnavailableSeat("X");

    public Student[][] table = null;

    public ArrayList<Student> students = new ArrayList<>();

    @Transactional
    public ArrayList<Student> initialize() {
        try {
            students = new ArrayList<>(studentRepository.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public Student[][] createTable(int row, int col) {
        table = new Student[row][col];
        students = initialize();
        return table;
    }

    public void setUnavailableSeat(int row, int col){
        if (table != null && row < table.length && col < table[row].length) {
            table[row][col] = unavailableSeat;
        } else {
            throw new ArrayIndexOutOfBoundsException("유효하지 않은 행 또는 열입니다.");
        }
    }

    /*
    @author 권성준, 이대원, 장지은
    @date 2023-12-23
    @parameter int row, int col, long id
    @description : 고정석 자리 배정
    @return
    */
    @Transactional
    public void setFixedSeat(int row, int col, long id) throws Exception {
        Student fixedStudent = new Student();
        if (table != null && row < table.length && col < table[row].length) {
            if (table[row][col] == null) {
                fixedStudent = studentRepository.findOne(id);
                table[row][col] = fixedStudent;

                int targetId = 0;
                for(int i = 0; i < students.size(); i++) {
                    if(students.get(i).getId() == id) {
                        targetId = i;
                        break;
                    }
                }

                students.remove(targetId);
                System.out.println(fixedStudent.getId());
                System.out.println(students);
            } else {
                throw new Exception("해당 좌석은 지정 불가합니다.");
            }
        } else {
            throw new ArrayIndexOutOfBoundsException("유효하지 않은 행 또는 열입니다.");
        }
    }

    /*
    @author 장지은
    @date 2023-12-23
    @parameter
    @description : ArrayList Student 셔플
    @return ArrayList<Student>
    */
    public ArrayList shuffleStudent() throws Exception{
        if(students != null) {
            Collections.shuffle(students);
            return students;
        }else {
            throw new Exception("학생들이 존재하지 않습니다.");
        }
    }

    /*
    @author 이대원, 장지은
    @date 2023-12-23
    @parameter List studentList
    @description : Student ArrayList를 table인 Student[][]에 삽입
    @return Student[][]
    */
    public Student[][] setTable(List studentList) throws Exception{
        int count = 0;
        ListIterator<Student> iterator = studentList.listIterator();
        for(int i = 0; i<table.length; i++){
            for(int j = 0; j<table[0].length; j++) {
                if (iterator.hasNext()){
                    if(table[i][j] == null) {
                        table[i][j] = iterator.next();
                    }else;
                }else;
            }
        }
        return table;
    }
}


