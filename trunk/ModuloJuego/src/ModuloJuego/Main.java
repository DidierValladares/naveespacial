package ModuloJuego;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class Main
{
    public static void main(String[] args)
    {
        final int ancho  = 600;
        final int altura = 800;
        final String anuncio = "Dispara con CTRL y usa las " +
                                "Flechas de teclado para desplazarte";

        JFrame    ventana        = new JFrame("Demo : Juego de Naves");
        Escenario espacioEstelar = new Escenario();
        JButton   barraAnuncio   = new JButton(anuncio);

        barraAnuncio.setFocusable(false);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocation(300,100);
        ventana.setSize(ancho,altura);
        ventana.setResizable(false);
        ventana.add( espacioEstelar, BorderLayout.CENTER );
        ventana.add( barraAnuncio  , BorderLayout.SOUTH  );
        ventana.setVisible(true);

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
