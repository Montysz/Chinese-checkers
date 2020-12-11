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
import chinese_checkers.serwer.Tile;


public class Draw extends JFrame implements MouseListener{
private Board currentBoard;
 public static void main(String[] args) 
    {
	 	Board Tmp = null;
    	try {
			Tmp = new Board(6);
		} 
    	catch (wrongNumberOfPlayersException e) {
			
			e.printStackTrace();
		}    	

    	Draw draw = new Draw(Tmp);
       draw.setVisible(true);
       draw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       draw.setAlwaysOnTop(true);//TODO: do wywalenia
       draw.setResizable(false);
    }

	private int numberOfPlayers = 6;
	//try catch
	//Board board = new Board(numberOfPlayers);


	private Board Tmp;
//	Tile a = Tmp.gameBoard[1][2];

	//zwraca int
//	int b = Tmp.gameBoard[1][2].getX();

	public Draw(Board board) {
		
		   setSize(500, 500);
	       this.currentBoard = board;
	       
	        addMouseListener(this);
	}


    public void paint(Graphics g)
    {
        drawBoard(g, this.currentBoard);
    }
    
    public void drawLine(Graphics2D g2)
    {
        for(int j=0; j<9; j++)
            {
                g2.setColor(Color.red);
                g2.fillRect(50, 50, 407, 407);
            }
        
    }
    
    public void drawBoard(Graphics g, Board gameboard)
    { 	
    	Image img= createImage(getSize().width, getSize().height);
        Graphics2D g2= (Graphics2D)img.getGraphics();
        drawLine(g2);
        
        for(int i=0;i<17;i++)
        {
            for(int j=0; j<13;j++)
            {
                
                switch(gameboard.getBoard()[i][j].getPlayerId())
                {
                    case -1:
                        g2.setColor(Color.black);
                        g2.fillRect(j+50+j*50, i+50+i*50, 50, 50);
                        break;
                    case 1:
                        g2.setColor(Color.red); 
                         
                 
                            
                        g2.fillRect(j+50+j*50, i+50+i*50, 50, 50);
                        break;  
                    case 2:
                        g2.setColor(Color.black);
                        g2.fillRect(j+50+j*50, i+50+i*50, 50, 50);
                        g2.setColor(Color.red);                                     
                        break;
                    case 3:
                        g2.setColor(Color.black);
                        g2.fillRect(j+50+j*50, i+50+i*50, 50, 50);
                        g2.setColor(Color.LIGHT_GRAY);
                        break;
                    case 4:
                        g2.setColor(Color.blue);
                        g2.fillRect(j+50+j*50, i+50+i*50, 50, 50);
                        g2.setColor(Color.red);                                             
                        break;    
                }
            }
        }
    }
    private int	xSize = 12;
    private int	ySize = 16;
     public void Field(int x, int y)
      {
        if(x > 50 && x < 450 && y > 50 && y < 450)
          {               
                setxSize(y/50-1);
                setySize(x/50-1);                
            //17 = y/50-1;
            //13 = ySize=x/50-1;   
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

	public int getxSize() {
		return xSize;
	}

	public void setxSize(int xSize) {
		this.xSize = xSize;
	}

	public int getySize() {
		return ySize;
	}

	public void setySize(int ySize) {
		this.ySize = ySize;
	}
	
}


