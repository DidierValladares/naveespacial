package ModuloJuego;


import java.applet.*;
import javax.sound.sampled.*;
import javax.swing.*;
import java.io.*;

public class Sonido extends JFrame
{

    Sonido(){ }

    public void disparar()
    {
        InputStream path = getClass().getResourceAsStream("photon.wav");

        try{
                   Clip sonido=AudioSystem.getClip();
                        sonido.open(AudioSystem.getAudioInputStream(path));
                        sonido.start();

        }catch(Exception fallo){
                        System.out.println(fallo);
        }
    }

    

}
