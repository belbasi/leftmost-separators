package IOTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static main.IOUtility.readFromFile;

public class IOUTilityTest {

    @Test
    public void testReadFromFileGivenEdges() {
        final String path = "C:\\Users\\mahdi\\OneDrive\\Documents\\GitHub\\leftmost-separators\\src\\main\\resources\\configuration\\example-graph-with-edges.json";
        Assertions.assertEquals(1, readFromFile(path));
    }
}
