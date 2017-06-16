/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebookcod;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.PostUpdate;
import facebook4j.ResponseList;
import facebook4j.conf.ConfigurationBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author artur
 */
public class Metodos {
    
    static Facebook facebook;
    /**
     * Metodo de validar tokkens y obtener los permisos
     */
    public void autorizar() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthAppId("419969195026537")
                .setOAuthAppSecret("a9857f890691750e5ea2764a42403362")
                .setOAuthAccessToken("EAACEdEose0cBAK4s0XEEcfnmBnSHkfCrXgedVzn4XMoZB8d4DW98dQXzIbjRZBQZC0GZAW5joYX3gOu6klA3cBrVu9EVAL2Wn6ncCInIjnSopmdZAGgG9zxmhMjNz9t8R88u12TkTkpHtLkRCkEYil8emaZCYCBz1tkKRc2mO4vi4XqJqVgSJclwD7KukjZASMZD")
                .setOAuthPermissions("email,publish_stream,publish_actions,user_likes,user_status,user_about_me,user_photos,user_posts");
        FacebookFactory ff = new FacebookFactory(cb.build());
        facebook = ff.getInstance();
    }
    
     /**
     * postea un estado nuevo
     *
     * @param mensaje contiene el mensaje a postear
     */
    public static void postearMensaje(String mensaje) {

        try {
            facebook.postStatusMessage(mensaje);
        } catch (FacebookException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /**
     * buscar un post
     *
     * @throws FacebookException
     */
    public static void buscarPost() throws FacebookException {
        ResponseList<Post> results = facebook.getPosts(JOptionPane.showInputDialog(null, "Introduce la busqueda"));

        System.out.println(results.toString());
    }
    
    /**
     * comenta una foto publicada en tu propio muro,el primer parámetro es el
     * ID,el segundo el comentario
     *
     * @throws FacebookException
     */
    public static void comentario() throws FacebookException {
        facebook.commentPhoto(JOptionPane.showInputDialog("Introduce el ID de la foto "), JOptionPane.showInputDialog(" Introduce el comentario  "));
    }
    
    /**
     * crea un nuevo post con imagen incluida,pero sólo desde  una URL  dada por parámetro
     *
     * los datos de postear foto me las inventé porque no se me ocurría que imagen buscar
     * 
     * @throws MalformedURLException
     * @throws FacebookException
     */
    public static void postPhoto() throws MalformedURLException, FacebookException {
        PostUpdate post = new PostUpdate(new URL("www.google.es"))
                .picture(new URL("http://www.google.es/imagen.jpg"))
                .name("Imagen de google")
                .caption("google.es")
                .description("Decribiendo la imagen subida...");
        facebook.postFeed(post);
    }
    
    /**
     * para buscar feeds referentes a las palabras de búsqueda
     *
     * @throws FacebookException
     */
    public static void buscarFeed() throws FacebookException {
        ResponseList<Post> noticia = facebook.getFeed(JOptionPane.showInputDialog("Introduce la palabra clave a buscar"));
        System.out.println(noticia.toString());
    }
}
