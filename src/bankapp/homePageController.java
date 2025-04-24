/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Lenovo
 */
public class homePageController {
  
    @FXML 
    ComboBox<String> comboBoxCards;

    /*----transfer page-----*/
    @FXML
    private Button transferButton;
    @FXML
    void transferButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TransferTo.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) transferButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    
    /*--------transfer amount to---------*/
    @FXML
    Button lamaBtClick;
    @FXML
    Button asmaBtClick;
    @FXML
    Button reemBtClick;
    @FXML
    Button yaraBtClick;
    @FXML
    void lamaAccButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TransferAmount.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) lamaBtClick.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
}
    @FXML
    void asmaAccButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TransferAmount.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) lamaBtClick.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
}
    @FXML
    void reemAccButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TransferAmount.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) reemBtClick.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
}
    @FXML
    void yaraAccButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TransferAmount.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) yaraBtClick.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
}
    
    
    /*--------mouse event in transfer to button-------*/
    @FXML
    void mouseEvent(){
    lamaBtClick.setOnMouseEntered(e -> lamaBtClick.setStyle("-fx-background-color: lightblue;"));
    lamaBtClick.setOnMouseExited(e -> lamaBtClick.setStyle("-fx-background-color:  DARKSLATEGRAY;"));
    
    asmaBtClick.setOnMouseEntered(e -> asmaBtClick.setStyle("-fx-background-color: lightblue;"));
    asmaBtClick.setOnMouseExited(e -> asmaBtClick.setStyle("-fx-background-color:  DARKSLATEGRAY;")); 

    reemBtClick.setOnMouseEntered(e -> reemBtClick.setStyle("-fx-background-color: lightblue;"));
    reemBtClick.setOnMouseExited(e -> reemBtClick.setStyle("-fx-background-color:  DARKSLATEGRAY;"));
    
    yaraBtClick.setOnMouseEntered(e -> yaraBtClick.setStyle("-fx-background-color: lightblue;"));
    yaraBtClick.setOnMouseExited(e -> yaraBtClick.setStyle("-fx-background-color:  DARKSLATEGRAY;"));
    
    }
    

    /*----deposit page-----*/
    @FXML
    private Button depositButton;
    @FXML
    void depositButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Transfer.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) depositButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    
    /*----withdraw page-----*/
    @FXML
    private Button withdrawButton;
    @FXML
    void withdrawButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Transfer.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) withdrawButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    
    /*----more page-----*/
    @FXML
    private Button moreButton;
    @FXML
    void moreButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Transfer.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) moreButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    
    /*----profile page-----*/  
    @FXML
    private Button profileButton;
    @FXML
    void profileButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profile.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) profileButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    
    /*----statics page-----*/
    @FXML
    private Button staticsButton;
    @FXML
    void staticsButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Transfer.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) staticsButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    } 
    
    
    /*----cards page-----*/ 
    @FXML
    private Button cardsButton;
    @FXML
    void cardsButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Cards.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) cardsButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    } 
    
    /*----go back to home page-----*/
    @FXML
    private Button goBack;
    @FXML
    void goBackButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) goBack.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    } 
    
    /*----go back to log in page-----*/
    @FXML
    private Button goBackToLogIn;
    @FXML
    void goBackToLogInButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LogIn.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) goBackToLogIn.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    /*------go back to transfer to page-------*/
    @FXML
    Button goToTransferToButton;
    @FXML
    void goToTransferTo(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TransferTo.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) goToTransferToButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    /*----log out-----*/  
    @FXML
    private Button logOut;
    @FXML
    void logOutButtonAction(ActionEvent event) throws IOException {
        
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LogIn.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) logOut.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
      
    }
    
    /*----------------------the up key adds 10 reyals and the down key takes out 10-------------------------*/
    @FXML
    TextField tf_msg;
    @FXML
    void addMore(KeyEvent event){
    String i ="0";    
    tf_msg.setText(i);
        tf_msg.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                int value = Integer.parseInt(tf_msg.getText());
                tf_msg.setText(String.valueOf(value + 10));
            } else if (e.getCode() == KeyCode.DOWN) {
                int value = Integer.parseInt(tf_msg.getText());
                tf_msg.setText(String.valueOf(value - 10));
            }
        });

}
    

    @FXML
    Button transfer;
    
    @FXML
    Label msgApproval;
   
    @FXML
    RadioButton rb1;

    @FXML
    RadioButton rb2;
    
    @FXML
    public void TransferApproval(ActionEvent event) throws IOException {
        
        transfer.setOnAction(e -> {
        if(tf_msg.getText().equals("")) {
            msgApproval.setText("Enter transfer amount");
        } else {
            boolean isnumber = true;
            try {
                Long x = Long.parseLong(tf_msg.getText());
                isnumber = true;
            } catch (NumberFormatException ex) {
                isnumber = false;
            }

            if (!rb1.isSelected() && !rb2.isSelected()) {
                msgApproval.setText("Select a pourpse");
            } else if(comboBoxCards.getSelectionModel().isEmpty()) {
                msgApproval.setText("Chose a card");
            } else{
                msgApproval.setTextFill(Color.web("#8FBC8F"));
                msgApproval.setText("Transfer done succefully!");
                
                
            }}
       
           /*--------toggle group radio button---------*/
                  ToggleGroup group = new ToggleGroup();
                  rb1.setToggleGroup(group);
                  rb2.setToggleGroup(group);
                  if (rb1.isSelected()) {
                  rb2.setSelected(false);
                   } else if (rb2.isSelected()) {
                  rb1.setSelected(false);
                   }
                  
                 /*---------------------------------save in dataBase----------------------------------- */
                 
                transfer t1= new transfer();
           
                    Session s2= HibernateUtil.getSessionFactory().openSession();
                    Transaction t2= s2.beginTransaction();
                    t1.setTransfer_amount(tf_msg.getText());
                    t1.setCards(comboBoxCards.getValue());
                    t1.setPurpose(((RadioButton) group.getSelectedToggle()).getText());
 
 
                    s2.save(t1);
                    t2.commit();
                    s2.close();
        
      
        });} 
  
    
 
    
   
/*--------------in change password page , check if the entered password is correct--------------*/    
@FXML
PasswordField passwordField1;

@FXML
PasswordField passwordFieldd;

@FXML
PasswordField passwordField2;

@FXML
Button resetPassword;

@FXML
public void checkPass (ActionEvent event){
resetPassword.setOnAction(e->{
       
        if (passwordField1.getText().length() != 10) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Form error");
                alert.setContentText("Password must be 10 digits");
                alert.showAndWait();}
        
        else if(!passwordField1.getText().equals(passwordField2.getText())) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Passwords dont match");
                alert.showAndWait();        
        } 
        
        else{
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Password changed");
                alert.setContentText("Change Password Was Successful");
                alert.showAndWait();
                

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("LogIn.fxml"));
                Parent root;
                root = loader.load();
                 Scene scene = new Scene(root);
                 Stage stage = (Stage) resetPassword.getScene().getWindow();
                 stage.setScene(scene);
                 stage.show();
            } catch (IOException ex) {
               Logger.getLogger(BankApp.class.getName()).log(Level.SEVERE, null, ex);
            }}
    });
}


}




