/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.servidorweb.main;

import co.edu.eam.servidorweb.Servidor;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kvin2
 */
public class Main {
   public static void main(String[] args) {
       try {
           // TODO code application logic here
           Servidor s= new Servidor();
           s.correrServidor();
       } catch (IOException ex) {
           Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
       }
                
    }
}
