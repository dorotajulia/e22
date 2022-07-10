package ovh.devnote.hello18.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ovh.devnote.hello18.entity.Ksiazka;
import ovh.devnote.hello18.services.BookService;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/list")
    public String listBook(Model model){
        List<Ksiazka> books = bookService.getBooks();
        model.addAttribute("books",books);
        return "bookslist";
    }



    @GetMapping("/deleteForm")
    public String deleteForm(Model model, Model modelIDToDelete){
        List<Ksiazka> books = bookService.getBooks();
        int bookIDToDelete = 0;
        model.addAttribute("books",books);
        modelIDToDelete.addAttribute("bookToDelete",bookIDToDelete);
        return "deleteBook";
    }

    @PostMapping("/deleteBook")
    public String deleteBook(@ModelAttribute("bookToDelete") int ksiazkaID){
        bookService.deleteBook(ksiazkaID);
        return "redirect:/books/manage";
    }

    @GetMapping("/formadd")
    public String addForm(Model model ) {
        Ksiazka book = new Ksiazka();
        model.addAttribute("book",book);
        return "addbookform";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Ksiazka ksiazka){
        bookService.saveBook(ksiazka);
        return "redirect:/books/list";
    }

    @RequestMapping("/chooseBookToUpdate")
    public String chooseForm(Model model, Model modelIDToDelete){
        List<Ksiazka> books = bookService.getBooks();
        int bookIDToDelete = 0;
        model.addAttribute("books",books);
        modelIDToDelete.addAttribute("bookToUpDateID",bookIDToDelete);
        return "updateChooseBook";
    }

    @RequestMapping("/updateForm")
    public String updateForm(@ModelAttribute("bookToUpDateID") int ksiazkaID,Model model, Model newBookModel){
        Ksiazka book = bookService.getBookByID(ksiazkaID);
        Ksiazka newBook = new Ksiazka();
        model.addAttribute("book",book);
        newBookModel.addAttribute("bookToUpDate", newBook);

        return "updateBookForm";
    }

    @PostMapping("/updateBook/{subjectid}")
    public String updateBook(@ModelAttribute("bookToUpDate") Ksiazka ksiazka,@PathVariable int subjectid){ //@ModelAttribute("bookToUpDateID2") int ksiazkaID,@ModelAttribute("bookToUpDate") Ksiazka ksiazka
        bookService.updateBook(subjectid, ksiazka);
        return "redirect:/books/manage";
    }

}

