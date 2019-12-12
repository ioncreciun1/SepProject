package Model;

public class DateInterval
{
  private Date date1;
  private Date date2;

  public DateInterval(Date date1, Date date2){
    this.date1 = date1;
    this.date2 = date2;
  }

  /**
   * if parameter date is between StartDate and End date return true, otherwise return false
   * @param date specific date
   * @return true or false
   */

 public boolean isBetween(Date date)
 {
   return false;
 }

  public  Date getStartDate(){
    return date1;
  }

  public Date getEndDate(){
    return date2;
  }


  public DateInterval copy(){
    DateInterval other = new DateInterval(date1,date2);
    return other;
  }

  public String toString(){
    return "Date 1: " + date1 + " Date 2: " + date2;
  }
}
