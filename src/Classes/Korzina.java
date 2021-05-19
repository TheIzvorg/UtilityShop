package Classes;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Korzina {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_Exit;

    @FXML
    private Button btn_Buy;

    @FXML
    private Button btn_Summ;

    @FXML
    void initialize() {
    }

    public void goToMsgBox(ActionEvent actionEvent) {
        Stage stage = (Stage) btn_Buy.getScene().getWindow();
        //stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/MessageBox.fxml"));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Бокс");
        stage.setScene(new Scene(root1));
        stage.show();
    }
}
