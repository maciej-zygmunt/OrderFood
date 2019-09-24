package pl.edu.agh.model.order;

public interface OrderItem {
    double getPrice();
    String toOrderString();
}
