import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import com.game.engine.model.PlayerScore;
import java.util.*;

/**
 * Write a description of class ScoresList here.
 * 
 * @author Sagar Mane 
 * @version 1.0
 */
public class ScoresList extends World
{
    Message m1;
    Service service;
    PlayerScore maxPlayerScore;
    int y;
    List<String> donePlayers;
    boolean allDone;

    /**
     * Constructor for objects of class ScoresList.
     * 
     */
    public ScoresList()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
       super(800, 600, 1);
       m1=new Message("ScoreBoard",40);
       addObject(m1,380,50);
       y = 50;
       service = Service.getInstance();
       service.updateScore(Score.getInstance().getScore());
       donePlayers = new ArrayList<String>();
    }
    
    public void act(){ 
        //System.out.println("#total scores"); 
        List<PlayerScore> scores = service.getGamePlayerScores();
        //System.out.println("#total scores" + scores.size()); 
        Greenfoot.setSpeed(25);
        for(PlayerScore p : scores){
            
            if(p.getPlayerId().equalsIgnoreCase("john") && p.getScore() >= 0 && !donePlayers.contains("john")){
                 y+=50;
                 addObject(new Message("John    -   " + p.getScore() ,40),380,y);
                 donePlayers.add("john");
            }
            if(p.getPlayerId().equalsIgnoreCase("bruce") && p.getScore() >= 0 && !donePlayers.contains("bruce")){
                 y+=50;
                 addObject(new Message("Bruce   -   " + p.getScore() ,40),380,y);
                 donePlayers.add("bruce");
            }
            if(p.getPlayerId().equalsIgnoreCase("milly")&& p.getScore() >= 0 && !donePlayers.contains("milly") ){
                  y+=50;
                  addObject(new Message("Milly  -   " + p.getScore() ,40),380,y);
                  donePlayers.add("milly");
            }
            if(p.getPlayerId().equalsIgnoreCase("lucy")&& p.getScore() >= 0 && !donePlayers.contains("lucy") ){
                 y+=50;
                 addObject(new Message("Lucy    -   " + p.getScore() ,40),380,y); 
                 donePlayers.add("lucy");
            }
            updateMax(p);        
        }
        Greenfoot.setSpeed(24);
        //Greenfoot.delay(10000);
        if(allDone) {
            Greenfoot.delay(10);
            if(service.getSelectedName().equalsIgnoreCase(maxPlayerScore.getPlayerId())) {
                Greenfoot.setWorld(new Winner());
            } else {
                 Greenfoot.setWorld(new GameOver()); 
            }
        }
          
        if(donePlayers.size() == 4) {
            allDone = true;
        }
    }
        
    private void updateMax(PlayerScore playerScore) {
        if(maxPlayerScore == null) {
            maxPlayerScore = playerScore;
        } else {
            if(playerScore.getScore() > maxPlayerScore.getScore()) {
                maxPlayerScore = playerScore;
            }
        }
    }        
}