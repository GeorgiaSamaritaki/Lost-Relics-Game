
package mvc.model.Pawn;

import mvc.model.Board.Player;
import mvc.model.Position.*;
/**
 * Represents a pawn object
 */
public abstract class Pawn {

    private Position position;
    private Path path;
    private final Player player;

    //method get score returns doyble for theseus
    protected Pawn(Player player) {
        this.player = player;
    }

    /** <b>Accessor</b><p>
     * <b>Postcondition</b> Returns the points of the position the pawn is on
     *                      if position is null return 0;
     *
     * @return the points of the position
     */
    public int getPositionScore() {
        if(getPositionnum() == -1) return 0;
        return getPosition().getPoints();
    }

    /** <b>Transformer</b><p>
     * <b>Postcondition:</b> Sets the path the pawn is on 
     *
     * @param path The path to be initialized to
     */
    public void setPath(Path path) {
        this.path = path;
        setPosition(path.getPosition(0));
    }

    /** <b>Accessor</b><p>
     * <b>Postcondition:</b> Gets the path the pawn is set on
     *
     * @return the path
     */
    public Path getPath() {
        return this.path;
    }

    /** <b>Transformer</b><p>
     * <b>Postcondition:</b> Sets the pawns position
     *
     * @param pos The position to be set to
     */
    public void setPosition(Position pos) {
        this.position = pos;
    }

    /** <b>Accessor</b><p>
     * <b>Postcondition:</b> Returns the position of the pawn
     *
     * @return Position of the pawn
     */
    public Position getPosition() {
        return this.position;
    }
    
    /** <b>Accessor</b><p>
     * <b>Postcondition:</b> Returns the position number of the path     *
     * @return Position number (int)of the pawn
     */
    public int getPositionnum() {
        if(position == null) return -1;
        return this.position.getNum();
    }

    /** <b>Accessor</b><p>
     * <b>Postcondition:</b> Returns the owner of the pawn
     *
     * @return The owner of the pawn
     */
    public Player getPlayer() {
        return this.player;
    }

    /** <b>Transformer</b><p>
     * <b>Precondition:</b><p>
     * The pawn is not in the last place
     * <b>Postcondition:</b> Advances pawn by one 
     *
     */
    public void advancebyOne() {
        int next =this.getPositionnum() + 1;
        if(next>8) return;
        setPosition(path.getPosition(next));
    }

    /** <b>Transformer</b><p>
     * <b>Precondition:</b><p>
     * The pawn is not in the first place
     * <b>Postcondition:</b> Returns pawn by one place back if it passes checkpoint sets checkpoint to false
     *
     */
    public void gobackbyOne() {
        int next =this.getPositionnum() - 1;
        if(next<0) return;
        setPosition(path.getPosition(next));
    }

    /** <b>Observer</b><p>
     * <b>Precondition</b> The pawn has started a path
     * <b>Postcondition </b> True if the pawn has passed position 7 false otherwise
     * @return boolean true if pawn passed position 7
     */
    public boolean reachedCheckPoint() {
        return getPositionnum()>5;
    }
    
    
    @Override
    public abstract String toString();

}
