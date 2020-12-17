package chinese_checkers.client;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JFrame;

import chinese_checkers.Exceptions.wrongNumberOfPlayersException;
import chinese_checkers.serwer.Board;


public class Draw extends JFrame implements MouseListener{
private Board currentBoard;
private int xSize;
private int ySize;
private PrintWriter out;
private Socket socket;
 
	public Draw(Board board, Socket socket) 
	{	
		   this.socket = socket;
		   try
		   {
			   this.out = new PrintWriter(socket.getOutputStream());
		   }
		   catch (IOException e)
		   {
			e.printStackTrace();
		   }
	       setSize(1000, 1000);
	       this.currentBoard = board;      
	       addMouseListener(this);
	       this.setVisible(true);
	       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       this.setAlwaysOnTop(true);
	       this.setResizable(false);
	}

    public void paint(Graphics g)
    {
        drawBoard(g, this.currentBoard);
        drawPlayers(g, this.currentBoard);
    }

    public void drawBoard(Graphics g, Board gameboard)
    { 	
    	Image img= createImage(getSize().width, getSize().height);
        Graphics2D g2= (Graphics2D)img.getGraphics(); 
        for(int i=0;i<17;i++)
        {
            for(int j=0; j<13;j++)
            {
                int r = 50;
                if(gameboard.getBoard()[i][j].getPlayerId() != -1)
                {                  
                    //g2.setColor(Color.blue);                         
                    //g2.fillRect(j+r+j*r+(i%2)*r/2, i+r+i*r, r , r);                     
                }
            }
        }     
        g.drawImage(img, 0, 0, this);
    	}
    public void drawPlayers(Graphics g, Board gameboard) {
    	Image img= createImage(getSize().width, getSize().height);
        Graphics2D g2= (Graphics2D)img.getGraphics();
        for(int i=0;i<17;i++)
        {
            for(int j=0; j<13;j++)
            {
                int r = 50;
                switch(gameboard.getBoard()[i][j].getPlayerId())
                {
                    
                	case -1:
                        g2.setColor(Color.black);
                        g2.fillOval(j+r+j*r+(i%2)*r/2, i+r+i*r, r , r); 
                        break;
                    case 0:
                        g2.setColor(Color.white);
                        g2.fillOval(j+r+j*r+(i%2)*r/2, i+r+i*r, r , r);                                         
                        break;  
                    case 1:
                        g2.setColor(Color.red);                         
                        g2.fillOval(j+r+j*r+(i%2)*r/2, i+r+i*r, r , r); 
                        break;  
                    case 2:
                        g2.setColor(Color.pink);
                        g2.fillOval(j+r+j*r+(i%2)*r/2, i+r+i*r, r , r);                                   
                        break;
                    case 3:
                        g2.setColor(Color.green);
                        g2.fillOval(j+r+j*r+(i%2)*r/2, i+r+i*r, r , r); 
                        break;
                    case 4:
                        g2.setColor(Color.blue);
                        g2.fillOval(j+r+j*r+(i%2)*r/2, i+r+i*r, r , r);                                         
                        break;  
                    case 5:
                        g2.setColor(Color.yellow);
                        g2.fillOval(j+r+j*r+(i%2)*r/2, i+r+i*r, r , r);                                           
                        break;  
                    case 6:
                        g2.setColor(Color.CYAN);
                        g2.fillOval(j+r+j*r+(i%2)*r/2, i+r+i*r, r , r);                                          
                        break; 

            }
       }
     }
        g.drawImage(img, 0, 0, this);
    }
   
    
    public int  fieldC = 0;
    public	String xold = "x";
	public String yold = "y";
    public void Field(int x, int y)
      {   	

    	if(((y/50 - 1) % 2 )  ==  1  ) {
    		 x = x - 25;   		 		 
    		 String x1 = Integer.toString(((x/50) - 1));
    		 String y1 = Integer.toString((y/50 - 1));
    		 //System.out.println(((x/50) - 1) +" "+ ((y/50 - 1)) );
       		 if(fieldC == 1){  			 
    			 fieldC = 0;
    			 out.println("mouse ".concat(xold + " ").concat(yold + " ").concat(x1 + " ").concat(y1));
				 out.flush(); 
    		 }
    		 else {
    			 fieldC = 1;
    			 xold = x1;
    			 yold = y1;
    			 return;
    		 }
    		 
    	 }
    	 else {
    		 String x1 = Integer.toString(((x/50) - 1));
    		 String y1 = Integer.toString((y/50 - 1));
    		 //System.out.println(((x/50) - 1) +" "+ ((y/50 - 1)) );
    		 if(fieldC == 1){  			 
    			 fieldC = 0;
    			 //System.out.print(x1.concat(y1).concat(xold).concat(yold)+ "\n");
    			 out.println("mouse ".concat(xold + " ").concat(yold + " ").concat(x1 + " ").concat(y1));
    			 out.flush(); 
    		
    		 }
    		 else {
    			 fieldC = 1;
    			 xold = x1;
    			 yold = y1;
    			return;
    		 }
    	 }   	    
      }
          
     public void mouseClicked(MouseEvent e) 
    {
         
         
    }	 
	public void mousePressed(MouseEvent e) {
		Field(e.getX(), e.getY());
		//System.out.print("\n press:"+  fieldC +"\n");
	}

	public void mouseReleased(MouseEvent e) {
		Field(e.getX(), e.getY()); 
		//System.out.print("\n reelased:"+  fieldC +"\n");

	}
	
	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
	}
	
	public void getCurrentBoard(Board gameBoard)
	{
		this.currentBoard = gameBoard;
		repaint();
	}
}