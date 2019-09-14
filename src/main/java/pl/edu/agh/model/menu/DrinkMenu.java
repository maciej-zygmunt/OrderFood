package pl.edu.agh.model.menu;

import lombok.Data;

import java.util.List;

@Data
public class DrinkMenu {
    final private List<ManuItem> drinks;
    final private List<String> extras;
}
