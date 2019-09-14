package pl.edu.agh;

import pl.edu.agh.controler.*;
import pl.edu.agh.controler.states.SelectOrderType;
import pl.edu.agh.dao.MenuDao;
import pl.edu.agh.model.menu.Menu;

import java.util.Scanner;

public class App {

    public void order() {
        Menu menu = new MenuDao().read("Menu.json");

        Scanner scanner = new Scanner(System.in);

        Context context=new Context("Food Menu Context",scanner,menu);
        context.setState(new SelectOrderType());

        while(context.getState()!=null) {
            context.run();
        }
        if(context.getBasket().isEmpty()) {
            System.out.println("Order canceled ");
        }

    }
    public static void main(String[] args) {
        App app = new App();
        app.order();

    }
}
