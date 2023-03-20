package inheritance.joinedtable;

import javax.persistence.*;

@Entity(name = "VehicleJoinedTable")
@Table(name = "vehicle")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer key;
    private Integer speed;

    public Integer getKey() {
        return key;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }
}