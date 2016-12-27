import greenfoot.*;  


public class Kingler extends Actor implements PokeSet1
{
     GifImage myGif= new GifImage("kingler.gif");
    public void setGif()
    {
     setImage(myGif.getCurrentImage());
    }
    public void act() 
    {
        setGif();
    }    
    
}
