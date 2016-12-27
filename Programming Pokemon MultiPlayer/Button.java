import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author Nitinkumar Gove
 * @version 1.0
 */
public class Button extends Actor
{
   String tag = "";
        
    public Button(String t)
    {
        this.tag = t;
        createButton(t);
    }
   
    public void act() 
    {      
       
    } 
 
    public void createButton(String tag)
    {       
          if(tag.equalsIgnoreCase("playnow")){
               GreenfootImage drawedImage = new GreenfootImage("playnowsmall.png");  
               setImage(drawedImage); 
            }
            else if(tag.equalsIgnoreCase("createnewgame")){
               GreenfootImage drawedImage = new GreenfootImage("createnewgame.png");  
               setImage(drawedImage); 
            }
              else if(tag.equalsIgnoreCase("joingame")){
               GreenfootImage drawedImage = new GreenfootImage("joingame.png");   
               setImage(drawedImage); 
            }
            else if(tag.equalsIgnoreCase("continue")){
               GreenfootImage drawedImage = new GreenfootImage("continuegame.png");   
               setImage(drawedImage); 
            }
          
    }
}
