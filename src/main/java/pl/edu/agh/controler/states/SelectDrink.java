package pl.edu.agh.controler.states;

import pl.edu.agh.controler.Context;
import pl.edu.agh.controler.State;
import pl.edu.agh.model.menu.MenuItem;


import java.util.List;

public class SelectDrink implements State {
    @Override
    public void run(Context context) {
        System.out.println("Select drink");
        List<MenuItem> drinks=context.getMenu().getDrinkMenu().getDrinks();
        for (int j = 0; j < drinks.size(); j++) {
            System.out.println(j+": "+drinks.get(j).toOrderString() );
        }
        int ans=context.selectAnswers(drinks.size());
        if(ans>=0) {
            MenuItem drink = drinks.get(ans);
            context.getBasket().push(drink,"Drink");
            context.setState(new SelectExtras());
        } else {
            context.getBasket().pop();
            context.setState(new SelectOrderType());
        }

    }
}
