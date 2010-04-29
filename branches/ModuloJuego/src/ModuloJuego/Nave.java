package ModuloJuego;

import java.awt.event.KeyEvent;

public class Nave extends Actor
{
    private String FiguraNave = "naveJugador.png";
    public Nave()
    {
        super(1,300);
        addFrame(1,FiguraNave);
        setAlturaMax(800);
        setAnchoMax(600);
    }

    public void actuando(float dt)
    {

    }

    public void movimientoFisico(float dt, Boolean [] teclas)
    {
        float  vx = 0;
        float  vy = 0;
        int velocidad = getVelocidad();

        if (teclas[0])
                vy = -velocidad;
        if (teclas[1])
                vy = velocidad;
        if (teclas[2])
                vx = -velocidad;
        if (teclas[3])
                vx = velocidad;

        int cordX = getX() + (int) (vx * dt);
        int cordY = getY() + (int) (vy * dt);

        if ( (cordX > getAncho()/2 ) && (cordX < getAnchoMax()-getAncho()/2) )
        {
          setX(cordX);
        }

        if ( (cordY > getAltura()/2 ) && (cordY < getAlturaMax()-getAltura() ) )
        {
          setY(cordY);
        }
    }
}
