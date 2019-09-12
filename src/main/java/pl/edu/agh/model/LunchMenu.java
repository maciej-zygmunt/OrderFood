package pl.edu.agh.model;

import lombok.Data;

import java.util.List;

@Data
public class LunchMenu {
    final private List<Cuisine> cuisines;
}
