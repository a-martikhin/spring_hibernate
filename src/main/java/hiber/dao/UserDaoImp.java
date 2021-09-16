package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> searchUser(String model, int series) {
        String hql = "FROM User us WHERE us.cars.model = :paramMod AND us.cars.series = :paramSer";
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql)
                .setParameter("paramMod", model)
                .setParameter("paramSer", series);
        return query.getResultList();

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }
}
