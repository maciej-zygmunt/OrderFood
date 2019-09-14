package pl.edu.agh.model.menu;

import lombok.Data;
import pl.edu.agh.model.order.Item;

import java.text.MessageFormat;


@Data
public class ManuItem implements Item {
    final private String name;
    final private double price;

    @Override
    public String toOrderString() {
        return MessageFormat.format(" {0} {1} ",name, price);
    }
}
