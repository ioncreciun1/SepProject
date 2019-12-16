package Model;

import java.util.ArrayList;

public class GroupList
{
  private ArrayList<Group> list;
  public GroupList () {
    list = new ArrayList<>();
  }
  public ArrayList<Course> getAllCourses(Group group) {
    return getGroup(group).getCourses();
  }

  /**
   * ///////////////////////////////////////HAVE TO IMPLEMENT
   * @return
   */

  public ArrayList<Group> getGroupsBySemester(int semester) {
    return null;
  }



  public void addGroup(Group group){
    list.add(group);
  }
  public int size(){
    return list.size();
  }
  public Group getGroup(Group group)
  {
    for(int i=0;i<size();i++)
    {
      if(list.get(i).equals(group)) return list.get(i);
    }
    return null;
  }
  public Group getGroup(int index)
  {
    return list.get(index);
  }

  public Group getGroup(int semester, String name){
    for (int i = 0; i < list.size()-1; i++) {
      if (getGroup(i).getName().equals(name) && getGroup(i).getSemester() == semester){
        return getGroup(i);
      }
    }
    System.out.println("ERROR GROUP DOESNT EXIST");
    return null;
  }

  public Course getCourse(String name, int semester, String groupName){
    for (int i = 0; i < list.size()-1; i++) {
      if (getGroup(i).getName().equals(groupName) && getGroup(i).getSemester() == semester){
        for (int j = 0; j < getGroup(i).getCourses().size(); j++) {
          if(getGroup(i).getCourses().get(j).getCourseName().equals(name)){
            return getGroup(i).getCourses().get(j);
          }
        }
      }
    }
    System.out.println("ERROR GROUP DOESNT EXIST");
    return null;
  }

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
