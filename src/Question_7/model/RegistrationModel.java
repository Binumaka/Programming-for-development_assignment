package Question_7.model;
public class RegistrationModel {
    String username, password, first_name, last_name, email,confirmpassword;
          
    
    public RegistrationModel(String username, String password, String first_name, String last_name, String email, String confirmpassword)
    {
        this.username=username;
        this.password=password;
        this.first_name=first_name;
        this.last_name=last_name;
        this.email=email;
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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getconfirmPassword() {
        return confirmpassword;
    }

    public void setconfirmPassword(String confirmpassword) {
        this.confirmpassword=confirmpassword;
    }
    
}   

