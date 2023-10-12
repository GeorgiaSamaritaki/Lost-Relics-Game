
package mvc.model.Pawn;

import mvc.model.Board.Player;

/**
 * Pawn of type Archeologist
 * @author G
 */
public class Archeologist extends Pawn {
    /**<b>Constructor</b>
     * <b>Postcondition</b>Object created
     * 
     * @param player  Owner of the pawn
     */
    public Archeologist(Player player) {
        super(player);
    }
    @Override
    public String toString() {
        return "Archeologist";
    }
    
}
