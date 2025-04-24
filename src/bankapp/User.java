/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "user")  
public class User implements Serializable {
    
    @Column(name = "accountNum")
    String accountNum;
    @Id
    @Column(name = "phoneNum")
    String phoneNum;
    @Column(name = "name")
    String name;
    @Column(name = "age")
    String age;
    @Column(name = "password")
    String password;
     

    
    public User() {
}

    public User(String name, String password, String accountNum, String age, String phoneNum) {
      this.name=name;
      this.password= password;
      this.accountNum=accountNum;
      this.age= age;
      this.phoneNum=phoneNum;
      
      
}
    public User(String password, String accountNum) {
      this.password= password;
      this.accountNum=accountNum;

      
      
}

   

    public String getAccNumber() {
        return accountNum;
    }

    public void setAccNumber(String accNumber) {
        this.accountNum = accNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNum;
    }

    public void setPhoneNumber(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    
    public String getName() {
      return name;
}
    
    public void setName(String name) {
      this.name = name;
}
    
    public String getPassword() {
      return password;
}
    
    
    public void setPassword(String password) {
      this.password = password;
}
    /*
     void saveRegistrationDataToFile(String name, String password, String accountNum, String age, String phoneNum) throws IOException {
    //    File file = new File("file.txt");
        // Write the registration data to the file
        try (FileWriter writer = new FileWriter("file.txt")) {
          writer.write(name.g);
         writer.close();
        } catch (IOException ee) {
            ee.printStackTrace();
}
        
}*/
}