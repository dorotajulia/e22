package ovh.devnote.hello18.services;

import ovh.devnote.hello18.entity.Zamowienie;

import java.util.List;

public interface OrderService {
    public List<Zamowienie> getOrders();
    public List<Zamowienie> getOrders(String username);
    public void saveOrder(Zamowienie order);
    public void completeOrder(int orderId);
}
