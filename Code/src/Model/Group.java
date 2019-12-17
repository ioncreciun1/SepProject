package Model;

import java.util.ArrayList;

public class Group
{
private String name;
private int numberOfStudents;
private int semester;
private ArrayList<Course> courses;

  /**
   *Three parameter Constructor
   * @param name name of Group
   * @param numberOfStudents number of students
   * @param semester number of semester
   */
  public Group(String name, int numberOfStudents , int semester){
  this.name = name;
  this.courses = new ArrayList<>();
setNumberOfStudents(numberOfStudents);
setSemester(semester);


}

  /**
   * add one course
   * @param course one course for this group
   */
  public void addCourse(Course course)
{
  courses.add(course);
}

  /**
   * add all courses
   * @param courses all courses for this group
   */
  public void setCourses(ArrayList<Course> courses)
  {
    this.courses = courses;
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

public  ArrayList<Course> getCourses() {
    return courses;
}

  /**
   *
   * @return name of group as string
   */
  public String  getName(){
  return name;
}

  /**
   * setting semester. If semester is from 1 to seven then we assign it
   * @param semester the semester
   */
  public void setSemester(int semester)
  {
    if(semester > 0 && semester <=7)
    {this.semester = semester; }
  }

  /**
   *  Setting number of Students. set number of students only if number is positive
   * @param numberOfStudents number of Students
   */
  public void setNumberOfStudents(int numberOfStudents){
  if(numberOfStudents > 0) this.numberOfStudents = numberOfStudents;
}

  /**
   *
   * @param obj
   * @return true if object have same information
   */
  public boolean equals(Object obj){
  if (!(obj instanceof Group))
    return false;
  Group other = (Group) obj;
  return this.numberOfStudents==other.numberOfStudents && this.name.equals(other.name) &&
      this.semester==other.semester  && this.courses.equals(other.courses);
}

  /**
   *
   * @return group as string
   */
  public String toString(){
    String s = "";
    for(int i = 0;i<courses.size();i++)
    {
      s+=courses.get(i) + "\n";
    }
  return "Name: " + name + "\nNumber of Students: " + numberOfStudents + "\n" + "Semester: " + semester + "\n" + s;
}
}
