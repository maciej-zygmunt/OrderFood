package pl.edu.agh.model.menu;

import lombok.Data;

import java.util.List;

@Data
public class Cuisine {
    final private String name;
    final private List<ManuItem> mainDishes;
    final private List<ManuItem> desserts;


}
