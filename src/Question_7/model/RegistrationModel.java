package Question_7.model;

import javax.swing.JOptionPane;

public class RegistrationModel {
    String username, password, fname, lname, email, gender, confirmpassword;
          
    
    public RegistrationModel(String username, String password, String fname, String lname, String email, String gender,String confirmpassword)
    {
        this.username=username;
        this.password=password;
        this.fname=fname;
        this.lname=lname;
        this.email=email;
        this.gender=gender;
        this.confirmpassword=confirmpassword;
        
    } 

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getconfirmPassword() {
        return confirmpassword;
    }

    public void setconfirmPassword(String confirmpassword) {
        this.confirmpassword=confirmpassword;
    }
    
}   

