import javax.swing.*;
import java.awt.*;

public class display extends JFrame
{
	public panel p;
	
	public display(boolean censored, boolean emerald)
	{
		p = new panel(censored, emerald);
	
		//this.setSize(638, 576);
		this.setSize(654, 615);
		this.add(p);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true); 
        this.addKeyListener(p);
	}
}