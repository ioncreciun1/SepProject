package Model;

public class Date
{
  private int day, month, year, hour, minute;

  /**
   * five Parameter constructor.
   * @param day
   * @param month
   * @param year
   * @param hour
   * @param minute
   */
  public Date(int day, int month, int year, int hour, int minute)
  {
  setHour(hour);
   setMinute(minute);
   setYear(year);
   setMonth(month);
   setDay(day);



  }



  public int getDay()
  {
    return day;
  }

  public int getMonth()
  {
    return month;
  }

  public int getYear()
  {
    return year;
  }

  public int getHour()
  {
    return hour;
  }

  public int getMinute()
  {
    return minute;
  }

  public void setTime(int hour, int minute)
  {
    setMinute(minute);
    setHour(hour);
  }

  /**
   * Method that check if parameter date is before another date
   * @param other date
   * @return true if parameter other is before another date
   */
  public boolean isBefore(Date other)
  {
    if (other.getYear() > getYear())
    {
      return true;
    }
    else if (other.getYear() < getYear())
    {
      return false;
    }
    else if (other.getMonth() > getMonth())
    {
      return true;
    }
    else if (other.getMonth() < getMonth())
    {
      return false;
    }
    else if (other.getDay() > getDay())
    {
      return true;
    }
    else if (other.getDay() < getDay())
    {
      return false;
    }
    else if (other.getHour() > getHour())
    {
      return true;
    }
    else if (other.getHour() < getHour())
    {
      return false;
    }
    else if (other.getMinute() > getMinute())
    {
      return true;
    }
    else if (other.getMinute() < getMinute())
    {
      return false;
    }

    else
    {
      return false;
    }
  }

  public void setMonth(int month)
  {
    if(month > 0 && month < 13) this.month = month;
  }

  public void setYear(int year)
  {
    this.year = year;
  }

  public void setDay(int day)
  {
    if (day <= this.numberOfDaysInMonth() && day>0)
      this.day = day;

  }

  /**
   * set Minute if is between 0 and 60
   * @param minute
   */
  public void setMinute(int minute)
  {
    if(minute > 0 && minute <60) {
      this.minute = minute;
    }
  }

  /**
   * set Hour if is between 0 and 24
   * @param hour
   */
  public void setHour(int hour)
  {
    if (hour < 24 && hour > 0)
    {
      this.hour = hour;
    }
  }

  public String toString()
  {
    String dayNew, monthNew;
    if (day < 10)
    {
      dayNew = "0" + day;
    }
    else
    {
      dayNew = "" + day;
    }
    if (month < 10)
    {
      monthNew = "0" + month;
    }
    else
    {
      monthNew = "" + month;
    }
    return year + "/" + monthNew + "/" + dayNew + " " + getHour()
        + ":" + getMinute();
  }

  public boolean isLeapYear()
  {
    return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
  }

  public int numberOfDaysInMonth()
  {
    switch (month)
    {
      case 2:
        if (isLeapYear())
        {
          return 29;
        }
        return 28;
      case 4:
      case 6:
      case 9:
      case 11:
        return 30;
      default:
        return 31;
    }
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Date))
      return false;
    Date other = (Date) obj;
    return (this.getDay() == other.getDay()) && (this.getMonth() == other
        .getMonth()) && (this.getYear() == other.getYear())
        && this.getHour() == other.getHour() && this.getMinute() == other
        .getMinute();
  }

  public int hoursBetween(Date other)
  {
    int days;
    int hours;
    if (getDay() != other.getDay())
    {
      if (getDay() < other.getDay())
      {
        days = other.getDay() - getDay();
        hours = other.getHour() - getHour();
      }
      else
      {
        days = getDay() - other.getDay();
        hours = getHour() - other.getHour();
      }
      if (days != 0)
      {
        return hours + (24 * days);
      }
      else
      {
        return hours;
      }
    }
    else
    {
      if (getHour() < other.getHour())
      {
        return other.getHour() - getHour();
      }
      else
      {
        return getHour() - other.getHour();
      }
    }
  }
//  public boolean equals(Object obj)
//  {
//    if(!(obj instanceof Date)) return false;
//    Date other = (Date)obj;
//    return this.minute==other.minute && this.month == other.month && this.day == other.day && this.hour == other.hour && this.year == other.year;
//  }
}