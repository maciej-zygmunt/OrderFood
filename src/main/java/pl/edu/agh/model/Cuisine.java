package pl.edu.agh.model;

import lombok.Data;

import java.util.List;

@Data
public class Cuisine {
    final private String name;
    final private List<Dish> mainDishes;
    final private List<Dish> desserts;


}
