package mvc.Controller;

import java.awt.event.*;
import java.util.Random;
import static javafx.application.Platform.exit;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;
import javax.swing.SwingUtilities;
import mvc.model.Board.*;
import mvc.model.Card.*;
import mvc.model.Finding.*;
import mvc.model.Pawn.*;
import mvc.model.Position.*;
import mvc.view.View;

/**
 * Controller is the master of the game and controls all of the operations executed
 */
public class Controller {

    private final Player player1, player2;
    private final Board board;
    private final Deck deck;
    View view;
    private boolean turn; // Determines who plays  - At the end of each round it changes
    private boolean PhaseB;

    public Controller() {
        turn = (new Random()).nextBoolean();
        this.deck = new Deck();
        board = new Board();
        player1 = new Player();
        player2 = new Player();
        PhaseB = false;
        init_player_cards();
        init();
    }

    /**Transformer
     * Initializes view and sets listener
     * 
     */
    public void init() {
        view = new View();
        view.initComponents(player1.getCards(), player2.getCards());
        view.initPawns(player1.getPawns(), player2.getPawns());
        setListeners();
        updateView();
        view.setVisible(true);
    }

    /**Transformer
     * Sets listeners of buttons
     */
    private void setListeners() {
        DeckListener deck = new DeckListener();
        view.getDeck().addMouseListener(deck);
        for (int i = 0; i < 8; i++) {
            CardListener listener = new CardListener(player1, deck);
            view.getCards1()[i].addMouseListener(listener);
            listener = new CardListener(player2, deck);
            view.getCards2()[i].addMouseListener(listener);
        }
        view.getFresco1Buttons().addMouseListener(new ButtonListener(player1));
        view.getFresco2Buttons().addMouseListener(new ButtonListener(player2));

    }

    public static void main(String[] argc) {
        Controller c = new Controller();

    }

    /** <b>Transformer(mutative)</b>
     * <p>
     * <b>Postcondition:</b> initializes players cards in the beginning </p>
     */
    private void init_player_cards() {
        for (int i = 0; i < 8; i++) {
            player1.AddCard(deck.drawCard());
            player2.AddCard(deck.drawCard());
        }

    }

    /** <b>Accessor</b><p>
     * <b>Postcondition</b> Determines whose turn it is
     *
     * @return player1 or player2
     */
    public Player getTurn() {
        if (this.turn) {
            return player1; //as in player 1
        } else {
            return player2; //as in player 2
        }
    }

    /** <b>Transformer</b>
     * <b>Postcondition</b> Switches turn
     *
     */
    public void endTurn() {
        turn = !turn;
    }

    /** <b>Observer</b><p>
     * <b>Postcondition</b> True if 4 checkpoints have been reached or the deck has been emptied
     *
     * @return boolean true if the game has ended
     */
    public boolean isFinished() {
        return this.checkPointsReached() > 3 || deck.isEmpty();
    }

    /** <b>Accessor</b><p>
     * <b>Precondition</b> The game has finished
     * <b>Postcondition</b> Returns the winner
     *
     * @return The winner
     *
     */
    public String getWinner() {
        if (player1.getScore() > player2.getScore()) {
            return "Player 1";
        } else if (player1.getScore() < player2.getScore()) {
            return "Player 2";
        } else {
            if (player1.getRareFindings().size() > player2.getRareFindings().size()) {
                return "Player 1";
            } else if (player1.getRareFindings().size() > player2.getRareFindings().size()) {
                return "Player2";
            } else {
                if (player1.getFrescos().size() > player2.getFrescos().size()) {
                    return "Player 1";
                } else if (player1.getFrescos().size() > player2.getFrescos().size()) {
                    return "Player2";
                } else {
                    if (player1.statuesCollected() > player2.statuesCollected()) {
                        return "Player 1";
                    } else if (player1.statuesCollected() < player2.statuesCollected()) {
                        return "Player2";
                    } else {
                        return "Draw";
                    }
                }

            }
        }
    }

    /** <b>Accessor</b><p>
     * <b>Postcondition</b> Calculates from the player's pawns how many checkpoints have been reached
     *
     * @return integer the total checkpoints reached by player1 and player2 pawns
     */
    public int checkPointsReached() {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (player1.getPawns()[i].reachedCheckPoint()) {
                count++;
            }
            if (player2.getPawns()[i].reachedCheckPoint()) {
                count++;
            }
        }
        return count;
    }

    /**Transformer
     * Updates player class and view of the item in position
     * 
     * @param player
     * @param pos 
     */
    public void availableMoves(Player player, Position pos) {
        if (pos.hasFinding()) {
            Finding f = player.takeFinding((FindingPosition) pos);
            if (f != null) {
                view.showMessage("Βρηκες Αντικειμενο!", f.getDescription(), INFORMATION_MESSAGE);
                if (f instanceof RareFinding) {
                    view.updateRareItem(player == player1, (RareFinding) f);
                }
                if (f instanceof Fresco) {
                    view.updateFresco(player == player1, (Fresco) f);
                }
            }
        }
    }

    /**Transformer
     * Postcondition: Displays popup dialog that lets the player choose a pawn
     * @param playerPawn array of the pawns available
     * @return the pawn chosen
     */
    public Pawn choosePawn(Pawn playerPawn[]) {
        Pawn Archeologist = null, Theseus = null;
        for (Pawn p : playerPawn) {
            if (p.getPositionnum() == -1) {
                if (p instanceof Archeologist) {
                    Archeologist = p;
                } else if (p instanceof Theseus) {
                    Theseus = p;
                }
            }
        }
        if (Archeologist == null && Theseus == null) {
            throw new IllegalArgumentException("No pawns");
        }
        if (Archeologist == null) {
            return Theseus;
        }
        if (Theseus == null) {
            return Archeologist;
        }

        String[] options = new String[]{"Theseus", "Archeologist"};
        int response = JOptionPane.showOptionDialog(null, "Choose type of Pawn", "",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if (response == 0) {
            return Theseus;
        } else {
            return Archeologist;
        }
    }

    /**Transformer
     * Postcondition updates the information displayed on screen
     * 
     */
    public void updateView() {
        view.updateBoardInfo(this.deck.availableCards(), this.checkPointsReached(), this.turn ? 1 : 2);
        view.updatePlayerInfo(player1.availableArch(), player1.availableTheseus(), player2.availableArch(), player2.availableTheseus(),
                player1.getScore(), player2.getScore(), player1.statuesCollected(), player2.statuesCollected());
    }

    /**
     * Listeners
     */
    private class CardListener implements MouseListener {

        Player player, other;
        DeckListener decklistener;

        CardListener(Player p, DeckListener deck) {
            player = p;
            this.decklistener = deck;
            other = (player == player1) ? player2 : player1;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (player != getTurn() || PhaseB) {
                return;
            }

            JButton but = ((JButton) e.getSource());
            int index = Integer.valueOf(but.getName());
            Card c = player.getCards().get(index);

            if (SwingUtilities.isLeftMouseButton(e)) {
                Path path = board.getPath(c.getPalace());
                Pawn p = path.isStarted(player);

                if (c instanceof Minotaur) {
                    p = path.isStarted(other);
                    if (p == null) {
                        view.showMessage("Incompatible card Played", "Your opponent has not played in this path", WARNING_MESSAGE);
                        return;
                    } else if (p instanceof Theseus) {
                        view.showMessage("No effect", "Your opponent's Theseus has repelled the attack", INFORMATION_MESSAGE);
                    } else if (p.reachedCheckPoint()) {
                        view.showMessage("No effect", "Your opponent's pawn has reached Checkpoint", INFORMATION_MESSAGE);
                    } else {
                        switch (p.getPositionnum()) {
                            case 0:
                                break;
                            default:
                                p.gobackbyOne();
                            case 1:
                                p.gobackbyOne();
                        }
                    }
                } else if (c instanceof Ariadne) {
                    if (p == null) {
                        view.showMessage("Incompatible card Played", "Path Cannot be started with Ariadne", WARNING_MESSAGE);
                        return;
                    } else {
                        switch (p.getPositionnum()) {
                            case 8:
                                view.showMessage("Finished here", "You have finished with this path",INFORMATION_MESSAGE);
                                return;
                            default:
                                p.advancebyOne();
                                availableMoves(player, p.getPosition());
                            case 7:
                                p.advancebyOne();
                                availableMoves(player, p.getPosition());
                                if (p.getPositionnum() == 8) {
                                    view.showMessage("Congratulations", path.getPalace().getDescription(), INFORMATION_MESSAGE);
                                }
                        }
                    }

                } else if (c instanceof NumberedCard) {
                    if (p == null) {
                        p = choosePawn(player.getPawns());
                        path.addPawn(p);
                    } else {
                        if(p.getPositionnum() == 8){
                            view.showMessage("Finished here", "You have finished with this path",INFORMATION_MESSAGE);
                        }else if (player.getLastCard(c.getPalace()).matchCard((NumberedCard) c)) {
                            p.advancebyOne();
                            availableMoves(player, p.getPosition());
                            if (p.getPositionnum() == 8) {
                                view.showMessage("Congratulations", path.getPalace().getDescription(), INFORMATION_MESSAGE);
                            }
                        } else {
                            view.showMessage("Incompatible card Played", "Card must be of equal or more value", INFORMATION_MESSAGE);
                            return;
                        }
                    }
                    player.updateLastCard((NumberedCard) c);
                    view.updateLastCardPile(player == player1, c);

                }
                view.updatePawn(p);

            }
            decklistener.setIndex(index, player, but);
            view.grayCard(but, c);
            PhaseB = true;
            updateView();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }
    }

    private class DeckListener implements MouseListener {

        int index;
        Player player;
        JButton but;

        public void setIndex(int i, Player p, JButton but) {
            index = i;
            this.player = p;
            this.but = but;
        }

        @Override
        public void mouseClicked(MouseEvent e) {

            if (!PhaseB) {
                return;
            }

            Card next = deck.drawCard();
            player.ReplaceCard(index, next);
            view.replaceCard(but, next);

            if (isFinished()) {
                view.showMessage("Game Finished", getWinner() + " has Won", INFORMATION_MESSAGE);
                exit();
            }
            PhaseB = false;
            endTurn();
            updateView();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }

    private class ButtonListener implements MouseListener {

        Player player;

        ButtonListener(Player p) {
            player = p;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            view.togglewindow(player == player1);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }
}
