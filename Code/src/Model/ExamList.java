package Model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ExamList
{
  private ArrayList<Exam> exams;

  /**
   * Zero parameter constructor.
   */
  public ExamList() {
    exams = new ArrayList<>();
  }

  /**
   * add Exam to list
   * @param exam
   */
  public void addExam(Exam exam){

    exams.add(exam);
  }

  /**
   *
   * @param exams list of exams
   */
  public void setExams(ArrayList<Exam> exams) {
    this.exams = exams;
  }

  /**
   *
   * @return total number of exams
   */
  public int size(){return exams.size();}

  /**
   * Remove an exam
   * @param exam
   */
  public void removeExam(Exam exam){
    exams.remove(exam);
  }

  /**
   *
   * @param index index in list
   * @return exam by index
   */
  public Exam getExam(int index)
  {
    return exams.get(index);
  }

  /**
   *
   * @param exam
   * @return exam if it is equal to another
   */
  public Exam getExam(Exam exam){
    for (int i = 0; i < exams.size(); i++)
    {
      if (exams.get(i).equals(exam)){
        return exams.get(i);
      }
    }
    return null;
  }

  /**
   * remove an exam by course name,semester,group name and type
   * @param course course of exam
   * @param semester group semester
   * @param group group name
   * @param type exam type
   */
  public void removeExam(String course, int semester, String group, String type){
    System.out.println("INPUT COURSE"+course);
  for(int i = 0; i < exams.size(); i++)
  {
    if(exams.get(i).getCourse().getCourseName().equals(course) && exams.get(i).getGroup().getSemester() == semester && exams.get(i).getGroup().getName().equals(group) && exams.get(i).getType().equals(type))
    {
      exams.remove(exams.get(i));
    }
  }
  }

  /**
   *
   * @return all exams as string
   */
  public String toString() {

return exams.toString();
  }
}
