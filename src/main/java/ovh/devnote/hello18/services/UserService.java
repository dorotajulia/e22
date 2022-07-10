package ovh.devnote.hello18.services;

import ovh.devnote.hello18.entity.User;

public interface UserService {
    public void saveUser(User user);
    public User getUser(String username);

}
