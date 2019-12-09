package Model;

import java.util.ArrayList;

public class RoomList
{
  private ArrayList<Room> rooms = new ArrayList<>();

  public void addRoom(Room room){
    rooms.add(room);
  }

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


}
