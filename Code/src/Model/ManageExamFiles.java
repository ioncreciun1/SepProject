package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageExamFiles
{
 private ArrayList<Exam> list = new ArrayList<>();
 private RoomList roomList = new RoomList();
  public void addRoomToList(Room room) throws FileNotFoundException
  {
    readRoomList();
    roomList.addRoom(room);
    String fileName = "RoomList.txt";
    File file = new File(fileName);
    PrintWriter writer = new PrintWriter(file);
    String xml = "";
    xml += "<?xml version=\"1.0\" encoding=\"UTF-8\"" + "standalone=\"no\"?>\n";
    xml +="<RoomList>";
    for(int i = 0; i<roomList.getRoomList().size();i++)
    {
      Room roomI = roomList.getRoomList().get(i);
      xml +="\n<Room>";
      xml +="\n<HDMI>" + roomI.isHDMI() + "</HDMI>";
      xml +="\n<VGA>" + roomI.isVGA() + "</VGA>";
      xml +="\n<Chairs>" + roomI.getChairs() + "</Chairs>";
      xml+= "\n<Tables>" + roomI.getTables() + "</Tables>";
      xml+="\n<RoomID>"+ roomI.getNumber() + "</RoomID>";
      xml +="\n</Room>";
    }
    xml +="\n<RoomList>";
    writer.println(xml);
    writer.flush();
    writer.close();
  }
  public void readRoomList() throws FileNotFoundException,NullPointerException
  {
    File file = new File("RoomList.txt");
    Scanner in = new Scanner(file);
    boolean HDMI = false;
    boolean VGA = false;
    int chairs = 0;
    int tables = 0;
    String roomId = "";

    while(in.hasNext()) {
      String line = in.next();
      if(line.contains("<HDMI>")) {
        line = line.replace("<HDMI>", "");
        line = line.replace("</HDMI>", "");
        String hdmiS = line.trim();
        HDMI = hdmiS.equals("true");
      }
      else if(line.contains("<VGA>")) {
        line = line.replace("<VGA>", "");
        line = line.replace("</VGA>", "");
        String vgaS = line.trim();
        VGA = vgaS.equals("true");
      }
      else if(line.contains("<Chairs>"))
      {
        line = line.replace("<Chairs>", "");
        line = line.replace("</Chairs>", "");
        chairs = Integer.parseInt(line.trim());
      }
      else if(line.contains("<Tables>"))
      {
        line = line.replace("<Tables>", "");
        line = line.replace("</Tables>", "");
        tables = Integer.parseInt(line.trim());
      }
      else if(line.contains("<RoomID>"))
      {
        line = line.replace("<RoomID>", "");
        line = line.replace("</RoomID>", "");
        roomId = line.trim();
      }
      if(line.contains("</Room>"))
      {
        Room room = new Room(HDMI,VGA,chairs,tables,roomId);
        roomList.addRoom(room);
      }
    }

  }
  public void AddExamList(Exam exam) throws FileNotFoundException
  {
    ReadExamList();
    list.add(exam);
    String fileName = "ExamList.txt";
    File file = new File(fileName);
    PrintWriter writer = new PrintWriter(file);
    String xml = "";
    xml += "<?xml version=\"1.0\" encoding=\"UTF-8\"" + "standalone=\"no\"?>\n";
    xml +="<ExamList>";
    for(int i = 0; i<list.size();i++)
    {
    xml +="\n<Exam>";
    xml +="\n<Semester>" + list.get(i).getGroup().getSemester() + "</Semester>";
    xml +="\n<Course>" +  list.get(i).getCourse().getCourseName() + "</Course>";
    xml +="  \n<Group>" +  list.get(i).getGroup().getName() + "</Group>";
      xml += "     \n<Examiners>";
//          xm+ testExam.getExaminer() + "/" + testExam.getCourse().getTeacher()
      xml+= "\n<Teacher>" +  list.get(i).getCourse().getTeacher() + "</Teacher>";
      xml+="\n<Examiner>"+  list.get(i).getExaminer() + "<Examiner>";
    xml += "\n</Examiners>";
      xml += "     \n<Type>"  +  list.get(i).getType()  + "</Type>";
    xml += "  \n<RoomNumber>" +  list.get(i).getRoom().getNumber() + "</RoomNumber>";
    xml += "   \n <StartDate>" ;
    xml+="\n<StartYear>" +  list.get(i).getDateInterval().getStartDate().getYear() + "</StartYear>";
      xml+="\n<StartMonth>" +  list.get(i).getDateInterval().getStartDate().getMonth() + "</StartMonth>";
      xml+="\n<StartDay>" +  list.get(i).getDateInterval().getStartDate().getDay() + "</StartDay>";
      xml+="\n<StartHour>" +  list.get(i).getDateInterval().getStartDate().getHour() + "</StartHour>";
      xml+="\n<StartMinute>" +  list.get(i).getDateInterval().getStartDate().getMinute() + "</StartMinute>";
  xml       += "\n</StartDate>";
      xml += "   \n <EndDate>" ;
      xml+="\n<EndYear>" +  list.get(i).getDateInterval().getEndDate().getYear() + "</EndYear>";
      xml+="\n<EndMonth>" +  list.get(i).getDateInterval().getEndDate().getMonth() + "</EndMonth>";
      xml+="\n<EndDay>" +  list.get(i).getDateInterval().getEndDate().getDay() + "</EndDay>";
      xml+="\n<EndHour>" +  list.get(i).getDateInterval().getEndDate().getHour() + "</EndHour>";
      xml+="\n<EndMinute>" +  list.get(i).getDateInterval().getEndDate().getMinute() + "</EndMinute>";
      xml       += "\n</EndDate>";
    xml +="\n</Exam>";
    }
    xml +="\n<ExamList>";
    writer.println(xml);
    writer.flush();
    writer.close();
  }
  public void ReadExamList() throws FileNotFoundException,NullPointerException
  {

  File file = new File("ExamList.txt");
    Scanner in = new Scanner(file);
    int semester = 0;
    String courseName = null;
    String teacher = null;
    String groupName = null;
    String Examiner = null;
        String type = null;
        String RoomNumber = null;
        int StartYear = 0;
        int StartMonth = 0;
        int StartDay=0;
        int StartHour = 0;
        int StartMinute = 0;
    int EndYear = 0;
    int EndMonth = 0;
    int EndDay=0;
    int EndHour = 0;
    int EndMinute = 0;
    while(in.hasNext()) {
        String line = in.next();
        if(line.contains("<Semester>")) {
          line = line.replace("<Semester>", "");
          line = line.replace("</Semester>", "");
          semester = Integer.parseInt(line.trim());
        }
        else if(line.contains("<Course>"))
        {
          line = line.replace("<Course>", "");
          line = line.replace("</Course>", "");
          courseName = line.trim();
        }
        else if(line.contains("<Group>"))
        {
          line = line.replace("<Group>", "");
          line = line.replace("</Group>", "");
          groupName = line.trim();
        }
        else if(line.contains("<Teacher>"))
        {
          line = line.replace("<Teacher>", "");
          line = line.replace("</Teacher>", "");
          teacher = line.trim();
        }
        else if(line.contains("<Examiner>"))
        {
          line = line.replace("<Examiner>", "");
          line = line.replace("</Examiner>", "");
          Examiner = line.trim();
        }
        else if(line.contains("<Type>"))
        {
          line = line.replace("<Type>", "");
          line = line.replace("</Type>", "");
          type = line.trim();
        }
        else if(line.contains("<RoomNumber>"))
        {
          line = line.replace("<RoomNumber>", "");
          line = line.replace("</RoomNumber>", "");
          RoomNumber = line.trim();
        }
    else  if(line.contains("<StartYear>")) {
        line = line.replace("<StartYear>", "");
        line = line.replace("</StartYear>", "");
        StartYear = Integer.parseInt(line.trim());
      }
        else  if(line.contains("<StartMonth>")) {
          line = line.replace("<StartMonth>", "");
          line = line.replace("</StartMonth>", "");
          StartMonth = Integer.parseInt(line.trim());
        }
        else  if(line.contains("<StartDay>")) {
          line = line.replace("<StartDay>", "");
          line = line.replace("</StartDay>", "");
          StartDay = Integer.parseInt(line.trim());
        }
        else  if(line.contains("<StartHour>")) {
          line = line.replace("<StartHour>", "");
          line = line.replace("</StartHour>", "");
          StartHour = Integer.parseInt(line.trim());
        }
        else  if(line.contains("<StartMinute>")) {
          line = line.replace("<StartMinute>", "");
          line = line.replace("</StartMinute>", "");
          StartMinute = Integer.parseInt(line.trim());
        }
        else  if(line.contains("<EndYear>")) {
          line = line.replace("<EndYear>", "");
          line = line.replace("</EndYear>", "");
          EndYear = Integer.parseInt(line.trim());
        }
        else  if(line.contains("<EndMonth>")) {
          line = line.replace("<EndMonth>", "");
          line = line.replace("</EndMonth>", "");
          EndMonth = Integer.parseInt(line.trim());
        }
        else  if(line.contains("<EndDay>")) {
          line = line.replace("<EndDay>", "");
          line = line.replace("</EndDay>", "");
          EndDay = Integer.parseInt(line.trim());
        }
        else  if(line.contains("<EndHour>")) {
          line = line.replace("<EndHour>", "");
          line = line.replace("</EndHour>", "");
          EndHour = Integer.parseInt(line.trim());
        }
        else  if(line.contains("<EndMinute>")) {
          line = line.replace("<EndMinute>", "");
          line = line.replace("</EndMinute>", "");
          EndMinute = Integer.parseInt(line.trim());
        }
        if(line.contains("</Exam>"))
        {
          DateInterval dateInterval = new DateInterval(new Date(StartYear,StartMonth,StartDay,StartHour,StartMinute),new Date(EndYear,EndMonth,EndDay,EndHour,EndMinute));
          Room room = new Room(true,true,30,30,RoomNumber);
          Examiner teach = new Examiner(teacher);
          Group group = new Group(groupName,10,1);
          Examiner examiner = new Examiner(Examiner);
          Course course = new Course(teach,courseName);
          Exam exam = new Exam(dateInterval,room,group,type,examiner,course);
          list.add(exam);
        }
    }






  }

  public ArrayList<Exam> getList() throws FileNotFoundException
  {
    return list;
  }
  public RoomList getRoomList() throws FileNotFoundException
  {
    return roomList;
  }

}
