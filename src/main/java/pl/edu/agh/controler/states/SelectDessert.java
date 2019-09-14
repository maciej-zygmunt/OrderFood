package pl.edu.agh.controler.states;

import pl.edu.agh.controler.Context;
import pl.edu.agh.controler.State;
import pl.edu.agh.model.menu.MenuItem;

import java.util.List;

public class SelectDessert implements State {
    @Override
    public void run(Context context) {
        System.out.println("Select desert");
        List<MenuItem> desserts=context.getCuisine().getDesserts();
        for (int j = 0; j < desserts.size(); j++) {
            System.out.println((j+": "+desserts.get(j).toOrderString()));
        }
        int ans=context.selectAnswers(desserts.size());
        if(ans>=0) {
            MenuItem dessert =  desserts.get(ans);
            context.getBasket().push(dessert,"Dessert");
            context.setState(null);
        } else {
            context.getBasket().pop();
            context.setState(new SelectMainDish());
        }

    }
}
