package ovh.devnote.hello18.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ovh.devnote.hello18.Cart;
import ovh.devnote.hello18.entity.Ksiazka;
import ovh.devnote.hello18.services.BookService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    private final Cart cart = new Cart();
    @Autowired
    private BookService bookService;

    @GetMapping
    public String cart(Model model) {
        List<Ksiazka> books = new ArrayList<>();
        for (Integer id : cart.bookIds) {
            int i = id;
            books.add(bookService.getBookByID(i));
        }
        model.addAttribute("books", books);
        return "cart";
    }

    @PostMapping("/createOrder")
    public String createOrder(Model model,Model username,Model priceModel,@RequestParam(name = "total") float price) {
        List<Ksiazka> books = new ArrayList<>();
        String booksString = "";
        for (Integer id : cart.bookIds) {
            booksString = booksString + id.toString() +";";
            int i = id;
            books.add(bookService.getBookByID(i));
        }

        String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();

        username.addAttribute("username", currentUserName);
        model.addAttribute("books", booksString);
        priceModel.addAttribute("price",price);

        return "redirect:/orders/createOrder";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam(name = "bookId") int id) {
        if (id != 0){
            cart.addBookId(id);
        }

        return "redirect:/cart";
    }

    @PostMapping("/delete")
    public String deleteFromCart(@RequestParam(name = "bookId") int id) {
        if (id != 0){
            cart.deleteBookId(id);
        }

        return "redirect:/cart";
    }

    @GetMapping("/empty")
    public String emptyCart() {
        cart.bookIds.clear();

        return "redirect:/cart";
    }

}
