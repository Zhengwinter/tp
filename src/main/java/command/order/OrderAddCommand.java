package command.order;

import model.Menu;
import model.MenuItem;
import model.Order;
import ui.Parser;


import java.util.Optional;




public class OrderAddCommand implements OrderCommand {
    private static final String LOGGER_NAME = "OrderAddCommandLogger";
    //private static final Logger logr = Logger.getLogger(LOGGER_NAME);
    /**
     * Executes the command to add a specified quantity of an item to an order.
     *
     * @param newOrder    the order to add the item to
     * @param inputText   the string containing details of item to be added
     * @param menu        the menu with the item to be added
     */
    public static void execute(Order newOrder, String inputText, Menu menu) {
        //OrderAddCommand.setUpLogger();

        //logr.info("Adding new item to order");
        String[] indexString = Parser.splitInput(Parser.analyzeInput(inputText), inputText);
        String itemID = indexString[0];
        String itemQuantity = indexString[1];
        Optional<MenuItem> item = menu.getItemById(itemID);

        // limit quantity to 1 - 9999
        if (Integer.parseInt(itemQuantity) < 1 || Integer.parseInt(itemQuantity) > 9999) {
            //logr.warning("Quantity of item is out of range");
            System.out.println("Quantity must be between 0 and 10000 (both exclusive)");
            return;
        }
        if (item.isPresent()) {
            try {
                for (int i = 0; i < Integer.parseInt(itemQuantity); i++) {
                    newOrder.add(item.get());
                }
            } catch (IllegalArgumentException e) {
                //logr.warning("Item count already at maximum");
                System.out.println(e.getMessage());
                return;
            }
            //logr.info("Item successfully added to order");
            System.out.println(itemQuantity + " " + item.get().getName() + " is added to order");
        } else {
            //logr.warning("Item not in menu, not added to order");
            System.out.println("Item not found in menu");
        }
    }

    /*
     * Sets up the logger for the OrderAddCommand class.



    private static void setUpLogger() {
        LogManager.getLogManager().reset();
        logr.setLevel(Level.INFO);

        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.SEVERE);
        logr.addHandler(ch);

        try {
            FileHandler fh = new FileHandler(LOGGER_NAME + ".log");
            fh.setLevel(Level.FINE);
            logr.addHandler(fh);
        } catch (IOException e) {
            logr.log(Level.SEVERE, "File logger not working", e);
        }
    }*/
}
