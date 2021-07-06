/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sonidos;

import org.jfugue.player.Player;

/**
 *
 * @author jprod
 */
public class Sonidos {
  
    public static String notas[]={"","C","D","E","F","G","A","B","C#"};
    
    private static Player rep = new Player();
    
    public static void reproducir(String nota){
        rep.play(nota);
    }
}
