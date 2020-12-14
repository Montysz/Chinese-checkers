package chinese_checkers.client;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import chinese_checkers.Exceptions.wrongNumberOfPlayersException;
import chinese_checkers.serwer.Board;


public class Draw extends JFrame implements MouseListener{
private Board currentBoard;
private int xSize;
private int ySize;
 public static void main(String[] args) throws wrongNumberOfPlayersException 
    {	 	
	   Board Tmp = new Board(6);
       Draw draw = new Draw(Tmp);
       draw.setVisible(true);
       draw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       draw.setAlwaysOnTop(true);
       draw.setResizable(false);
    }

 
	public Draw(Board board) 
	{	
		   setSize(1000, 1000);
	       this.currentBoard = board;      
	       addMouseListener(this);
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
                    g2.setColor(Color.blue);                         
                    g2.fillRect(j+r+j*r+(i%2)*r/2, i+r+i*r, r , r);                     
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
     public void Field(int x, int y)
      {
        if(x > 50 && x < 450 && y > 50 && y < 450)
          {               
                setxSize((y/50-1));
                setySize((x/50-1));                 
          }
        }  
     
    public void mouseClicked1(MouseEvent e) 
    {
        Field(e.getX(), e.getY());       
        repaint();        
    }	 
    public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub	
	}

	public int getySize() {
		return ySize;
	}

	public void setySize(int ySize) {
		this.ySize = ySize;
	}

	public int getxSize() {
		return xSize;
	}

	public void setxSize(int xSize) {
		this.xSize = xSize;
	}
}