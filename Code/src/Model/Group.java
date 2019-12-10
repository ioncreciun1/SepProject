package Model;

public class Group
{
private String name;
private int numberOfStudents;
private int semester;

  /**
   *Three parameter Constructor: If number of students is negative then convert to positive.
   * If semester is negative convert to positive,
   * else if Semester is bigger than seven then set it to seven
   * @param name name of Group
   * @param numberOfStudents
   * @param semester

   */
  public Group(String name, int numberOfStudents , int semester){
  this.name = name;
setNumberOfStudents(numberOfStudents);
setSemester(semester);

}

  /**
   *
   * @return number of students
   */
  public int getNumberOfStudents(){
  return numberOfStudents;
}

  /**
   *
   * @return semester as integer between 1 and 7
   */
  public int getSemester(){
  return semester;
}

  /**
   *
   * @return name of group as
   */
  public String  getName(){
  return name;
}

  /**
   * setting semester. Negative semester is converting to positive, Semester bigger than seven si set to seven
   * If semester is equal to zero then it is set to one
   * @param semester the semester
   */
  public void setSemester(int semester)
  {
    if(semester<0) this.semester = -semester;
    else if(semester>7) this.semester = 7;
    else if(semester == 0) this.semester = 1;
    else this.semester = semester;
  }

  /**
   *  Setting number of Students. Negative number is converting to positive
   * @param numberOfStudents number of Students
   */
  public void setNumberOfStudents(int numberOfStudents){
  if(numberOfStudents<0) this.numberOfStudents = -numberOfStudents;
  else this.numberOfStudents = numberOfStudents;
}

public boolean equals(Object obj){
  if (!(obj instanceof Group))
    return false;
  Group other = (Group) obj;
  return this.numberOfStudents==other.numberOfStudents && this.name.equals(other.name) &&
      this.semester==other.semester ;
}

public String toString(){
  return "Name: " + name + "Number of Students: " + numberOfStudents + "\n" + "Semester: " + semester;
}
}
