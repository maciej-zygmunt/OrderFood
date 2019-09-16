package pl.edu.agh.model.order;

import lombok.ToString;

import java.text.MessageFormat;
import java.util.Stack;

@ToString
public class Basket  {
    final private Stack<CategorizedOrderItem> items=new Stack<>();
    public void push(OrderItem item, String category) {
        CategorizedOrderItem orderItem=new CategorizedOrderItem(category,item);
        items.push(orderItem);
    }
    public CategorizedOrderItem pop() {
        return items.pop();
    }


    public String toOrderString() {
        if(items.empty()) {
            return "";
        }
        StringBuilder sb= new StringBuilder();
        sb.append("Your basket\n");
        items.forEach(c->sb.append(c.toOrderString()+"\n"));
        sb.append(MessageFormat.format("Total: {0,number,#.00}",getTotal()));
        return sb.toString();
    }
    public double getTotal(){
       return items.stream().mapToDouble(CategorizedOrderItem::getPrice).sum();
    }
    public boolean isEmpty() {
        return items.empty();
    }
}
