package naumaxia;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.*;

public class BattleFrame extends JFrame {

    private JSplitPane sep;
    private Grid playerGrid;
    private Grid cpuGrid;
    private JLabel title1;
    private JLabel title2;
    private int tmpx;
    private int tmpy;
    private boolean tempOrient;
    private int hitCounter = 0; //tsekarei xtipimena ploia gia na bgalei to nikiti
    private String plr;       
    private boolean temp;

    public BattleFrame(String player, Grid plrGrid) {

        this.playerGrid = plrGrid;
        this.plr = player;
        this.setTitle("Battleship - Play Game");
        this.setSize(1000, 500);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        sep = new JSplitPane();
        sep.setSize(3, 500);
        sep.setLocation(500, 0);
        sep.setEnabled(false);
        this.add(sep);

//        playerGrid = new Grid(10, 10);
//        playerGrid.setSize(400, 400);
        playerGrid.setLocation(50, 50);
        this.add(playerGrid);

        cpuGrid = new Grid(10, 10);
        cpuGrid.setSize(400, 400);
        cpuGrid.setLocation(550, 50);
        this.add(cpuGrid);

        title1 = new JLabel();
        title1.setText(player + "'s Board");
        title1.setSize(player.length() * 7 + 56, 18);
        title1.setLocation((500 - (player.length() * 7 + 56)) / 2, 22);
        this.add(title1);

        title2 = new JLabel();
        title2.setText("Computer's Board");
        title2.setSize(112, 18);
        title2.setLocation(694, 22);
        this.add(title2);


//        Submarine sub = new Submarine(1, 1, true, true);
//        if (sub.isOrientation() == true) {
//            for (int i = sub.getPosy(); i < sub.getPosy() + sub.getLength(); i++) {
//
//                playerGrid.getInnerCells()[sub.getPosx()][i].setBackground(Color.GRAY);
//            }
//        } else {
//            for (int i = sub.getPosx(); i < sub.getPosx() + sub.getLength(); i++) {
//                playerGrid.getInnerCells()[i][sub.getPosy()].setBackground(Color.GRAY);
//            }
//        }
//
//        Battleship battle = new Battleship(3, 2, false, true);
//        if (battle.isOrientation() == true) {
//            for (int i = battle.getPosy(); i < battle.getPosy() + battle.getLength(); i++) {
//                playerGrid.getInnerCells()[battle.getPosx()][i].setBackground(Color.GRAY);
//            }
//        } else {
//            for (int i = battle.getPosx(); i < battle.getPosx() + battle.getLength(); i++) {
//                playerGrid.getInnerCells()[i][battle.getPosy()].setBackground(Color.GRAY);
//            }
//        }
//
//        AircraftCarier air = new AircraftCarier(8, 1, true, true);
//        if (air.isOrientation() == true) {
//            for (int i = air.getPosy(); i < air.getPosy() + air.getLength(); i++) {
//                playerGrid.getInnerCells()[air.getPosx()][i].setBackground(Color.GRAY);
//            }
//        } else {
//            for (int i = air.getPosx(); i < air.getPosx() + air.getLength(); i++) {
//                playerGrid.getInnerCells()[i][air.getPosy()].setBackground(Color.GRAY);
//            }
//        }
//
//        Destroyer destro = new Destroyer(3, 6, false, true);
//        if (destro.isOrientation() == true) {
//            for (int i = destro.getPosy(); i < destro.getPosy() + destro.getLength(); i++) {
//                playerGrid.getInnerCells()[destro.getPosx()][i].setBackground(Color.GRAY);
//            }
//        } else {
//            for (int i = destro.getPosx(); i < destro.getPosx() + destro.getLength(); i++) {
//                playerGrid.getInnerCells()[i][destro.getPosy()].setBackground(Color.GRAY);
//            }
//        }
//
//        PatrolBoat patrol = new PatrolBoat(8, 8, false, true);
//        if (patrol.isOrientation() == true) {
//            for (int i = patrol.getPosy(); i < patrol.getPosy() + patrol.getLength(); i++) {
//                playerGrid.getInnerCells()[patrol.getPosx()][i].setBackground(Color.GRAY);
//            }
//        } else {
//            for (int i = patrol.getPosx(); i < patrol.getPosx() + patrol.getLength(); i++) {
//                playerGrid.getInnerCells()[i][patrol.getPosy()].setBackground(Color.GRAY);
//            }
//        }

//dimiourgia karavion tou CPU (ta valame sto idio simeio me ta dika mas gia na mporoume na ta tsekaroume)
        //  for (int salala = 0; salala < 10; salala++) {
        // Submarine cpuSub = new Submarine();

        temp = placeShip(3); // kalesma sinartisis gia na tsekarei an einai valid i 8esi tou ploiou
        while (temp == false) {
            temp = placeShip(3);   
        }
        Submarine cpuSub = new Submarine(tmpy, tmpx, tempOrient, true);
        if (cpuSub.isOrientation() == true) {
            for (int i = cpuSub.getPosy(); i < cpuSub.getPosy() + cpuSub.getLength(); i++) {// elegxos twn keliwn pou 8a vaftoun



                //cpuGrid.getInnerCells()[cpuSub.getPosx()][i].setBackground(Color.GRAY);
                cpuGrid.getInnerCells()[cpuSub.getPosx()][i].setEnabled(true);    // leme oti iparxei ploio
            }
        } else {
            for (int i = cpuSub.getPosx(); i < cpuSub.getPosx() + cpuSub.getLength(); i++) {

               // cpuGrid.getInnerCells()[i][cpuSub.getPosy()].setBackground(Color.GRAY);
                cpuGrid.getInnerCells()[i][cpuSub.getPosy()].setEnabled(true);
            }
        }
        // }


        temp = placeShip(4);
        while (temp == false) {
            temp = placeShip(4);
        }
        Battleship cpuBattle = new Battleship(tmpy, tmpx, tempOrient, true);
        if (cpuBattle.isOrientation() == true) {
            for (int i = cpuBattle.getPosy(); i < cpuBattle.getPosy() + cpuBattle.getLength(); i++) {
               // cpuGrid.getInnerCells()[cpuBattle.getPosx()][i].setBackground(Color.GRAY);
                cpuGrid.getInnerCells()[cpuBattle.getPosx()][i].setEnabled(true);
            }
        } else {
            for (int i = cpuBattle.getPosx(); i < cpuBattle.getPosx() + cpuBattle.getLength(); i++) {
               // cpuGrid.getInnerCells()[i][cpuBattle.getPosy()].setBackground(Color.GRAY);
                cpuGrid.getInnerCells()[i][cpuBattle.getPosy()].setEnabled(true);
            }
        }






        temp = placeShip(5);
        while (temp == false) {
            temp = placeShip(5);
        }
        AircraftCarier cpuAir = new AircraftCarier(tmpy, tmpx, tempOrient, true);
        if (cpuAir.isOrientation() == true) {
            for (int i = cpuAir.getPosy(); i < cpuAir.getPosy() + cpuAir.getLength(); i++) {
              //  cpuGrid.getInnerCells()[cpuAir.getPosx()][i].setBackground(Color.GRAY);
                cpuGrid.getInnerCells()[cpuAir.getPosx()][i].setEnabled(true);
            }
        } else {
            for (int i = cpuAir.getPosx(); i < cpuAir.getPosx() + cpuAir.getLength(); i++) {
               // cpuGrid.getInnerCells()[i][cpuAir.getPosy()].setBackground(Color.GRAY);
                cpuGrid.getInnerCells()[i][cpuAir.getPosy()].setEnabled(true);
            }
        }
        temp = placeShip(3);
        while (temp == false) {
            temp = placeShip(3);
        }
        Destroyer cpuDestro = new Destroyer(tmpy, tmpx, tempOrient, true);
        if (cpuDestro.isOrientation() == true) {
            for (int i = cpuDestro.getPosy(); i < cpuDestro.getPosy() + cpuDestro.getLength(); i++) {
               // cpuGrid.getInnerCells()[cpuDestro.getPosx()][i].setBackground(Color.GRAY);
                cpuGrid.getInnerCells()[cpuDestro.getPosx()][i].setEnabled(true);
            }
        } else {
            for (int i = cpuDestro.getPosx(); i < cpuDestro.getPosx() + cpuDestro.getLength(); i++) {
               // cpuGrid.getInnerCells()[i][cpuDestro.getPosy()].setBackground(Color.GRAY);
                cpuGrid.getInnerCells()[i][cpuDestro.getPosy()].setEnabled(true);
            }
        }






        temp = placeShip(2);
        while (temp == false) {
            temp = placeShip(2);
        }
        PatrolBoat cpuPatrol = new PatrolBoat(tmpy, tmpx, tempOrient, true);
        if (cpuPatrol.isOrientation() == true) {
            for (int i = cpuPatrol.getPosy(); i < cpuPatrol.getPosy() + cpuPatrol.getLength(); i++) {
              //  cpuGrid.getInnerCells()[cpuPatrol.getPosx()][i].setBackground(Color.GRAY);
                cpuGrid.getInnerCells()[cpuPatrol.getPosx()][i].setEnabled(true);
            }
        } else {
            for (int i = cpuPatrol.getPosx(); i < cpuPatrol.getPosx() + cpuPatrol.getLength(); i++) {
             //   cpuGrid.getInnerCells()[i][cpuPatrol.getPosy()].setBackground(Color.GRAY);
                cpuGrid.getInnerCells()[i][cpuPatrol.getPosy()].setEnabled(true);
            }
        }


        for (int i = 0; i < cpuGrid.getRows(); i++) {
            for (int j = 0; j < cpuGrid.getCols(); j++) {
                cpuGrid.getInnerCells()[i][j].addMouseListener(new MouseListener() { //dimiourgia listener se ka8e panel tou cpugrid
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        JPanel x = (JPanel) e.getSource();
                        if (x.isRequestFocusEnabled() == false) {       //elegxoume ean to sigekrimeno JPanel pou patisame einai ksanapatimeno

                            Random rand = new Random();

                            

                            if (x.isEnabled() == true) { // an xtipisei metra gia na bgalei winner meta apo 17 xtipimata
                                x.setBackground(Color.RED);
                                hitCounter++;   //new
                                if (hitCounter >= 17) {
                                    JOptionPane.showMessageDialog(null, "Winner is player: " + plr); // minima nikis
                                    
                                    System.out.println("nikitis einai o " + plr);


                                }
                                x.setEnabled(false);   //petixe stoxo
                                x.setRequestFocusEnabled(true); //xtipi8ike kai dn ksanaxtipaei
                            } else {
                                if (x.getBackground() != Color.RED) {// an dn einai kokkino dn xtipise ara ginetai aspro
                                    x.setBackground(Color.WHITE);
                                }
                                x.setRequestFocusEnabled(true); //xtipi8ike kai dn ksanaxtipaei
                            }
                            playerGrid.hit(rand.nextInt(10), rand.nextInt(10)); //kalesma ma8odou gia xtipima tou cpu
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
                        if (x.getBackground() == Color.CYAN) { //hover
                            x.setBackground(Color.green);
                        };
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                        JPanel x = (JPanel) e.getSource();

                        if (x.getBackground() == Color.GREEN) {//hover
                            x.setBackground(Color.CYAN);
                        };
                    }
                });





            }


        }
    }

    public boolean isTemp() {
        return temp;
    }

    public void setTemp(boolean temp) {
        this.temp = temp;
    }
    

    public JSplitPane getSep() {
        return sep;
    }

    public void setSep(JSplitPane sep) {
        this.sep = sep;
    }

    public Grid getPlayerGrid() {
        return playerGrid;
    }

    public void setPlayerGrid(Grid playerGrid) {
        this.playerGrid = playerGrid;
    }

    public Grid getCpuGrid() {
        return cpuGrid;
    }

    public void setCpuGrid(Grid cpuGrid) {
        this.cpuGrid = cpuGrid;
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

    public int getTmpx() {
        return tmpx;
    }

    public void setTmpx(int tmpx) {
        this.tmpx = tmpx;
    }

    public int getTmpy() {
        return tmpy;
    }

    public void setTmpy(int tmpy) {
        this.tmpy = tmpy;
    }

    public boolean isTempOrient() {
        return tempOrient;
    }

    public void setTempOrient(boolean tempOrient) {
        this.tempOrient = tempOrient;
    }

    public int getHitCounter() {
        return hitCounter;
    }

    public void setHitCounter(int hitCounter) {
        this.hitCounter = hitCounter;
    }

    public String getPlr() {
        return plr;
    }

    public void setPlr(String plr) {
        this.plr = plr;
    }

    public boolean placeShip(int lng) {//sinartisi pou vlepei an einai valid i 8esi gia na mpei to ploio

        Random rand = new Random();
        boolean z = rand.nextBoolean();
        int x;
        int y;
        if (z == true) {
            x = rand.nextInt(10 - lng); //elenxei ta oria simfwna me to orientation
            y = rand.nextInt(10);
            for (int i = x; i < x + lng; i++) {
                if (cpuGrid.getInnerCells()[y][i].isEnabled() == true) { //an iparxei allo ploio epistrefei me false gia na ksanakalestei
                    return false;
                }


            }
        } else {
            x = rand.nextInt(10);
            y = rand.nextInt(10 - lng);//elenxei ta oria simfwna me to orientation
            for (int i = y; i < y + lng; i++) {
                if (cpuGrid.getInnerCells()[i][x].isEnabled() == true) {//an iparxei allo ploio epistrefei me false gia na ksanakalestei
                    return false;
                }

            }
        }

        setTmpx(x);
        setTmpy(y);
        setTempOrient(z);
        return true; // an ola swsta epistrefei tis times pou 8a mpei to ploio

    }
}

        
