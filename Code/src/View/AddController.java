package View;

import javafx.event.ActionEvent;
import javafx.scene.layout.Region;

public class AddController
{
  private Region root;
  private ViewHandler viewHandler;
  public AddController(){}
  public void init(ViewHandler viewHandler,  Region root)
  {
    this.viewHandler = viewHandler;
    this.root = root;
    reset();
  }
  public void reset() {

  }

  public Region getRoot()
  {
    return root;
  }

  public void cancel(ActionEvent event)
  {
    viewHandler.openView("landing");
  }
}
