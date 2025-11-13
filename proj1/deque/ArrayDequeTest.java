package deque;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
    /** Test if the addFirst and isEmpty funciton works well*/
    @Test
    public void addFirstIsEmptyTest() {
        ArrayDeque<String> alst = new ArrayDeque();
        assertEquals(true, alst.isEmpty());
        alst.addFirst("I");
        alst.addFirst("Love");
        alst.addFirst("Toby");
        assertEquals(false, alst.isEmpty());
    }
}
