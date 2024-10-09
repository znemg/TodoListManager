// Ivonne Zhang
// 05/30/2024

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.io.*;

public class TodoListTest {
    
    @Test
    @DisplayName("Test getSize()")
    public void testGetSize(){
        TodoList td1 = new TodoList();
        td1.add("CSE homework");
        td1.add("test1");
        td1.add("test2");
        
        int expectedSize = 3;
        int actualSize = td1.getSize();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    @DisplayName("Test get()")
    public void testGet(){
        TodoList td2 = new TodoList();
        td2.add("English homework");
        td2.add("test1");
        td2.add("test2");

        String expectedGet = "test1";
        String actualGet = td2.get(1);

        assertEquals(expectedGet, actualGet);
    }

    @Test
    @DisplayName("Test isEmpty()")
    public void testIsEmpty(){
        TodoList td3 = new TodoList();

        assertTrue(td3.isEmpty());

        td3.add("Math homework");
        td3.add("test1");
        td3.add("test2");

        assertFalse(td3.isEmpty());
    }

    @Test
    @DisplayName("Test indexOf()")
    public void testIndexOf(){
        TodoList td4 = new TodoList();
        td4.add("Physics homework");
        td4.add("test1");
        td4.add("test2");

        int expectedIndex = 1;
        int actualIndex = td4.indexOf("test1");

        assertEquals(expectedIndex, actualIndex);

    }

    @Test
    @DisplayName("Test set()")
    public void testSet(){
        TodoList td5 = new TodoList();
        td5.add("Do laundary");
        td5.add("test1");
        td5.add("test2");

        td5.set(1, "updated test1");

        String expectedSet = "updated test1";
        String actualSet = td5.get(1);

        assertEquals(expectedSet, actualSet);
    }


    @Test
    @DisplayName("Test add()")
    public void testAdd(){
        TodoList td6 = new TodoList();
        td6.add("Isarn Thai Soul Kitchen");
        td6.add("Kin Len Thai");

        String expectedAdd = "Kin Len Thai";
        String actualAdd = td6.get(td6.getSize()-1);

        assertEquals(expectedAdd, actualAdd);
    }

    @Test
    @DisplayName("Test add(int, String)")
    public void testAddAtIndex(){
        TodoList td7 = new TodoList();
        td7.add("Get an airbnb by Sea-Tac airport");
        td7.add("Delta Flight to Shanghai");
        td7.add(1, "buy some ice cream");

        String expectedAddAtIndex = "buy some ice cream";
        String actualAddAtIndex = td7.get(1);

        assertEquals(expectedAddAtIndex, actualAddAtIndex);
    }


    @Test
    @DisplayName("Test remove()")
    public void testRemove(){
        TodoList td8 = new TodoList();
        td8.add("Coca-Cola");
        td8.add("Pepsi");
        td8.remove(1);

        int expectedSizeAfterRemove = 1;
        int actualSizeAfterRemove = td8.getSize();

        assertEquals(expectedSizeAfterRemove, actualSizeAfterRemove);
    }

    @Test
    @DisplayName("Test clear()")
    public void testClear(){
        TodoList td9 = new TodoList();
        td9.add("Orange");
        td9.add("Blue");
        td9.add("Purple");

        td9.clear();

        assertTrue(td9.isEmpty());
    }


    @Test
    @DisplayName("Test mark()")
    public void testMark(){
        TodoList td11 = new TodoList();
        td11.add("Try");
        td11.add("Almond Croissant");
        td11.add("In Bulldog Cafe:)");

        td11.mark(2);

        assertEquals(2, td11.getSize());
        assertEquals("In Bulldog Cafe:)", td11.get(1));
    }


    @Test
    @DisplayName("Test load()")
    public void testLoad() throws FileNotFoundException {
        TodoList td12 = new TodoList();

        PrintStream out = new PrintStream("testfile.txt");
        out.println("happy1");
        out.println("happy2");

        td12.load("testfile.txt");

        assertEquals(2, td12.getSize());
        assertEquals("happy1", td12.get(0));
        assertEquals("happy2", td12.get(1));
    }

    @Test
    @DisplayName("Test save()")
    public void testSave() throws FileNotFoundException {
        TodoList td13 = new TodoList();
        td13.add("summer");
        td13.add("where is seattle summer");

        td13.save("testsavefile.txt");

        Scanner fileScan = new Scanner(new File("testsavefile.txt"));
        List<String> items = new ArrayList<>();
        while (fileScan.hasNextLine()){
            items.add(fileScan.nextLine());
        }

        assertEquals(2, items.size());
        assertEquals("summer", items.get(0));
        assertEquals("where is seattle summer", items.get(1));
    }

}