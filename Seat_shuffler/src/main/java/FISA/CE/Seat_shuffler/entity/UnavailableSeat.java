package FISA.CE.Seat_shuffler.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@DiscriminatorValue("Unavailable")
public class UnavailableSeat extends Student{
    @Id
    private long id;

    @Column
    private String name;
}