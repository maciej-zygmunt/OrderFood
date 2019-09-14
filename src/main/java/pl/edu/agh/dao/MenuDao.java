package pl.edu.agh.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pl.edu.agh.model.menu.Menu;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class MenuDao {
    public Menu read(String fileName) {
        try {
            URL url = this.getClass().getClassLoader().getResource(fileName);
            Reader reader = new InputStreamReader(url.openStream()); //Read the json output
            Gson gson = new GsonBuilder().create();
            Menu menu = gson.fromJson(reader, Menu.class);
            return menu;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
