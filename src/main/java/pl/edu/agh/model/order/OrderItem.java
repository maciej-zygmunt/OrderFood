package pl.edu.agh.model.order;

import pl.edu.agh.model.menu.MenuItem;

import java.text.MessageFormat;


public class OrderItem  {
    final private String category;
    final private BasketItem item;

    public OrderItem(String category, BasketItem item) {
        this.category = category;
        this.item = item;
    }
    public String toOrderString(){
        return MessageFormat.format("{0} {1}",category, item.toOrderString());
    }

    public double getPrice() {
            return item.getPrice();
    }
}
