package pl.edu.agh.model;

import lombok.Data;


@Data
public class Dish implements Item {
    final private String name;
    final private double price;
}
