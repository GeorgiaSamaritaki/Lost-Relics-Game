/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.Card;

import mvc.model.Board.Palace;


public class Minotaur extends SpecialCard {

    public Minotaur(Palace palace) {
        super(palace,11,palace.name()+"Min");
    }
    
    /**<b>Accessor</b>
     * <p><b>Postcondition</b> Returns the name of the card and the palace it 
     *                          belongs to
     * @return String name
     */
    @Override
    public String toString() {
        return "Minotaur of palace " + this.palace.name();
    }
}
