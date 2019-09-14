package pl.edu.agh.model.order;

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
        StringBuilder sb= new StringBuilder();
        items.forEach(c->sb.append(c.toOrderString()+"\n"));
        return sb.toString();
    }
    public boolean empty() {
        return items.empty();
    }
}
