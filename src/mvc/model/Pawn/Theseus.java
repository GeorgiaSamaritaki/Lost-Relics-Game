
package mvc.model.Pawn;

import mvc.model.Board.Player;

/**
 *Type of pawn
 */
public class Theseus extends Pawn{
/**
 * <b>Constructor</b>
 * <b>Postcondition</b>Creates an object and sets an owner type of player to the piece  
 * @param player 
 */
    public Theseus(Player player) {
        super(player);
    }
    /**<b>Accessor</b>
     * <b>Postcondition</b> Returns the position score doubled 
     *                  since theseus earns double the points
     * @return Integer value of the position
     */
    @Override
    public int getPositionScore(){
        return 2*super.getPositionScore();
    }

    @Override
    public String toString() {
        return "Theseus";
    }
    
    

}
