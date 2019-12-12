package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageRoomListFile {
    RoomList roomList = new RoomList();

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
                if (hdmiS.equals("true")){
                    HDMI = true;
                } else {
                    HDMI = false;
                }
            }
            else if(line.contains("<VGA>")) {
                line = line.replace("<VGA>", "");
                line = line.replace("</VGA>", "");
                String vgaS = line.trim();
                if (vgaS.equals("true")){
                    VGA = true;
                } else {
                    VGA = false;
                }
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
}
