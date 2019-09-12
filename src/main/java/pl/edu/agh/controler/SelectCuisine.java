package pl.edu.agh.controler;

import pl.edu.agh.model.Cuisine;

import java.util.List;

public class SelectCuisine implements State {
    @Override
    public void run(Context context) {
            List<Cuisine> cuisines=context.getMenu().getLunchMenu().getCuisines();
            int i=0;
            for (Cuisine c : cuisines ) {
                System.out.println((i++) + ":" + c.getName());
            }
            System.out.println("Select cuisine ");
            int ans = context.selectAnswers(cuisines.size());
            if(ans>=0) {
                Cuisine cuisine = cuisines.get(ans);
                context.setState(new SelectMainDish());
                context.setCuisine(cuisine);
            } else {
                context.setState(null);
                context.setCuisine(null);
            }


    }
}
