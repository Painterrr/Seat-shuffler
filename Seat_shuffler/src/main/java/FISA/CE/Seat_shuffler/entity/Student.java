package FISA.CE.Seat_shuffler.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;



import lombok.*;

import static javax.persistence.GenerationType.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Student extends People {
    @Id @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column
    private String name;
}
