package View;

import Model.ManageExamModel;
import Model.ManageExamModelManager;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import java.io.FileNotFoundException;

public class EditController
{
  public TextField semesterField;
  public DatePicker dateStartField;
  public TextField courseField;
  public TextField timeStartField;
  public TextField groupField;
  public DatePicker dateEndField;
  public ComboBox typeField;
  public TextField timeEndField;
  public ComboBox roomField;
  public TextField examinerField;
  private Region root;
  private ManageExamModel model;
  private ViewHandler viewHandler;
  public EditController(){}
  public void init(ViewHandler viewHandler, ManageExamModel model,Region root)
  {
    this.viewHandler = viewHandler;
    this.root = root;
    this.model=model;

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
