package View;

import javafx.scene.layout.Region;

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
}
