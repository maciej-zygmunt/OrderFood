package pl.edu.agh.model.order;

import lombok.ToString;

import java.text.MessageFormat;

@ToString
public class CategorizedOrderItem {
    final private String category;
    final private OrderItem item;

    public CategorizedOrderItem(String category, OrderItem item) {
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
