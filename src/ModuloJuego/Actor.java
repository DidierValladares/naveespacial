package ModuloJuego;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.io.IOException;

public class Actor
{
    private int posx,posy,alturamax,anchomax;
    private boolean destruir;
    private boolean activo;
    private int imagenActual,nroImagenes;
    private Image [] imagenesActor;
    private int velocidad;

    public Actor(int nro_imagenes, int velocidad_actor)
    {
       activo=false;
       imagenActual  = 0;
       nroImagenes   = nro_imagenes;
       velocidad = velocidad_actor;
       imagenesActor = new Image[nro_imagenes];
    }
    
    public void setDestruirActor(boolean estado)
    {
        destruir = estado;
    }

    public boolean getDestruirActor()
    {
        return destruir;
    }

    public void  setAlturaMax(int max)
    {
        alturamax = max;
    }

    public void  setAnchoMax(int max)
    {
        anchomax = max;
    }

    public int getAnchoMax()
    {
        return anchomax;
    }

    public int getAlturaMax()
    {
        return alturamax;
    }

    public int getVelocidad()
    {
        return velocidad;
    }
    public void setVelocidad(int nueva_velocidad)
    {
        velocidad=nueva_velocidad;
    }

    public void setX(int x)
    {
        posx= x;//
    }
    public void setY(int y)
    {
        posy= y;//
    }
    public int getX()
    {
        return posx;
    }
    public int getY()
    {
        return posy;
    }

    public int getAncho()
    {
        return imagenesActor[imagenActual].getWidth(null);
    }
    public int getAltura()
    {
        return imagenesActor[imagenActual].getHeight(null);
    }
    public void on() {
        activo=true;
    }
    public void off()
    {
        activo=false;
    }
    public boolean estaActuando()
    {
        return activo;
    }

    public void seleccionarImagen(int nroImagen)
    {
       imagenActual = nroImagen;
    }
    
    public int frames()
    {
       return nroImagenes;
    }

    public void addFrame(int frameno, String nombreArchivo)
    {
       if (frameno-1<imagenesActor.length)
         imagenesActor[frameno-1] = new ImageIcon(
                 getClass().getResource(nombreArchivo)).getImage();
       else
         System.out.println("imposible cargar "+nombreArchivo+" arreglo lleno");
    }

    public void dibujar(Graphics g)
    {
        g.drawImage(imagenesActor[imagenActual],getX()-getAncho()/2,
                getY()-getAltura()/2, null);
    }

    public void actuando(float dt)
    {

    }
} // fin clase Actor


