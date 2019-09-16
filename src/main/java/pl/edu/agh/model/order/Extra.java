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
        StringBuilder sb= new StringBuilder();
        extras.forEach(c->sb.append(c+","));
        if(sb.length()>0 ) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();

    }

    @Override
    public double getPrice() {
        return 0;
    }
}
