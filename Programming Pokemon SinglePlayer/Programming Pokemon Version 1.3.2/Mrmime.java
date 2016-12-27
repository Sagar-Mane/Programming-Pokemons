import greenfoot.*;  


public class Mrmime extends Actor implements PokeSet1
{
    GifImage myGif= new GifImage("mr-mime.gif");
    public void setGif()
    {
        setImage(myGif.getCurrentImage());
    }
    public void act() 
    {
        setGif();
    }    
}
