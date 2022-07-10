package ovh.devnote.hello18.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ovh.devnote.hello18.entity.Ksiazka;
import ovh.devnote.hello18.entity.User;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{
    @Autowired
    private SessionFactory mySessionFactory;
    @Override
    public void saveUser(User user){
        Session session = mySessionFactory.getCurrentSession();
        System.out.println(user.getUsername());
        session.save(user);
    }
    @Override
    public User getUser(String username){
        Session currentSession = mySessionFactory.getCurrentSession();
        System.out.println(username);
        Query<User> query = currentSession.createQuery("SELECT b from User b WHERE b.username LIKE ?1", User.class).setParameter(1,username);

//        Query<User> query = currentSession.createQuery("from User",User.class);
        User user = new User();

        if (!query.list().isEmpty()){
            user = query.getSingleResult();
        }
        System.out.println(user.getUsername());
        return user;
    }





}
