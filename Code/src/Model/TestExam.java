package Model;

import java.io.FileNotFoundException;

public class TestExam
{
  public static void main(String[] args) throws FileNotFoundException
  {

    Date date1 = new Date(4, 12, 2019, 8, 30);
   // System.out.println(date1);
    Date date2 = new Date(5, 12, 2019, 9, 30);
    Room room = new Room(true, true, 40, 10, "301.A");
    Examiner teacher1 = new Examiner("Bob");
    Examiner teacher2 = new Examiner("Bob");
    Course course = new Course(teacher1, "SDJ");
    Group group = new Group("Y", 30, 2);
//  Group group1 = new Group("X",25,5);
//   System.out.println(group1);
   // Date date3 = new Date(10,1,2000,8,30);
    ManageExamModelManager model = new ManageExamModelManager();
  Date date3 = new Date(10,1,2000,12,30);
//
 ManageExamFiles file = new ManageExamFiles();
 DateInterval dateInterval = new DateInterval(date1, date2);
    Exam testExam = new Exam(dateInterval, room, group, "Written", teacher2, course);
   model.addExam(testExam);
   file.ReadExamList();
   file.AddExamList(testExam);
    System.out.println(date3);




  //  System.out.println(model.getAllExams().getExam(0).getDateInterval());
  //  System.out.println( model.isRoomTaken("301.A",new DateInterval(date1,date2)));
//   for(int i = 0;i<model.getAllAvailableRooms(dateInterval).size();i++)
//    { System.out.println(model.getAllAvailableRooms(dateInterval).get(i).getNumber());}
//    model.addExam(testExam);
//    System.out.println(new DateInterval(date1,date2));
//    System.out.println(dateInterval);
//    System.out.println("IS between: " + dateInterval.isBetween(date3));
//  ManageExamModel model = new ManageExamModelManager();
//    ManageExamFiles files = new ManageExamFiles();
//    files.readGroupList();
//    //System.out.println(files.getGroupList());
//    System.out.println(model.getTeacherByCourseAndGroup("SDJ1","Y"));

   // System.out.println(model.isExaminerTaken(teacher2,new DateInterval(date2,date3)));
//    System.out.println(testExam);
//    System.out.println(dateInterval.isBetween(date3));
//ManageExamFiles file = new ManageExamFiles();
//file.AddExamList(testExam);
//    ManageExamFiles file = new ManageExamFiles();
//    file.ReadExamList();
//    for(int i=0;i<file.getList().size();i++)
//    {
//      System.out.println(file.getList().get(i));
//    }
   // System.out.println(room);
   // System.out.println(testExam);

    //  ManageExamFiles file = new ManageExamFiles();
    //  file.ReadExamList();
    //    System.out.println(file.getList().size());
    //  for(int i = 0;i<file.getList().size();i++)
    //  {
    //    System.out.println(file.getList().get(i));
    //  }
    //  }
  }
}
