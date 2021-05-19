package Classes;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class LK {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_Exit;

    @FXML
    private ImageView image_Foto;

    @FXML
    private TextField textField_LastName;

    @FXML
    private TextField textFirld_FirstName;

    @FXML
    private TextField textField_MiddleName;

    @FXML
    private Button btn_Save;

    @FXML
    private DatePicker calendar_DateBirh;

    @FXML
    void initialize() {
    }

    public void Close(ActionEvent actionEvent) {
        Stage stage = (Stage) btn_Exit.getScene().getWindow();
        stage.close();
    }

    public void Save(ActionEvent actionEvent) {
    }
}
