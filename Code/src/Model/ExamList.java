package Model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ExamList
{
  private ArrayList<Exam> exams = new ArrayList<>();


  public void addExam(Exam exam){

    exams.add(exam);
  }

  public int size(){return exams.size();}
  public void removeExam(Exam exam){
    exams.remove(exam);
  }

  /**
   * Check for all rooms that were taken and if this room is taken for exactly this interval return true
   * If only one day return true and message with what days exactly
   * @param room
   * @param date
   * @return
   */
//  public boolean isRoomTaken(Room room,DateInterval date)
//  {
//    for(int i = 0;i<size();i++)
//    {
//      if(room.equals(exams.get(i).getRoom()) && ()
//    }
//    return false;
//  }

  public boolean isExaminerTaken(Examiner examiner,DateInterval dateInterval)
  {
    for(int i=0;i<size();i++)
    {
      if(exams.get(i).getExaminer().equals(examiner) && (exams.get(i).getDateInterval().isBetween(dateInterval.getStartDate()) || exams.get(i).getDateInterval().isBetween(dateInterval.getEndDate()))) return true;
    }
    return false;
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
}
