package ovh.devnote.hello18.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Zamowienie {

    public Zamowienie(){}
//    public Orders(String nazwa, String wydawnictwo, float cena) {
//        this.nazwa = nazwa;
//        this.wydawnictwo = wydawnictwo;
//        this.cena = cena;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "price")
    private float price;
    @Column(name = "status")
    private String status;
    @Column(name = "date_time")
    private Timestamp date_time;
    @Column(name = "username")
    private String username;
    @Column(name = "ksiazkiString")
    public String ksiazkiString;

    @ManyToMany
    @JoinTable(
            name="zamowienia_to_ksiazki",
            joinColumns = @JoinColumn(name="order_id"),
            inverseJoinColumns = @JoinColumn(name="ksiazka_id")
    )
    private List<Ksiazka> ksiazki;

    public void updateKsiazkaString(){
        String books = "";
        for (Ksiazka book : ksiazki) {
            books = books + book.getNazwa() +", ";
        }
        ksiazkiString = books;
    }
    public void addKsiazka(Ksiazka ksiazka){
        if (ksiazki == null)
            ksiazki = new ArrayList<>();

        ksiazki.add(ksiazka);
        updateKsiazkaString();
    }

    public void removeKsiazka(Ksiazka ksiazka){
        if (ksiazki == null)
            return;

        ksiazki.remove(ksiazka);
        updateKsiazkaString();
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getDate_time() {
        return date_time;
    }

    public void setDate_time(Timestamp date_time) {
        this.date_time = date_time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setKsiazki(List<Ksiazka> ksiazki) {
        this.ksiazki = ksiazki;
    }

    public List<Ksiazka> getKsiazki() {
        return ksiazki;
    }

    public void setKsiazkiString(String ksiazkiString) {
        this.ksiazkiString = ksiazkiString;
    }

    public String getKsiazkiString(){
        return ksiazkiString;
    }

//    public String getKsiazkiString(){
//        String books = "";
//        for (Ksiazka book : ksiazki) {
//            books = books + book.getNazwa() +", ";
//        }
//        return books;
//    }
}
