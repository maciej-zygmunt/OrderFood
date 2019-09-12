package pl.edu.agh.controler;

import lombok.Data;
import pl.edu.agh.model.Cuisine;
import pl.edu.agh.model.Dish;
import pl.edu.agh.model.LunchMenu;
import pl.edu.agh.model.Menu;

import java.util.List;
import java.util.Scanner;

@Data
public class Context {
    final private  String name;
    final private Scanner scanner;
    final private Menu menu;

    private State state;
    //private List list;
    private Cuisine cuisine;
    private Dish mainDish;
    private Dish dessert;

    public void run() {
        state.run(this);
    }

    public  int selectAnswers( int range) {
        int a = 0;
        String prompt="Provide number < ,-1 to go back ";
        while(true) {
            while (!scanner.hasNextInt()) {
                System.out.println(prompt + range);
                scanner.next();
            }
            a = scanner.nextInt();
            if(a==-1) {
                return a;
            }
            if (a >= 0 && a < range) {
                return a;
            } else {
                System.out.println(prompt + range);
                continue;
            }
        }
    }
}
