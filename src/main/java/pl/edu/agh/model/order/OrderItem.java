package pl.edu.agh.model.order;

import pl.edu.agh.model.menu.MenuItem;

import java.text.MessageFormat;


public class OrderItem {
    final private String category;
    final private Item item;

    public OrderItem(String category, Item item) {
        this.category = category;
        this.item = item;
    }
    public String toOrderString(){
        return MessageFormat.format("{0} {1}",category, item.toOrderString());
    }

    public Double getPrice() {
        if (item instanceof MenuItem) {
            MenuItem menuItem = (MenuItem) item;
            return (double)menuItem.getPrice();

        }
        return 0.0;
    }
}
