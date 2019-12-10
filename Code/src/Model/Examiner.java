package Model;

public class Examiner
{
  private String name;

  /**
   * One parameter Constructor: if name is null then you can't assign it
   * @param name the name of Examiner
   */
  public Examiner(String name){
    if(!name.equals(""))this.name = name;
  }

  /**
   * Getter
   * @return name of Examiner
   */
  public String getName()
  {
    return name;
  }
  public String toString()
  {
    return "Name: " + name;
  }

  /**
   * Checking is two Examiner object are equals
   * @param obj
   * @return true if Two Examiners have same parameter otherwise false
   */
  public boolean equals(Object obj){
    if (!(obj instanceof Examiner))
      return false;
    Examiner other = (Examiner)obj;
    return this.name.equals(other.name);
  }
}
