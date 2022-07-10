package ovh.devnote.hello18.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ovh.devnote.hello18.entity.Kategoria;
import ovh.devnote.hello18.entity.Ksiazka;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {
    //automatyczne wykorzystanie beana sessionFactory
    @Autowired
    private SessionFactory mySessionFactory;

    @Override
//pobranie i zwrocenie wszystkich ksiazek z bazy za pomoca zapytania HQL:
    public List<Ksiazka> getBooks() {
        //sesja hibertabe
        Session currentSession = mySessionFactory.getCurrentSession();
        //zapytanie
        Query<Ksiazka> query = currentSession.createQuery(" from Ksiazka", Ksiazka.class);
        List<Ksiazka> books = query.getResultList();
        return books;
    }


    @Override
//zapis ksiazki do bazy:
    public void saveBook(Ksiazka ksiazka) {
        Session session = mySessionFactory.getCurrentSession();

        session.save(ksiazka);
    }

    @Override
    public void updateBook(int ksiazkaID, Ksiazka ksiazka) {
        Session session = mySessionFactory.getCurrentSession();
        Ksiazka ksiazkaToUpdate = session.get(Ksiazka.class, ksiazkaID);
//        ksiazkaToUpdate.setAutorzy(ksiazka.getAutorzy());
        ksiazkaToUpdate.setNazwa(ksiazka.getNazwa());
//        ksiazkaToUpdate.setKategoria(ksiazka.getKategoria());
        ksiazkaToUpdate.setWydawnictwo(ksiazka.getWydawnictwo());
        ksiazkaToUpdate.setCena(ksiazka.getCena());

//        session.update(ksiazkaToUpdate);
    }

    @Override
    public void deleteBook(int ksiazkaID){
        Session session = mySessionFactory.getCurrentSession();
        Ksiazka ksiazkaToDelete = session.get(Ksiazka.class, ksiazkaID);

        session.delete(ksiazkaToDelete);
    }

    @Override
    public Ksiazka getBookByID(int ksiazkaID){
        Session session = mySessionFactory.getCurrentSession();
        Ksiazka ksiazka = session.get(Ksiazka.class, ksiazkaID);
//        Query<Ksiazka> query = currentSession.createQuery("SELECT b from Ksiazka b WHERE b.id LIKE ?1", Ksiazka.class).setParameter(1,ksiazkaID);
//        Ksiazka ksiazka = query.getSingleResult();

        return ksiazka;
    }

    @Override
    public List<Kategoria> getKategoria(){

        Session currentSession = mySessionFactory.getCurrentSession();

        Query<Kategoria> query = currentSession.createQuery(" from Kategoria", Kategoria.class);
        List<Kategoria> kategoriaList = query.getResultList();
        return kategoriaList;
    }

    @Override
    public Kategoria getKategoriaByID(int id){
        Session currentSession = mySessionFactory.getCurrentSession();

        Query<Kategoria> query = currentSession.createQuery("SELECT b from Kategoria b WHERE b.id LIKE ?1", Kategoria.class).setParameter(1,id);
        Kategoria kategoria = query.getSingleResult();
        return kategoria;
    }


}