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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Auth {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_Exit;

    @FXML
    private PasswordField textField_Password;

    @FXML
    private TextField textField_Login;

    @FXML
    private Button btn_Register;

    @FXML
    private Button btn_Auth;

    @FXML
    void initialize() {

    }

    public void goToRegister(ActionEvent actionEvent) throws  IOException{
        Stage stage = (Stage) btn_Auth.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/Register.fxml"));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Регистрация");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void goToMenu(ActionEvent actionEvent) throws IOException {
        //String test = textField_Login.getText();
        //test = textField_Password.getText();
        if(textField_Login.getText().equals("admin") &&
            textField_Password.getText().equals("admin")){
            Stage stage = (Stage) btn_Auth.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/MenuController.fxml"));
            Parent root1 = null;
            try {
                root1 = (Parent) fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Меню");
            stage.setScene(new Scene(root1));
            stage.show();
        }
    }

    public void Exit(ActionEvent actionEvent) throws IOException {
        System.exit(1);
    }
}

