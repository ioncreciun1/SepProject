package Model;

public class Course
{
  private String name;
  private Examiner teacher;

  public Course(Examiner teacher, String name){
    addExaminer(teacher,name);
  }

  public void addExaminer(Examiner teacher, String  name){
    this.name = name;
    this.teacher = teacher;

  }

  public String getCourseName(){
    return name;
  }

  public Examiner getTeacher(){
    return teacher;
  }

public String toString(){
    return "Course: " + name + "\n" + "Teacher: " + teacher;
}

public boolean equals(Object obj){
    if (!(obj instanceof Course))
      return false;
    Course other = (Course)obj;
    return this.name.equals(other.name) && this.teacher.equals(other.teacher);
}
}
