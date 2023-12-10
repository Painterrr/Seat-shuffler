package FISA.CE.Seat_shuffler.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import FISA.CE.Seat_shuffler.entity.Student;

import java.util.List;


@Repository
public class StudentRepository{
    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> findAll() {
        String sql = "SELECT * FROM student";
        return jdbcTemplate.query(sql, (resultSet, rowNum) ->
                new Student(resultSet.getInt("id"),
                            resultSet.getNString("name")));
    }
}
