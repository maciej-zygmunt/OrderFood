package pl.edu.agh.model.menu;

import lombok.Data;

import java.util.List;

@Data
public class LunchMenu {
    final private List<Cuisine> cuisines;
}
