import java.awt.Dimension;
import java.awt.Toolkit;
public class resolucaodatela{
    public static void main(String[] args){
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) d.getWidth();
        int screenHeight = (int) d.getHeight();

        System.out.println("A tela deste dispositivo tem as seguintes dimensões: " + screenWidth + " x " + screenHeight);
        
    }
}
