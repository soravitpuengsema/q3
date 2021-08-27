import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;


public class xogame{

  public static void startgame(){
    Board a = new Board();
    a.choosemode();

  }
  public static void main(String[] args) {
    startgame();
  }
}

class drawing extends Canvas {
  int u;
  drawing(int n){
    u = n;
  }
  public void paint(Graphics g) {
    for ( int i = 0 ; i < 600 ; i += 600/u ){  
      for ( int j = 0 ; j < 600 ; j += 600/u ){
        g.drawRect( i , j , 600/u , 600/u );
      }
    }
  }
}

class Board implements MouseListener{
  public JFrame f;
  public String[][] board;
  public int turn_count = 0;
  public String player = "X";
  public int n;
  public JLabel[] label;

  public void createboard() {
    //r.setMode();
    //int n = r.getMode();
    board = new String[n][n];
    int k = 0;
    for (int i = 0 ; i < n ; i++){
      for ( int j = 0 ; j < n ; j++){
        board[i][j] = String.valueOf(k+1);
        k++;
      }
    }

    /*for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        String temp = board[i][j];
        board[i][j] = board[j][i];
        board[j][i] = temp;
      }*/


  }

  public void choosemode(){

    JFrame nm = new JFrame("setsize_board");  
    JTextField tf =new JTextField();
    tf.setBounds(160, 80, 140, 30);
    tf.setFont(new Font("Sample glyphs",Font.BOLD, 20));            
    JButton start = new JButton("Start");
    start.setBounds(70, 70, 80, 50);    
    JLabel how = new JLabel("How many number for n*n?");
    how.setFont(new Font("Sample glyphs",Font.BOLD, 20));
    how.setBounds(60, 10, 400, 50);
    
    nm.add(how);
    nm.add(start);
    nm.add(tf); 
    nm.setSize(400,200);    
    nm.setLayout(null);    
    nm.setVisible(true);
    nm.setResizable(false);
    nm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    start.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e){  
        String size = tf.getText();  
        n = Integer.parseInt(size);
        createboard();
        setup();
        nm.setVisible(false);
      }  
    });    
  }

  public void setup() {

    f = new JFrame("Sorting_Game");
    drawing d = new drawing(n);
    //f.add(d);
    label = new JLabel[n*n];
    int k = 0;
    for ( int i = 0 ; i < 600 ; i += 600/n ){
      for ( int j = 0 ; j < 600 ; j += 600/n ){
        label[k] = new JLabel();
        label[k].setBounds( j+(n*3), i+(n*3) , 75 , 75 );
        label[k].setFont(new Font("Sample glyphs",Font.BOLD, 550/(n*3)));
        label[k].setText(board[i/(600/n)][j/(600/n)]);
        f.add(label[k]);
        k += 1;
      }
    }
    

    f.add(d);

    d.addMouseListener(this);

    f.setSize(615,640);
    f.setVisible(true);
    f.setLayout(null);
    f.setResizable(false);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //String bt = "bt";
    //int k = 0;

  }

  public void changeboard(){

    int k = 0;
    for ( int i = 0 ; i < 600 ; i += 600/n ){
      for ( int j = 0 ; j < 600 ; j += 600/n ){
        label[k].setText(board[i/(600/n)][j/(600/n)]);
        //f.add(label[k]);
        k += 1;
      }
    }
  }

  @Override
  public void mouseReleased(MouseEvent ev) {
    try{
      int mY = ev.getY() / (600/n);
      int mX = ev.getX() / (600/n);
      if (!(board[mY][mX].equals("X")) && !(board[mY][mX].equals("O"))){
        board[mY][mX] = player;
        changePlayer();
        turn_count += 1;
      }
      changeboard();
      System.out.println(turn_count);
      if ( checkwin() == true ){
        f.getContentPane().removeAll();
        f.repaint();
        changePlayer();
        JLabel win = new JLabel(player + " WIN!");
        win.setFont(new Font("Sample glyphs",Font.BOLD, 90));
        win.setBounds(150, 200, 400, 100);
        f.add(win);

        return;
        }
      if (turn_count == n*n){
        f.getContentPane().removeAll();
        f.repaint();
        JLabel draw = new JLabel("Is A DRAW!");
        draw.setFont(new Font("Sample glyphs",Font.BOLD, 70));
        draw.setBounds(120, 200, 400, 100);
        f.add(draw);
        return;
      }
    }
    catch(Exception e){
    }
  }

  @Override
  public void mousePressed(MouseEvent mouseEvent) {

  }

  @Override
  public void mouseClicked(MouseEvent mouseEvent) {

  }

  @Override
  public void mouseEntered(MouseEvent mouseEvent) {

  }

  @Override
  public void mouseExited(MouseEvent e) {}

  public void changePlayer() {
    if ( player == "X"){
      player = "O";
    }
    else if ( player == "O" ){
      player = "X";
    }
  }

  public boolean checkwin() {
    String[] checker = new String[n];
        for (int i = 0 ; i < n ; i++ ){
            if( player.equals("X") ){
                checker[i] = "O";
            }
            else{
                checker[i] = "X";
            }
        }
        String[] ltor = new String[n];
        String[] rtol = new String[n];
        
        for ( int i = 0 ; i < n ; i++ ){
            if(Arrays.deepEquals( checker, board[i] )){
                return true;
            }
            String[] temp = new String[n];
            for ( int j=0 ; j<n ; j++ ){
                temp[j] = board[j][i];
            }
            if( Arrays.deepEquals(checker, temp) ){
                return true;
            }
            ltor[i] = board[i][i];
            rtol[i] = board[i][(n-1)-i];
        }
        if( Arrays.deepEquals( checker, ltor ) || Arrays.deepEquals( checker, rtol ) ){
            return true;
        }
        return false;
  }
}