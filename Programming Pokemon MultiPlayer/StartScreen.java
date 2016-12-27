import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.awt.Color;
/**
 * Write a description of class StartScreen here.
 * 
 * @author Nitinkumar Gove
 * @version 1.0
 */
public class StartScreen extends World
{
    
    Button createGame, joinGame;
    
    /**
     * Constructor for objects of class StartScreen. 
     */
    
    Service service;
    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.        
        super(800, 600, 1); 
        Greenfoot.setSpeed(50);
        createGame = new Button("createnewgame");
        joinGame = new Button("joingame");
        
        this.setBackground(new GreenfootImage("poke2.jpg"));
        this.addObject(createGame, 400, 250 ) ;
        this.addObject(joinGame, 400, 320 ) ;
        try{        
            service = Service.getInstance();             
            // long gm = service.createGame();
            // ArrayList<Long> glist = service.getAvailableGames(); 
            // for(Long l : glist)
            // {
            //     System.out.println("Game "+l);
            // }
        }
        catch(Exception e)
        {
                
        }    
        
        // add a player to a game
        // String myid = service.addPlayer(gm, "Sagar");
        // System.out.println("myid " + myid);
        
        // update my score
        // service.updateScore(100);
        // service.updateScore(200);
        // service.updateScore(300);     
        
    }
    
    public void act(){       
        if (Greenfoot.mouseClicked(createGame)) {
             //System.out.println("#create");
             long gm = service.createGame();
             
             //System.out.println("#created "+gm);
             if(gm>0){
                 HowToPlay h = new HowToPlay();
                 Greenfoot.setWorld(h);  
            }
            else
            {
               Message m = new Message("Please Join existing game !", 40,Color.WHITE);
               addObject(m, 550, 50);
            }
        }
        
        if(Greenfoot.mouseClicked(joinGame)){
            
        //System.out.println("#join");
        int gamecount= service.getGamesCount();
        
            if(gamecount==0)
            {
                //System.out.println("You need to create a game first");
                Message m = new Message("No Active Games ! Please create one !", 40,Color.WHITE);
               addObject(m, 550, 50);
            }
            else {
                //System.out.println("#games-" + gamecount);
                if(gamecount<=5){
                    ChooseGame h = new ChooseGame(gamecount);
                    Greenfoot.setWorld(h);
                }
                else
                {
                    ChooseGame h = new ChooseGame(5);
                }
            }            
        }
    } 
    
    public int fetchGame(){
        return 0;
    }
 
}
