package View;

import Model.ManageExamModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ViewHandler
{
  private Scene currentScene;
  private Stage primaryStage;
  private AddController addController;
  private EditController editController;
  private LandingController landingController;
  private ManageExamModel model;

  public ViewHandler ()
  {

    this.currentScene = new Scene(new Region());
  }
  public void start(Stage primaryStage) throws FileNotFoundException
  {
    this.primaryStage = primaryStage;
    openView("landing");
  }
  public void openView(String id) throws FileNotFoundException
  {
    Region root = null;
    switch (id)
    {
      case "landing" : root = landingView("Landing.fxml"); break;
      case "add"  : root = addView("Add.fxml"); break;
      case "edit" : root = editView("Edit.fxml"); break;
    }

    currentScene.setRoot(root);
    String title = "";
    if(root.getUserData() !=null)
    {
      title+=root.getUserData();
    }
    primaryStage.setTitle(title);
    primaryStage.sizeToScene();
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  private Region landingView(String fxml) throws FileNotFoundException
  {
  if(landingController == null)
  {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxml));
      Region root = loader.load();
      landingController = loader.getController();
      landingController.init(this,model,root);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
  else {
    landingController.reset();
  }
  return  landingController.getRoot();
}
  private Region addView(String fxml)
  {
    if(addController == null)
    {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxml));
        Region root = loader.load();
        addController = loader.getController();
        addController.init(this,root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    else {
      addController.reset();
    }
    return  addController.getRoot();
  }
  private Region editView(String fxml)
  {
    if(editController == null)
    {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxml));
        Region root = loader.load();
        editController = loader.getController();
        editController.init(this,root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    else {
         editController.reset();
    }
    return  editController.getRoot();
  }


  public void closeView()
  {
    primaryStage.close();
  }




}
