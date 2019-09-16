package pl.edu.agh;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.edu.agh.controler.Context;
import pl.edu.agh.controler.State;
import pl.edu.agh.controler.states.SelectCuisine;
import pl.edu.agh.controler.states.SelectDessert;
import pl.edu.agh.controler.states.SelectMainDish;
import pl.edu.agh.controler.states.SelectOrderType;
import pl.edu.agh.dao.MenuDao;
import pl.edu.agh.model.menu.Menu;
import pl.edu.agh.model.order.Basket;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class StatesTest {
    private Menu menu;

    @Before
    public void initialize() {
        menu = new MenuDao().read("Menu.json");

    }

    @Test
    public void selectOrderTypeTest() {
        Scanner scanner = simulateScanner("1");
        Context context = new Context("Food Menu Context", scanner, menu);
        context.setState(new SelectOrderType());
        context.run();
        State state = context.getState();
        Assert.assertTrue("Next type", state instanceof SelectCuisine);
    }

    @Test
    public void selectMainDishTest() {
        Scanner scanner = simulateScanner("0");
        Context context = new Context("Food Menu Context", scanner, menu);
        context.setState(new SelectMainDish());
        context.run();
        State state = context.getState();
        Assert.assertTrue("Next type", state instanceof SelectDessert);
    }

    @Test
    public void selectLunchTest() {
        Scanner scanner = simulateScanner("1 0 0 0");
        Context context = new Context("Food Menu Context", scanner, menu);
        context.setState(new SelectOrderType());
        while (context.getState() != null) {
            context.run();
        }
        Basket basket = context.getBasket();
        String expectedBasket = "Basket(items=[" +
                "CategorizedOrderItem(category=Main dish, item=MenuItem(name=fish, price=22.5)), " +
                "CategorizedOrderItem(category=Dessert, item=MenuItem(name=ice-cream, price=11.9))" +
                "])";
        String actualBasket = basket.toString();
        Assert.assertEquals(expectedBasket, actualBasket);
    }

    @Test
    public void selectDrinkTest() {
        Scanner scanner = simulateScanner("0 0 0 1 -1");
        Context context = new Context("Food Menu Context", scanner, menu);
        context.setState(new SelectOrderType());
        while (context.getState() != null) {
            context.run();
        }
        Basket basket = context.getBasket();
        String expectedBasket = "Basket(items=[" +
                "CategorizedOrderItem(category=Drink, item=MenuItem(name=cola, price=5.0)), " +
                "CategorizedOrderItem(category=Extra, item=Extra(name=Extras, extras=[ice cubes, lemon]))" +
                "])";
        String actualBasket = basket.toString();
        Assert.assertEquals(expectedBasket, actualBasket);
    }

    private Scanner simulateScanner(String inStr) {
        try {
            InputStream in = new ByteArrayInputStream(inStr.getBytes("UTF8"));
            Scanner scanner = new Scanner(in);
            return scanner;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
