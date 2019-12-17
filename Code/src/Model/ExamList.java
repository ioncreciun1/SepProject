package Model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ExamList
{
  private ArrayList<Exam> exams = new ArrayList<>();


  public void addExam(Exam exam){

    exams.add(exam);
  }

  public void setExams(ArrayList<Exam> exams) {
    this.exams = exams;
  }

  public int size(){return exams.size();}
  public void removeExam(Exam exam){
    exams.remove(exam);
  }
  public Exam getExam(int index)
  {
    return exams.get(index);
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

  public void removeExam(String course, int semester, String group, String type){
    System.out.println("INPUT COURSE"+course);
  for(int i = 0; i < exams.size(); i++)
  {
    if(exams.get(i).getCourse().getCourseName().equals(course) && exams.get(i).getGroup().getSemester() == semester && exams.get(i).getGroup().getName().equals(group) && exams.get(i).getType().equals(type))
    {
      exams.remove(exams.get(i));
    }
  }
    System.out.println("ERROR EXAM NOT FOUND BY COURSE");
  }

  public Exam getExam(String course, int semester, String group, String type){
    System.out.println("INPUT COURSE"+course);
    for(int i = 0; i < exams.size(); i++)
    {
      if(exams.get(i).getCourse().getCourseName().equals(course) && exams.get(i).getGroup().getSemester() == semester && exams.get(i).getGroup().getName().equals(group) && exams.get(i).getType().equals(type))
      {
        return exams.get(i);
      }
    }
    System.out.println("ERROR EXAM NOT FOUND BY COURSE");
    return null;
  }

  public String toString() {

return exams.toString();
  }
}
