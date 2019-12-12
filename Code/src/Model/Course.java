package Model;

public class Course
{
  private String name;
  private Examiner teacher;

  /**
   * Contructor with 2 parameters that are initialize with method addExaminer
   *
   * @param teacher
   * @param name
   */
  public Course(Examiner teacher, String name)
  {
    addExaminer(teacher, name);
  }

  /**
   * Set Teacher and course name
   * If course Name is null or it is bigger than 4 then value are not assigned
   *
   * @param teacher Teacher for this course
   * @param name    course name
   */
  public void addExaminer(Examiner teacher, String name)
  {
    if (!name.equals("") && name.length() < 5)
    {
      this.name = name;
      this.teacher = teacher;
    }
  }

  /**
   * Getter for course name
   *
   * @return course name as String
   */
  public String getCourseName()
  {
    return name;
  }

  public Examiner getTeacher()
  {
    return teacher;
  }

  public String toString()
  {
    return "Course: " + name + "\n" + "Teacher: " + teacher;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Course))
      return false;
    Course other = (Course) obj;
    return this.name.equals(other.name) && this.teacher.equals(other.teacher);
  }
}
