package Model;

import java.util.ArrayList;
import java.util.Random;

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

  public ArrayList<Room> getRoomList(){
      return rooms;
  }

  public void addTestRooms(){
    int roomid = 0;
    for (int i = 0; i < 60; i++) {
        boolean isHDMI;
        boolean isVGA;
        int randHDMI = new Random().nextInt(1);
        int randVGA = new Random().nextInt(1);
        int randSeatsTables = new Random().nextInt(30)+20;
        if(randHDMI == 0) {
          isHDMI = false;
        }else{
          isHDMI = true;
        }
        if(randVGA == 0){
          isVGA = true;
        } else {
          isVGA = false;
        }
        addRoom(new Room(isHDMI,isVGA,randSeatsTables,randSeatsTables,roomid));
        roomid++;
    }
  }


}
