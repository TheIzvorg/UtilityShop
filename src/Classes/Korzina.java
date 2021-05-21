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
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Korzina {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label_Korzina;

    @FXML
    private Label label_Summ;

    @FXML
    private Button btn_Exit;

    @FXML
    private Button btn_Buy;

    @FXML
    private Button btn_Summ;

    @FXML
    void initialize() {
        fillKorzina();
        Summ();
    }


    public void fillKorzina(){
        for(int i = 0; i < Product.name.length; i++){
            if(Product.count[i] != 0){
                String myLabel = label_Korzina.getText();
                String newLine = Product.getProduct(i);
                label_Korzina.setText(((myLabel.equals("") ? myLabel : myLabel + "\r\n") + newLine));
            }
        }
    }

    public void buy(){
        label_Korzina.setText("");
        label_Summ.setText("Сумма: " + 0 + " руб");
        for(int i = 0; i < Product.count.length; i++)
            Product.count[i] = 0;
    }

    public void goToMsgBox(ActionEvent actionEvent) {
        buy();
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

    public void Summ(){
        int summ = (Product.count[0] * 100) + (Product.count[1] * 5000) + (Product.count[2] * 200);
        label_Summ.setText("Сумма: " + (summ) + " руб");
    }

    public void Exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void goToMenu(ActionEvent actionEvent) {
        Stage stage = (Stage) btn_Exit.getScene().getWindow();
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
