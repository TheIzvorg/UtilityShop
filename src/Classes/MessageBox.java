package Classes;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MessageBox {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_Exit;

    @FXML
    private Label label_Text;

    @FXML
    private Button btn_Ok;

    @FXML
    void initialize() {

    }

    public void Close(ActionEvent actionEvent) {
        Stage stage = (Stage) btn_Ok.getScene().getWindow();
        stage.close();
    }
}
