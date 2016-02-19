import java.util.*;

public class Word {
  private static ArrayList<Word> words = new ArrayList<Word>();

  private String mWord;
  private int mId;
  private ArrayList<Definition> mDefinitions;


  public Word(String word) {
    mWord = word;
    words.add(this);
    mId = words.size();
    mDefinitions = new ArrayList<Definition>();
  }



}
