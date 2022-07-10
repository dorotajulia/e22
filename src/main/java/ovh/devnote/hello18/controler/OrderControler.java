package ovh.devnote.hello18.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ovh.devnote.hello18.entity.Ksiazka;
import ovh.devnote.hello18.entity.Zamowienie;
import ovh.devnote.hello18.services.BookService;
import ovh.devnote.hello18.services.OrderService;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderControler {
    @Autowired
    OrderService orderService;
    @Autowired
    BookService bookService;

    @GetMapping("/createOrder")
    public String createOrder(@ModelAttribute("books")String books, @ModelAttribute("username") String username,@ModelAttribute("price") float price) {
        Zamowienie zamowienie = new Zamowienie();
        String[] split = books.split(";");
        String booksString = "";
        for (int i = 0; i<split.length; i++){

            if(!split[i].substring(0, split[i].length()).isEmpty()) {
                int j = Integer.parseInt(split[i].substring(0, split[i].length()));
                zamowienie.addKsiazka(bookService.getBookByID(j));
                Ksiazka book = bookService.getBookByID(j);
                booksString = booksString + book.getNazwa() + ", ";
                System.out.println(j);
            }

        }

        zamowienie.setUsername(username);
        zamowienie.setKsiazkiString(booksString);
        zamowienie.setDate_time(Timestamp.from(Instant.now()));
        zamowienie.setPrice(price);
        zamowienie.setStatus("ZLOZONE");

        orderService.saveOrder(zamowienie);
        return "redirect:/cart/empty";
    }

    @RequestMapping("/userOrderList")
    public String userOrderList(Model model){
        List<Zamowienie> orders = orderService.getOrders(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("orders",orders);
        return "userZamowienia";
    }

    @RequestMapping("/adminOrderList")
    public String adminOrderList(Model model){
        List<Zamowienie> orders = orderService.getOrders();
        model.addAttribute("orders",orders);
        System.out.println(orders.get(0).getKsiazkiString());

        return "adminZamowienia";
    }

    @PostMapping("/complete")
    public String completeOrder(@RequestParam(name = "orderId") int id){
        orderService.completeOrder(id);
        return "redirect:/orders/adminOrderList";
    }

}
