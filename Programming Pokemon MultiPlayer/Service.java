import com.game.engine.model.Game;
import com.game.engine.model.GamePlayer;
import com.game.engine.model.GamePlayerScore;
import com.game.engine.model.PlayerScore;
import javax.ws.rs.core.Response;
import com.game.http.client.GameServiceClient;
import java.util.*;
import com.game.http.client.util.ServiceUtil;

/**
 * Write a description of class Service here. 
 * @author Nitinkumar Gove
 * @version 2.0
 */
public class Service  
{
    //private static GameServiceClient client = new GameServiceClient("10.250.109.180", 8080);  
    private static GameServiceClient client = new GameServiceClient("game-server-6e2b029e.785fe513.svc.dockerapp.io", 8080);  
    
    Game gm;
    GamePlayer gp;    
    String playerid;
    int totalGames;
    long selectedGame;
    String selectedName;
    
    ArrayList<Long> gameIds;    
    ArrayList<String> playerNames;       // names of players which are part of current name
    ArrayList<String> availableNames;    // 
    ArrayList<String> allowedNames;      //    
    
    private static Service service; 
    
    
    
    private Service(){
        
        gm  = new Game();
        totalGames = 0;
        selectedGame = 0;
        selectedName = ""; 
        
        gameIds = new ArrayList<Long>();
        playerNames = new ArrayList<String>();
        allowedNames = new ArrayList<String>();
        
        // adding the four available names
        availableNames = new ArrayList<String>();
        availableNames.add("milly");
        availableNames.add("bruce");
        availableNames.add("john");
        availableNames.add("lucy");
        
        gp = null;   
    }
    
    
    public static Service getInstance(){
        if(service==null)
        {
            service = new Service();
            service.getAvailableGames();
            return service;
        }
        else
            return service;
    }
    
    public void setSelectedName(String name){
        this.selectedName = name;
    }
    
    public String getSelectedName(){
        return this.selectedName;
    }
    
    public void setGameIds(ArrayList<Long> ids){
        gameIds = new ArrayList<>(ids);
    }
    
    public int getGamesCount(){
        return this.totalGames;
    }
    
    public void setGamesCount(int count){
        totalGames = count; 
    }
    
    public void setPlayerNames(ArrayList<String> names){
        this.playerNames = new ArrayList<String>(names);
    }
    
    public long createGame(){
        try{            
         Response response = client.postGame(gm);
         gm = response.readEntity(Game.class);
         // System.out.println("New Game ID:" +gm.getGameId());  
         selectedGame = gm.getGameId();
         return selectedGame;
        }
        catch(Exception e){
           System.out.println(e.getMessage());           
           return 0;
        }         
    }
    
    public String addPlayer(long gameId, String name){
         gp = new GamePlayer(name, gameId);
         Response addPLayerreponse = client.addPlayerToGame(gp);           
         return gp.getPlayerId();
    } 
    
    public void updateScore(int score){ 
      
       PlayerScore newPlayerScore = new PlayerScore(getSelectedName(), score);       
       GamePlayerScore gamePlayerScore = new GamePlayerScore(getSelectedGame(), newPlayerScore);
       Response updatePlayerScoreResponse = client.updatePlayerScore(gamePlayerScore);  
       //service = new Service();
    }
    
     
    public ArrayList<Long>  getAvailableGames(){
            Response response = client.getAllActive();           
            String allGames = response.readEntity(String.class);            
            ArrayList<Long> ids = new ArrayList();          
            for (Game g : ServiceUtil.getGameList(allGames)) {
                   // System.out.print(g.getGameId()+ " ");
                   ids.add(g.getGameId());         
            }       
            // udpate game count
            setGameIds(ids);
            setGamesCount(ids.size());
            
            return ids;         
    }
    
    public long getSelectedGame()
    {
            return selectedGame;
    }
    
    public ArrayList<String> getPlayerNames(long gid){
        
        Response response = client.getGame(gid);
        Game game = response.readEntity(Game.class);
        selectedGame = gid; 
        // System.out.println("Got game with Game ID: " +game.getGameId());
        
        List<PlayerScore> playerScores = game.getPlayerScores();
        ArrayList<String> players = new ArrayList<String>();
        
        //System.out.println("Number of players in the game " + playerScores.size());        
        
        for(PlayerScore playerScore : playerScores) {
            players.add(playerScore.getPlayerId());
        }       
        
        // set player names and print them on console
        setPlayerNames(players);
        printPlayerNames();      
        
        return players;        
    }
    
    // finding allowed names
    public ArrayList<String> findAllowedNames(){
        if(playerNames.size()!=0){
            for(int i=0; i < availableNames.size() ; i++){
                if(!isPresent(availableNames.get(i))){         
                    allowedNames.add(availableNames.get(i));
                }
            } 
            //System.out.println("#allowed-"+allowedNames.size());
            return allowedNames;
        }
        else
            return availableNames;
        
    }
    
    // check if the name is already taken
    public boolean isPresent(String name){        
        if(playerNames.size()!=0){
            for(int i = 0 ; i<playerNames.size();i++){
                //System.out.println("#Comparing "+ name + " and " + playerNames.get(i) );
                if(playerNames.get(i).equalsIgnoreCase(name))
                    return true;
                
            }            
        }
        return false;
    }
    
    // get allowed names
    public ArrayList<String> getAllowedNames(){
        
        return allowedNames;
    }
    
    public void printPlayerNames(){
          for(String id : playerNames) {
            //System.out.println("#" + id);
         }          
    }
    
    public Game getGame(long gid){
        Response response = client.getGame(gid);
        Game game = response.readEntity(Game.class);
        return game;
    }
    
     public List<PlayerScore> getGamePlayerScores(){
        Response response = client.getGame(selectedGame);
        Game game = response.readEntity(Game.class);
        return game.getPlayerScores();
    }
    
    
    public boolean isGameOver(Game game){
        List<PlayerScore> playerScores = game.getPlayerScores();
        for(PlayerScore playerScore : playerScores) {
            if(playerScore.getScore() < 0) {
                return false;
            }
        }
        return true;
    }
   
    
    
    
    
}
