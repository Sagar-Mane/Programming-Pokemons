import greenfoot.*;  

public class Ponyta extends Actor implements PokeSet1
{
    GifImage myGif= new GifImage("ponyta.gif");
    public void setGif()
    {
        setImage(myGif.getCurrentImage()); 
    }
    
    
    public void act() 
    {
       setGif();
    }    
}
