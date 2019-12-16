package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RoomList
{
  private ArrayList<Room> rooms = new ArrayList<>();

  public void addRoom(Room room){
    rooms.add(room);
  }

  /**
   *Get all Available Rooms in this Date Interval. If this room already is taken for exam in this date interval
   *  or at least from one day(if exam is more than one day) then return false
  // * @param dateInterval Start date of Exam and End date of exam
   * @return all available Rooms in this interval
   *
   */



  public ArrayList<Room> getAllRoomsWithPort(String port){
    ArrayList<Room> rooms1 = new ArrayList<>();
    if (port.equals("HDMI")){
      for (int i = 0; i <rooms.size() ; i++)
      {
        if (rooms.get(i).isHDMI()) rooms1.add(rooms.get(i));
      }
    }
    else {
      for (int i = 0; i <rooms.size() ; i++)
      {
        if (rooms.get(i).isVGA()) rooms1.add(rooms.get(i));
      }
    }
      return rooms1;
  }

  public ArrayList<Room> getRoomList(){
    return rooms;
  }
}
