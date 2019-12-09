package Model;

public class Date
{
  private int day, month, year, hour, minute;

  public Date(int day, int month, int year, int hour, int minute) {
    this.hour = hour;
    this.minute = minute;
    this.day = day;
    if (year < 0) {
      year = -year;
    }
    this.year = year;
    if (month < 1) {
      month = 1;
    } else if (month > 12) {
      month = 12;
    }
    this.month = month;
  }

  public int getDay() {
    return day;
  }

  public int getMonth() {
    return month;
  }

  public int getYear() {
    return year;
  }

  public int getHour() {
    return hour;
  }

  public int getMinute() {
    return minute;
  }

  public String getMonthName() {
    switch (month) {
      case 1:
        return "January";
      case 2:
        return "February";
      case 3:
        return "March";
      case 4:
        return "April";
      case 5:
        return "May";
      case 6:
        return "June";
      case 7:
        return "July";
      case 8:
        return "August";
      case 9:
        return "September";
      case 10:
        return "October";
      case 11:
        return "November";
      default:
        return "December";
    }
  }

  public boolean isBefore(Date other) {
    if (other.getYear() > getYear()) {
      return true;
    } else if (other.getYear() < getYear()) {
      return false;
    } else if (other.getMonth() > getMonth()) {
      return true;
    } else if (other.getMonth() < getMonth()) {
      return false;
    } else if (other.getDay() > getDay()) {
      return true;
    } else if (other.getDay() < getDay()) {
      return false;
    } else {
      return false;
    }
  }


  public String toString() {
    String dayNew, monthNew;
    if (day < 10) {
      dayNew = "0" + day;
    } else {
      dayNew = "" + day;
    }
    if (month < 10) {
      monthNew = "0" + month;
    } else {
      monthNew = "" + month;
    }
    return dayNew + "/" + monthNew + "/" + year + " hour="+getHour()+" minute="+getMinute();
  }

  public static int convertToMonthNumber(String monthName){
    if (monthName.equals("December")){
      return 12;
    }else if (monthName.equals("February")){
      return 2;
    }else if (monthName.equals("March")){
      return 3;
    }else if (monthName.equals("April")){
      return 4;
    }else if (monthName.equals("May")){
      return 5;
    }else if (monthName.equals("June")){
      return 6;
    }else if (monthName.equals("July")){
      return 7;
    }else if (monthName.equals("August")){
      return 8;
    }else if (monthName.equals("September")){
      return 9;
    }else if (monthName.equals("October")){
      return 10;
    }else if (monthName.equals("November")){
      return 11;
    }else{
      return 1;
    }
  }
  public boolean isLeapYear(){
    return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
  }

  public int numberOfDaysInMonth(){
    switch(month){
      case 2:
        if(isLeapYear()){
          return 29;
        }
        return 28;
      case 4:
      case 6:
      case 9:
      case 11:
        return 30;
      default: return 31;
    }
  }


  public boolean equals(Object obj) {
    if (!(obj instanceof Date))
      return false;
    Date other = (Date)obj;
    return (this.getDay() == other.getDay()) && (this.getMonth() == other.getMonth()) && (this.getYear() == other.getYear()) && this.getHour() == other.getHour() && this.getMinute() == other.getMinute();
  }

  public int hoursBetween(Date other){
    int days;
    int hours;
    if(getDay() != other.getDay()){
      if(getDay() < other.getDay()){
        days = other.getDay()-getDay();
        hours = other.getHour()-getHour();
      }else {
        days = getDay()-other.getDay();
        hours = getHour()-other.getHour();
      }
      if(days != 0){
        return hours+(24*days);
      } else {
        return hours;
      }
    } else {
      if(getHour() < other.getHour()){
        return other.getHour()-getHour();
      }else {
        return getHour()-other.getHour();
      }
    }
  }
}