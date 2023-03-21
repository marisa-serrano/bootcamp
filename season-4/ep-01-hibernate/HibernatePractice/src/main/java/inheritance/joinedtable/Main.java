package inheritance.joinedtable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();

        Car car1 = new Car();
        car1.setSpeed(200);
        car1.setWheels(4);

        em.getTransaction().begin();
        em.persist(car1);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}