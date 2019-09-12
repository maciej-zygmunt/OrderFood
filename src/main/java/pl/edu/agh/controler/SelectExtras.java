package pl.edu.agh.controler;

import pl.edu.agh.model.Drink;

import java.util.List;

public class SelectExtras implements State {
    @Override
    public void run(Context context) {
        List<String> extras=context.getMenu().getDrinkMenu().getExtras();
        for (int j = 0; j < extras.size(); j++) {
            System.out.println(j+": "+extras.get(j) );
        }
        System.out.println("Select drink");
        int ans=context.selectAnswers(extras.size());
        if(ans>=0) {
            String extra = extras.get(ans);
            context.setState(null);
        } else {
            context.setState(new SelectDrink());
        }

    }
}
