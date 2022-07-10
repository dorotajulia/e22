package ovh.devnote.hello18.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ovh.devnote.hello18.dao.UserDAO;
import ovh.devnote.hello18.entity.Kategoria;
import ovh.devnote.hello18.entity.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;
    @Override
    @Transactional
    public void saveUser(User user){
        userDAO.saveUser(user);
    }
    @Override
    @Transactional
    public User getUser(String username){ return userDAO.getUser(username);}



}
