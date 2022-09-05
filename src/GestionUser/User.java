/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionUser;

import java.util.Objects;


/**
 *
 * @author panda
 */
public class User {
    private int id;
    private String login;
    private String pwd;
    private int Telephone;
    private String email;
    private String role;

    
    

    public User() {
    }

    public User(int id, String login, String pwd, int Telephone, String email, String role) {
        this.id = id;
        this.login = login;
        this.pwd = pwd;
        this.Telephone = Telephone;
        this.email=email;
        this.role = role;
       
        
    }

    


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getTelephone() {
        return Telephone;
    }

    public void setTelephone(int Telephone) {
        this.Telephone = Telephone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "user{" + "id=" + id + ", login=" + login + ", pwd=" + pwd + ", Telephone=" + Telephone + ", email=" + email +  ", role=" + role + '}';
    }
    

}