// Ivonne Zhang
// 05/30/2024

import java.util.*;
import java.io.*;

// This class represents a TODO list manager. It provides functionalities to add,
// remove, mark as done, load from a file, save to a file, and print TODO items.
// The class uses an ArrayList to store the list of TODO items.

public class TodoList {
    
    // TODO: Your code here! 
    private List<String> todos;

    // Behavior:
    //   - Constructor that initializes the ArrayList to store todo items
    // Parameters:
    //   - None.
    // Returns:
    //   - None.
    // Exceptions:
    //   - None.

    public TodoList(){
        this.todos = new ArrayList<>();
    }


    // Behavior:
    //   - Returns the number of items in the TodoList.
    // Parameters:
    //   - None.
    // Returns:
    //   - int: The size of the Todolist
    // Exceptions:
    //   - None.

    public int getSize(){
        return todos.size();
    }


    // Behavior:
    //   - Get the given index of item from the TodoList.
    // Parameters:
    //   - int: the given index.
    // Returns:
    //   - String: the item at given index.
    // Exceptions:
    //   - None.

    public String get(int i){
        return todos.get(i);
    }


    // Behavior:
    //   - Checks if the TodoList is empty or not.
    // Parameters:
    //   - None.
    // Returns:
    //   - boolean: true if the TodoList is empty.
    //              false if the TodoList is NOT empty.
    // Exceptions:
    //   - None.

    public boolean isEmpty(){
        if (todos.size() != 0){
            return false;
        }
        return true;
    }


    // Behavior:
    //   - Returns the index of the given todo item.
    // Parameters:
    //   - String: the given todo item.
    // Returns:
    //   - int: The index of the item
    // Exceptions:
    //   - None.

    public int indexOf(String item){
        return todos.indexOf(item);
    }


    // Behavior:
    //   - Set the index in the TodoList to another item.
    // Parameters:
    //   - int: index of item to be replaced.
    //   - String: item to replace.
    // Returns:
    //   - None.
    // Exceptions:
    //   - None.

    public void set(int i, String item){
        todos.set(i, item);
    }


    // Behavior:
    //   - Add a todo item to the TodoList at the back.
    // Parameters:
    //   - String: the item to be added.
    // Returns:
    //   - None.
    // Exceptions:
    //   - None.

    public void add(String item){
        todos.add(item);
    }


    // Behavior:
    //   - Add a todo item to the TodoList at the desired index. 
    // Parameters:
    //   - int: the index to be added.
    //   - String: the item to be added.
    // Returns:
    //   - None.
    // Exceptions:
    //   - None.

    public void add(int i, String item){
        todos.add(i, item);
    }


    // Behavior:
    //   - Remove the item in the TodoList at the given index.
    // Parameters:
    //   - int: the index of the item to be removed
    // Returns:
    //   - None.
    // Exceptions:
    //   - None.

    public void remove(int i){
        todos.remove(i);
    }


    // Behavior:
    //   - Clear the TodoList.
    // Parameters:
    //   - None.
    // Returns:
    //   - None.
    // Exceptions:
    //   - None.

    public void clear(){
        todos.clear();
    }


    // Behavior:
    //   - Print the TodoList in order. 
    //     If there is nothing in the TodoList, return a message.
    // Parameters:
    //   - None.
    // Returns:
    //   - None.
    // Exceptions:
    //   - None.

    public void printTodos() {
        System.out.println("Today's TODOs:");
        if (todos.size() != 0){
            for (int i = 0; i < todos.size(); i++){
                System.out.println("  " + (i+1) + ": " + todos.get(i));
            }
        } else {
            System.out.println("  You have nothing to do yet today! Relax!");
        }
    }


    // Behavior:
    //   - Mark the todo at the given index to be done. 
    // Parameters:
    //   - int: the index of the item going to be removed.
    // Returns:
    //   - None.
    // Exceptions:
    //   - None.

    public void mark(int index) {
        todos.remove(index-1);
    }


    // Behavior:
    //   - Load all the todo items into a file.
    //     Clear the current todos, and load the file to the TodoList.
    // Parameters:
    //   - String: the fileName to be loaded.
    // Returns:
    //   - None. 
    // Exceptions:
    //   - FileNotFoundException: if the file is not found. 

    public void load(String fileName) throws FileNotFoundException{
        Scanner fileScan = new Scanner(new File(fileName));
        todos.clear();
        while (fileScan.hasNextLine()){
            String line = fileScan.nextLine();
            todos.add(line);
        }
    }


    // Behavior:
    //   - Save the current TodoList into a file. 
    // Parameters:
    //   - String: the fileName to be saved.
    // Returns:
    //   - None. 
    // Exceptions:
    //   - FileNotFoundException: if the file is not found. 

    public void save(String fileName) throws FileNotFoundException{

        File fileTodo = new File(fileName);
        PrintStream output = new PrintStream(fileTodo);

        for(int i = 0; i < todos.size(); i ++){
            output.println(todos.get(i));
        }
    }

    // End of class. 
}