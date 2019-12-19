package Model;

/**
 * A class representing an Examiner
 *
 * @author Andrei Moldovanu, Eugen Cius, Mario Handzhiev
 */
public class Examiner
{
  private String name;

  /**
   * One parameter Constructor: if name is null then you can't assign it
   * @param name the name of Examiner
   */
  public Examiner(String name){
   setName(name);
  }

  /**
   *
   * @return name of Examiner
   */
  public String getName()
  {
    return name;
  }
  public String toString()
  {
    return   name;
  }


  public void setName(String name)
  {
    if (name.length() > 1)
    {
      this.name = name;
    }
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
