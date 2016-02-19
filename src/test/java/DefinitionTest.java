import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void Definition_instantiatesCorrectly_true() {
    Definition myDefinition = new Definition("affable, to a fault");
    assertEquals(true, myDefinition instanceof Definition);
  }

  @Test
  public void Definition_instantiatesWithTextOfDefinition_true() {
    Definition myDefinition = new Definition("an exhaustive list");
    assertEquals("an exhaustive list", myDefinition.getDefintion());
  }

}
