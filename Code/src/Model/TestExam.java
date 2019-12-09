package Model;

public class TestExam
{
  public static void main(String[] args)
  {
    Date date1 = new Date(10,1,2000,9,30);
    Date date2 = new Date(10,1,2000,12,30);
    Room room = new Room(true, true, 10,10);
    Examiner teacher1 = new Examiner("Bob");
    Examiner teacher2 = new Examiner("Wade");
    Course course = new Course(teacher1,"SDJ");
    Group group = new Group("Y",10,1,course);
    DateInterval dateInterval = new DateInterval(date1,date2);
    Exam testExam = new Exam(dateInterval,room,group,"written",teacher2);


    System.out.println(testExam.toString());
  }
}
