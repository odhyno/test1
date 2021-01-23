package logic;

//import bean.UserBean;

/**
 *  Interfaccia per far comunicare il Main con le varie classi Boundary
 *  @author Leonardo Monnati, Vincenzo Visconti, Alessandro Corsico
 *  @version 1.0
 */
public interface RequestScene
{
    void setNewStage(String fxmlFile, int sizeX, int sizeY, String title ) throws Exception;
    //void setLoggedUser(UserBean userBean);
    //UserBean getLoggedUser();
    
   // void setLoggedUsers(UserBean userBean);
   //  List< UserBean> getLoggedUsers();
}

