import org.junit.*;
import static org.junit.Assert.*;
import org.junit.ClassRule;
import org.junit.Test;
import java.util.*;
import org.fluentlenium.adapter.FluentTest;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @Rule
  public ClearRule clearRule = new ClearRule();

  @ClassRule
  public static ServerRule server = new ServerRule();


  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("your dictionary");
  }

  @Test
  public void navigatesToAddWord() {
    goTo("http://localhost:4567/");
    click("a", withText("add a new word"));
    assertThat(pageSource()).contains("add a new word to the dictionary");
  }

  @Test
  public void wordisCreatedandDisplayedinIndex() {
    goTo("http://localhost:4567/");
    click("a", withText("add a new word"));
    fill("#word").with("remoulade");
    submit(".btn");
    assertThat(pageSource()).contains("remoulade");
  }

  @Test
  public void navigatesToDynamicWord() {
    goTo("http://localhost:4567/");
    click("a", withText("add a new word"));
    fill("#word").with("remoulade");
    submit(".btn");
    click("a", withText("remoulade"));
    assertThat(pageSource()).contains("remoulade");
  }

  // @Test
  // public void

}
