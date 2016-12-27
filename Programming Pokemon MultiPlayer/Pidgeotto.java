import greenfoot.*;  

public class Pidgeotto extends Actor implements PokeSet1
{
    GifImage myGif= new GifImage("pidgeotto.gif");
    public void setGif()
    {
        setImage(myGif.getCurrentImage());
    }
    public void act() 
    {
        setGif();
        
    }    
}
