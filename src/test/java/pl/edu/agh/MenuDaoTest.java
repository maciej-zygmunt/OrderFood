package pl.edu.agh;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Assert;
import org.junit.Test;
import pl.edu.agh.dao.MenuDao;
import pl.edu.agh.model.menu.*;

import java.util.List;


public class MenuDaoTest
{

    @Test
    public void serializeJsonLunchMenuTest()
    {
        List<MenuItem> mainDishes=List.of(
                new MenuItem("fish",22.50),
                new MenuItem("chicken",24.30)

        );
        List<MenuItem> desserts=List.of(
                new MenuItem("ice-cream",11.90)
        );
        List<Cuisine> cuisines=List.of(
                new Cuisine("Polish",mainDishes,desserts)
        );
        LunchMenu lunchMenu = new LunchMenu(cuisines);
        String expectedJson="{\"cuisines\":[{\"name\":\"Polish\",\"mainDishes\":[{\"name\":\"fish\",\"price\":22.5},{\"name\":\"chicken\",\"price\":24.3}],\"desserts\":[{\"name\":\"ice-cream\",\"price\":11.9}]}]}";

        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(lunchMenu);
        Assert.assertEquals(expectedJson,json);
    }
    @Test
    public void serializeJsonDrinkMenuTest()
    {
        List<MenuItem> drinks=List.of(
          new MenuItem("cola", 5.00),
          new MenuItem("coffee",3.50)
        );
        List<String> extras = List.of(
                "ice cubes",
                "lemon"
        );
        DrinkMenu drinkMenu= new DrinkMenu(drinks,extras);
        String expectedJson="{\"drinks\":[{\"name\":\"cola\",\"price\":5.0},{\"name\":\"coffee\",\"price\":3.5}],\"extras\":[\"ice cubes\",\"lemon\"]}";
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(drinkMenu);
        Assert.assertEquals(expectedJson,json);
    }

    @Test
    public void menuDaoTest()
    {
        MenuDao lunchMenuDao = new MenuDao();
        Menu menu=new MenuDao().read("Menu.json");
        String expectedMenu="Menu(lunchMenu=LunchMenu(cuisines=[Cuisine(name=Polish, mainDishes=[MenuItem(name=fish, price=22.5), MenuItem(name=chicken, price=24.3), MenuItem(name=dumplings, price=28.5)], " +
                "desserts=[MenuItem(name=ice-cream, price=11.9)]), Cuisine(name=Mexican, mainDishes=[MenuItem(name=taco, price=23.5), MenuItem(name=chicken, price=24.3), MenuItem(name=tortilla, price=18.5)], " +
                "desserts=[MenuItem(name=papaya, price=11.9)]), Cuisine(name=Italian, mainDishes=[MenuItem(name=spaghetti, price=22.5), MenuItem(name=pizza, price=24.3), MenuItem(name=tortellini, price=28.5)], " +
                "desserts=[MenuItem(name=tiramisu, price=12.9)])]), " +
                "drinkMenu=DrinkMenu(drinks=[MenuItem(name=cola, price=5.0), MenuItem(name=coffee, price=3.5)], extras=[ice cubes, lemon]))";
        String menuString=menu.toString();
        Assert.assertEquals(expectedMenu,menuString);

    }

}
