package Model;

/**
 * A class representing a room
 *
 * @author Eugen Cius
 */
public class Room
{
  private boolean HDMI;
  private int chairs;
  private boolean VGA;
  private int tables;
  private String number;

  /**
   * Five Parameter Constructor
   * @param HDMI for port HDMI
   * @param VGA port VGA for computer
   * @param chairs number of chairs
   * @param tables number of tables
   * @param number number of room
   */

  public Room(boolean HDMI , boolean VGA, int chairs, int tables,String number){
    this.HDMI = HDMI;
    this.VGA = VGA;
    this.chairs = chairs;
    this.tables  = tables;
    this.number = number;
  }

  /**
   * One parameter constructor with number of room
   * @param number
   */
  public Room (String number) {
    this.number = number;
    this.tables = 1;
    this.VGA = false;
    this.HDMI = false;
    this.chairs = 1;
  }

  /**
   * Getter for number
   * @return number of room
   */
  public String getNumber()
  {
    return number;
  }

  /**
   *
   * @return true if Room have HDMI port
   */
  public boolean isHDMI()
  {
    return HDMI;
  }

  /**
   * Setter for HDMI
   * @param HDMI set true if there is HDMI port in this Room
   */
  public void setHDMI(boolean HDMI)
  {
    this.HDMI = HDMI;
  }

  /**
   * Getter for chairs
   * @return number of chairs
   */
  public int getChairs()
  {
    return chairs;
  }

  /**
   * if number of chairs is bigger than zero assign it
   * @param chairs number of chairs in a room
   */
  public void setChairs(int chairs)
  {
    if(chairs> 0 ) this.chairs = chairs;
  }

  /**
   *
   * @return if Room has VGA port
   */
  public boolean isVGA()
  {
    return VGA;
  }

  /**
   * Seter for VGA port
   * @param VGA for port VGA
   */
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
   * set number of tables if it is positive
   * @param tables
   */
  public void setTables(int tables)
  {
if(tables > 0) this.tables = tables;
  }

  /**
   *
   * @param obj
   * @return true if this room equals obj
   */
  public boolean equals(Object obj)
  {
    if(!(obj instanceof Room)) return false;
    Room other = (Room) obj;
    return this.chairs == other.chairs && this.HDMI == other.HDMI && this.VGA == other.VGA && this.tables == other.tables && this.number.equals(other.number);
  }

  /**
   *
   * @return room as string
   */
  @Override public String toString()
  {
    return "Room{" + "HDMI=" + HDMI + ", chairs=" + chairs + ", VGA=" + VGA
        + ", tables=" + tables  + '}';
  }
}
