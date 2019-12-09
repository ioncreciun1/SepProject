package Model;

import java.util.ArrayList;

public class ExamList
{
  private ArrayList<Exam> exams = new ArrayList<>();
  private Course course;
  private Group group;

  public void addExam(Exam exam){
    exams.add(exam);
  }

  public void removeExam(Exam exam){
    exams.remove(exam);
  }

  public Exam getExam(Exam exam){
    for (int i = 0; i < exams.size(); i++)
    {
      if (exams.get(i).equals(exam)){
        return exams.get(i);
      }
    }
    return null;
  }
}
