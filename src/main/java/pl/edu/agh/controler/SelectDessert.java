package pl.edu.agh.controler;

import pl.edu.agh.model.Dish;

import java.util.List;

public class SelectDessert implements State {
    @Override
    public void run(Context context) {
        List<Dish> desserts=context.getCuisine().getDesserts();
        for (int j = 0; j < desserts.size(); j++) {
            System.out.println((j+": "+desserts.get(j).toString()));
        }
        System.out.println("Select desert");
        int ans=context.selectAnswers(desserts.size());
        if(ans>=0) {
            Dish dessert = (Dish) desserts.get(ans);
            context.getBasket().getItems().push(dessert);
            context.setState(null);
        } else {
            context.getBasket().getItems().pop();
            context.setState(new SelectMainDish());
        }

    }
}
