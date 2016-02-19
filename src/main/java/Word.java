import java.util.*;

public class Word {
  private static ArrayList<Word> words = new ArrayList<Word>();

  private static ArrayList<Definition> mDefinitions;
  private String mWord;
  private int mId;


  public Word(String word) {
    mWord = word;
    words.add(this);
    mId = words.size();
    mDefinitions = new ArrayList<Definition>();
  }

  public String getWord() {
    return mWord;
  }

  public Integer getId() {
    return mId;
  }

  public static ArrayList<Definition> getDefinitions() {
    return mDefinitions;
  }

  public void addDefinition(Definition definition) {
    mDefinitions.add(definition);
  }

  public static ArrayList<Word> all() {
    return words;
  }

  public static void clearWords() {
    words = new ArrayList<Word>();
  }

  public static void clearDefinitions() {
    mDefinitions = new ArrayList<Definition>();
  }

  public static Word find(int id) {
    try {
      return words.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }



}
