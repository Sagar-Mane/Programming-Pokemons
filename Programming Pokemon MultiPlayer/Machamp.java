import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Machamp extends Actor implements PokeSet1
{
     GifImage myGif= new GifImage("machamp.gif");
     public void setGif()
     {
         setImage(myGif.getCurrentImage());
     }
    
    public void act() 
    {
        setGif();
    }    
}
