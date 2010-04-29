package ModuloJuego;

public class Misil extends Actor
{
    private String FiguraMisil = "misilJugador.gif";
    Misil()
    {
        super(1,400); //  imagen y velocidad por defecto
        addFrame(1,FiguraMisil);
        setAlturaMax(800);
    }

    Misil(int x, int y)
    {
        this();
        setX(x);
        setY(y);
    }

    @Override
    public void actuando(float dt)
    {
        setY( getY() - (int)(getVelocidad()*dt)  );
        if (getY() < 0 ) setDestruirActor(true);
    }
}
