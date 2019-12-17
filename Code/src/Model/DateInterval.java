package Model;

/**
 * A class representing a date Interval
 *
 * @author Andrei Moldovanu
 */
public class DateInterval
{
  private Date date1;
  private Date date2;

  /**
   * Two parameter Constructor, Check if start Date is before end Date
   * @param date1 startDate
   * @param date2 endDate
   */
  public DateInterval(Date date1, Date date2)
  {
    if (date1.isBefore(date2))
    {
      this.date1 = date1;
      this.date2 = date2;
    }
  }


  /**
   * if parameter date is between StartDate and End date return true, otherwise return false
   * @param date specific date
   * @return true or false
   */

 public boolean isBetween(Date date)
 {
   return ((date1.isBefore(date) || date1.equals(date))&& (date.isBefore(date2) || date2.equals(date)));
 }

  /**
   *
   * @return start date
   */
  public  Date getStartDate(){
    return date1;
  }

  /**
   *
   * @return end date
   */
  public Date getEndDate(){
    return date2;
  }

  /**
   *
   * @param obj
   * @return true if date interval is equal to obj
   */
  public boolean equals(Object obj)
  {
    if(!(obj instanceof  DateInterval)) return false;
    DateInterval other = (DateInterval) obj;
    return date1.equals(other.date1) && date2.equals(other.date2);
  }

  /**
   *
   * @return date as string
   */
  public String toString(){
    return  date1 + " - " + date2;
  }
}
