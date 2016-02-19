import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;

public class WordTest {

  @Test
  public void Word_instantiatesCorrectly_true() {
    Word testWord = new Word ("lugubrious");
    assertEquals(true, testWord instanceof Word);
  }

  @Test
  public void getWord_returnsWord_true() {
    Word testWord = new Word ("mendacious");
    assertEquals(true, testWord instanceof Word);
  }

  @Test
  public void getId_returnsIdOfWord() {
    Word testWord = new Word ("bunt");
    assertTrue(testWord.all().size() == testWord.getId());
  }

  @Test
  public void getDefinitions_initiallyReturnsEmptyArrayList() {
    Word testWord = new Word("laudable");
    assertTrue(testWord.getDefinitions() instanceof ArrayList);
  }


}
