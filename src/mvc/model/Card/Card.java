
package mvc.model.Card;

import mvc.model.Board.Palace;

public abstract class Card {
    protected Palace palace;
    protected String image;
    protected final int value;
    
    /**<b>Constructor</b><p>
     * <b>Postcondition</b> Sets the palace type of the card
     *
     * @param palace  Card of Palace palace
     * @param value
     * @param imgname
     */
    protected Card(Palace palace,int value,String imgname){
        this.palace = palace;
        this.image = "resources/images/cards/"+imgname+".jpg";
        this.value = value;
    }
    
    /**<b>Accessor</b>
     * <b>Postcondition</b> Returns the value of numbered card
     * 
     * @return  the cards value
     */
    public int getValue(){
        return this.value;
    }
    
    
    /** <b>Accessor</b>
     * <p><b>Postcondition:</b> Returns the palace card belongs to
     * @return the palace type 
     */
    public Palace getPalace(){
        return this.palace;
    }
   
    
    public String getImage() {
        return image;
    }
    
     /**
     * <b>Accessor</b>
     * <p><b>Postcondition:</b> The string representation of a card is returned</p>
     * @return The string representation of a card 
     */
    @Override
    public abstract String toString();
    
    
    
}
