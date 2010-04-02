package ModuloJuego;

public class NaveEnemiga extends Actor
{
    private String FiguraNave = "naveEnemiga.png";
    int signo = 1;
    NaveEnemiga() 
    {
        super(1,200);
        addFrame(1,FiguraNave);
        setX(400);
        setY(50);
    }

    @Override
    public void actuando(float dt) 
    {
        float incremento =  ( (float) getVelocidad() * dt);
        incremento = incremento*signo;
        setX( getX() +(int) incremento);
        if(getX() >= 560) signo = -signo;
        if(getX() <= 35) signo = -signo;
    }
}
