import greenfoot.*;  


public class Wailord extends Actor implements PokeSet1
{
    GifImage myGif= new GifImage("wailord.gif");
    public void setGif()
    {
        setImage(myGif.getCurrentImage());
    }
    

    public void act() 
    {
        // Add your action code here.
        setGif();
    }    
}
