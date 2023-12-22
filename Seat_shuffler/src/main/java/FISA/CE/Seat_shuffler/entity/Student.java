package FISA.CE.Seat_shuffler.entity;

import javax.persistence.*;


import lombok.*;

import java.util.Objects;

import static javax.persistence.GenerationType.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
public class Student {
    @Id @GeneratedValue(strategy = IDENTITY)
    private long id;

    @Column
    private String name;
}
