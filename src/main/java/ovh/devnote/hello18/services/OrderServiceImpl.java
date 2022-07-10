package ovh.devnote.hello18.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ovh.devnote.hello18.Cart;
import ovh.devnote.hello18.dao.OrdersDAO;
import ovh.devnote.hello18.entity.Zamowienie;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrdersDAO ordersDAO;

    @Override
    @Transactional
    public List<Zamowienie> getOrders(){
        return ordersDAO.getOrders();
    }
    @Override
    @Transactional
    public List<Zamowienie> getOrders(String username){
        return ordersDAO.getOrders(username);
    }
    @Override
    @Transactional
    public void saveOrder(Zamowienie order){
        ordersDAO.saveOrder(order);
    }
    @Override
    @Transactional
    public void completeOrder(int orderId){
        ordersDAO.completeOrder(orderId);
    }
}
