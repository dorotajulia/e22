package ovh.devnote.hello18.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ovh.devnote.hello18.entity.Ksiazka;
import ovh.devnote.hello18.entity.Zamowienie;

import java.util.List;

@Repository
public class OrdersDAOImpl implements OrdersDAO{

    @Autowired
    private SessionFactory mySessionFactory;


    @Override
    public List<Zamowienie> getOrders(){
        Session currentSession = mySessionFactory.getCurrentSession();

        Query<Zamowienie> query = currentSession.createQuery(" from Zamowienie", Zamowienie.class);
        List<Zamowienie> orders = query.getResultList();
        return orders;
    }

    @Override
    public List<Zamowienie> getOrders(String username){
        Session currentSession = mySessionFactory.getCurrentSession();

        Query<Zamowienie> query = currentSession.createQuery("SELECT b from Zamowienie b where b.username like ?1", Zamowienie.class).setParameter(1, username);
        List<Zamowienie> orders = query.getResultList();
        return orders;
    }

    @Override
    public void saveOrder(Zamowienie order){
        Session session = mySessionFactory.getCurrentSession();

        session.save(order);
    }

    @Override
    public void completeOrder(int orderId){
        Session currentSession = mySessionFactory.getCurrentSession();

        Query<Zamowienie> query = currentSession.createQuery("SELECT b from Zamowienie b where b.id like ?1", Zamowienie.class).setParameter(1, orderId);
        Zamowienie order = query.getSingleResult();
        order.setStatus("ZREALIZOWANE");
    }
}
