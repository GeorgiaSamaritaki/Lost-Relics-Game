package mvc.model.Card;
import mvc.model.Board.Palace;

/**StandardCard with numerical value
 * 
 */
public class NumberedCard extends Card {

    public NumberedCard(Palace palace, int value) {
        super(palace,value,palace.name()+value);
    }
    
    /** <b>Observer</b>
     * <b>Postcondition</b> Returns true if the card c equal or more of the last 
     *                          numberedcard played and the game has yet to finish 
     * 
     * @param c Card we want to play
     * @return True if the card can be played else false
     */
    public boolean matchCard(NumberedCard c) {
        return c.getValue() >= this.getValue();
    }

    /**<b>Accessor</b>
     * <p><b>Postcondition</b> Returns the name of the card and the palace it 
     *                          belongs to
     * @return String name
     */
    @Override
    public String toString() {
        return "NumberedCard of value "+this.getValue()+
               " of palace "+ ((Card)this).getPalace().toString();
    }
    
    
}
