/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.Position;

import mvc.model.Finding.Finding;
import mvc.model.Finding.Fresco;

public class FindingPosition extends Position {

    private Finding finding;
    
    public FindingPosition(int points, Path path, int positionInPath) {
        super(points, path, positionInPath);
        hasFinding = false;
    }

    /** <b>Accessor</b>
     * <p>
     * <b>Postcondition</b> returns the finding in the current position if there is none return null
     * <b>Precondition</b> The position has a finding
     * 
     * @return the finding in position
     */
    public Finding getFinding() {
        if(!(finding instanceof Fresco)) this.hasFinding = false;
        return this.finding;
    }

    /**<b>Transformer</b>
     * <p>
     * <b>Postcondition</b> Puts the finding in this position
     *
     * @param finding The finding to be placed
     */
    public void setFinding(Finding finding) {
        hasFinding = true;
        this.finding = finding;
    }

}
