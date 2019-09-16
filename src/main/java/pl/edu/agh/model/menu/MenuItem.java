package pl.edu.agh.model.menu;

import lombok.Data;
import pl.edu.agh.model.order.OrderItem;

import java.text.MessageFormat;


@Data
public class MenuItem implements OrderItem {
    final private String name;
    final private double price;

    @Override
    public String toOrderString() {
        return MessageFormat.format("{0}: {1,number,#.00} ",name, price);
    }
}
