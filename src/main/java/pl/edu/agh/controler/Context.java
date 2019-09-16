package pl.edu.agh.controler;

import lombok.Data;
import pl.edu.agh.model.menu.Cuisine;
import pl.edu.agh.model.menu.Menu;
import pl.edu.agh.model.order.Basket;

import java.text.MessageFormat;
import java.util.Optional;
import java.util.Scanner;

@Data
public class Context {
    public static final String PROVIDE_NUMBER_SINGLE = "Provide number 0..{0},-2 to go back ";
    public static final String PROVIDE_NUMBER_MULTI = "Provide number 0..{0},-1 to finish -2 to go back ";
    final private String name;
    final private Scanner scanner;
    final private Menu menu;

    private State state;
    private Cuisine cuisine;
    private Basket basket= new Basket();

    public Context(String name, Scanner scanner, Menu menu) {
        this.name = name;
        this.scanner = scanner;
        this.menu = menu;
        //Allows to test states without call sequence dependency.
        Optional<Cuisine> cuisine= menu.getLunchMenu().getCuisines().stream().findFirst();
        if(cuisine.isPresent()) {
            this.cuisine = cuisine.get();
        }
    }

    public void run() {
        state.run(this);
        System.out.println(basket.toOrderString());
    }

    public int selectAnswers(int range) {
        String prompt = PROVIDE_NUMBER_SINGLE;
        return selectAnswers(range, prompt);
    }

    public int selectAnswers(int range, String prompt) {
        while (true) {
            String processedPrompt= MessageFormat.format(prompt,range-1);
            System.out.println(processedPrompt);
            while (!scanner.hasNextInt()) {
                System.out.println(processedPrompt);
                scanner.next();
            }
            int a = scanner.nextInt();
            if (a < 0) {
                return a;
            } else if (a >= 0 && a < range) {
                return a;
            } else {
                System.out.println(processedPrompt);
                continue;
            }
        }
    }
}
