// Ivonne Zhang
// 05/30/2024

import java.util.*;
import java.io.*; 

// This class is the entry for the Todo List Manager.
// It provid options to add items, mark items as done, 
// load from a file, and save to a file.

public class TodoListMain {

    // Behavior:
    //   - Shows a welcome message and menu of options to the user
    //   - Options for the user to add, mark, load, or save Todo items.
    // Parameters:
    //   - args.
    // Returns:
    //   - None.
    // Exceptions:
    //   - FileNotFoundException: Thrown if file is not found.

    public static void main(String[] args) throws FileNotFoundException {
 
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome to your TODO List Manager!");

        TodoList todos = new TodoList(); 

        String choice = "";
        while (!choice.equalsIgnoreCase("Q")){
            System.out.println("What would you like to do?");
            System.out.print("(A)dd TODO, (M)ark TODO as done, " +
                            "(L)oad TODOs, (S)ave TODOs, (Q)uit? ");
            choice = console.nextLine();
            
            if (choice.equalsIgnoreCase("A")){
                addItem(console, todos);
            } else if (choice.equalsIgnoreCase("M")){
                markItemAsDone(console, todos);
            } else if (choice.equalsIgnoreCase("L")){
                loadItems(console, todos);
            } else if (choice.equalsIgnoreCase("S")){
                saveItems(console, todos);
            } else if (!choice.equalsIgnoreCase("Q")){
                System.out.println("Unknown input: " + choice);
                todos.printTodos();
            }
        }
    }
    
    
    // Behavior:
    //   - This method adds todo item to the list. The items can be inserted at 
    //      a specified position or at the end.
    // Parameters:
    //   - console: the Scanner for user input.
    //   - todos: the TodoList of current todo items.
    // Returns:
    //   - None.
    // Exceptions:
    //   - Cannot input a location out of bounds.

    public static void addItem(Scanner console, TodoList todos) {

        System.out.print("What would you like to add? ");
        String userInput = console.nextLine();

        int location = todos.getSize();
        String item = "";

        if (!userInput.equals("")) {

            if (!todos.isEmpty()){ //making sure there is something in the list, 
                                   //so we can ask for location
                System.out.print("Where in the list should it be (1-" + 
                                (todos.getSize()+1) + ")? (Enter for end): ");
                String inputLocation = console.nextLine();
                 
                if (!inputLocation.equals("")) {
                    location = Integer.parseInt(inputLocation);
                    todos.add((location-1), userInput);
                } else {
                    todos.add(userInput);
                    location ++;
                }
            } else {
                todos.add(userInput);
            }
        }
        todos.printTodos();
    }


    // Behavior:
    //   - This method removes a todo item from the TodoList based on the user's 
    //      input of the index.
    // Parameters:
    //   - console: the Scanner for user input.
    //   - todos: the TodoList of current todo items.
    // Returns:
    //   - None.
    // Exceptions:
    //   - Cannot input a location out of bounds.

    public static void markItemAsDone(Scanner console, TodoList todos) {
        
        if (todos.getSize() == 0){
            System.out.println("All done! Nothing left to mark as done!");
        } else {
            System.out.print("Which item did you complete (1-" + 
                             todos.getSize() + ")? ");
            String inputLocation = console.nextLine();
            int location = Integer.parseInt(inputLocation);
            todos.mark(location);
        }
        todos.printTodos();
    }


    // Behavior:
    //   - This method loads todo items from a specified file of user's input. 
    //      It clears the current TodoList and then adds items from the file.
    // Parameters:
    //   - console: the Scanner for user input.
    //   - todos: the TodoList of current todo items.
    // Returns:
    //   - None.
    // Exceptions:
    //   - FileNotFoundException: if the file does not exist.

    public static void loadItems(Scanner console, TodoList todos)
                                throws FileNotFoundException {

        System.out.print("File name? ");
        String fileName = console.nextLine();

        todos.load(fileName);
        todos.printTodos();
    }


    // Behavior:
    //   - This method saves the TodoList of todo items to a specified 
    //      file according to user's input.
    // Parameters:
    //   - console: the Scanner for user input.
    //   - todos: the TodoList of current todo items.
    // Returns:
    //   - None.
    // Exceptions:
    //   - FileNotFoundException: if the file is not found.

    public static void saveItems(Scanner console, TodoList todos)
                                throws FileNotFoundException {

        System.out.print("File name? ");
        String fileName = console.nextLine();

        todos.save(fileName);
        todos.printTodos();
    }

    // End of class.
}