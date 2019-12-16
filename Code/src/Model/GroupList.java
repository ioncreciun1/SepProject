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

  public void setList(ArrayList<Group> list) {
    this.list = list;
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
    System.out.println("ERROR GROUP DOESNT EXIST");
    return null;
  }

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
