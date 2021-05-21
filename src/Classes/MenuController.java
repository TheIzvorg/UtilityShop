package Classes;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodTextRun;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static Classes.Product.FillProduct;

public class MenuController {

    @FXML
    private Label label_OlegUcsusName;

    @FXML
    private Label label_ZazerName;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_LK;

    @FXML
    private Button btn_Korzina;

    @FXML
    private Tab tab_Menu1;

    @FXML
    private ImageView image_OlegUcsus;


    @FXML
    private Label label_OlegUcsusCount;

    @FXML
    private Button btn_OlegUcsusDec;

    @FXML
    private Button btn_OlegUcsusInc;

    @FXML
    private Tab tab_Menu2;

    @FXML
    private ImageView image_BurgerOleg;

    @FXML
    private Label label_BurgerOlegCount;

    @FXML
    private Button btn_BurgOlegDec;

    @FXML
    private Button btn_BurgOlegInc;

    @FXML
    private Tab tab_Menu3;

    @FXML
    private ImageView image_Zezar;

    @FXML
    private Label label_ZazerCount;

    @FXML
    private Button btn_ZazerDec;

    @FXML
    private Button btn_ZazerInc;

    @FXML
    private Label label_Summ;

    @FXML
    private Label label_BurgerOlegName;

    @FXML
    void initialize() {

    }

    public void goToLK(ActionEvent actionEvent) {
        Stage stage = (Stage) btn_LK.getScene().getWindow();
        //stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/LK.fxml"));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Личный кабинет");
        stage.setScene(new Scene(root1));
        stage.show();
    }


    public void goToKorzina(ActionEvent actionEvent) {
        FillProduct(0,label_OlegUcsusName.getText(),100,Integer.parseInt(label_OlegUcsusCount.getText()));
        FillProduct(1,label_BurgerOlegName.getText(),5000,Integer.parseInt(label_BurgerOlegCount.getText()));
        FillProduct(2,label_ZazerName.getText(),200,Integer.parseInt(label_ZazerCount.getText()));
        Stage stage = (Stage) btn_Korzina.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/KORZINA.fxml"));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }

        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Корзина");
        stage.setScene(new Scene(root1));

        stage.show();

    }

    public String Summ(String label, int number, int menuNumber){
        int count = Integer.parseInt(label);
        count+=number;
        if(count < 0) {count = 0;}
        Product.count[menuNumber] = count;
        //Counters[menuNumber] = count;
        label = (String.valueOf(count));
        //int summ = (Counters[0] * 100) + (Counters[1] * 5000) + (Counters[2] * 200);
        int summ = (Product.count[0] * 100) + (Product.count[1] * 5000) + (Product.count[2] * 200);
        label_Summ.setText("Сумма: " + (summ) + " руб");
        return label;
    }

    public void OlegUcsusCountDec(ActionEvent actionEvent) {
        label_OlegUcsusCount.setText(Summ(label_OlegUcsusCount.getText(),-1,0));
    }

    public void OlegUcsusCountInc(ActionEvent actionEvent) {
        label_OlegUcsusCount.setText(Summ(label_OlegUcsusCount.getText(),1,0));
    }

    public void BurgOlegDec(ActionEvent actionEvent) {
        label_BurgerOlegCount.setText(Summ(label_BurgerOlegCount.getText(),-1,1));

    }

    public void BurgOlegInc(ActionEvent actionEvent) {
        label_BurgerOlegCount.setText(Summ(label_BurgerOlegCount.getText(),1,1));

    }

    public void ZazerDec(ActionEvent actionEvent) {
        label_ZazerCount.setText(Summ(label_ZazerCount.getText(),-1,2));

    }

    public void ZazerInc(ActionEvent actionEvent) {
        label_ZazerCount.setText(Summ(label_ZazerCount.getText(),1,2));

    }

    public void Exit(ActionEvent actionEvent) {
        System.exit(1);
    }
}

