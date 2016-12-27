import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;

/**
 * Write a description of class Name here.
 * @author Nitinkumar Gove
 * @version 3.0
 */
public class Name extends World
{
    NameButton john, lucy, bruce, milly;
    ArrayList<String> allowedNames;
    Message m;
    Service service;    
    String variable = " Awesome ! Just the way you picked a name for you, in computer world you \n use variables to a particular memory location.";    
    
    public Name()
    {          
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        john = new NameButton("john");
        milly = new NameButton("milly");
        bruce = new NameButton("bruce");
        lucy = new NameButton("lucy");
        
        service = Service.getInstance();
        allowedNames = new ArrayList<String>(service.findAllowedNames());
        
        //System.out.println("#allowednames"+allowedNames.size());      
        
        m = new Message("Select a name for your player ", 40);
        addObject(m, 400, 150);
        drawButtons();
        
     
    }
    
    // add buttons to world
    // draw the allowed buttons
	public void drawButtons()
	{
		int startx = 350;
		int starty = 250;
		for(String s : allowedNames){
			
			if(s.equalsIgnoreCase("john")){
				//System.out.println("#create > " + s + " at " + startx + " , " + starty);
				// add button here
				addObject(john, startx, starty);
				starty += 80;
			}
			else if(s.equalsIgnoreCase("bruce")){
				//System.out.println("#create > " + s + " at " + startx + " , " + starty);
				// add button here
				 addObject(bruce, startx, starty);
				starty += 80;
			}
			else if(s.equalsIgnoreCase("lucy")){
				//System.out.println("#create > " + s + " at " + startx + " , " + starty);
				// add button here
				addObject(lucy, startx, starty); 
				starty += 80;
			}
			else if(s.equalsIgnoreCase("milly")){
				//System.out.println("#create > " + s + " at " + startx + " , " + starty);
				// add button here
				addObject(milly, startx, starty);
				starty += 80;
			}
		}
	}
       
    public void act() 
    {       
        
        if (Greenfoot.mouseClicked(john)) {
           //System.out.println("#clicked "+john.getTag()); 
           //System.out.println("#addto "+service.getSelectedGame());
           service.setSelectedName(john.getTag());
           service.addPlayer(service.getSelectedGame(),john.getTag()); 
           Greenfoot.setWorld(new Level01());
        }
        else if (Greenfoot.mouseClicked(bruce)) {
           //System.out.println("#clicked "+bruce.getTag()); 
           //System.out.println("#addto "+service.getSelectedGame());
           service.setSelectedName(bruce.getTag());
           service.addPlayer(service.getSelectedGame(),bruce.getTag()); 
           Greenfoot.setWorld(new Level01());
        }
        else if (Greenfoot.mouseClicked(milly)) {
           //System.out.println("#clicked "+milly.getTag()); 
           //System.out.println("#addto "+service.getSelectedGame());
           service.setSelectedName(milly.getTag());
           service.addPlayer(service.getSelectedGame(),milly.getTag()); 
           Greenfoot.setWorld(new Level01());
        }
        else if (Greenfoot.mouseClicked(lucy)) {
           //System.out.println("#clicked "+lucy.getTag()); 
           //System.out.println("#addto "+service.getSelectedGame());
           service.setSelectedName(lucy.getTag());
           service.addPlayer(service.getSelectedGame(),lucy.getTag()); 
           Greenfoot.setWorld(new Level01());
        }
        
      
    } 
 
    
    
}
