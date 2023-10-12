/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.Board;

import java.util.ArrayList;
import java.util.Collections;
import mvc.model.Position.Path;
import mvc.model.Card.Card;
import mvc.model.Finding.*;
import mvc.model.Position.*;

/**
 *
 */
public class Board {

    private final Path paths[] = new Path[4];
    
    /** <b>Constructor</b>
     * <p>
     * <b>Postcondition</b> Determines who plays firsts Initializes paths calls method initialize():
     *
     */
    public Board() {
        paths[0] = new Path(Palace.Knossos, RareFinding.RingOfMinoa);
        paths[1] = new Path(Palace.Malia, RareFinding.JewelOfMalia);
        paths[2] = new Path(Palace.Phaistos, RareFinding.DiskOfFaistos);
        paths[3] = new Path(Palace.Zakros, RareFinding.RhytonOfZakros);

        distributeFindings();
    }

    /** <b>Transformer</b>
     * <b>Postcondition</b> Puts all findings randomly in Finding positions
     *
     */
    private void distributeFindings() {

        ArrayList<Position> temp = new ArrayList<>(16);
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 8; j = j + 2) {
                if (!(((FindingPosition) (paths[i].getPosition(j))).hasFinding())) {
                    temp.add(paths[i].getPosition(j));
                }
            }
            if (!(((FindingPosition) (paths[i].getPosition(8))).hasFinding())) {
                temp.add(paths[i].getPosition(8));
            }
        }
        Collections.shuffle(temp);
        for (int i = 0; i < 10; i++) {
            ((FindingPosition) (temp.get(i))).setFinding(new SnakeGoddess());
        }
        for (int i = 10; i < 15; i++) {
            ((FindingPosition) (temp.get(i))).setFinding(Fresco.valueOf("fresco" + (i - 9)));
        }

    }

    /** <b>Accessor</b>
     * <b>Postcondition</b> Returns the path of palace 
     * @param palace 
     *@return Path of specified palace
     */
    public Path getPath(Palace palace) {
        
        switch (palace) {
            case Knossos:
                return paths[0];
            case Malia:
                return paths[1];
            case Phaistos:
                return paths[2];
            case Zakros:
                return paths[3];
        }
        return null;
    }

}
