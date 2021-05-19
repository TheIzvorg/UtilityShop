package Classes;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Register {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_Exit;

    @FXML
    private PasswordField textField_ConfirmPassword;

    @FXML
    private PasswordField textField_Password;

    @FXML
    private TextField textField_Login;

    @FXML
    private TextField textField_Email;

    @FXML
    private Button btn_Register;

    @FXML
    private TextField textField_Chapcha;

    @FXML
    private Label label_Chapcha;

    @FXML
    private RadioButton radioBtn_Male;

    @FXML
    private RadioButton radioBtn_Female;

    @FXML
    private Button btn_Cancel;

    @FXML
    private TextField txtBox_Name;

    @FXML
    private TextField txtBox_SurName;

    @FXML
    void initialize() {
        DBConect dbConect = new DBConect();

        String gender = radioBtn_Male.isSelected() ? "Male" : "Female";

        btn_Register.setOnAction(event -> {
            try {
                dbConect.singUser(textField_Login.getText(),textField_Password.getText(),txtBox_Name.getText(),
                        txtBox_SurName.getText(),textField_Email.getText(),gender);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        btn_Cancel.setOnAction(event -> {
            btn_Cancel.getScene().getWindow().hide();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/Auth.fxml"));
            try{
                fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root1 = fxmlLoader.getRoot();
            Stage stage = new Stage();
        });
    }
}
