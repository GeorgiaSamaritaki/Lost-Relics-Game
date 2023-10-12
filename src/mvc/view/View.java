/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view;

import java.awt.*;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.*;
import mvc.model.Board.Palace;
import mvc.model.Card.Card;
import mvc.model.Finding.*;
import mvc.model.Pawn.Pawn;

/**
 *
 */
public class View extends JFrame {

    JLayeredPane pane1, pane2, mainpane;
    JButton deck, F1, F2;
    JLabel Info, availablePawns1, player1LastCard[], player2LastCard[],
            availablePawns2, Score1, Score2, Statues1, Statues2;
    JLabel path1[], path2[], path3[], path4[], pathPoints[];
    JLabel RareFinding1[], RareFinding2[], Frescos1[], Frescos2[];
    JLabel statue1, statue2;
    JLabel statuetxt1, statuetxt2;
    JFrame frescoswindow1, frescoswindow2;
    Map<Pawn, JLabel> pawns = new HashMap<>(9);
    JButton Cards1[] = new JButton[8], Cards2[] = new JButton[8];//8 for each
    private final ClassLoader cldr;

    public View() {
        cldr = this.getClass().getClassLoader();
        this.setResizable(false);
        this.setTitle("Game");
        this.setPreferredSize(new Dimension(1315, 975));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    
    /* Getters */
    public JButton[] getCards1() {
        return Cards1;
    }

    public JButton[] getCards2() {
        return Cards2;
    }

    public JButton getDeck() {
        return this.deck;
    }

    public JButton getFresco1Buttons() {
        return F1;
    }

    public JButton getFresco2Buttons() {
        return F2;
    }

    /**
     * <b>transformer(mutative)</b>:initializes some buttons and labels <br />
     * <p>
     * <b>Postcondition:</b> initializes some buttons and labels </p>
     *
     */
    public void initComponents(ArrayList<Card> cards1, ArrayList<Card> cards2) {

        pane1 = new JLayeredPane();
        pane1.setBounds(0, 0, 1309, 201);
        pane1.setBackground(Color.WHITE);
        pane1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
        pane1.setOpaque(true);

        URL imageURL = cldr.getResource("resources/images/bg.png"); //image
        Image image = new ImageIcon(imageURL).getImage();
        mainpane = new JExtension(image);
        mainpane.setBounds(0, 200, 1314, 540);

        pane2 = new JLayeredPane();
        pane2.setBounds(0, 740, 1309, 200);
        pane2.setBackground(Color.WHITE);
        pane2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GREEN));
        pane2.setOpaque(true);

        this.initCards(cards1, cards2);

        this.add(pane1);
        this.add(mainpane);
        this.add(pane2);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        pack();

        initPaths();
        initInfo();

        pane1.repaint();
        pane2.repaint();
        mainpane.repaint();
    }

    public void initPawns(Pawn pawn1[], Pawn pawn2[]) {
        JLabel p1[] = new JLabel[4];
        JLabel p2[] = new JLabel[4];
        URL ur = cldr.getResource("resources/images/pionia/arch.jpg");
        Image image = new ImageIcon(ur).getImage();
        image = image.getScaledInstance(40, 50, java.awt.Image.SCALE_SMOOTH);
        for (int i = 0; i < 3; i++) {
            p1[i] = new JLabel();
            p1[i].setIcon(new ImageIcon(image));
            p1[i].setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
            p1[i].setBounds(0, 10, 40, 50);
            pawns.put(pawn1[i], p1[i]);

            p2[i] = new JLabel();
            p2[i].setIcon(new ImageIcon(image));
            p2[i].setBounds(50, 10, 40, 50);
            p2[i].setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GREEN));
            pawns.put(pawn2[i], p2[i]);
        }
        ur = cldr.getResource("resources/images/pionia/theseus.jpg");
        image = new ImageIcon(ur).getImage();
        image = image.getScaledInstance(40, 50, java.awt.Image.SCALE_SMOOTH);
        p1[3] = new JLabel();
        p1[3].setIcon(new ImageIcon(image));
        p1[3].setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
        p1[3].setBounds(0, 10, 40, 50);
        pawns.put(pawn1[3], p1[3]);
        p2[3] = new JLabel();
        p2[3].setIcon(new ImageIcon(image));
        p2[3].setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GREEN));
        p2[3].setBounds(50, 10, 40, 50);
        pawns.put(pawn2[3], p2[3]);

    }

    private void initInfo() {
        availablePawns1 = new JLabel();
        availablePawns1.setBounds(22, 165, 700, 30);
        availablePawns1.setText("Player1 - All Pawns Available");
        availablePawns1.setFont(new Font("Serif", Font.PLAIN, 22));
        pane1.add(availablePawns1);

        availablePawns2 = new JLabel();
        availablePawns2.setBounds(22, 165, 700, 30);
        availablePawns2.setText("Player2 - All Pawns Available");
        availablePawns2.setFont(new Font("Serif", Font.PLAIN, 22));
        pane2.add(availablePawns2);

        Score1 = new JLabel();
        Score1.setBounds(1100, 20, 200, 30);
        Score1.setText("My Score : 0 points");
        Score1.setFont(new Font("Serif", Font.BOLD, 17));
        pane1.add(Score1);

        Score2 = new JLabel();
        Score2.setBounds(1100, 20, 200, 30);
        Score2.setText("My Score : 0 points");
        Score2.setFont(new Font("Serif", Font.BOLD, 17));
        pane2.add(Score2);

        statue1 = new JLabel();
        statue1.setBounds(1235, 130, 60, 60);
        URL ur = cldr.getResource("resources/images/findings/snakes.jpg");
        Image image = new ImageIcon(ur).getImage();
        image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
        statue1.setIcon(new ImageIcon(image));
        pane1.add(statue1);

        statue2 = new JLabel();
        statue2.setBounds(1235, 130, 60, 60);
        ur = cldr.getResource("resources/images/findings/snakes.jpg");
        image = new ImageIcon(ur).getImage();
        image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
        statue2.setIcon(new ImageIcon(image));
        pane2.add(statue2);

        statuetxt1 = new JLabel();
        statuetxt1.setBounds(1125, 140, 200, 30);
        statuetxt1.setText("Statues : 0 ");
        statuetxt1.setFont(new Font("Serif", Font.BOLD, 18));
        pane1.add(statuetxt1);

        statuetxt2 = new JLabel();
        statuetxt2.setBounds(1125, 140, 200, 30);
        statuetxt2.setText("Statues : 0 ");
        statuetxt2.setFont(new Font("Serif", Font.BOLD, 18));
        pane2.add(statuetxt2);

        Info = new JLabel();
        Info.setBounds(20, 420, 160, 80);
        Info.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        Info.setText("<html> Available cards: 84 <br>  CheckPoints: 0<br>  Turn: <html>");
        Info.setFont(new Font("Serif", Font.BOLD, 17));
        Info.setBackground(Color.WHITE);
        Info.setOpaque(true);
        mainpane.add(Info);

        pathPoints = new JLabel[9];
        for (int i = 0; i < 9; i++) {
            pathPoints[i] = new JLabel();
            pathPoints[i].setBounds(328 + i * 105, 10, 100, 50);
            pathPoints[i].setFont(new Font("Serif", Font.BOLD, 19));
            mainpane.add(pathPoints[i]);
        }
        pathPoints[0].setText("-20 points");
        pathPoints[1].setText("-15 points");
        pathPoints[2].setText("-10 points");
        pathPoints[3].setText("5 points");
        pathPoints[4].setText("10 points");
        pathPoints[5].setText("15 points");
        pathPoints[6].setText("<html>30 points<br>CheckPoint!</html>");
        pathPoints[6].setBounds(328 + 6 * 105, 15, 100, 70);
        pathPoints[7].setText("35 points");
        pathPoints[8].setText("50 points");

        RareFinding1 = new JLabel[4];
        RareFinding2 = new JLabel[4];
        for (int i = 0; i < 4; i++) {
            RareFinding1[i] = new JLabel();
            RareFinding1[i].setBounds(765 + i * 85, 135, 50, 50);
            pane1.add(RareFinding1[i]);

            RareFinding2[i] = new JLabel();
            RareFinding2[i].setBounds(765 + i * 85, 135, 50, 50);
            pane2.add(RareFinding2[i]);
        }

        ur = cldr.getResource(RareFinding.RingOfMinoa.getImage());
        image = grayImage(new ImageIcon(ur).getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
        RareFinding1[0].setIcon(new ImageIcon(image));
        RareFinding2[0].setIcon(new ImageIcon(image));

        ur = cldr.getResource(RareFinding.JewelOfMalia.getImage());
        image = grayImage(new ImageIcon(ur).getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
        RareFinding1[1].setIcon(new ImageIcon(image));
        RareFinding2[1].setIcon(new ImageIcon(image));

        ur = cldr.getResource(RareFinding.DiskOfFaistos.getImage());
        image = grayImage(new ImageIcon(ur).getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
        RareFinding1[2].setIcon(new ImageIcon(image));
        RareFinding2[2].setIcon(new ImageIcon(image));

        ur = cldr.getResource(RareFinding.RhytonOfZakros.getImage());
        image = grayImage(new ImageIcon(ur).getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
        RareFinding1[3].setIcon(new ImageIcon(image));
        RareFinding2[3].setIcon(new ImageIcon(image));

        F1 = new JButton();
        F1.setBounds(1100, 70, 190, 40);
        F1.setText("Frescos");
        F1.setFont(new Font("Serif", Font.BOLD, 22));
        pane1.add(F1);

        F2 = new JButton();
        F2.setBounds(1100, 70, 190, 40);
        F2.setText("Frescos");
        F2.setFont(new Font("Serif", Font.BOLD, 22));
        pane2.add(F2);

        frescoswindow1 = new JFrame();
        frescoswindow1.setBounds(1310, 0, 311, 345);
        frescoswindow1.setVisible(false);
        frescoswindow2 = new JFrame();
        frescoswindow2.setBounds(1310, 635, 311, 345);
        frescoswindow2.setVisible(false);
        Frescos1 = new JLabel[6];
        Frescos2 = new JLabel[6];
        for (int i = 0; i < 6; i++) {
            Fresco f = Fresco.valueOf("fresco" + (i + 1));
            ur = cldr.getResource(f.getImage());
            image = grayImage(new ImageIcon(ur).getImage());
            if (i < 3) {
                image.getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH);
            } else {
                image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
            }
            Frescos1[i] = new JLabel();
            Frescos1[i].setIcon(new ImageIcon(image));
            frescoswindow1.add(Frescos1[i], i);

            Frescos2[i] = new JLabel();
            Frescos2[i].setIcon(new ImageIcon(image));
            frescoswindow2.add(Frescos2[i]);
        }
        Frescos1[0].setBounds(0, 0, 200, 100);
        Frescos2[0].setBounds(0, 0, 200, 100);
        Frescos1[1].setBounds(0, 100, 200, 100);
        Frescos2[1].setBounds(0, 100, 200, 100);
        Frescos1[2].setBounds(0, 200, 200, 100);
        Frescos2[2].setBounds(0, 200, 200, 100);

        Frescos1[3].setBounds(200, 0, 100, 100);
        Frescos2[3].setBounds(200, 0, 100, 100);
        Frescos1[4].setBounds(200, 100, 100, 100);
        Frescos2[4].setBounds(200, 100, 100, 100);
        Frescos1[5].setBounds(200, 200, 100, 100);
        Frescos2[5].setBounds(200, 200, 100, 100);

        frescoswindow1.add(new JLabel());
        frescoswindow2.add(new JLabel());
   }

    private void initPaths() {

        path1 = new JLabel[9];
        path2 = new JLabel[9];
        path3 = new JLabel[9];
        path4 = new JLabel[9];
        String palace = "knossos";

        JLabel[][] paths = new JLabel[4][9];
        paths[0] = path1; // knossos
        paths[1] = path2; // malia
        paths[2] = path3; //phaistos
        paths[3] = path4; //zakros

        for (int x = 0; x < 4; x++) {
            switch (x) {
                case 1:
                    palace = "malia";
                    break;
                case 2:
                    palace = "phaistos";
                    break;
                case 3:
                    palace = "zakros";
                    break;
            }
            int j = 0;
            for (int i = 0; i < 7; i = i + 2) {
                URL ur = cldr.getResource("resources/images/paths/" + palace + ".jpg");
                Image image = new ImageIcon(ur).getImage();
                image = image.getScaledInstance(100, 80, java.awt.Image.SCALE_SMOOTH);
                paths[x][i] = new JLabel();
                paths[x][i].setBounds(328 + j * 210, 80 + x * 110, 100, 80);
                paths[x][i].setIcon(new ImageIcon(image));
                mainpane.add(paths[x][i]);

                ur = cldr.getResource("resources/images/paths/" + palace + "2.jpg");
                image = new ImageIcon(ur).getImage();
                image = image.getScaledInstance(100, 80, java.awt.Image.SCALE_SMOOTH);
                paths[x][i + 1] = new JLabel();
                paths[x][i + 1].setBounds(432 + j * 210, 80 + x * 110, 100, 80);
                paths[x][i + 1].setIcon(new ImageIcon(image));

                mainpane.add(paths[x][i + 1]);
                j++;
            }
            URL ur = cldr.getResource("resources/images/paths/" + palace + "Palace.jpg");
            Image image = new ImageIcon(ur).getImage();
            image = image.getScaledInstance(120, 90, java.awt.Image.SCALE_SMOOTH);
            paths[x][8] = new JLabel();
            paths[x][8].setBounds(1167, 70 + x * 110, 120, 90);
            paths[x][8].setIcon(new ImageIcon(image));
            mainpane.add(paths[x][8]);

        }
    }

    private void initCards(ArrayList<Card> cards1, ArrayList<Card> cards2) {
        for (int i = 0; i < 8; i++) {
            Cards1[i] = new JButton();
            Cards1[i].setBounds(20 + i * 85, 10, 100, 140);
            Cards1[i].setBorder(BorderFactory.createLineBorder(Color.white));
            URL ur = cldr.getResource(cards1.get(i).getImage());
            Image image2 = new ImageIcon(ur).getImage();
            image2 = image2.getScaledInstance(100, 140, java.awt.Image.SCALE_SMOOTH);
            Cards1[i].setName(Integer.toString(i));
            Cards1[i].setIcon(new ImageIcon(image2));
            pane1.add(Cards1[i], 0);
        }
        player1LastCard = new JLabel[4];
        for (int i = 0; i < 4; i++) {
            player1LastCard[i] = new JLabel();
            player1LastCard[i].setBounds(750 + i * 85, 10, 80, 120);
            pane1.add(player1LastCard[i]);
        }
        player1LastCard[0].setText(Palace.Knossos.name());
        player1LastCard[0].setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        player1LastCard[1].setText(Palace.Malia.name());
        player1LastCard[1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
        player1LastCard[2].setText(Palace.Phaistos.name());
        player1LastCard[2].setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        player1LastCard[3].setText(Palace.Zakros.name());
        player1LastCard[3].setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));

        for (int i = 0; i < 8; i++) {
            Cards2[i] = new JButton();
            Cards2[i].setBounds(20 + i * 85, 10, 100, 140);
            Cards2[i].setBorder(BorderFactory.createLineBorder(Color.white));
            Cards2[i].setName(Integer.toString(i));
            URL ur = cldr.getResource(cards2.get(i).getImage());
            Image image2 = new ImageIcon(ur).getImage();
            image2 = image2.getScaledInstance(100, 140, java.awt.Image.SCALE_SMOOTH);
            Cards2[i].setIcon(new ImageIcon(image2));
            pane2.add(Cards2[i], 0);
        }
        player2LastCard = new JLabel[4];
        for (int i = 0; i < 4; i++) {
            player2LastCard[i] = new JLabel();
            player2LastCard[i].setBounds(750 + i * 85, 10, 80, 120);
            pane2.add(player2LastCard[i]);
        }
        player2LastCard[0].setText(Palace.Knossos.name());
        player2LastCard[0].setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        player2LastCard[1].setText(Palace.Malia.name());
        player2LastCard[1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
        player2LastCard[2].setText(Palace.Phaistos.name());
        player2LastCard[2].setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        player2LastCard[3].setText(Palace.Zakros.name());
        player2LastCard[3].setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));

        deck = new JButton();
        deck.setBounds(20, 250, 100, 140);
        URL ur = cldr.getResource("resources/images/cards/backCard.jpg");
        Image image2 = new ImageIcon(ur).getImage();
        image2 = image2.getScaledInstance(100, 140, java.awt.Image.SCALE_SMOOTH);
        deck.setIcon(new ImageIcon(image2));
        mainpane.add(deck);

    }

    /** <b>transformer(mutative)</b>
     * <p>
     * <b>Postcondition</b> Updates last card of player 
     *
     * @param player true for p1 false for p2
     * @param c
     */
    public void updateLastCardPile(Boolean player, Card c) { //true for player one
        JLabel lastcards[] = (player) ? player1LastCard : player2LastCard;
        URL ur = cldr.getResource(c.getImage());
        Image image = new ImageIcon(ur).getImage();

        image = image.getScaledInstance(80, 120, java.awt.Image.SCALE_SMOOTH);
        switch (c.getPalace()) {
            case Knossos:
                lastcards[0].setIcon(new ImageIcon(image));
                break;
            case Malia:
                lastcards[1].setIcon(new ImageIcon(image));
                break;
            case Phaistos:
                lastcards[2].setIcon(new ImageIcon(image));
                break;
            case Zakros:
                lastcards[3].setIcon(new ImageIcon(image));
                break;
            default:
                throw new AssertionError(c.getPalace().name());

        }
        this.repaint();
    }

    /** <b>transformer(mutative)</b>
     * <p>
     * <b>Postcondition</b> Updates rare items of player 
     *
     * @param player the player playing ~ true for p1 false for p2
     * @param finding the finding found
     */
    public void updateRareItem(Boolean player, RareFinding finding) {
        JLabel[] RareFindings = (player) ? RareFinding1 : RareFinding2;
        int i;
        switch (finding) {
            case DiskOfFaistos:
                i = 2;
                break;
            case RingOfMinoa:
                i = 0;
                break;
            case JewelOfMalia:
                i = 1;
                break;
            case RhytonOfZakros:
                i = 3;
                break;
            default:
                throw new AssertionError(finding.name());
        }

        Image image = new ImageIcon(cldr.getResource(finding.getImage())).getImage();
        image = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        RareFindings[i].setIcon(new ImageIcon(image));
    }

    /** <b>transformer(mutative)</b>
     * <p>
     * <b>Postcondition</b> Updates fresco of player 
     *
     * @param player the player playing ~ true for p1 false for p2
     * @param finding the finding found
     */
    public void updateFresco(Boolean player, Fresco finding) {
        JLabel[] frescos = (player) ? Frescos1 : Frescos2;
        int i;
        switch (finding) {
            case fresco1:
                i = 0;
                break;
            case fresco2:
                i = 1;
                break;
            case fresco3:
                i = 2;
                break;
            case fresco4:
                i = 3;
                break;
            case fresco5:
                i = 4;
                break;
            case fresco6:
                i = 5;
                break;
            default:
                throw new AssertionError(finding.name());

        }

        Image image = new ImageIcon(cldr.getResource(finding.getImage())).getImage();
        image.getScaledInstance(frescos[i].getIcon().getIconWidth(), frescos[i].getIcon().getIconHeight(), java.awt.Image.SCALE_SMOOTH);
        frescos[i].setIcon(new ImageIcon(image));
    }

    /** <b>transformer(mutative)</b>
     * <p>
     * <b>Postcondition</b> Updates position of pawn in display
     *
     * @param pawn
     */
    public void updatePawn(Pawn pawn) {
        JLabel p;
        if (pawns.containsKey(pawn)) {
            p = pawns.get(pawn);
        } else {
            throw new IllegalArgumentException("In update pawn");
        }
        switch (pawn.getPath().getPalace()) {
            case Knossos:
                path1[pawn.getPositionnum()].add(p);
                break;
            case Malia:
                path2[pawn.getPositionnum()].add(p);
                break;
            case Phaistos:
                path3[pawn.getPositionnum()].add(p);
                break;
            case Zakros:
                path4[pawn.getPositionnum()].add(p);
                break;
        }
        mainpane.repaint();
    }

    /** <b>transformer(mutative)</b>
     * <p>
     * <b>Postcondition</b> Updates components of player display
     *
     * @param availableCards
     * @param player 1 for p1 2 for p2
     * @param chp Checkpoints reached
     */
    public void updateBoardInfo(int availableCards, int chp, int player) {

        Info.setText("<html> Available cards: " + availableCards + "<br>  CheckPoints: " + chp
                + "<br>  Turn: Player " + player + "<html>");

        this.repaint();
    }

    public void updatePlayerInfo(int player1arch, int player1theseus, int player2arch, int player2theseus,
            int score1, int score2, int statues1, int statues2) {
        String text = "Player1 - ";
        if (player1arch == 0 && player1theseus == 0) {
            text += "No pawns available";
        } else if (player1arch == 3 && player1theseus == 1) {
            text += "All pawns available";
        } else {
            text += "Available Pawns: ";
            if (player1arch != 0) {
                text += player1arch + " Archeologists";
                if (player1theseus != 0) {
                    text += " and ";
                }
            }
            if (player1theseus != 0) {
                text += player1theseus + " Theseus";
            }
        }
        availablePawns1.setText(text);

        text = "Player2 - ";
        if (player2arch == 0 && player2theseus == 0) {
            text += "No pawns available";
        } else if (player2arch == 3 && player2theseus == 1) {
            text += "All pawns available";
        } else {
            text += "Available Pawns: ";
            if (player2arch != 0) {
                text += player2arch + " Archeologists";
                if (player2theseus != 0) {
                    text += " and ";
                }
            }
            if (player2theseus != 0) {
                text += player2theseus + " Theseus";
            }
        }
        availablePawns2.setText(text);
        statuetxt1.setText("Statues : " + statues1);
        statuetxt2.setText("Statues : " + statues2);

        Score1.setText("My Score : " + score1 + " points");
        Score2.setText("My Score : " + score2 + " points");

    }

    
    /**Transformer
     * Replaces card c image in jButton but
     * @param but the button        
     * @param c the card
     */
    public void replaceCard(JButton but, Card c) {
        URL ur = cldr.getResource(c.getImage());
        Image image = new ImageIcon(ur).getImage().getScaledInstance(100, 140, java.awt.Image.SCALE_SMOOTH);
        but.setIcon(new ImageIcon(image));
    }

    /**Transformer
     * Sets image of card c grayed in JButton but
     * @param but
     * @param c 
     */
    public void grayCard(JButton but, Card c) {
        URL ur = cldr.getResource(c.getImage());
        Image image = new ImageIcon(ur).getImage().getScaledInstance(100, 140, java.awt.Image.SCALE_SMOOTH);
        but.setIcon(new ImageIcon(grayImage(image)));
    }

    /**Transformer
     * Returns the grayed version of img 
     * @param img
     * @return 
     */
    public Image grayImage(Image img) {
        ImageFilter filter = new GrayFilter(true, 60);
        ImageProducer producer = new FilteredImageSource(img.getSource(), filter);
        return Toolkit.getDefaultToolkit().createImage(producer);
    }

    /**Transformer
     * Toggles visibility of fresco window of player
     * @param player  true for p1 false for p2
     */
    public void togglewindow(Boolean player) {
        JFrame frame = (player) ? frescoswindow1 : frescoswindow2;
        if (frame.isShowing()) {
            frame.setVisible(false);
        } else {
            frame.setVisible(true);
        }
    }

    /**
     * Brings up an information-message dialog titled "title".
     *
     * @param title
     * @param message
     * @param messageType
     */
    public void showMessage(String title, String message, int messageType) {
        JOptionPane.showMessageDialog(this, message, title, messageType);
    }

}
