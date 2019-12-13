import Model.ManageExamModel;
import Model.ManageExamModelManager;
import View.ViewHandler;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class MyApplication extends Application
{
  public void start(Stage primaryStage) throws FileNotFoundException
  {
    ManageExamModel model = new ManageExamModelManager();
    ViewHandler view = new ViewHandler(model);
    view.start(primaryStage);
  }
}
