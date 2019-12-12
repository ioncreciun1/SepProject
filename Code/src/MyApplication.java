import View.ViewHandler;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class MyApplication extends Application
{
  public void start(Stage primaryStage) throws FileNotFoundException
  {
    ViewHandler view = new ViewHandler();
    view.start(primaryStage);
  }
}
