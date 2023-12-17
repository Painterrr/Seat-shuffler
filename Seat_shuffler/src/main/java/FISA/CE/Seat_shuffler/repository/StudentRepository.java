package FISA.CE.Seat_shuffler.repository;

import FISA.CE.Seat_shuffler.entity.Student;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class StudentRepository{

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(int row, int col, Integer id, String name){
        Student student = new Student(id, name);
        em.persist(student);
    }
    @Transactional
    public List<Student> findAll(){
        return em.createQuery("select s from Student s", Student.class).getResultList();
    }

    public Student findOne(Integer id){
        Student student = em.find(Student.class, id);

        return student;
    }

    public void deleteById(Integer id){
        if(findOne(id) != null){
            em.remove(findOne(id));
        }
    }


}