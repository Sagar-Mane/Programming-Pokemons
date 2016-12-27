import greenfoot.*;  

public class Chansey extends Actor implements PokeSet1
{
    GifImage myGif= new GifImage("chansey.gif");
    public void setGif()
    {
        setImage(myGif.getCurrentImage());
    }
    public void act() 
    {
       setGif();
    }    
}
