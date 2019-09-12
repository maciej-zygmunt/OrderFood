package pl.edu.agh.controler;

import pl.edu.agh.model.Dish;
import pl.edu.agh.model.Drink;

import java.util.List;

public class SelectDrink implements State {
    @Override
    public void run(Context context) {
        List<Drink> drinks=context.getMenu().getDrinkMenu().getDrinks();
        for (int j = 0; j < drinks.size(); j++) {
            System.out.println(j+": "+drinks.get(j) );
        }
        System.out.println("Select drink");
        int ans=context.selectAnswers(drinks.size());
        if(ans>=0) {
            Drink drink = drinks.get(ans);
            //context.setList(context.getCuisine().getDesserts());
            context.setState(new SelectExtras());
        } else {
            //context.setList(context.getLunchMenu().getCuisines());
            context.setState(new SelectOrderType());
        }

    }
}
