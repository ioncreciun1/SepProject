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

  

}
