package pl.edu.agh;

import pl.edu.agh.controler.*;
import pl.edu.agh.dao.MenuDao;
import pl.edu.agh.model.Menu;

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
        if(!context.getBasket().getItems().empty()) {
            System.out.println(context.getBasket());
        } else {
            System.out.println("Order canceled ");
        }

    }
    public static void main(String[] args) {
        App app = new App();
        app.order();

    }
}
