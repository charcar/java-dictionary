import java.util.*;

public class Definition {

  private String mDefinition;
  private static ArrayList<Definition> instances =new ArrayList<Definition>();

  public Definition(String definition) {
    mDefinition = definition;
  }

  public String getDefinition() {
    return mDefinition;
  }

  private static ArrayList<Definition> all() {
    return instances;
  }

}
