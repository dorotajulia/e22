package ovh.devnote.hello18.dao;

import ovh.devnote.hello18.entity.Zamowienie;

import java.util.List;

public interface OrdersDAO {
    public List<Zamowienie> getOrders();
    public List<Zamowienie> getOrders(String username);
    public void saveOrder(Zamowienie order);
    public void completeOrder(int orderId);
}
