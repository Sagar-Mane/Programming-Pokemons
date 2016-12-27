import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NameButtons here.
 * 
 * @author Nitinkumar Gove
 * @version 1.0
 */
public class NameButton extends Button
{
   String tag = "";
        
    public NameButton(String t)
    {
        super(t);
        this.tag = t;
        createButton(t);
    }
    public String getTag()
    {
            return this.tag;
    }
    public void act(){
        createButton(this.tag);
         if (Greenfoot.mouseClicked(this)) {
           // System.out.println("Button " + this.getTag());
        }        
    }  
    
    public void createButton(String tag)
    {       
        if(tag.equalsIgnoreCase("lucy")){
               GreenfootImage drawedImage = new GreenfootImage("lucy.png");
               setImage(drawedImage);  
        }
        else if(tag.equalsIgnoreCase("john")){
               GreenfootImage drawedImage = new GreenfootImage("john.png");
               setImage(drawedImage); 
        }
        else if(tag.equalsIgnoreCase("bruce")){
               GreenfootImage drawedImage = new GreenfootImage("bruce.png");
               setImage(drawedImage);  
        }
        else if(tag.equalsIgnoreCase("milly")){
               GreenfootImage drawedImage = new GreenfootImage("milly.png");
               setImage(drawedImage); 
        }
        else if(tag.equalsIgnoreCase("game1")){
               GreenfootImage drawedImage = new GreenfootImage("game1.png");
               setImage(drawedImage);  
        }
        else if(tag.equalsIgnoreCase("game2")){
               GreenfootImage drawedImage = new GreenfootImage("game2.png");
               setImage(drawedImage); 
        }
        else if(tag.equalsIgnoreCase("game3")){
               GreenfootImage drawedImage = new GreenfootImage("game3.png");
               setImage(drawedImage);  
        }
        else if(tag.equalsIgnoreCase("game4")){
               GreenfootImage drawedImage = new GreenfootImage("game4.png");
               setImage(drawedImage); 
        }
        else if(tag.equalsIgnoreCase("game5")){
               GreenfootImage drawedImage = new GreenfootImage("game5.png");
               setImage(drawedImage); 
        }
    }
}
