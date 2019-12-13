package Model;

import java.io.FileNotFoundException;

public class Exam
{
  private String type;
  private Group group;
  private Examiner examiner;
  private Room room;
  private DateInterval dateInterval;
  private Course course;

  public Exam(DateInterval dateInterval, Room room, Group group, String type,
      Examiner examiner, Course course)
  {
    if(room.getChairs() >= group.getNumberOfStudents()) // && isRoomTaken(room,dateInterval))
      setRoom(room);
    this.group = group;
    setType(type);

   //if(isExaminerTaken(examiner,dateInterval))
     this.examiner = examiner;
    this.dateInterval = dateInterval;
    this.course = course;
  }

  public DateInterval getDateInterval()
  {
    return dateInterval;
  }

  public Course getCourse()
  {
    return course;
  }

  public Room getRoom()
  {
    return room;
  }

  public Group getGroup()
  {
    return group;
  }

  public String getType()
  {
    return type;
  }

  /**
   * Setter for exam type. Exam type can be only Written or Oral, other values are not accepted
   *
   * @param type type of Exam
   */
  public void setType(String type)
  {
    if (type.equals("Oral") || type.equals("Written"))
    {
      this.type = type;
    }
  }





  public Examiner getExaminer()
  {
    return examiner;
  }

  /**
   * Setter for room
   *
   */
  public void setRoom(Room room)
  {

      this.room = room;

  }


  public boolean equals(Object obj)
  {
    if (!(obj instanceof Exam))
      return false;
    Exam other = (Exam) obj;
    return this.dateInterval.equals(other.dateInterval) && this.type
        .equals(other.type) && this.group.equals(other.group) && this.examiner
        .equals(other.examiner) && this.room.equals(other.room);
  }

  public String toString()
  {
    return "type=" + getType()
        + " group=" + getGroup().toString()
        + " examiners=" + getExaminer() +
        " room=" + getRoom().toString()
        + " dateInterval=" + getDateInterval().toString();
  }
}
