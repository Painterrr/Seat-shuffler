package FISA.CE.Seat_shuffler.repository;

import FISA.CE.Seat_shuffler.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager em;

    /*
    @author 장지은
    @date 2023-12-18
    @parameter long id, String name
    @description : Student id와 name을 받아 객체 생성해서 저장
    @return
    */
    public void save(long id, String name){
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        em.persist(student);
    }

    /*
    @author 장지은
    @date 2023-12-18
    @parameter long id
    @description : 해당하는 id 탐색 후 해당 id 보유한 Student 반환
    @return student
    */
    public Student findOne(long id){
        Student student = em.find(Student.class, id);
        return student;
    }

    /*
    @author 장지은
    @date 2023-12-23
    @parameter
    @description : 현재 DB에 저장되어있는 모든 Student 객체 Arraylist로 반환
    @return ArrayList<Student>
    */
    public ArrayList<Student> findAll(){
        ArrayList<Student> list = (ArrayList<Student>) em.createQuery("select s from Student s", Student.class).getResultList();
        return list;
    }

    /*
    @author 장지은
    @date 2023-12-18
    @parameter long id, long newid, String newname
    @description : 해당하는 id의 Student 객체 탐색 후 새로운 newid, newname으로 변경
    @return
    */
    public void update(long id, long newid, String newname){
        Student student = em.find(Student.class, id);
        student.setId(newid);
        student.setName(newname);
    }

    /*
    @author 장지은
    @date 2023-12-18
    @parameter long id
    @description : 해당하는 id의 Student 객체 탐색 후 삭제
    @return
    */
    public void delete(long id){
        em.remove(findOne(id));
    }
}