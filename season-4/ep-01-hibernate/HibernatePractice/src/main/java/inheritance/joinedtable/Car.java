package inheritance.joinedtable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "CarJoinedTable")
@Table(name = "car_joined_table")
public class Car extends Vehicle {

    private Integer wheels;

    public Integer getWheels() {
        return wheels;
    }

    public void setWheels(Integer wheels) {
        this.wheels = wheels;
    }
}