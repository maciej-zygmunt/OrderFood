package pl.edu.agh.model.order;

import lombok.Data;

import java.util.SortedSet;
import java.util.TreeSet;

@Data
public class Extra implements OrderItem {
    final private String name;
    private SortedSet<String> extras=new TreeSet<>();
    @Override
    public String toOrderString() {
        return String.join(",",extras);
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
