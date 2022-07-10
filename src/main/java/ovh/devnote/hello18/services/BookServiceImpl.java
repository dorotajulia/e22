package ovh.devnote.hello18.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ovh.devnote.hello18.dao.BookDAO;
import ovh.devnote.hello18.entity.Kategoria;
import ovh.devnote.hello18.entity.Ksiazka;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookDAO bookDAO;

    @Override
    @Transactional
    public List<Ksiazka> getBooks() {
        List<Ksiazka> books = bookDAO.getBooks();
        return books;
    }
    @Override
    @Transactional
    public void saveBook(Ksiazka ksiazka) {
        bookDAO.saveBook(ksiazka);
    }

    @Override
    @Transactional
    public void deleteBook(int ksiazkaID){
        if (ksiazkaID != 0) {
            bookDAO.deleteBook(ksiazkaID);
        }
    }

    @Override
    @Transactional
    public void updateBook(int ksiazkaID, Ksiazka ksiazka){
        if (ksiazkaID != 0) {
            bookDAO.updateBook(ksiazkaID, ksiazka);
        }
    }

    @Override
    @Transactional
    public Ksiazka getBookByID(int ksiazkaID){
        Ksiazka ksiazkaNew = new Ksiazka();
        if (ksiazkaID != 0) {
            ksiazkaNew = bookDAO.getBookByID(ksiazkaID);
        }
        return ksiazkaNew;
    }

    @Override
    @Transactional
    public List<Kategoria> getKategoria(){ return bookDAO.getKategoria(); }

    @Override
    @Transactional
    public Kategoria getKategoriaByID(int id){ return bookDAO.getKategoriaByID(id);}
}
