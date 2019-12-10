package Model;

public class Exam
{
  private String type;
  private Group group;
  private Examiner examiners;
  private Room room;
  private DateInterval dateInterval;

  public Exam(DateInterval dateInterval,Room room, Group group, String type, Examiner examiners){
    this.room = room;
    this.group = group;
    this.type = type;
    this.examiners = examiners;
    this.dateInterval = dateInterval;
  }

  public DateInterval getDateInterval()
  {
    return dateInterval;
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

  public Examiner getExaminers()
  {
    return examiners;
  }


  public void setType(String type)
  {

    this.type = type;
  }

  public void setRooms(){
    this.room = room;
  }

  public boolean equals(Object obj){
    if (!(obj instanceof Exam))
      return false;
    Exam other = (Exam) obj;
    return this.dateInterval.equals(other.dateInterval) && this.type.equals(other.type) && this.group.equals(other.group) &&
        this.examiners.equals(other.examiners) && this.room.equals(other.room);
  }

  public String toString(){
    return "type="+getType()+" group="+getGroup().toString()+" examiners="+getExaminers().toString()+" room="+getRoom().toString() + " dateInterval="+getDateInterval().toString();
  }
}
