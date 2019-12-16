package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RoomList
{
  private ArrayList<Room> rooms;
  public RoomList(){
    rooms = new ArrayList<>();
  }

  /**
   *  add room to list
   * @param room
   */
  public void addRoom(Room room){
    rooms.add(room);
  }

  /**
   *
   * @param port
   * @return all room with this specific port
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

  /**
   *
   * @param id name of room
   * @return true if there is such room based on name
   */
  public boolean containsId(String id){
    for (int i = 0; i < rooms.size()-1; i++) {
      if (rooms.get(i).getNumber().equals(id)){
        return true;
      }
    }
    return false;
  }

  /**
   *
   * @param rooms set all rooms
   */
  public void setRooms(ArrayList<Room> rooms) {
    this.rooms = rooms;
  }

  /**
   *
   * @param id name of room
   * @return return room from a list based on name
   */
  public Room getRoomById(String id){
    for (int i = 0; i < rooms.size()-1; i++) {
      if (rooms.get(i).getNumber().equals(id)){
        return rooms.get(i);
      }
    }
    System.out.println("ERROR - ROOM DOESN'T EXIST");
    return null;
  }

  /**
   *
   * @return all rooms
   */
  public ArrayList<Room> getRoomList(){
    return rooms;
  }
}
