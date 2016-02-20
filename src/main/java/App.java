import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

        get("/", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();
          model.put("template", "templates/index.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/words/new", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();
          model.put("template", "templates/add-word.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();
          String newWordString = request.queryParams("word");
          Word newWord = new Word(newWordString);
          model.put("words", Word.all());
          model.put("template", "templates/index.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/:id", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();
          Word word = Word.find(Integer.parseInt(request.params(":id")));
          model.put("word", word);
          model.put("template", "templates/word-definitions.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/:id/newDefinition", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();
          Word word = Word.find(Integer.parseInt(request.params(":id")));
          model.put("word", word);
          model.put("template", "templates/add-definition.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/:id", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();
          String newDefinitionString = request.queryParams("definition");
          Definition newDef = new Definition(newDefinitionString);
          Word word = Word.find(Integer.parseInt(request.params(":id")));
          word.addDefinition(newDef);
          model.put("word", word);
          model.put("definitions", word.getDefinitions());
          model.put("template", "templates/word-definitions.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

    }
}
