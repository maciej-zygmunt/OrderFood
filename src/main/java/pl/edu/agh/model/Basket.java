package pl.edu.agh.model;

import lombok.Data;

import java.util.Stack;

@Data
public class Basket {
    final private Stack<Item> items=new Stack<>();
}
