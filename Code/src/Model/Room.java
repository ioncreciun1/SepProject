package Model;

public class Room
{
  private boolean HDMI;
  private int chairs;
  private boolean VGA;
  private int tables;
  private int id;

  public Room(boolean HDMI , boolean VGA, int chairs, int tables, int id){
    this.HDMI = HDMI;
    this.VGA = VGA;
    this.chairs = chairs;
    this.tables  = tables;
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public boolean isHDMI()
  {
    return HDMI;
  }

  public void setHDMI(boolean HDMI)
  {
    this.HDMI = HDMI;
  }

  public int getChairs()
  {
    return chairs;
  }

  public void setChairs(int chairs)
  {
    this.chairs = chairs;
  }

  public boolean isVGA()
  {
    return VGA;
  }

  public void setVGA(boolean VGA)
  {
    this.VGA = VGA;
  }

  public int getTables()
  {
    return tables;
  }

  public void setTables(int tables)
  {
    this.tables = tables;
  }

  @Override public String toString()
  {
    return "Room{" + "HDMI=" + HDMI + ", chairs=" + chairs + ", VGA=" + VGA
        + ", tables=" + tables  + '}';
  }
}
