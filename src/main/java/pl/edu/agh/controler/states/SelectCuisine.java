package pl.edu.agh.controler.states;

import pl.edu.agh.controler.Context;
import pl.edu.agh.controler.State;
import pl.edu.agh.model.menu.Cuisine;

import java.util.List;

public class SelectCuisine implements State {
    @Override
    public void run(Context context) {
        List<Cuisine> cuisines = context.getMenu().getLunchMenu().getCuisines();
        for (int i = 0; i <cuisines.size(); i++) {
            System.out.println(i + ":" + cuisines.get(i).getName());
        }
        System.out.println("Select cuisine ");
        int ans = context.selectAnswers(cuisines.size());
        if (ans >= 0) {
            Cuisine cuisine = cuisines.get(ans);
            context.setState(new SelectMainDish());
            context.setCuisine(cuisine);
        } else {
            context.setState(null);
            context.setCuisine(null);
        }


    }
}
