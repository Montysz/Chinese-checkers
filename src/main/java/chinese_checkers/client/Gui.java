package chinese_checkers.client;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Gui {
	
	public static void main(String[] args) {
		new Gui();
	}

	Gui(){
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
	
		panel.setBorder(BorderFactory.createEmptyBorder());
	}


}
