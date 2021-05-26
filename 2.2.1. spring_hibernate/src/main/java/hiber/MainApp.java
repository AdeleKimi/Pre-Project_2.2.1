package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car = new Car("fiat",5);
      Car car1 = new Car("reno",10);
      Car car2 = new Car("lada",15);
      Car car3 = new Car("kia",20);

      User user = new User("User1", "Lastname1", "user1@mail.ru");
     user.setCar(car);
////      car.setUser(user);
      userService.add(user);
      User user1 = new User("User2", "Lastname2", "user2@mail.ru");
      user1.setCar(car1);
////      car1.setUser(user1);
      userService.add(user1);
      User user2 = new User("User3", "Lastname3", "user3@mail.ru");
      user2.setCar(car2);
//      car2.setUser(user2);
      userService.add(user2);
      User user3 = new User("User4", "Lastname4", "user4@mail.ru");
      user3.setCar(car3);
//      car3.setUser(user3);
      userService.add(user3);


      List<User> users = userService.listUsers();
      for (User all : users) {
         System.out.println("Id = "+all.getId());
         System.out.println("First Name = "+all.getFirstName());
         System.out.println("Last Name = "+all.getLastName());
         System.out.println("Email = "+all.getEmail());
         System.out.println("Car = " +all.getCar());
         System.out.println();
      }


      User test = userService.getUser("kia",20);
      System.out.println(test.getFirstName());
      System.out.println(test.getLastName());
      System.out.println(test.getCar());

      context.close();
   }
}
