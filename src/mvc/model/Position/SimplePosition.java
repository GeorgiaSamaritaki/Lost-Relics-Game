/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.Position;


/**
 * Position without finding
 */
public class SimplePosition extends Position {

    /** <b>Constructor</b>
     * <p>
     * <b>Postcondition</b> Creates object
     *
     * @param points The points of the position
     * @param path of the position
     * @param positionInPath the position this position is in given path
     */
    public SimplePosition(int points, Path path, int positionInPath) {
        super(points, path, positionInPath);
        hasFinding = false;
    }


}
