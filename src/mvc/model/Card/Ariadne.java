/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.Card;

import mvc.model.Board.Palace;

public class Ariadne extends SpecialCard {

    /**<b>Constructor</b><p>
     * <b>Postcondition:</b> Initializes palace variable for this card creates object
     * 
     * @param palace 
     * @param imgname 
     */
    public Ariadne(Palace palace) {
        super(palace,11,palace.name()+"Ari");
    }

    /**<b>Accessor</b>
     * <p><b>Postcondition</b> Returns the name of the card and the palace it 
     *                          belongs to
     * @return String name
     */
    @Override
    public String toString() {
        return "Ariadne of palace "+ this.palace.name();
    }

}
