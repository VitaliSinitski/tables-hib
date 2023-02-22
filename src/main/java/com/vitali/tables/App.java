package com.vitali.tables;

import com.vitali.tables.entity.Car;
import com.vitali.tables.entity.Home;
import com.vitali.tables.entity.People;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        EntityManager em = HibernateUtil.getEntityManager();
        
        Home home = new Home (null,"Minsk", null);

        Car car = new Car(null, "VW", "Van", null);
        Set<Car> cars = new HashSet<>();
        cars.add(car);


        People people = new People(null, "Jack", 18, home, cars);


        
        Set<People> peoples = new HashSet<>();
        peoples.add(people);
        car.setPeopleSet(peoples);


//        people.setHome(home);
//        people.setCarSet(cars);

        em.getTransaction().begin();

        em.persist(people);

        em.getTransaction().commit();
        em.close();
    }

    
    
}
