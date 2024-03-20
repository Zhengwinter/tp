package command;

public class HelpCommand implements MainCommand{

    public static void execute() {
        System.out.print("Here are the list of available commands:\n\t");
        System.out.println("help: Shows all the commands that can be used.");
        System.out.println("\tcreate order -menu <menu_id>: Creates a new order using the specified menu.");
        System.out.println("\tview -order -all: Shows a brief summary of all the created orders.");
        System.out.println("\tview -order <order_id>: Shows all the contents of a specified order.");
        System.out.println("\tedit -order <order_id>: Navigates to the order interface to perform sub-commands" +
                "for editing an order.");
        System.out.println("\tbye: Quits the program");
    }
}