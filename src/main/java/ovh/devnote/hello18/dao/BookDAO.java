package ovh.devnote.hello18.dao;

import org.springframework.stereotype.Repository;
import ovh.devnote.hello18.entity.Kategoria;
import ovh.devnote.hello18.entity.Ksiazka;

import java.util.List;


public interface BookDAO {
    public List<Ksiazka> getBooks();
    public void saveBook(Ksiazka ksiazka);
    public void updateBook(int ksiazkaID, Ksiazka ksiazka);
    public void deleteBook(int ksiazkaID);
    public Ksiazka getBookByID(int ksiazkaID);

    public List<Kategoria> getKategoria();
    public Kategoria getKategoriaByID(int id);


}
