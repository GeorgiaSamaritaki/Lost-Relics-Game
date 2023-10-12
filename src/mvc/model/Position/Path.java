
package mvc.model.Position;

import java.util.ArrayList;
import java.util.Random;
import mvc.model.Board.Palace;
import mvc.model.Board.Player;
import mvc.model.Finding.*;
import mvc.model.Pawn.Pawn;

/** Class path determines the set of position the pawns can take
 */
public class Path {
    private final Palace palace;
    private final Position []path = new Position[9];
    private ArrayList<Pawn> pawns;
    
    /**<b>Constructor</b><p>
     * <b>Postcondition</b> Creates path object initializing variables
     * 
     * @param palace The palace the path belongs to
     * @param finding  The rare finding that has to be added in this path
     */
    public Path(Palace palace,RareFinding finding){
        this.palace = palace;
        pawns = new ArrayList<>();
        initialize(finding);
    }
   

    /**<b>Transformer</b><p>
     * <b>Postcondition:</b> Sets position 2,4,6,8,9 to special position and rest to simple
     *                          Adds rare finding randomly to one of FindingPositions
     * 
     */
    private void initialize(RareFinding finding) {
        path[0] = new SimplePosition(-20,this,0);
        path[2] = new SimplePosition(-10,this,2);
        path[4] = new SimplePosition(10,this,4);
        path[6] = new SimplePosition(30,this,6);
        
        path[1] = new FindingPosition(-15,this,1);   
        path[3] = new FindingPosition(5,this,3);
        path[5] = new FindingPosition(15,this,5);
        path[7] = new FindingPosition(35,this,7);
        path[8] = new FindingPosition(50,this,8);
        
        Random rn = new Random();
        switch(rn.nextInt(5)){
            case 0:
                ((FindingPosition)path[1]).setFinding(finding);
                break;
            case 1:
                ((FindingPosition)path[3]).setFinding(finding);
                break;
            case 2:
                ((FindingPosition)path[5]).setFinding(finding);
                break;
            case 3:
                ((FindingPosition)path[7]).setFinding(finding);
                break;
            case 4:
                ((FindingPosition)path[8]).setFinding(finding);
                break;
        }
        
    }
    
    /**<b>Accessor</b><p>
     * <b>Postcondition</b> Returns the position i of the path
     * @param i The position to be returned
     * @return Position i of path
     */
    public Position getPosition(int i){
        if(i<0 || i>8) throw new IllegalArgumentException("wrong position");
        return this.path[i];
    }
    
    /**<b>Accessor</b><p>
     * <b>Postcondition</b> Returns the palace enum value of the path
     * @return Palace of the path
     */
    public Palace getPalace(){
        return this.palace;
    }
    
    /**<b>Transformer</b><p>
     * <b>Precondition</b> Player does not have a pawn already in path
     *  <b>Postcondition:</b> Adds pawn to path 
     * @param p 
     */
    public void addPawn(Pawn p){ 
        p.setPosition(path[0]);
        p.setPath(this);
        pawns.add(p);
    }
    
    /**<b>Observer</b><p>
     * <b>Postcondition</b> Returns true if the player  has placed a pawn on this path
     *                      else false 
     * @param player The player checked
     * @return  boolean
     */
    public Pawn isStarted(Player player){
        for (Pawn p : pawns) {
            if(p.getPlayer().equals(player)) return p;
        }
        return null;
    }
}
