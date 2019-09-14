package pl.edu.agh;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import pl.edu.agh.dao.MenuDao;
import pl.edu.agh.model.menu.*;

import java.util.List;


public class OrderFoodTest
{

    @Test
    public void serializeJsonLunchMenuTest()
    {
        List<ManuItem> mainDishes=List.of(
                new ManuItem("fish",22.50),
                new ManuItem("chicken",24.30)

        );
        List<ManuItem> desserts=List.of(
                new ManuItem("ice-cream",11.90)
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
        List<ManuItem> drinks=List.of(
          new ManuItem("cola", 5.00),
          new ManuItem("coffee",3.50)
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
