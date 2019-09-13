package pl.edu.agh.controler;

import pl.edu.agh.model.Dish;

import java.util.List;

public class SelectMainDish  implements State{
    @Override
    public void run(Context context) {
        List<Dish> mainDishes=context.getCuisine().getMainDishes();
        for (int j = 0; j < mainDishes.size(); j++) {
            System.out.println(j+": "+mainDishes.get(j).toString() );
        }
        System.out.println("Select main dish");
        int ans=context.selectAnswers(mainDishes.size());
        if(ans>=0) {
            Dish mainDish = mainDishes.get(ans);
            context.getBasket().getItems().push(mainDish);
            context.setState(new SelectDessert());
        } else {
            context.getBasket().getItems().pop();
            context.setState(new SelectCuisine());
        }
    }
}
