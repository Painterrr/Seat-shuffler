package FISA.CE.Seat_shuffler.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@ToString
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int num;

    @Column
    private String name;
}
