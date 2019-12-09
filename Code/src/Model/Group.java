package Model;

public class Group
{
private String name;
private int numberOfStudents;
private int semester;
private Course course;

public Group(String name, int numberOfStudents , int semester, Course course){
  this.name = name;
  this.numberOfStudents = numberOfStudents;
  this.semester = semester;
  this.course = course;
}

public int getNumberOfStudents(){
  return numberOfStudents;
}

public int getSemester(){
  return semester;
}
public String  getName(){
  return name;
}

public void setNumberOfStudents(int numberOfStudents){
  this.numberOfStudents = numberOfStudents;
}

public boolean equals(Object obj){
  if (!(obj instanceof Group))
    return false;
  Group other = (Group) obj;
  return this.numberOfStudents==other.numberOfStudents && this.name.equals(other.name) &&
      this.semester==other.semester && this.course.equals(other.course);
}

public String toString(){
  return "Name: " + name + "Number of Students: " + numberOfStudents + "\n" + "Semester: " + semester + "Course: " + course;
}
}
