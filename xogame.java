import java.util.Scanner;
import javax.swing.*;

//import jdk.internal.jshell.tool.resources.version;

import java.awt.*;
import java.awt.event.*;

public class xogame{

  public static void startgame(){
    Board a = new Board();
    //System.out.println(a.board[15][1]);
    System.out.println("Welcome to the XO game! (Tic Tac Toe)");
    a.setup();
    a.setuppupdatelabel();
    a.pickPosition();

  }
  public static void main(String[] args) {
    startgame();
  }
}

class drawing extends Canvas{
    public void paint(Graphics g) {
        // 1st rows
        g.drawRect(10,10,120,160);
        g.drawRect(130,10,120,160);
        g.drawRect(250,10,120,160);
        g.drawRect(370,10,120,160);

        // 2nd rows
        g.drawRect(10,170,120,160);
        g.drawRect(130,170,120,160);
        g.drawRect(250,170,120,160);
        g.drawRect(370,170,120,160);

        // 3rd rows
        g.drawRect(10,330,120,160);
        g.drawRect(130,330,120,160);
        g.drawRect(250,330,120,160);
        g.drawRect(370,330,120,160);

        // 4th rows
        g.drawRect(10,490,120,160);
        g.drawRect(130,490,120,160);
        g.drawRect(250,490,120,160);
        g.drawRect(370,490,120,160);

    }
}

class inputProcessor {

  public String mode;
  public int number;

  public void setNum() {
    Scanner inpn = new Scanner(System.in);
    while ( true ) {
      try {
        System.out.println("Where do you want to place: ");
        number = inpn.nextInt();
        inputChecker();
        break;
      } catch (Exception e){
        System.out.println("Please enter a number");
        inpn.next();
      }
    }
  }

  public boolean inputChecker() {
    if ( 0<number && number<10 ) {
      return true;
    } else {
      return false;
    }
  }

  public int getNum() {
    if ( inputChecker() == true );
      return number;
  }
}


class Board {
  public String[][] board = {{"0","1"},{"1","2"},{"2","3"},{"3","4"},{"4","5"},{"5","6"},{"6","7"},{"7","8"},{"8","9"},{"9","10"},{"10","11"},{"11","12"},{"12","13"},{"13","14"},{"14","15"},{"15","16"}};
  //public String[][] board = {{"0","1","2","3"},{"4","5","6","7"},{"8","9","10","11"},{"12","13","14","15"}};
  public int turn_count = 0;
  public String player = "X";
  public JFrame f;
  public JLabel l_0;
  public JLabel l_1;
  public JLabel l_2;
  public JLabel l_3;
  public JLabel l_4;
  public JLabel l_5;
  public JLabel l_6;
  public JLabel l_7;
  public JLabel l_8;
  public JLabel l_9;
  public JLabel l_10;
  public JLabel l_11;
  public JLabel l_12;
  public JLabel l_13;
  public JLabel l_14;
  public JLabel l_15;
  public JLabel l_16;
  inputProcessor r = new inputProcessor();

  public void setup() {
    f = new JFrame("XO Game");
    drawing d = new drawing();

        // l_0
        JLabel l_0 = new JLabel();
        l_0.setBounds(35,40,90,100);
        l_0.setFont(new Font("Sample glyphs",Font.BOLD, 50));

        // l_1
        JLabel l_1 = new JLabel();
        l_1.setBounds(155,40,90,100);
        l_1.setFont(new Font("Sample glyphs",Font.BOLD, 50));

        // l_2
        JLabel l_2 = new JLabel();
        l_2.setBounds(275,40,90,100);
        l_2.setFont(new Font("Sample glyphs",Font.BOLD, 50));

        // l_3
        JLabel l_3 = new JLabel();
        l_3.setBounds(395,40,90,100);
        l_3.setFont(new Font("Sample glyphs",Font.BOLD, 50));

        // l_4
        JLabel l_4 = new JLabel();
        l_4.setBounds(35,200,90,100);
        l_4.setFont(new Font("Sample glyphs",Font.BOLD, 50));

        // l_5
        JLabel l_5 = new JLabel();
        l_5.setBounds(155,200,90,100);
        l_5.setFont(new Font("Sample glyphs",Font.BOLD, 50));

        // l_6
        JLabel l_6 = new JLabel();
        l_6.setBounds(275,200,90,100);
        l_6.setFont(new Font("Sample glyphs",Font.BOLD, 50));

        // l_7
        JLabel l_7 = new JLabel();
        l_7.setBounds(395,200,90,100);
        l_7.setFont(new Font("Sample glyphs",Font.BOLD, 50));

        // l_8
        JLabel l_8 = new JLabel();
        l_8.setBounds(35,360,90,100);
        l_8.setFont(new Font("Sample glyphs",Font.BOLD, 50));

        // l_9
        JLabel l_9 = new JLabel();
        l_9.setBounds(155,360,90,100);
        l_9.setFont(new Font("Sample glyphs",Font.BOLD, 50));

        // l_10
        JLabel l_10 = new JLabel();
        l_10.setBounds(275,360,90,100);
        l_10.setFont(new Font("Sample glyphs",Font.BOLD, 50));

        // l_11
        JLabel l_11 = new JLabel();
        l_11.setBounds(395,360,90,100);
        l_11.setFont(new Font("Sample glyphs",Font.BOLD, 50));

        // l_12
        JLabel l_12 = new JLabel();
        l_12.setBounds(35,520,90,100);
        l_12.setFont(new Font("Sample glyphs",Font.BOLD, 50));

        // l_13
        JLabel l_13 = new JLabel();
        l_13.setBounds(155,520,90,100);
        l_13.setFont(new Font("Sample glyphs",Font.BOLD, 50));

        // l_14
        JLabel l_14 = new JLabel();
        l_14.setBounds(275,520,90,100);
        l_14.setFont(new Font("Sample glyphs",Font.BOLD, 50));

        // l_15
        JLabel l_15 = new JLabel();
        l_15.setBounds(395,520,90,100);
        l_15.setFont(new Font("Sample glyphs",Font.BOLD, 50));

        f.add(l_0);f.add(l_1);f.add(l_2);f.add(l_3);
        f.add(l_4);f.add(l_5);f.add(l_6);f.add(l_7);
        f.add(l_8);f.add(l_9);f.add(l_10);f.add(l_11);
        f.add(l_12);f.add(l_13);f.add(l_14);f.add(l_15);

        f.add(d);
        f.setSize(510,710);
        f.setVisible(true);
        f.setLayout(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


  }
        public void setuppupdatelabel(){

        l_0.setText(board[0][1]);l_1.setText(board[1][1]);l_2.setText(board[2][1]);l_3.setText(board[3][1]);
        l_4.setText(board[4][1]);l_5.setText(board[5][1]);l_6.setText(board[6][1]);l_7.setText(board[7][1]);
        l_8.setText(board[8][1]);l_9.setText(board[9][1]);l_10.setText(board[10][1]);l_11.setText(board[11][1]);
        l_12.setText(board[12][1]);l_13.setText(board[13][1]);l_14.setText(board[14][1]);l_15.setText(board[15][1]);
        
    }


  public void pickPosition() {
    while ( checkWin() == false ){
      try {
        r.setNum();
        int pos = r.getNum();
        if ( !(board[pos-1][1].equals("X")) && !(board[pos-1][1].equals("O")) ) {
          board[pos-1][1] = player;
          changePlayer();
          //displayBoard();
          //updateboard();

          setuppupdatelabel();

          turn_count = turn_count + 1;
        } else {
          System.out.println("Please enter number that is not taken");
      }
      }catch(Exception e){
        System.out.println("Please enter number between 1-9");
      }
    }
  }

  public void changePlayer() {
    if ( player == "X"){
      player = "O";
    }
    else if ( player == "O" ){
      player = "X";
    }
  }

  public boolean checkWin() {
    if (board[0][1].equals(board[1][1]) && board[1][1].equals(board[2][1])){
      if (board[0][1] == "X"){
        System.out.println("\n=========");
        System.out.println("X Win");
        System.out.println("=========");
        return true;
      }else{
        System.out.println("\n=========");
        System.out.println("O Win");
        System.out.println("=========");
        return true;
      }
    }
    if (board[3][1].equals(board[4][1]) && board[4][1].equals(board[5][1])){
      if (board[3][1] == "X"){
        System.out.println("\n=========");
        System.out.println("X Win");
        System.out.println("=========");
        return true;
      }else{
        System.out.println("\n=========");
        System.out.println("O Win");
        System.out.println("=========");
        return true;
      }
    }
    if (board[6][1].equals(board[7][1]) && board[7][1].equals(board[8][1])){
      if (board[6][1] == "X"){
        System.out.println("\n=========");
        System.out.println("X Win");
        System.out.println("=========");
        return true;
      }else{
        System.out.println("\n=========");
        System.out.println("O Win");
        System.out.println("=========");
        return true;
      }
    }
    if (board[0][1].equals(board[3][1]) && board[3][1].equals(board[6][1])){
      if (board[0][1] == "X"){
        System.out.println("\n=========");
        System.out.println("X Win");
        System.out.println("=========");
        return true;
      }else{
        System.out.println("\n=========");
        System.out.println("O Win");
        System.out.println("=========");
        return true;
      }
    }
    if (board[1][1].equals(board[4][1]) && board[4][1].equals(board[7][1])){
      if (board[1][1] == "X"){
        System.out.println("\n=========");
        System.out.println("X Win");
        System.out.println("=========");
        return true;
      }else{
        System.out.println("\n=========");
        System.out.println("O Win");
        System.out.println("=========");
        return true;
      }
    }
    if (board[2][1].equals(board[5][1]) && board[5][1].equals(board[8][1])){
      if (board[2][1] == "X"){
        System.out.println("\n=========");
        System.out.println("X Win");
        System.out.println("=========");
        return true;
      }else{
        System.out.println("\n=========");
        System.out.println("O Win");
        System.out.println("=========");
        return true;
      }
    }
    if (board[0][1].equals(board[4][1]) && board[4][1].equals(board[8][1])){
      if (board[0][1] == "X"){
        System.out.println("\n=========");
        System.out.println("X Win");
        System.out.println("=========");
        return true;
      }else{
        System.out.println("\n=========");
        System.out.println("O Win");
        System.out.println("=========");
        return true;
      }
    }
    if (board[2][1].equals(board[4][1]) && board[4][1].equals(board[6][1])){
      if (board[2][1] == "X"){
        System.out.println("\n=========");
        System.out.println("X Win");
        System.out.println("=========");
        return true;
      }else{
        System.out.println("\n=========");
        System.out.println("O Win");
        System.out.println("=========");
        return true;
      }
    }
    if ( turn_count == 9 ){
      System.out.println("\n=========");
      System.out.println("IS A DRAW");
      System.out.println("=========");
      return true;
    }else{
      return false;
    }
  }
}
