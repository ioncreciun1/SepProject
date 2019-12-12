package Model;

import java.io.FileNotFoundException;
import java.util.Random;

public class TestExam
{
  public static void main(String[] args) throws FileNotFoundException
  {
    ManageRoomListFile file = new ManageRoomListFile();
    boolean randHDMI = new Random().nextBoolean();
    boolean randVGI = new Random().nextBoolean();
    int randST = new Random().nextInt(40) + 20;
    Room room = new Room(randHDMI,randVGI,randST,randST,"25");

    file.addRoomToList(room);

  }
}
