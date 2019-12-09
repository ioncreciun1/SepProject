package Model;

public class Examiner
{
  private String name;
  public Examiner(String name){
    this.name = name;
  }

   public String toString()
  {
    return "Name: " + name;
  }

  public boolean equals(Object obj){
    if (!(obj instanceof Examiner))
      return false;
    Examiner other = (Examiner)obj;
    return this.name.equals(other.name);
  }
}
