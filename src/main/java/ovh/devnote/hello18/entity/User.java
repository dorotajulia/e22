package ovh.devnote.hello18.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "users")
public class User {
    @Id
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private Boolean enabled;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Authority> authorities;
    public User() {
        enabled = true;
        authorities = new ArrayList<>();
    }
    public User(String username) {
        this.username = username;
    }
    public User(String username, String password) {
        this();
        this.username = username;
        BCryptPasswordEncoder bcryp = new BCryptPasswordEncoder();
        this.password = bcryp.encode(password);
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        BCryptPasswordEncoder bcryp = new BCryptPasswordEncoder();
        this.password = bcryp.encode(password);
    }
    public Boolean getEnabled() {
        return enabled;
    }
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    public List<Authority> getAuthorities() {
        return authorities;
    }
    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
}

