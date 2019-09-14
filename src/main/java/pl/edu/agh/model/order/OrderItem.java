package pl.edu.agh.model.order;

import java.text.MessageFormat;


public class OrderItem {
    final private String category;
    final private Item item;

    public OrderItem(String category, Item item) {
        this.category = category;
        this.item = item;
    }
    public String toOrderString(){
        return MessageFormat.format("Ordered: {0} {1}.",category, item.toOrderString());
    }
}
