package pl.edu.agh.controler.states;

import pl.edu.agh.controler.Context;
import pl.edu.agh.controler.State;
import pl.edu.agh.model.menu.MenuItem;

import java.util.List;

public class SelectMainDish  implements State {
    @Override
    public void run(Context context) {
        System.out.println("Select main dish");
        List<MenuItem> mainDishes=context.getCuisine().getMainDishes();
        for (int j = 0; j < mainDishes.size(); j++) {
            System.out.println(j+": "+mainDishes.get(j).toOrderString() );
        }
        int ans=context.selectAnswers(mainDishes.size());
        if(ans>=0) {
            MenuItem mainDish = mainDishes.get(ans);
            context.getBasket().push(mainDish,"Main dish");
            context.setState(new SelectDessert());
        } else {
            context.getBasket().pop();
            context.setState(new SelectCuisine());
        }
    }
}
