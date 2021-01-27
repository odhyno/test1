package application;

/**
 *  Interfaccia per far comunicare il Main con le varie classi Boundary
 *  @author Leonardo Monnati, Vincenzo Visconti, Alessandro Corsico
 *  @version 1.0
 */
public interface RequestScene
{
    void setNewStage(String fxmlFile, int sizeX, int sizeY, String title );
   
}

