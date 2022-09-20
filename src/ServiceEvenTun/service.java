/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceEvenTun;


import java.io.IOException;
import java.util.List;


/**
 *
 * @author panda
 */
public interface service<T> {
//void switchrole(String role) throws IOException;
    void adduser(T u);

    void addpub(T t);

    boolean forgetpass(T t);

    void deleteuser(T t);
    void deletepub(T t);

    boolean readById(T t);
     void readByLogin(T t);

    List<T> readAll();

    void login(T t);

    void updatepass(T t);

    void upuser(T t);

    void  updatepub(T t);
 void readByIdpromo (int t);
}
