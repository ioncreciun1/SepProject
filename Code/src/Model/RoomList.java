package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RoomList
{
  private ArrayList<Room> rooms = new ArrayList<>();

  public RoomList(){
    addRooms(); // Adds Pre-Set Rooms
  }

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

  public void addRooms(){
    int roomId = 0;
    for (int i = 0; i < 40; i++) {
        boolean randHDMI = new Random().nextBoolean();
        boolean randVGI = new Random().nextBoolean();
        int randST = new Random().nextInt(40) + 20;
        Room room = new Room(randHDMI,randVGI,randST,randST,roomId+"");
        roomId++;
        rooms.add(room);
    }
  }

  public ArrayList<Room> getRoomList(){
    return rooms;
  }
}
