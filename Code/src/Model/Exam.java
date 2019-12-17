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

  /**
   * Six parameters Constructor.
   * Set room only if it is big enough
   *
   * @param dateInterval date Interval for exam
   * @param room room for exam
   * @param group class for this exam
   * @param type exam type
   * @param examiner external examiner
   * @param course course for this exam
   */
  public Exam(DateInterval dateInterval, Room room, Group group, String type,
      Examiner examiner, Course course)
  {
    if(room.getChairs() >= group.getNumberOfStudents())
      setRoom(room);
    this.group = group;
    setType(type);
     this.examiner = examiner;
    this.dateInterval = dateInterval;
    this.course = course;
  }

  /**
   *
   * @return date Interval
   */
  public DateInterval getDateInterval()
  {
    return dateInterval;
  }

  /**
   *
   * @return Course
   */
  public Course getCourse()
  {
    return course;
  }

  /**
   *
   * @return room
   */
  public Room getRoom()
  {
    return room;
  }

  /**
   *
   * @return group
   */
  public Group getGroup()
  {
    return group;
  }

  /**
   *
   * @return exam type
   */
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

  /**
   *
   * @param obj
   * @return true if this exam is equal to another
   */
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
