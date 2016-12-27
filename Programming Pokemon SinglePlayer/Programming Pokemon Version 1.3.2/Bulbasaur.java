import greenfoot.*; 
import java.util.concurrent.ThreadLocalRandom;   

public class Bulbasaur extends Actor implements PokeSet1
{
    GifImage myGif= new GifImage("bulbasaur.gif");
    public void setGif()
    {
        setImage(myGif.getCurrentImage());
     }
public void act() 
    {
        setGif(); 
    }    
    
}
