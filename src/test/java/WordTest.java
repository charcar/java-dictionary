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

  @Test
  public void addDefinition_addsADefinitionToArrayList() {
    Word testWord = new Word("petty");
    Definition testDefinition = new Definition("trivial, trifling");
    testWord.addDefinition(testDefinition);
    assertTrue(testWord.getDefinitions().contains(testDefinition));
  }

  @Test
  public void all_returnsAllInstancesofWord_true() {
    Word firstWord = new Word("Black");
    Word secondWord = new Word("Adder");
    assertTrue(Word.all().contains(firstWord));
    assertTrue(Word.all().contains(secondWord));
  }

  @Test
  public void clear_removesAllWordInstancesFromMemory() {
    Word testWord = new Word("destruction");
    Word.clearWords();
    assertEquals(Word.all().size(), 0);
  }
}
