package FISA.CE.Seat_shuffler.repository;

import FISA.CE.Seat_shuffler.entity.Student;
import org.junit.Before;
import org.junit.Test;
// import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StudentRepositoryTest {

    @Mock
    private EntityManager entityManager;

    @InjectMocks
    private StudentRepository studentRepository;

    @Before
    public void setUp() {
        // Setup any initial conditions or mocks before each test method.
    }

    @Test
    public void testSave() {
        // Given
        long id = 1L;
        String name = "John Doe";
        Student student = new Student();
        student.setId(id);
        student.setName(name);

        // When
        studentRepository.save(id, name);

        // Then
        verify(entityManager, times(1)).persist(eq(student));  // 수정된 부분
    }

    @Test
    public void testFindOne() {
        // Given
        long id = 1L;
        Student expectedStudent = new Student();
        when(entityManager.find(Student.class, id)).thenReturn(expectedStudent);

        // When
        Student result = studentRepository.findOne(id);

        // Then
        verify(entityManager).find(Student.class, id);
        assertEquals(expectedStudent, result);  // 수정된 부분
    }

    @Test
    public void testFindAll() {
        // Given
        TypedQuery<Student> query = mock(TypedQuery.class);
        List<Student> expectedList = new ArrayList<>();
        when(entityManager.createQuery("select s from Student s", Student.class)).thenReturn(query);
        when(query.getResultList()).thenReturn(expectedList);

        // When
        List<Student> result = studentRepository.findAll();

        // Then
        verify(entityManager).createQuery("select s from Student s", Student.class);
        verify(query).getResultList();
        assertEquals(expectedList, result);  // 수정된 부분
    }
}