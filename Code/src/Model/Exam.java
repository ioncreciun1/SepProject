package Model;

public class Exam
{
  private String type;
  private Group group;
  private Examiner examiner;
  private Room room;
  private DateInterval dateInterval;
  private Course course;

  public Exam(DateInterval dateInterval,Room room, Group group, String type, Examiner examiner, Course course){
   setRoom(room);
    this.group = group;
    setType(type);
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

  public Group getGroup(){
    return group;
  }

  public String getType(){
    return type;
  }

  public Examiner getExaminer()
  {
    return examiner;
  }

  /**
   *Setter for exam type. Exam type can be only Written or Oral, other values are not accepted
   * @param type type of Exam
   */
  public void setType(String type)
  {
  if(type.equals("Oral") || type.equals("Written"))
   { this.type = type;}
  }

  /**
   * Setter for room. check if Room is suitable
   * @param room
   */
  public void setRoom(Room room){
    if(isRoomSuitable(room))
    {this.room = room;}
  }
  /**
   * Check if number of students is equal or less than number of chairs in this room
   * @param room
   * @return true if room is suitable
   */
  public boolean isRoomSuitable(Room room)
  {
    //System.out.println(room.getChairs());
    System.out.println(this.group);
    return true;
        //room.getChairs()>group.getNumberOfStudents();
  }

  public boolean equals(Object obj){
    if (!(obj instanceof Exam))
      return false;
    Exam other = (Exam) obj;
    return this.dateInterval.equals(other.dateInterval) && this.type.equals(other.type) && this.group.equals(other.group) &&
        this.examiner.equals(other.examiner) && this.room.equals(other.room);
  }

  public String toString(){
    return "type="+getType()+" group="+getGroup().toString()+" examiners="+getExaminer()+" room="+getRoom().toString() + " dateInterval="+getDateInterval().toString();
  }
}
