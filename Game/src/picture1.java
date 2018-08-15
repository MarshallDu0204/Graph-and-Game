import java.awt.Graphics;

import javax.swing.JComponent;

public class picture1 extends JComponent {
	table1 a = new table1(10,10);
	int count;
	int countturn;
	void getcount(int c,int d)
	{
		count = c;
		countturn =d;
		System.out.println("turnnumber:"+countturn);
	}
	protected void paintComponent(Graphics g)
	{
		if(0<=count&&count<5)
		{
		a.draw1(g);
		}
		if(countturn>=0)
		{
			a.drawa1(g);
		}
	}
	public void setships(boolean l)
	{
		if(0<=count&&count<5)
		{
		a.setships(l);
		}
	}
}
