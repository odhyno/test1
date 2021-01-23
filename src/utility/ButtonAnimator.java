package utility;

import javafx.scene.image.ImageView;


/**
 *  Classe di utility per animare le ImageView come se fossero bottoni
 *  @author Leonardo Monnati,Vincenzo Visconti, Alessandro Corsico
 *  @version 1.0
 */
public abstract class ButtonAnimator
{
    private static final double OPACITY_ENTER = 0.5;

    private static final double OPACITY_EXITED = 1;

    private static final double OPACITY_PRESSED = 0.3;

    private static final double OPACITY_RELEASED = 0.5;


    public static void mouseEntered(ImageView imageView) { imageView.setOpacity(OPACITY_ENTER); }

    public static void mouseExited(ImageView imageView) { imageView.setOpacity(OPACITY_EXITED); }

    public static void mousePressed(ImageView imageView) { imageView.setOpacity(OPACITY_PRESSED); }

    public static void mouseReleased(ImageView imageView) { imageView.setOpacity(OPACITY_RELEASED); }
}
