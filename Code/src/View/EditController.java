package View;

import javafx.event.ActionEvent;
import javafx.scene.layout.Region;

import java.io.FileNotFoundException;

public class EditController
{
  private Region root;
  private ViewHandler viewHandler;
  public EditController(){}
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

  public void cancel(ActionEvent event) throws FileNotFoundException
  {
    viewHandler.openView("landing");
  }
}
