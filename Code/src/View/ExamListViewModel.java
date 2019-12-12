package View;

import Model.Exam;
import Model.ManageExamFiles;
import Model.ManageExamModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ExamListViewModel
{
  private ManageExamFiles files;
  private ManageExamModel model;
  private ObservableList<ExamViewModel> list;
  public ExamListViewModel(ManageExamModel model) throws FileNotFoundException
  {
    this.model=model;
    this.files = new ManageExamFiles();
    files.ReadExamList();
    list= FXCollections.observableArrayList();
  }

  public ObservableList<ExamViewModel> getList()
  {
    return list;
  }


    public ObservableList<ExamViewModel> update() throws FileNotFoundException,NullPointerException
  {
    ArrayList<Exam> exams = new ArrayList<>();
    System.out.println(files.getList().size());
    for(int i = 0;i<files.getList().size();i++)
    {
      exams.add(files.getList().get(i));
    }
    list.clear();
    for(int i=0;i<exams.size();i++)
    {
      list.add(new ExamViewModel(exams.get(i)));
    }
    return list;
  }
}
