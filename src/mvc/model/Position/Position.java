
package mvc.model.Position;

/**
 *Class that represents a position in the path
 *  pos1(-20),pos2(-15),pos3(-10),pos4(5),pos5(10),pos6(15),pos7(30),pos8(35),pos9(50)
 */
public abstract class Position {
    private final int points;
    private final int posnumber; //position number in path
    private final Path path;
    protected boolean hasFinding;

    /**<b>Constructor</b>
     * <b>Postcondition</b> Initializes the points of the current position
     * 
     * @param points the points of the position
     * @param path
     * @param positionInPath
     */
    protected Position(int points,Path path,int positionInPath){
        this.points = points;
        this.path = path;
        this.posnumber = positionInPath;
    }
    
    /**<b>Accessor</b><p>
     * <b>Postcondition</b> Returns the number the position is in the path
     * @return Integer of position
    */
    public int getNum(){
        return posnumber;
    }
   
    /**<b>Accessor</b><p>
     * <b>Postcondition</b> Return the points specified in this position
     * (to be used from pawn class)
     * @return Integer of points
    */
    public int getPoints(){
        return this.points;
    }
    
    /**<b>Accessor</b><p>
     * <b>Postcondition</b> Returns the path this position belongs to
     * 
     * @return The path this position is in
     */
    public Path getPath(){
        return this.path;
    }
  
    /**<b>Accessor</b><p>
     * <b>Postcondition</b> returns the boolean value of hasFinding
     * @return boolean value
     */
    public boolean hasFinding(){
        return hasFinding;
    }
    
   
}
