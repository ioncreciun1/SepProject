package View;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

public class LandingController
{
  public Label errorLabel;
  private Region root;
  private ViewHandler viewHandler;
  public LandingController(){}

  public void addExamPressed(ActionEvent event)
  {
    viewHandler.openView("add");

  }
  public void init(ViewHandler viewHandler,  Region root)
  {
    this.viewHandler = viewHandler;
    this.root = root;
    reset();
  }
  public void reset() {
//    this.errorLabel.setText("");
  }

  public Region getRoot()
  {
    return root;
  }
  public void removeExamPressed(ActionEvent event)
  {
  }

  public void editExamPressed(ActionEvent event)
  {
    viewHandler.openView("edit");
  }
}
