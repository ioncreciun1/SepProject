package View;

import Model.ManageExamModel;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;

import java.io.FileNotFoundException;

public class LandingController
{
  public Label errorLabel;
  public TableView<ExamViewModel> tableViewExam;
  public TableColumn<ExamViewModel,Number> semesterColumn;
  public TableColumn<ExamViewModel, String> courseColumn;
  public TableColumn<ExamViewModel, String> groupColumn;
  public TableColumn<ExamViewModel, String> ExaminersColumn;
  public TableColumn<ExamViewModel, String> typeColumn;
  public TableColumn<ExamViewModel, String> roomColumn;
  public TableColumn<ExamViewModel, String> startTimeColumn;
  public TableColumn<ExamViewModel, String> endTimeColumn;
  private Region root;
  private ViewHandler viewHandler;
  private ManageExamModel model;
  private ExamListViewModel viewModel;
  public LandingController(){}

  public void addExamPressed(ActionEvent event) throws FileNotFoundException
  {
    viewHandler.openView("add");

  }
  public void init(ViewHandler viewHandler,ManageExamModel model,  Region root)
      throws FileNotFoundException
  {
    this.viewHandler = viewHandler;
    this.root = root;
    this.model=model;
    this.viewModel = new ExamListViewModel(model);

semesterColumn.setCellValueFactory( cellDate -> cellDate.getValue().semesterPropertyProperty());
courseColumn.setCellValueFactory(cellData -> cellData.getValue().coursePropertyProperty());
groupColumn.setCellValueFactory(cellData -> cellData.getValue().groupPropertyProperty());
roomColumn.setCellValueFactory(cellData -> cellData.getValue().roomPropertyProperty());
ExaminersColumn.setCellValueFactory(cellData -> cellData.getValue().examinerPropertyProperty());
typeColumn.setCellValueFactory(cellData -> cellData.getValue().typePropertyProperty());
startTimeColumn.setCellValueFactory(cellDate -> cellDate.getValue().startYearPropertyProperty());
    endTimeColumn.setCellValueFactory(cellDate -> cellDate.getValue().endYearPropertyProperty());
    reset();

  }
  public void reset() throws FileNotFoundException
  {
    errorLabel.setText("");
    tableViewExam.setItems(viewModel.update());
  }

  public Region getRoot()
  {
    return root;
  }
  public void removeExamPressed(ActionEvent event)
  {
  }

  public void editExamPressed(ActionEvent event) throws FileNotFoundException
  {
    viewHandler.openView("edit");
  }
}
