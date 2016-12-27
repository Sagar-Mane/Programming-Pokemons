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
    public void act() 
    {
        // Add your action code here.
        createButton(this.tag);
         if (Greenfoot.mouseClicked(this)) {
            System.out.println("Button " + this.getTag());
        }
        
        
    }  
    
    public void createButton(String tag)
    {       
        if(tag.equalsIgnoreCase("lucy")){
               GreenfootImage drawedImage = new GreenfootImage("namelucy.jpg");
               setImage(drawedImage);  
        }
        else if(tag.equalsIgnoreCase("john")){
               GreenfootImage drawedImage = new GreenfootImage("namejohn.jpg");
               setImage(drawedImage); 
        }
        else if(tag.equalsIgnoreCase("bruce")){
               GreenfootImage drawedImage = new GreenfootImage("namebruce.jpg");
               setImage(drawedImage);  
        }
        else if(tag.equalsIgnoreCase("milly")){
               GreenfootImage drawedImage = new GreenfootImage("namemilly.jpg");
               setImage(drawedImage); 
        }
    }
}
