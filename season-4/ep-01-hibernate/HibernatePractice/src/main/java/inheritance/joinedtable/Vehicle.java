package inheritance.joinedtable;

import javax.persistence.*;

@Entity(name = "VehicleJoinedTable")
@Table(name = "vehicle_joined_table")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer speed;

    public Integer getId() {
        return id;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }
}