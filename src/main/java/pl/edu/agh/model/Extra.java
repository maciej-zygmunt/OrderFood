package pl.edu.agh.model;

import lombok.Data;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

@Data
public class Extra implements Item {
    final private String name;
    private SortedSet<String> extras=new TreeSet<>();
}
