package ModuloJuego;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Main
{


    public static void main(String[] args)
    {
        final int ancho  = 600;
        final int altura = 800;
        final String anuncio = "Dispara con CTRL y usa las " +
                                "Flechas de teclado para desplazarte";

        final String autor = "Modulo de Juego - Naves " +
                                " \n \n "+
                                " Instrucciones:  \n"+
                                " Tecla CTRL  - Disparar Arma Laser \n "+
                                " Flechas direccionales para \n"+
                                " Desplazarte en el campo de batalla \n  "+
                                "  \n  "+
                                " Copyright ddcruzg ©  \n"+
                                " Intro - Alduxz  \n \n Bienvenidos los Aportes";

        final JFrame    intruxz        = new JFrame("Intro a la Aplicacion");
        JButton   boton_ok   = new JButton("OK");
        JTextArea texto_ok = new JTextArea(autor);

        final JFrame    ventana        = new JFrame("Demo : Juego de Naves");
            
        Escenario espacioEstelar = new Escenario();
        JButton   barraAnuncio   = new JButton(anuncio);

        barraAnuncio.setFocusable(false);

        intruxz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        intruxz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        intruxz.setLocation(300,100);
        intruxz.setSize(300,300);
        intruxz.add(boton_ok ,BorderLayout.AFTER_LAST_LINE);
        intruxz.add(texto_ok ,BorderLayout.CENTER );
        //boton_ok.setBounds (100, 122, 59, 25);

        boton_ok.addActionListener (new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                System.out.println("Gogogo");
                ventana.setVisible(true);
                intruxz.setVisible(false);
            }

          });

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocation(300,100);
        ventana.setSize(ancho,altura);
        ventana.setResizable(false);
        ventana.add( espacioEstelar, BorderLayout.CENTER );
        ventana.add( barraAnuncio  , BorderLayout.SOUTH  );
        ventana.setVisible(false);

        intruxz.setVisible(true);

        Nave navecita = new Nave();
        navecita.setX(300);
        navecita.setY(700);
        NaveEnemiga enemigo = new NaveEnemiga();
        
        espacioEstelar.agregarActor(enemigo);
        espacioEstelar.agregarActor(navecita);
        espacioEstelar.agregarPlayer(navecita);
        espacioEstelar.bucleDelJuego();


        

    }

}
