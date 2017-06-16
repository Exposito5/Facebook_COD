/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebookcod;

import facebook4j.FacebookException;
import java.net.MalformedURLException;
import javax.swing.JOptionPane;

/**
 *
 * @author artur
 */
public class FacebookCOD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FacebookException, MalformedURLException {
        Metodos m = new Metodos();
        int select;
     do{
        m.autorizar();
        select = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la opción deseada "
                + "\n 1.postear \n 2.buscar Post \n 3. Mostrar Feed \n 4.comentar Foto \n 5. Postear foto \n 0.Salir"));
        switch(select){ 
        case 1: m.postearMensaje(JOptionPane.showInputDialog("Introduce el contenido del post "));
        break;
        case 2:m.buscarPost();
        break;
        case 3:m.buscarFeed();
        break;
        case 4:m.comentario();
        break;
        case 5:m.postPhoto();
        break;
        
        }  
     }while(select!=0);
    }
    
}
