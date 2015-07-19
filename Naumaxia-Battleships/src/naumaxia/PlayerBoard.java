package naumaxia;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class PlayerBoard extends JFrame {

    private JLabel phrase;
    private JLabel title1;
    private JLabel title2;
    private Grid ship1;
    private Grid ship2;
    private Grid ship3;
    private Grid ship4;
    private Grid ship5;
    private Grid playerGrid;
    private JButton rotate;
    private JButton startGame;
    private JFrame selfFrame;
    private String n;
    private AircraftCarier air;
    private Battleship battle;
    private Submarine sub;
    private Destroyer destro;
    private PatrolBoat patrol;
    private int shipLength = 0;
    private boolean orient;
    private boolean tempValid = true;
    private int shipEnabled;
    private int[][] shipInside = new int[10][10];
    private int blocks = 0;
    private MouseListener list;
    private Boolean play = false;

    public PlayerBoard(String name) {

        this.n = name;
        selfFrame = this;
        this.setTitle("Battleship - Ships' Placement");
        this.setSize(700, 700);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        phrase = new JLabel("Plese select ships from the left and place them in your board. Press \"start game\" when you are ready!");
        phrase.setSize(600, 18);
        phrase.setLocation(50, 15);

        title1 = new JLabel("Ships to be placed");
        title1.setSize(150, 18);
        title1.setLocation(75, 220);

        title2 = new JLabel("Your Board");
        title2.setSize(100, 18);
        title2.setLocation(420, 130);

        ship1 = new Grid(1, 5);
        ship1.setSize(200, 40);
        ship1.setLocation(25, 240);

        ship2 = new Grid(1, 5);
        ship2.setSize(200, 40);
        ship2.setLocation(25, 285);

        ship3 = new Grid(1, 5);
        ship3.setSize(200, 40);
        ship3.setLocation(25, 330);

        ship4 = new Grid(1, 5);
        ship4.setSize(200, 40);
        ship4.setLocation(25, 375);

        ship5 = new Grid(1, 5);
        ship5.setSize(200, 40);
        ship5.setLocation(25, 420);

        playerGrid = new Grid(10, 10);
        playerGrid.setSize(400, 400);
        playerGrid.setLocation(250, 150);

        rotate = new JButton("Rotate");
        rotate.setSize(80, 20);
        rotate.setLocation(5, 645);

        startGame = new JButton("Start Game");
        startGame.setSize(100, 20);
        startGame.setEnabled(false);
        startGame.setLocation(590, 645);


        //startGame.setEnabled(false);

        this.add(phrase);
        this.add(title1);
        this.add(title2);
        this.add(ship1);
        this.add(ship2);
        this.add(ship3);
        this.add(ship4);
        this.add(ship5);
        this.add(playerGrid);
        this.add(rotate);
        this.add(startGame);


        for (int i = 0; i < 10; i++) { // parallilos pinakas gia na vlepoume an iparxei ploio mesa sto grid
            for (int j = 0; j < 10; j++) {
                shipInside[j][i] = 0;
            }
        }


        air = new AircraftCarier(0, 0, true, true);                                     // dimiourgia kai topo8etisi ploiwn sta mikra grid
        for (int i = air.getPosy(); i < air.getPosy() + air.getLength(); i++) {
            ship1.getInnerCells()[air.getPosx()][i].setBackground(Color.GRAY);
        }

        battle = new Battleship(0, 0, false, true);
        for (int i = battle.getPosy(); i < battle.getPosy() + battle.getLength(); i++) {
            ship2.getInnerCells()[battle.getPosx()][i].setBackground(Color.GRAY);
        }
        sub = new Submarine(0, 0, true, true);
        for (int i = sub.getPosy(); i < sub.getPosy() + sub.getLength(); i++) {
            ship3.getInnerCells()[sub.getPosx()][i].setBackground(Color.GRAY);
        }

        destro = new Destroyer(0, 0, false, true);
        for (int i = destro.getPosy(); i < destro.getPosy() + destro.getLength(); i++) {
            ship4.getInnerCells()[destro.getPosx()][i].setBackground(Color.GRAY);
        }

        patrol = new PatrolBoat(0, 0, false, true);
        for (int i = patrol.getPosy(); i < patrol.getPosy() + patrol.getLength(); i++) {
            ship5.getInnerCells()[patrol.getPosx()][i].setBackground(Color.GRAY);
        }

        for (int i = 4; i > 3; i--) {                                           // oti perisseuei sta grid ginetai null gia na exei gri xrwma
            ship2.getInnerCells()[0][i].setBackground(null);

        }

        for (int i = 4; i > 2; i--) {
            ship3.getInnerCells()[0][i].setBackground(null);

        }

        for (int i = 4; i > 2; i--) {

            ship4.getInnerCells()[0][i].setBackground(null);

        }

        for (int i = 4; i > 1; i--) {

            ship5.getInnerCells()[0][i].setBackground(null);

        }


        ship1.addMouseListener(new MouseListener() {  // dimiourgia listener sto grid gia na pairnoume to ploio opou kai na patame
            @Override
            public void mouseClicked(MouseEvent e) {
                orient = true;
                for (int i = air.getPosy(); i < air.getPosy() + air.getLength(); i++) {
                    ship1.getInnerCells()[air.getPosx()][i].setBackground(Color.YELLOW); //energo einai yellow
                }
                shipLength = air.getLength(); //pairnoume mege8os ploiou
                shipEnabled = 1;                //kai poio ploio einai

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
        });


        ship2.addMouseListener(new MouseListener() {// dimiourgia listener sto grid gia na pairnoume to ploio opou kai na patame
            @Override
            public void mouseClicked(MouseEvent e) {
                orient = true;
                for (int i = battle.getPosy(); i < battle.getPosy() + battle.getLength(); i++) {
                    ship2.getInnerCells()[battle.getPosx()][i].setBackground(Color.YELLOW);
                }
                shipLength = battle.getLength();//pairnoume mege8os ploiou
                shipEnabled = 2;                //kai poio ploio einai

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
        });
        ship3.addMouseListener(new MouseListener() {// dimiourgia listener sto grid gia na pairnoume to ploio opou kai na patame
            @Override
            public void mouseClicked(MouseEvent e) {
                orient = true;
                for (int i = sub.getPosy(); i < sub.getPosy() + sub.getLength(); i++) {
                    ship3.getInnerCells()[sub.getPosx()][i].setBackground(Color.YELLOW);
                }
                shipLength = sub.getLength();//pairnoume mege8os ploiou
                shipEnabled = 3;                    //kai poio ploio einai

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
        });
        ship4.addMouseListener(new MouseListener() {// dimiourgia listener sto grid gia na pairnoume to ploio opou kai na patame
            @Override
            public void mouseClicked(MouseEvent e) {
                orient = true;
                for (int i = destro.getPosy(); i < destro.getPosy() + destro.getLength(); i++) {
                    ship4.getInnerCells()[destro.getPosx()][i].setBackground(Color.YELLOW);
                }
                shipLength = destro.getLength();//pairnoume mege8os ploiou
                shipEnabled = 4;                //kai poio ploio einai

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
        });
        ship5.addMouseListener(new MouseListener() {// dimiourgia listener sto grid gia na pairnoume to ploio opou kai na patame
            @Override
            public void mouseClicked(MouseEvent e) {
                orient = true;
                for (int i = patrol.getPosy(); i < patrol.getPosy() + patrol.getLength(); i++) {
                    ship5.getInnerCells()[patrol.getPosx()][i].setBackground(Color.YELLOW);
                }
                shipLength = patrol.getLength();//pairnoume mege8os ploiou
                shipEnabled = 5;                //kai poio ploio einai

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
        });




        for (int i = 0; i < playerGrid.getRows(); i++) {
            for (int j = 0; j < playerGrid.getCols(); j++) {
                playerGrid.getInnerCells()[i][j].addMouseListener(list = new MouseListener() { // eisagwgi listener se ka8e panel sto grid
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        JPanel x = (JPanel) e.getSource();
                        if (play == false) { // an dn exei pati8ei to koumpi start
                            if (shipInside[x.getX() / 40][x.getY() / 40] != 0) {   //elegxei an to panel pou pati8ike exei mesa ploio
                                int tempsa = shipInside[x.getX() / 40][x.getY() / 40];  // kai vazei ti timi tou sti tempsa
                                for (int k = 0; k < 10; k++) {
                                    for (int l = 0; l < 10; l++) {
                                        if (shipInside[l][k] == tempsa) { // opoio ploio pati8ei mesa sto grid ginetai yellow
                                            playerGrid.getInnerCells()[k][l].setBackground(Color.yellow);

                                            if (shipInside[l][k] == 1) {//to pairnoume gia na to kanoume topo8etisi alllou me vasi to id tou ploioy
                                                shipLength = 5;
                                                shipInside[l][k] = 0;
                                            }
                                            if (shipInside[l][k] == 2) {
                                                shipLength = 4;
                                                shipInside[l][k] = 0;
                                            }
                                            if (shipInside[l][k] == 3) {
                                                shipLength = 3;
                                                shipInside[l][k] = 0;
                                            }
                                            if (shipInside[l][k] == 4) {
                                                shipLength = 3;
                                                shipInside[l][k] = 0;
                                            }
                                            if (shipInside[l][k] == 5) {
                                                shipLength = 2;
                                                shipInside[l][k] = 0;
                                            }
                                        }

                                    }

                                }
                            } else {
                                if (x.getBackground() == Color.GREEN && orient == true) { //an mporei na mpei (green) kai an einai orizontia
                                    for (int i = (x.getX() / 40); i < (x.getX() / 40) + shipLength; i++) {//i perioxi pou 8a vaftei
                                        playerGrid.getInnerCells()[x.getY() / 40][i].setBackground(Color.GRAY); //bapse gri ti perioxi pou prepei 
                                        playerGrid.getInnerCells()[x.getY() / 40][i].setEnabled(true);   //dilwse oti iparxei ploio sti perioxi
                                        shipInside[i][x.getY() / 40] = shipEnabled;                 // kai pairnei id gia na mporei na ginei i metakinisi
                                        for (int k = 0; k < 10; k++) {
                                            for (int l = 0; l < 10; l++) {
                                                if (playerGrid.getInnerCells()[k][l].getBackground() == Color.yellow) { //metakinisi
                                                    playerGrid.getInnerCells()[k][l].setBackground(Color.CYAN);
                                                    shipInside[k][l] = 0;
                                                    playerGrid.getInnerCells()[k][l].setEnabled(false);

                                                }
                                            }
                                        }
                                    }

                                    shipLength = 0;                             //opoio ploio exei par8ei apo to grid tou otan topo8eti8ei ginetai 
                                    if (shipEnabled == 1) {                     //null to grid tou
                                        for (int k = 0; k < 5; k++) {
                                            ship1.getInnerCells()[0][k].setBackground(null);

                                        }
                                    }
                                    if (shipEnabled == 2) {
                                        for (int k = 0; k < 5; k++) {
                                            ship2.getInnerCells()[0][k].setBackground(null);

                                        }
                                    }
                                    if (shipEnabled == 3) {
                                        for (int k = 0; k < 5; k++) {
                                            ship3.getInnerCells()[0][k].setBackground(null);

                                        }
                                    }
                                    if (shipEnabled == 4) {
                                        for (int k = 0; k < 5; k++) {
                                            ship4.getInnerCells()[0][k].setBackground(null);

                                        }
                                    }
                                    if (shipEnabled == 5) {
                                        for (int k = 0; k < 5; k++) {
                                            ship5.getInnerCells()[0][k].setBackground(null);

                                        }
                                    }
                                }
                            }
                            if (x.getBackground()== Color.GREEN && orient == false) { // idio me apo panw apla gia ta ka8eta ploia
                                for (int i = (x.getY() / 40); i < (x.getY() / 40) + shipLength; i++) {
                                    playerGrid.getInnerCells()[i][x.getX() / 40].setBackground(Color.GRAY);
                                    playerGrid.getInnerCells()[i][x.getX() / 40].setEnabled(true);
                                    shipInside[x.getX() / 40][i] = shipEnabled;
                                    for (int k = 0; k < 10; k++) {
                                        for (int l = 0; l < 10; l++) {
                                            if (playerGrid.getInnerCells()[k][l].getBackground() == Color.yellow) {
                                                playerGrid.getInnerCells()[k][l].setBackground(Color.CYAN);
                                                shipInside[k][l] = 0;
                                                playerGrid.getInnerCells()[k][l].setEnabled(false);

                                            }
                                        }
                                    }

                                }

                                shipLength = 0;
                                if (shipEnabled == 1) {
                                    for (int k = 0; k < 5; k++) {
                                        ship1.getInnerCells()[0][k].setBackground(null);

                                    }
                                }
                                if (shipEnabled == 2) {
                                    for (int k = 0; k < 5; k++) {
                                        ship2.getInnerCells()[0][k].setBackground(null);

                                    }
                                }
                                if (shipEnabled == 3) {
                                    for (int k = 0; k < 5; k++) {
                                        ship3.getInnerCells()[0][k].setBackground(null);

                                    }
                                }
                                if (shipEnabled == 4) {
                                    for (int k = 0; k < 5; k++) {
                                        ship4.getInnerCells()[0][k].setBackground(null);

                                    }
                                }
                                if (shipEnabled == 5) {
                                    for (int k = 0; k < 5; k++) {
                                        ship5.getInnerCells()[0][k].setBackground(null);

                                    }
                                }
                            }
                            for (int i = 0; i < 10; i++) {    //metrame ta ploia pou topo8eti8ikan wste na energopoii8ei to start
                                for (int j = 0; j < 10; j++) {
                                    if (shipInside[i][j] != 0) {
                                        blocks += 1;
                                    }
                                }
                            }
                            if (blocks >= 17) {
                                startGame.setEnabled(true);
                            } else {
                                blocks = 0;
                            }
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) { 
                        JPanel x = (JPanel) e.getSource();
                        if (play == false) {        //elegxoume an exei patithei to start
                            if (orient == true) {   //gia ta orizontia ploia
                                if (x.getX() / 40 + shipLength <= 10) { //elegxei gia na min vgei ekso apo ta oria tou grid
                                    for (int i = (x.getX() / 40); i < (x.getX() / 40) + shipLength; i++) {  //elegxei ean i perioxi pou tha katalavei  
                                        if (playerGrid.getInnerCells()[x.getY() / 40][i].getBackground() == Color.gray) {   //to ploio einai diathesimi
                                            tempValid = false;                                                              //kai kanei ti valid false
                                            break;
                                        } else {
                                            tempValid = true;                                                               // allios ti kanei true
                                        }
                                    }
                                    if (tempValid == true) {                                                                //an einai valid tote to topotheti
                                        for (int i = (x.getX() / 40); i < (x.getX() / 40) + shipLength; i++) {              //kanontas ola ta cells tou ploiou
                                            playerGrid.getInnerCells()[x.getY() / 40][i].setBackground(Color.GREEN);        //prasina
                                        }
                                    } else {                                                                                //allios an den einai valid
                                        x.setBackground(Color.red);                                                         //kanta kokkina
                                    }
                                } else {                                                                                    //auto to else einai gia tin proti if pou elegxei 
                                    x.setBackground(Color.red);                                                             //ta oria tou grid kai episis to kanei kokkino 
                                }
                            } else {                                                                                        //allios gia ta katheta ploia
                                                                                                                            //isxioun ta idia gia apo pano
                                if (x.getY() / 40 + shipLength <= 10) {
                                    for (int i = (x.getY() / 40); i < (x.getY() / 40) + shipLength; i++) {
                                        if (playerGrid.getInnerCells()[i][x.getX() / 40].getBackground() == Color.GRAY) {
                                            tempValid = false;
                                            break;
                                        } else {
                                            tempValid = true;
                                        }

                                    }
                                    if (tempValid == true) {
                                        for (int i = (x.getY() / 40); i < (x.getY() / 40) + shipLength; i++) {
                                            playerGrid.getInnerCells()[i][x.getX() / 40].setBackground(Color.GREEN);
                                        }
                                    } else {
                                        x.setBackground(Color.red);
                                    }

                                } else {
                                    x.setBackground(Color.red);
                                }
                            }
                            //System.out.println(x.getX() / 40 + "," + x.getY() / 40 + " shipInside=" + shipInside[x.getX() / 40][x.getY() / 40]);

                        }
                    }

                    @Override
                    public void mouseExited(MouseEvent e) { //idia sxolia me to mouse entered


                        JPanel x = (JPanel) e.getSource();
                        if (play == false) {
                            if (x.getBackground() != Color.yellow) {
                                if (playerGrid.getInnerCells()[x.getY() / 40][x.getX() / 40].isEnabled() == true) {
                                    playerGrid.getInnerCells()[x.getY() / 40][x.getX() / 40].setBackground(Color.gray);
                                } else {
                                    if (orient == true) {
                                        if (x.getX() / 40 + shipLength <= 10) {

                                            for (int i = (x.getX() / 40); i < (x.getX() / 40) + shipLength; i++) {
                                                if (playerGrid.getInnerCells()[x.getY() / 40][i].getBackground() == Color.gray) {
                                                    tempValid = false;
                                                    break;
                                                } else {
                                                    tempValid = true;
                                                }
                                            }
                                            if (tempValid == true) {
                                                for (int i = (x.getX() / 40); i < (x.getX() / 40) + shipLength; i++) {
                                                    playerGrid.getInnerCells()[x.getY() / 40][i].setBackground(Color.cyan);
                                                }
                                            } else {
                                                x.setBackground(Color.cyan);
                                            }
                                        } else {
                                            x.setBackground(Color.cyan);
                                        }
                                    } else {

                                        if (x.getY() / 40 + shipLength <= 10) {
                                            for (int i = (x.getY() / 40); i < (x.getY() / 40) + shipLength; i++) {
                                                if (playerGrid.getInnerCells()[i][x.getX() / 40].getBackground() == Color.GRAY) {
                                                    tempValid = false;
                                                    break;
                                                } else {
                                                    tempValid = true;
                                                }

                                            }
                                            if (tempValid == true) {
                                                for (int i = (x.getY() / 40); i < (x.getY() / 40) + shipLength; i++) {
                                                    playerGrid.getInnerCells()[i][x.getX() / 40].setBackground(Color.cyan);
                                                }
                                            } else {
                                                x.setBackground(Color.cyan);
                                            }

                                        } else {
                                            x.setBackground(Color.cyan);
                                        }
                                    }
                                }
                            }
                        }
                    }
                });





            }



        }

        rotate.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) { // allazei to orientation
                        if (orient == true) {
                            orient = false;
                        } else {
                            orient = true;
                        }
                    }
                });

        startGame.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
//                         for (int i = 0; i < playerGrid.getRows(); i++) {
//                            for (int j = 0; j < playerGrid.getCols(); j++) {
//                playerGrid.getInnerCells()[i][j].removeMouseListener(list);
//                        
//                        }}
                        play = true;//kanei to play true gia na bgoun oi ;istener
                        BattleFrame fra = new BattleFrame(n, playerGrid); //kai pernaei to onoma tou paixti kai to grid tou
                        fra.setVisible(true);

                        selfFrame.setVisible(false);

                    }
                });
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public AircraftCarier getAir() {
        return air;
    }

    public void setAir(AircraftCarier air) {
        this.air = air;
    }

    public Battleship getBattle() {
        return battle;
    }

    public void setBattle(Battleship battle) {
        this.battle = battle;
    }

    public Submarine getSub() {
        return sub;
    }

    public void setSub(Submarine sub) {
        this.sub = sub;
    }

    public Destroyer getDestro() {
        return destro;
    }

    public void setDestro(Destroyer destro) {
        this.destro = destro;
    }

    public PatrolBoat getPatrol() {
        return patrol;
    }

    public void setPatrol(PatrolBoat patrol) {
        this.patrol = patrol;
    }

    public int getShipLength() {
        return shipLength;
    }

    public void setShipLength(int shipLength) {
        this.shipLength = shipLength;
    }

    public boolean isOrient() {
        return orient;
    }

    public void setOrient(boolean orient) {
        this.orient = orient;
    }

    public boolean isTempValid() {
        return tempValid;
    }

    public void setTempValid(boolean tempValid) {
        this.tempValid = tempValid;
    }

    public int getShipEnabled() {
        return shipEnabled;
    }

    public void setShipEnabled(int shipEnabled) {
        this.shipEnabled = shipEnabled;
    }

    public int[][] getShipInside() {
        return shipInside;
    }

    public void setShipInside(int[][] shipInside) {
        this.shipInside = shipInside;
    }

    public int getBlocks() {
        return blocks;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }

    public MouseListener getList() {
        return list;
    }

    public void setList(MouseListener list) {
        this.list = list;
    }

    public Boolean getPlay() {
        return play;
    }

    public void setPlay(Boolean play) {
        this.play = play;
    }

    public JLabel getPhrase() {
        return phrase;
    }

    public void setPhrase(JLabel phrase) {
        this.phrase = phrase;
    }

    public JLabel getTitle1() {
        return title1;
    }

    public void setTitle1(JLabel title1) {
        this.title1 = title1;
    }

    public JLabel getTitle2() {
        return title2;
    }

    public void setTitle2(JLabel title2) {
        this.title2 = title2;
    }

    public Grid getShip1() {
        return ship1;
    }

    public void setShip1(Grid ship1) {
        this.ship1 = ship1;
    }

    public Grid getShip2() {
        return ship2;
    }

    public void setShip2(Grid ship2) {
        this.ship2 = ship2;
    }

    public Grid getShip3() {
        return ship3;
    }

    public void setShip3(Grid ship3) {
        this.ship3 = ship3;
    }

    public Grid getShip4() {
        return ship4;
    }

    public void setShip4(Grid ship4) {
        this.ship4 = ship4;
    }

    public Grid getShip5() {
        return ship5;
    }

    public void setShip5(Grid ship5) {
        this.ship5 = ship5;
    }

    public Grid getPlayerGrid() {
        return playerGrid;
    }

    public void setPlayerGrid(Grid playerGrid) {
        this.playerGrid = playerGrid;
    }

    public JButton getRotate() {
        return rotate;
    }

    public void setRotate(JButton rotate) {
        this.rotate = rotate;
    }

    public JButton getStartGame() {
        return startGame;
    }

    public void setStartGame(JButton startGame) {
        this.startGame = startGame;
    }

    public JFrame getSelfFrame() {
        return selfFrame;
    }

    public void setSelfFrame(JFrame selfFrame) {
        this.selfFrame = selfFrame;
    }
}

