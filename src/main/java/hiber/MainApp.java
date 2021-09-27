package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("Ford Mustang", 319)));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("Chevrolet Blaizer", 850)));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("Toyota Camry", 240)));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("Lada Priora", 124)));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("User Auto Model = " + user.getCars().getModel());
            System.out.println("User Auto Series = " + user.getCars().getSeries());
            System.out.println();
        }

        List<User> searchResult = userService.getByCarModelAndCarSeries("Lada Priora", 124);
        for (User user : searchResult) {
            System.out.println("User of Car " + user.getCars().getModel() + " = "
                    + user.getFirstName() + " "
                    + user.getLastName());
            System.out.println();
        }
        context.close();
    }
}
