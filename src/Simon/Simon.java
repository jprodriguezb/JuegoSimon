/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simon;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author jprod
 */
public class Simon {
    public static final int COLOR_VERDE=1;
    public static final int COLOR_ROJO=2;
    public static final int COLOR_AZUL=3;
    public static final int COLOR_AMARILLO=4;
    public static final int COLOR_MORADO=5;
    public static final int COLOR_ANARANJADO=6;
    public static final int COLOR_ROSADO=7;
    public static final int COLOR_NEGRO=8;
    
    public static final int NIVEL_RAPIDO=500;
    public static final int NIVEL_NORMAL=1000;
    public static final int NIVEL_LENTO=2000;
    
    public static ArrayList<Integer> secuencia = new ArrayList<Integer>();
    public static int indice;
    
    public static int nivel=NIVEL_NORMAL;
    public static int puntaje=0;
    public static int mayorPuntaje=0;
    
    
    public static int generarColor(){
        return (int)((Math.random()*8)+1);
    }
    
    public static void agregarSecuencia(){
        secuencia.add(Simon.generarColor());
        Simon.indice=0;
    }
    
    public static int obtenerSecuencia(){
        if (Simon.indice==Simon.secuencia.size()){
            Simon.indice=0;
            return 0;
        }else{
            int valor=(int)secuencia.get(indice);
            Simon.indice++;
            return valor;
        }
    }
    
    public static boolean compararSecuencia(int color){
        return Simon.secuencia.get(indice++)==color;
    }
    
    public static void reiniciar(){
        Simon.indice=0;
        Simon.secuencia.clear();
        Simon.puntaje=0;
    }
}
