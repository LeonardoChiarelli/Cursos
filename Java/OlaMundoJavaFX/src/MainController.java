import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {
    @FXML
    private Button myButton;

    @FXML
    private void initialize(){
        myButton.setOnAction(event -> System.err.println("Olá, Mundo"));
    }
}
