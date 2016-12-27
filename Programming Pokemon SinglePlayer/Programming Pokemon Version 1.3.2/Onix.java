import greenfoot.*;  

public class Onix extends Actor implements PokeSet1
{
    
    GifImage myGif= new GifImage("onix.gif");
    public void setGif()
    {
        setImage(myGif.getCurrentImage());
    }

    public void act() 
    {
        setGif();
    }    
}
