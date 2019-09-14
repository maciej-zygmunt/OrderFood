package pl.edu.agh.model.order;

import java.text.MessageFormat;
import java.util.Stack;


public class Basket implements Item {
    final private Stack<OrderItem> items=new Stack<>();
    public void push(Item item, String category) {
        OrderItem orderItem=new OrderItem(category,item);
        items.push(orderItem);
    }
    public OrderItem pop() {
        return items.pop();
    }

    @Override
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
       double total=items.stream().mapToDouble(OrderItem::getPrice).sum();
       return total;
    }
    public boolean isEmpty() {
        return items.empty();
    }
}
