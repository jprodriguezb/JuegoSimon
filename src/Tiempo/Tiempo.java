/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tiempo;

/**
 *
 * @author jprod
 */
public class Tiempo {
    private static int minutos;
    private static int segundos;
    
    public static void avanzar(){
        Tiempo.segundos++;
        if (Tiempo.segundos==60){
            Tiempo.minutos++;
            Tiempo.segundos=0;
        }
    }
    
    public static void reiniciar(){
        Tiempo.segundos=0;
        Tiempo.minutos=0;
    }
    
    public static String obtenerTiempo(){
        String tiempo;
        if (Tiempo.minutos<10){
            tiempo="0"+ String.valueOf(Tiempo.minutos);
        }else{
            tiempo=String.valueOf(Tiempo.minutos);
        }
        tiempo+=":";        
        if (Tiempo.segundos<10){
            tiempo+="0"+ String.valueOf(Tiempo.segundos);
        }else{
            tiempo+=String.valueOf(Tiempo.segundos);
        }
        return tiempo;
    }
}
