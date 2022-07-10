package ovh.devnote.hello18;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashSet;
import java.util.Set;

@Component
@SessionScope
public class Cart {
    public Set<Integer> bookIds = new HashSet<>();
    public void addBookId(int id) {
        Integer i = id;
        bookIds.add(i);
    }
    public void deleteBookId(Integer id) {
        Integer i = id;
        System.out.println(id);
        bookIds.remove(i);
    }
    public Set<Integer> getBookIds() {
        return bookIds;
    }
}
