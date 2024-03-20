package command;

import model.Menu;

import java.util.ArrayList;
public class ViewMenuCommand implements MainCommand {

    public static void execute(ArrayList<Menu> menusList) {

        try {
            for (Menu menu: menusList) {
                System.out.println(menu);
            }
        } catch (IndexOutOfBoundsException e) {
            //TODO: add exception class
            System.out.println("Menu does not exist");
        }
    }
}