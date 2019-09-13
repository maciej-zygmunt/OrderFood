package pl.edu.agh.controler;

import pl.edu.agh.model.Drink;
import pl.edu.agh.model.Extra;

import java.util.List;

public class SelectExtras implements State {
    final private Extra extra=new Extra("Extras");
    @Override
    public void run(Context context) {
        List<String> extras=context.getMenu().getDrinkMenu().getExtras();

        for (int j = 0; j < extras.size(); j++) {
            System.out.println(j+": "+extras.get(j) );
        }
        System.out.println("Select extra's");
        int ans=context.selectAnswers(extras.size(),Context.PROVIDE_NUMBER_MULTI);
        if(ans>=0) {
            String selected = extras.get(ans);
            extra.getExtras().add(selected);
            System.out.println("Extras ="+ extra);
            context.setState(this);
        } else if (ans==-1) {
            context.getBasket().getItems().push(extra);
            context.setState(null);
        }else {
            //go back
            context.getBasket().getItems().pop();
            context.setState(new SelectDrink());
        }

    }
}
