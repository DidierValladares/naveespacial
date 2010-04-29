package ModuloJuego;

import javax.swing.JPanel;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Escenario extends JPanel
{
    private final int Arriba    = 0;
    private final int Abajo     = 1;
    private final int Izquierda = 2;
    private final int Derecha   = 3;
    private final int Disparar  = 4;
    
    private Boolean [] Tecla = { false,false,false,false};
    
    private ArrayList<Actor> actores;
    private Nave Player;
    private float dtiempo;
    private String figurafondo = "espacioEstelar800x600.jpg";
    private Image fondo;
    private Sonido sonido;

    public Escenario()
    {
        super();
        fondo = new ImageIcon( getClass().getResource(figurafondo)).getImage();
        addKeyListener(new Teclado() );
        setFocusable(true);
        actores = new ArrayList<Actor>();
        sonido = new Sonido();
    }

    public void agregarPlayer(Nave jugador)
    {
        Player =  jugador;
    }

    public void agregarActor(Actor nuevoActor)
    {
        actores.add(nuevoActor);
    }


    private class Teclado extends KeyAdapter
    {
        public void keyPressed(KeyEvent e) {
         actualiza(e.getKeyCode(), true);
         }

        public void keyReleased(KeyEvent e) {
           actualiza(e.getKeyCode(), false);
        }

        private void actualiza(int keyCode, boolean pulsado)
        {
            switch (keyCode)
            {
                case KeyEvent.VK_UP:
                    Tecla[Arriba] = pulsado;
                    break;
                case KeyEvent.VK_DOWN:
                    Tecla[Abajo]  = pulsado;
                    break;
                case KeyEvent.VK_LEFT:
                    Tecla[Izquierda] = pulsado;
                    break;
                case KeyEvent.VK_RIGHT:
                    Tecla[Derecha] = pulsado;
                    break;
                case KeyEvent.VK_CONTROL :
                    agregarActor( new Misil(Player.getX(),Player.getY()) );
                    sonido.disparar();
                    break;
            }
        }
    }
    //

    public void paintComponent(Graphics GPanel)
    {
        super.paintComponent(GPanel);
       GPanel.drawImage(fondo, 0,0,null);
       if ( !actores.isEmpty() )
        {
          // System.out.println("numero de actores: " + actores.size());
           for ( Actor personaje : actores )
           {
              personaje.dibujar(GPanel);
              personaje.actuando(dtiempo);
           }
           for ( Actor personaje : actores )
           {
              if ( personaje.getDestruirActor() )
              {
                  actores.remove(personaje);
                  break;
              }
           }

        }
        
    }

    public void bucleDelJuego()
    {
       long tiempoViejo = System.nanoTime();

       while(true)
       {
           long tiempoNuevo = System.nanoTime();
           dtiempo = (tiempoNuevo - tiempoViejo) / 1000000000f;
           Player.movimientoFisico(dtiempo,Tecla);
           tiempoViejo = tiempoNuevo;
           repaint();
  
           try
           {
             Thread.sleep(20);
           }
           catch(Exception e){ }
       }

    }
}

