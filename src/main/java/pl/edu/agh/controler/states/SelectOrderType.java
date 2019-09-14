package pl.edu.agh.controler.states;

import pl.edu.agh.controler.Context;
import pl.edu.agh.controler.State;
import pl.edu.agh.controler.states.SelectCuisine;
import pl.edu.agh.controler.states.SelectDrink;

import java.util.List;

public class SelectOrderType implements State {

    @Override
    public void run(Context context) {
        List<String> orderTypes=List.of(
                "Drink",
                "Lunch"
        );
        for (int i = 0; i < orderTypes.size(); i++) {
            System.out.println(i+ ":" +orderTypes.get(i));
        }
        System.out.println("Select order type ");
        int ans = context.selectAnswers(orderTypes.size());
        switch (ans) {
            case 0:
                context.setState(new SelectDrink());
                break;
            case 1:
                context.setState(new SelectCuisine());
                break;
            case -1:
                context.setState(null);
                context.setCuisine(null);
                break;
            default:
                System.out.println("Not implemented");
                break;
        }
    }
}
