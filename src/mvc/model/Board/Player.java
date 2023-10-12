package mvc.model.Board;

import java.util.ArrayList;
import mvc.model.Card.*;
import mvc.model.Finding.*;
import mvc.model.Pawn.*;
import mvc.model.Position.*;

/**
 * Player class describes the characteristics of a player and provides modification methods.
 */
public class Player {

    private final ArrayList<Card> hand;
    private final NumberedCard LastPlayed[];
    private ArrayList<RareFinding> Syllogi;
    private ArrayList<Fresco> Fresco;
    private final Pawn pawns[];
    private int Score;
    private int NumOfStatues;

    public Player() {
        this.Syllogi = new ArrayList<>();
        this.Fresco = new ArrayList<>();
        this.Score = 0;
        this.NumOfStatues = 0;
        this.LastPlayed = new NumberedCard[4];
        this.hand = new ArrayList<>();
        this.pawns = new Pawn[4];
        for (int i = 0; i < 3; i++) {
            pawns[i] = new Archeologist(this);
        }
        pawns[3] = new Theseus(this);

    }

    /** <b>Accessor(selector)</b>
     * <p>
     * <b>Postcondition:</b> Returns a new array of the available cards of the player
     *
     * @return the Cards collection of a player
     */
    public ArrayList<Card> getCards() {
        return this.hand;
    }

    /**
     * Getters
     *
     * @return
     */
    public Pawn[] getPawns() {
        return this.pawns;
    }

    public ArrayList getRareFindings() {
        return Syllogi;
    }

    public ArrayList getFrescos() {
        return Fresco;
    }

    /** <b>Transformer</b><p>
     * <b>Postcondition</b>Replaces card c in hand on index position
     *
     * @param index position in hand of last removed card
     * @param c the card to be removed
     *
     */
    public void ReplaceCard(int index, Card c) {
            hand.set(index, c);
    }

    /** <b>Accessor(selector)</b>
     * <p>
     * <b>Postcondition:</b> Returns last card played on each palace if no card has been played returns null
     *
     * @param palace indicates the palace needed
     * @return Last played card on palace path
     */
    public NumberedCard getLastCard(Palace palace) {
        for (NumberedCard c : LastPlayed) {
            if (c == null) {
                continue;
            }
            if (c.getPalace() == palace) {
                return c;
            }
        }
        return null;
    }

    /** <b>Transformer(mutative)</b>
     * <p>
     * <b>Precondition:</b> Player does not have 8 cards
     * <p>
     * <b>Postcondition:</b> Adds card c to players hand
     *
     * @param C Adds card c to player's hand
     */
    public void AddCard(Card C) {
        hand.add(C);

    }

    /** <b>Transformer</b>
     * <p>
     * <b>Postcondition:</b> Changed the last card of same palace in lastCard array
     *
     * @param add the new card
     */
    public void updateLastCard(NumberedCard add) {
        for (int i = 0; i < 4; i++) {
            if (LastPlayed[i] == null || LastPlayed[i].getPalace() == add.getPalace()) {
                LastPlayed[i] = add;
                return;
            }
        }
    }

    /** <b>Transformer</b>
     * <p>
     * <b>Postcondition</b> Checks the type of the finding in position and adds it accordingly to player
     *
     * @param pos Takes finding from position pos
     * @return Null if the player has already the fresco
     */
    public Finding takeFinding(FindingPosition pos) {
        Finding f = pos.getFinding();
        if (f instanceof RareFinding) {
            Syllogi.add((RareFinding) f);
        } else if (f instanceof Fresco) {
            if (Fresco.contains((Fresco) f)) {
                return null;
            } else {
                Fresco.add((Fresco) f);
            }
        } else if (f instanceof SnakeGoddess) {
            NumOfStatues++;
        }
        return f;
    }

    /** <b>Accessor</b>
     * <p>
     * <b>Postcondition</b> Calculates the sum of pawn's positions rare findings values and frescos values and updates Scores then Returns score
     *
     * @return The score that was calculated
     */
    public int getScore() {
        Score = 0;
        for (int i = 0; i < 4; i++) {
            Score += pawns[i].getPositionScore();
        }
        Syllogi.forEach((f) -> {
            Score += f.getValue();
        });
        Fresco.forEach((f) -> {
            Score += f.getValue();
        });
        switch (NumOfStatues) {
            case 1:
                Score += -20;
                break;
            case 2:
                Score += -15;
                break;
            case 3:
                Score += 5;
                break;
            case 4:
                Score += 15;
                break;
            case 5:
                Score += 30;
                break;
            case 6:
                Score += 45;
                break;
            case 7:
                Score += 55;
                break;
            case 8:
                Score += 70;
                break;
            case 9:
                Score += 90;
                break;
            case 10:
                Score += 100;
                break;
        }
        return Score;
    }

    /** <b>Accessor</b>
     * <p>
     * <b>Postcondition</b> Returns how many archeologists are left
     *
     * @return String for JLabel
     */
    public int availableArch() {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (pawns[i].getPositionnum() == -1) {
                count++;
            }
        }
        return count;
    }

    /** <b>Accessor</b>
     * <p>
     * <b>Postcondition</b> Returns how many theseus are left
     *
     * @return String for JLabel
     */
    public int availableTheseus() {
        return pawns[3].getPositionnum() == -1 ? 1 : 0;
    }

    /** <b> Accessor</b>
     * <p>
     * <b> Postcondition Returns the number of statues the player has collected</b>
     *
     * @return int value
     */
    public int statuesCollected() {
        return NumOfStatues;
    }
}
