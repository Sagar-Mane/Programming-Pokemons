import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.ws.rs.core.Response;
import java.util.ArrayList;

/**
 * Write a description of class ChooseGame here.
 * 
 * @author Nitinkumar Gove
 * @version 2.0
 */
public class ChooseGame extends World
{
    NameButton game1, game2, game3, game4, game5;
    
    Message m; 
    Service service;
    
    ArrayList<Long> gameIds;
    ArrayList<String> names;
    boolean isactive = false;    
     
    public ChooseGame(int games)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels. 
        
       super(800, 600, 1);  
     
       service = Service.getInstance(); 
       int activegames = service.getGamesCount();
       
       //System.out.println("#active games "+activegames);
       if(activegames != 0 ) 
       {       
           isactive = true; 
           names = new ArrayList<String>();        
           m = new Message(" Which game you want to join ? ", 40);
           addObject(m, 400, 50);
         
            int startx = 400;
            int starty = 130;
            //System.out.println("#gamestochoose" + games);
            for(int i=0;i<games;i++)
            {                  
                switch(i){
                    case 0: game1 = new NameButton("game"+(i+1));
                            
                            addObject(game1, startx, starty);
                            starty += 90;
                            break;
                    case 1: game2 = new NameButton("game"+(i+1));
                            addObject(game2, startx, starty);
                            starty += 90;
                            break;
                    case 2: game3 = new NameButton("game"+(i+1));
                            addObject(game3, startx, starty);
                            starty += 90;
                            break;
                    case 3: game4 = new NameButton("game"+(i+1));
                            addObject(game4, startx, starty);
                            starty += 90;
                            break;
                    case 4: game5 = new NameButton("game"+(i+1));
                            addObject(game5, startx, starty);
                            starty += 90;
                            break;
                }
            }        
        }
        else
        {
            m = new Message(" There are no active games present. \n How about creating a one for yourself ? \n < Click to go back > ", 40);
           addObject(m, 400, 300);
           isactive = false;
        }
    }
    
  
    
    public void act() 
    {  
       if(isactive){ 
           
           gameIds = service.getAvailableGames();
           
           
            if (Greenfoot.mouseClicked(game1)) {
                 //System.out.println("joining game 1");
                 service.getPlayerNames(gameIds.get(0));
                 Name h = new Name();
                 Greenfoot.setWorld(h); 
                 
            }
            else if (game2!=null && Greenfoot.mouseClicked(game2)) {
                //System.out.println("joining game 2");
                service.getPlayerNames(gameIds.get(1));
                Name h = new Name();
                Greenfoot.setWorld(h);
                 
            }
            else if (game3!=null && Greenfoot.mouseClicked(game3)) {
                //System.out.println("joining game 3 " );
                service.getPlayerNames(gameIds.get(2));
                Name h = new Name();
                Greenfoot.setWorld(h);
                
            }
            else if (game4!=null && Greenfoot.mouseClicked(game4)) {
                //System.out.println("joining game 4");
                service.getPlayerNames(gameIds.get(3));
                Name h = new Name();
                Greenfoot.setWorld(h);
                
            }
            else if (game5!=null && Greenfoot.mouseClicked(game5)) {
                //System.out.println("joining game5");
                service.getPlayerNames(gameIds.get(4));
                Name h = new Name();
                Greenfoot.setWorld(h);
                
            }
        }
        else
        {
            if (Greenfoot.mouseClicked(this)) {
                 StartScreen h = new StartScreen();
                 Greenfoot.setWorld(h);                 
            }
        }
    }
  
    
    
    
}
