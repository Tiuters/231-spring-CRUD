package web.service;

import hiber.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarFactory {
    Session session = null;
    Transaction txn = null;
    private static int CARS_COUNT;

    public List<Car> index() {

        try {
            session = Util.getSessionFactory().openSession();
            System.out.println("Создание сессии");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        List<Car> cars = null;
        try {
            session.beginTransaction();
            cars = session.createQuery("FROM Car").list();
            txn = session.getTransaction();
            txn.commit();
        } catch (Throwable e) {
            if (txn != null) {
                txn.rollback();
            }
            throw e;
        }
        return cars;
    }

    public void save(Car car) {

        try {
            session = Util.getSessionFactory().openSession();
            System.out.println("Создание сессии");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            session.beginTransaction();
            session.save(car);
            txn = session.getTransaction();
            txn.commit();
        } catch (Throwable e) {
            if (txn != null) {
                txn.rollback();
            }
            throw e;
        }
    }


    public Car show(int id) {
//        return cars.stream().filter(person -> person.getId() == id)
//            .findAny().orElse(null);
        return null;
    }

//    public void save(Car car) {
////        car.setId(++CARS_COUNT);
////        cars.add(car);
//    }

    public void update(int id, Car updatedCar) {
//        Car personToBeUpdated = show(id);
//        personToBeUpdated.setName(updatedCar.getName());
//        personToBeUpdated.setType(updatedCar.getType());
//        personToBeUpdated.setDoors(updatedCar.getDoors());
    }

    public void delete(int id) {
//        cars.removeIf(p -> p.getId() == id);
    }



 //    public List<Car> index() {
//        return cars;
//    }


    //    private List<Car> cars;
//    {
//        cars = new ArrayList<>();
//
//        cars.add(new Car(++CARS_COUNT, "Carrr", "T", 2));
//        cars.add(new Car(++CARS_COUNT, "Phiiii", "Q", 0));
//        cars.add(new Car(++CARS_COUNT, "Trycl", "H", 3));
//        cars.add(new Car(++CARS_COUNT, "Jazzz", "J", 8));
//    }
}
