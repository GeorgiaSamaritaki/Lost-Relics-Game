/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  mvc.model.Card;

import mvc.model.Board.Palace;


public abstract class SpecialCard extends Card {
    
    /**<b>Constructor</b><p>
     * <b>PostCondition</b> Creates a Special card with type of Palace palace
     * 
     * @param palace The palace the card belongs to
     */
    protected SpecialCard(Palace palace,int value,String imgname) {
        super(palace,value,imgname);
    }
    
}
