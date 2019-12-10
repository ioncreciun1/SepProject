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

  /**
   *
   * @return true if Room have HDMI port
   */
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

  /**
   * if number is negative it converts to a positive one
   * @param chairs number of chairs in a room
   */
  public void setChairs(int chairs)
  {
    if(chairs<0) this.chairs = -chairs;
     else this.chairs = chairs;
  }

  /**
   *
   * @return if Room has VGA port
   */
  public boolean isVGA()
  {
    return VGA;
  }


  public void setVGA(boolean VGA)
  {
    this.VGA = VGA;
  }

  /**
   *
   * @return number of tables
   */
  public int getTables()
  {
    return tables;
  }

  /**
   * if number is negative converts it to a positive one
   * @param tables
   */
  public void setTables(int tables)
  {
    if(tables < 0) this.tables = -tables;
   else  this.tables = tables;
  }

  @Override public String toString()
  {
    return "Room{" + "HDMI=" + HDMI + ", chairs=" + chairs + ", VGA=" + VGA
        + ", tables=" + tables  + '}';
  }
}
