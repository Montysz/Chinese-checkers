package chinese_checkers.client;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.*;

public class Gui2 implements ActionListener
{
	JTextField fullName;
	PrintWriter out;	
	Gui2(Socket socket)		
	{		
		try
		{
			out = new PrintWriter(socket.getOutputStream());
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		JFrame jfrm = new JFrame("Ready State");
		jfrm.setSize(250, 250);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fullName = new JTextField(10);
		fullName.setText("not ready");
		
		JPanel submitPane = new JPanel();
		JButton submitButton = new JButton("Ready");
		submitButton.addActionListener(this);
		submitPane.add(submitButton);
		jfrm.add(submitPane,BorderLayout.NORTH);
		
		JPanel outFieldPane= new JPanel();
		outFieldPane.add(new JLabel("You are"));
		outFieldPane.add(fullName);
		jfrm.add(outFieldPane,BorderLayout.AFTER_LAST_LINE);
		jfrm.setVisible(true);
	}
		
	public void actionPerformed(ActionEvent e)
	{
			fullName.setText("ready");
	        ready();
	}
	
    public String ready()
    {
    	out.println("readyButton");
    	out.flush();
    	return "ready";
    }
    /*
	public static void main(String[] args)
	{
		new Gui2(null);  
	}
	*/
}