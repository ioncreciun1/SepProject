package Model;

import java.util.ArrayList;
/**
 * A class representing a Group list
 *
 * @author Mario Handzhiev
 */

public class GroupList
{
  private ArrayList<Group> list;

  /**
   * Zero parameter constructor
   */
  public GroupList () {
    list = new ArrayList<>();
  }

  /**
   *
   * @param group
   * @return all courses for this group
   */
  public ArrayList<Course> getAllCourses(Group group) {
    return getGroup(group).getCourses();
  }

  /**
   *
   * @param list list of groups
   */
  public void setList(ArrayList<Group> list) {
    this.list = list;
  }

  /**
   *
   * @param group
   */
  public void addGroup(Group group){
    list.add(group);
  }

  /**
   *
   * @return number of groups
   */
  public int size(){
    return list.size();
  }

  /**
   *
   * @param group
   * @return group if it is equal to group param
   */
  public Group getGroup(Group group)
  {
    for(int i=0;i<size();i++)
    {
      if(list.get(i).equals(group)) return list.get(i);
    }
    return null;
  }

  /**
   *
   * @param index number of group in list
   * @return group by index
   */
  public Group getGroup(int index)
  {
    return list.get(index);
  }

  /**
   *
   * @param semester semester
   * @param name name of group
   * @param courseName name of course
   * @return group based on semester, name of group and name of course
   */
  public Group getGroup(int semester, String name, String courseName){
    for (int i = 0; i < list.size(); i++) {
      if (getGroup(i).getName().equals(name) && getGroup(i).getSemester() == semester){
        for (int j = 0; j < getGroup(i).getCourses().size()-1; j++) {
          if(getGroup(i).getCourses().get(j).getCourseName().equals(courseName)){
            return getGroup(i);
          }
        }
      }
    }
    return null;
  }

  /**
   *
   * @param semester semester
   * @param name name of group
   * @param courseName name of course
   * @return course based on semester,name of group and name of course
   */
  public Course getCourse(int semester, String name, String courseName){
    for (int i = 0; i < list.size(); i++) {
      if (getGroup(i).getName().equals(name) && getGroup(i).getSemester() == semester){
        for (int j = 0; j < getGroup(i).getCourses().size()-1; j++) {
          if(getGroup(i).getCourses().get(j).getCourseName().equals(courseName)){
            return getGroup(i).getCourses().get(j);
          }
        }
      }
    }
    return null;
  }

  /**
   *
   * @return group list as string
   */
  public String toString()
  {
    String s = "";
    for(int i = 0;i<list.size();i++)
    {
      s+=list.get(i) + "\n";
    }
    return s;
  }
  

}
