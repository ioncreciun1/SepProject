package Model;

public class Course
{
  private String name;
  private Examiner teacher;

  /**
   * Constructor with 2 parameters that are initialize with method addExaminer
   * you can only assign values if name is not null and not bigger than 5 characters
   *
   * @param teacher teacher
   * @param name course name
   */
  public Course(Examiner teacher, String name)
  {
    addExaminer(teacher, name);
  }

  /**
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
   *
   * @return course name as String
   */
  public String getCourseName()
  {
    return name;
  }

  /**
   *
   * @return teacher for this course
   */
  public Examiner getTeacher()
  {
    return teacher;
  }

  /**
   *
   * @return course name and teacher name
   */
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
