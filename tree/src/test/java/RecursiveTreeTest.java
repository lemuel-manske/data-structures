import org.junit.jupiter.api.BeforeEach;
import tree.RecursiveTree;

public class RecursiveTreeTest extends TreeTest {


    @BeforeEach
    void setTree() {
        tree = new RecursiveTree<>();
    }
}
