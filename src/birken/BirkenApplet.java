package birken;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BirkenApplet extends JApplet implements ActionListener{

	
	/**
	 * stian 8090
	 * mikal 20013
	 * thomas 19555
	 * ole 9029
	 */
	private static final long serialVersionUID = 1L;
	
	private TextField oneStartnr,twoStartnr;
	private TextArea window1, window2, window3;
	private Label label1;
	private Button b1;
	private JPanel pane = new JPanel();
	
	
	
	public BirkenApplet() {
		setSize(600, 500);
		pane.setSize(500, 500);
		getContentPane().add(pane);
		setPreferredSize(new Dimension(500,500));
		label1 = new Label("Please enter startnumbers : ");
		pane.add(label1);
		oneStartnr = new TextField(5);
		twoStartnr = new TextField(5);
		pane.add(oneStartnr);
		pane.add(twoStartnr);
		b1 = new Button("Compare");
		b1.addActionListener(this);
		pane.add(b1);
		window1 = new TextArea(10,35);
		window2 = new TextArea(10,35);
		window3 = new TextArea(10,74);
		pane.add(window1);
		pane.add(window2);
		pane.add(window3);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			Main m = new Main(Integer.parseInt(oneStartnr.getText()),Integer.parseInt(twoStartnr.getText()));
			window1.setText(m.getPerson(1).getSum().toString());
			window2.setText(m.getPerson(2).getSum().toString());
			window3.setText(m.toString());
//			oneStartnr.setText("");
//			twoStartnr.setText("");
		}
		catch(NumberFormatException err){
			err.printStackTrace();
		}
	} 
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Comparing times in Birken");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 500);
		frame.getContentPane().add(new BirkenApplet());
		Dimension sd = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((sd.width-600)/2, (sd.height-500)/2);
		frame.setVisible(true);
	}

}
