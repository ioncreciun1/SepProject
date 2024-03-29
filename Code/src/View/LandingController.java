package View;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;

import java.io.FileNotFoundException;
import java.util.Optional;

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

  public void addExamPressed() throws FileNotFoundException
  {
    viewHandler.openView("add");

  }
  public void init(ViewHandler viewHandler,ManageExamModel model,  Region root)
      throws FileNotFoundException
  {
    this.viewHandler = viewHandler;
    this.root = root;
    this.model=model;

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
    this.viewModel = new ExamListViewModel(model);
    errorLabel.setText("");
    tableViewExam.setItems(viewModel.update());

  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void removeExamPressed() throws FileNotFoundException {
    ManageExamFiles file = new ManageExamFiles();
    file.ReadExamList();
    file.readRoomList();
    file.readGroupList();
    errorLabel.setText("");
    try
    {
      ExamViewModel selectedItem = tableViewExam.getSelectionModel()
          .getSelectedItem();
      boolean remove = confirmation();
      if (remove)
      {
        //create exam to remove from file
        file.RemoveExamFromList(selectedItem.coursePropertyProperty().getValue(),Integer.parseInt(selectedItem.semesterPropertyProperty().getValue().toString()),selectedItem.groupPropertyProperty().getValue(),selectedItem.typePropertyProperty().getValue());
        //remove this exam from view
        viewModel.remove(selectedItem.coursePropertyProperty().get());

        tableViewExam.getSelectionModel().clearSelection();
      }
    }
    catch (Exception e)
    {
      errorLabel.setText("Item not found: " + e.getMessage());
    }
  }

  private boolean confirmation()
  {
    int index = tableViewExam.getSelectionModel().getSelectedIndex();
    ExamViewModel selectedItem = tableViewExam.getItems().get(index);
    if (index < 0 || index >= tableViewExam.getItems().size())
    {
      return false;
    }
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText(
        "Remove exam: " + selectedItem.coursePropertyProperty().get()
            + "-" +selectedItem.semesterPropertyProperty().get()  + selectedItem.groupPropertyProperty().get() + ", "
            + selectedItem.typePropertyProperty().get() + "?");
    Optional<ButtonType> result = alert.showAndWait();
    return (result.isPresent()) && (result.get() == ButtonType.OK);
  }

  public void editExamPressed(ActionEvent event) throws FileNotFoundException
  {
    if (!tableViewExam.getSelectionModel().isEmpty()){
      ManageExamFiles file = new ManageExamFiles();
      file.ReadExamList();
      ExamViewModel selectedItem = tableViewExam.getSelectionModel().getSelectedItem();
      viewHandler.setSelectedExam(file.getExamList().getExam(selectedItem.coursePropertyProperty().getValue(),Integer.parseInt(selectedItem.semesterPropertyProperty().getValue().toString()),selectedItem.groupPropertyProperty().getValue(),selectedItem.typePropertyProperty().getValue()));
      viewHandler.openView("edit");
    }
  }
}
