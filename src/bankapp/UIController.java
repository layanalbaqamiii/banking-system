
package bankapp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.animation.FadeTransition;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class UIController {
      
    /*----------------------------sign up page-------------------------------*/
    @FXML
    AnchorPane signUpScene;
    
    @FXML
    AnchorPane logInScene;
    
    @FXML
    Label nameLabel;
    
    @FXML
    TextField nameField;
    
    @FXML
    PasswordField passwordField;
    
    @FXML
    Button signUpButton;
    

    @FXML
    TextField accNumberField;

    @FXML    
    TextField AgeField;
    
    @FXML
    Label nameOutput;
     
    @FXML
    TextField phoneNumberField;
    
  
   
    @FXML
    private Label welcome;
    
   
    @FXML
    // Create a StringProperty to hold the text of the text field
    StringProperty textFieldText = new SimpleStringProperty();
 
    
    public void initializable () {
        welcome.textProperty().bind(nameField.textProperty());
        // Bind the text of the text field to the StringProperty
        textFieldText.bind(nameField.textProperty());

    }
    
    
    @FXML
    public void handleSignUpButtonAction(ActionEvent event) throws IOException {
        Window owner = signUpButton.getScene().getWindow();
        

        if(nameField.getText().isEmpty()) {
        showAlert(Alert.AlertType.ERROR, owner, "Form Error!","Please enter your name");
        return;
        }
        
        if(passwordField.getText().isEmpty()) {
        showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter a password");
        return;
        } else if(passwordField.getText().length() != 10) {
        showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Password must be 10 digits");
        return;
        } else {
        try {
            Long x = Long.parseLong(passwordField.getText());
            // Check if password contains only numbers
            for(char c : passwordField.getText().toCharArray()) {
                if(!Character.isDigit(c)) {
                    throw new NumberFormatException();
                }
            }
        } catch (NumberFormatException ex) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Password must be numbers");
            return;
        }
    }
        

        if(accNumberField.getText().isEmpty()) {
        showAlert(Alert.AlertType.ERROR, owner, "Form Error!","Please enter your Account Number");
        return;        
        } else if(accNumberField.getText().length() != 15) {
        showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Account number must be 15 digits");
        return;
        } else {
        try {
            Long x = Long.parseLong(accNumberField.getText());
            // Check if account number contains only numbers
            for(char c : accNumberField.getText().toCharArray()) {
                if(!Character.isDigit(c)) {
                    throw new NumberFormatException();
                }
            }
        } catch (NumberFormatException ex) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Account number must be numbers");
            return;
        }
    }
        
        if(AgeField.getText().isEmpty()) {
        showAlert(Alert.AlertType.ERROR, owner, "Form Error!","Please enter your Age");
        return;
        }
        
        if(phoneNumberField.getText().isEmpty()) {
        showAlert(Alert.AlertType.ERROR, owner, "Form Error!","Please enter phone number");
        return;
        }else if(phoneNumberField.getText().length() != 10) {
        showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Phone number must be 10 digits");
        return;
        } else {
        try {
            Long x = Long.parseLong(phoneNumberField.getText());
            // Check if Phone number contains only numbers
            for(char c : phoneNumberField.getText().toCharArray()) {
                if(!Character.isDigit(c)) {
                    throw new NumberFormatException();
                }
            }
        } catch (NumberFormatException ex) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Phone number must be numbers");
            return;
        }
    }
        try (FileWriter writer = new FileWriter("user.txt")) {
       //   writer.write("name\t\t\t"+"passwordField\t\t\t"+"accNumberField\t\t\t"+"AgeField\t\t\t"+"phoneNumberField\n");
          writer.write(nameField.getText()+" "+passwordField.getText()+" "+accNumberField.getText()+
                  " "+AgeField.getText()+" "+phoneNumberField.getText()+"\n");
         writer.close();
        } catch (IOException ee) {
            ee.printStackTrace();
}
        try {
        
         

        User newUser = new User(nameField.getText(), passwordField.getText(), accNumberField.getText(),  AgeField.getText(), phoneNumberField.getText());
        showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!", "Welcome " + newUser.getName());
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LogIn.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) signUpButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        /*---------------------------------save in dataBase----------------------------------- */
        User u= new User();
                    u.setAccNumber(accNumberField.getText());
                    u.setPhoneNumber(phoneNumberField.getText());
                    u.setName(nameField.getText());
                    u.setAge(AgeField.getText());
                    u.setPassword(passwordField.getText());
                   
                    Session s1= HibernateUtil.getSessionFactory().openSession();
                    Transaction t= s1.beginTransaction();
                    
                    s1.save(u);
                    t.commit();
                    s1.close();
   
        
    } catch (IOException e) {
        showAlert(Alert.AlertType.ERROR, owner, "Form Error!", e.getMessage());
    }

      
    }
    
    /*-------------------------------log in page------------------------------*/
    @FXML
    PasswordField passwordFieldd;
    
    @FXML
    Button logInButton;

    @FXML
    TextField accNumberFieldd;

    
    @FXML
    public void handleLogInButtonAction(ActionEvent event) throws IOException {
        Window window = logInButton.getScene().getWindow();
      


       if(accNumberFieldd.getText().isEmpty()) {
        showAlert(Alert.AlertType.ERROR, window, "Form Error!", "Please enter your account number");
        return;
    } else {
        String accountNum = accNumberFieldd.getText();
        boolean acc = false;
        if(accountNum.equals(accNumberField)) {
            acc = true;
        }
        else{
            if(acc=false) {
            showAlert(Alert.AlertType.ERROR, window, "Form Error!", "Account number is not correct");
            return;
        }}
    }

    if(passwordFieldd.getText().isEmpty()) {
        showAlert(Alert.AlertType.ERROR, window, "Form Error!", "Please enter a password");
        return;
    } else {
        String password = passwordFieldd.getText();
        boolean correctPassword = false;
        if(password.equals(passwordField)) {
            correctPassword = true;
        }
        else {
            if(correctPassword=false) {
            showAlert(Alert.AlertType.ERROR, window, "Form Error!", "Password is not correct");
            return;
        } }
    }
        try {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) logInButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
             
        
    } catch (IOException e) {
        showAlert(Alert.AlertType.ERROR, window, "Form Error!", e.getMessage());
    }
    

    }
    
    /**
     * Shows an alert dialog with the specified type, title and message.
     * @param alertType
     * @param owner
     * @param title
     * @param message
     */
    
    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
      Alert alert = new Alert(alertType);
      alert.setTitle(title);
      alert.setHeaderText(null);
      alert.setContentText(message);
      alert.initOwner(owner);
      alert.show();
}
    
    /*-------------------------interface -----------------------*/
    @FXML
    Button interfaceLogInButton;
    @FXML
    public void interfaceLogIn(ActionEvent event) throws IOException {
  
    FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.5), interfaceLogInButton.getScene().getRoot());
    fadeOut.setFromValue(1);
    fadeOut.setToValue(0);
    fadeOut.setOnFinished(e -> {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LogIn.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) interfaceLogInButton.getScene().getWindow();
            stage.setScene(scene);
            FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.5), root);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.play();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    });
    fadeOut.play();
} 
     
    @FXML
    Button interfaceSignUpButton;
    @FXML
    public void interfaceSignUp(ActionEvent event) throws IOException {
    FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.5), interfaceSignUpButton.getScene().getRoot());
    fadeOut.setFromValue(1);
    fadeOut.setToValue(0);
    fadeOut.setOnFinished(e -> {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) interfaceSignUpButton.getScene().getWindow();
            stage.setScene(scene);
            FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.5), root);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.play();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    });
    fadeOut.play(); 
    }
      
    @FXML
    Hyperlink goToSignUp;
    @FXML
    public void goToeSignUp(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) goToSignUp.getScene().getWindow();
        stage.setScene(scene);
        stage.show();      
    }
    
    @FXML
    Button goToStartUp;
    @FXML
    public void goToStartUp(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("interface.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) goToStartUp.getScene().getWindow();
        stage.setScene(scene);
        stage.show();      
    }
    
  


    @FXML
    private Hyperlink forgetPass;
    @FXML
     void forgetPassAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("changePassword.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) forgetPass.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
 
     
 
}
