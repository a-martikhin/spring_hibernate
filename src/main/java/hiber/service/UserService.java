package hiber.service;

import hiber.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

    @Transactional
    void add(User user);

    List<User> getByCarModelAndCarSeries(String model, int series);

    List<User> listUsers();
}
