/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.nio.file.Path;
import javax.smartcardio.Card;
import mvc.model.Board.Board;
import mvc.model.Board.Palace;
import mvc.model.Board.Player;
import mvc.model.Card.Minotaur;
import mvc.model.Card.NumberedCard;
import mvc.model.Card.SpecialCard;
import mvc.model.Finding.RareFinding;
import mvc.model.Pawn.Archeologist;
import mvc.model.Pawn.Pawn;
import mvc.model.Pawn.Theseus;
import mvc.model.Position.FindingPosition;
import mvc.model.Position.SimplePosition;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G
 */
public class ModelTest {

    @Test
    public void test1() {
        Player p = new Player();
        assertEquals(p.getScore(), 0);

        SpecialCard m = new Minotaur(Palace.Knossos);
        assertTrue(m instanceof SpecialCard);
        NumberedCard card = new NumberedCard(Palace.Knossos, 5);
        assertEquals(card.getValue(), 5);

    }

    @Test
    public void test2() {
        Board b = new Board();
        mvc.model.Position.Path path = b.getPath(Palace.Knossos);
        assertTrue(path.getPosition(1).hasFinding());
        path = b.getPath(Palace.Malia);
        assertTrue(path.getPosition(1).hasFinding());

        Archeologist pawn = new Archeologist(new Player());
        path.addPawn(pawn);
        assertEquals(pawn.getPositionnum(), 0);
        pawn.advancebyOne();
        assertEquals(pawn.getPositionnum(), 1);

        FindingPosition position = new FindingPosition(20, path, 0);
        position.setFinding(RareFinding.DiskOfFaistos);
        assertTrue(position.hasFinding());

        position.getFinding();
        assertFalse(position.hasFinding());
    
        SimplePosition pos= new SimplePosition(0, path, 0);
        assertFalse(pos.hasFinding());
    }
 
    @Test
    public void test3() {
        Archeologist arc =  new Archeologist(new Player());
        Theseus thes = new Theseus(new Player());
        
        Board b = new Board();
        mvc.model.Position.Path path = b.getPath(Palace.Knossos);
        assertTrue(path.getPosition(1).hasFinding());
        path = b.getPath(Palace.Malia);
        
        path.addPawn(arc);
        path.addPawn(thes);
        
        assertEquals(2*arc.getPositionScore(),thes.getPositionScore());
        
    }
}
