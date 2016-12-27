import greenfoot.*;  

public class Pikachu extends Actor implements PokeSet1
{
     GifImage myGif= new GifImage("pikachu.gif");
    public void setGif()
    {
    setImage(myGif.getCurrentImage());
}
    public void act() 
    {
     setGif();
    }    
}
