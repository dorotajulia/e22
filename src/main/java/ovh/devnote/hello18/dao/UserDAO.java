package ovh.devnote.hello18.dao;

import ovh.devnote.hello18.entity.User;

public interface UserDAO {
    public void saveUser(User user);
    public User getUser(String username);


}
