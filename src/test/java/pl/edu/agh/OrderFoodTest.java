package pl.edu.agh;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import pl.edu.agh.dao.MenuDao;
import pl.edu.agh.model.*;

import java.util.List;


public class OrderFoodTest
{

    @Test
    public void serializeJsonLunchMenuTest()
    {
        List<Dish> mainDishes=List.of(
                new Dish("fish",22.50),
                new Dish("chicken",24.30)

        );
        List<Dish> desserts=List.of(
                new Dish("ice-cream",11.90)
        );
        List<Cuisine> cuisines=List.of(
                new Cuisine("Polish",mainDishes,desserts)
        );
        LunchMenu lunchMenu = new LunchMenu(cuisines);


        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(lunchMenu);
        System.out.println(json);
    }
    @Test
    public void serializeJsonDrinkMenuTest()
    {
        List<Drink> drinks=List.of(
          new Drink("cola", 5.00),
          new Drink("coffee",3.50)
        );
        List<String> extras = List.of(
                "ice cubes",
                "lemon"
        );
        DrinkMenu drinkMenu= new DrinkMenu(drinks,extras);
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(drinkMenu);
        System.out.println(json);
    }

    @Test
    public void menuDaoTest()
    {
        MenuDao lunchMenuDao = new MenuDao();
        Menu menu=new MenuDao().read("Menu.json");
        System.out.println(menu);
    }

}
