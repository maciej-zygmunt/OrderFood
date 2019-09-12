package pl.edu.agh.model;

import lombok.Data;

import java.util.List;

@Data
public class DrinkMenu {
    final private List<Drink> drinks;
    final private List<String> extras;
}
