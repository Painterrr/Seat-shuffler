package FISA.CE.Seat_shuffler.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;



import lombok.*;

import java.util.Objects;

import static javax.persistence.GenerationType.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString

public class Student {
    @Id @GeneratedValue(strategy = IDENTITY)
    private long id;

    @Column
    private String name;
}
