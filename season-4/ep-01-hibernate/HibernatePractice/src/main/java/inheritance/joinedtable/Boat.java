package inheritance.joinedtable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "BoatJoinedTable")
@Table(name = "boat_joined_table")
public class Boat extends Vehicle {

    private Integer seats;

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }
}
