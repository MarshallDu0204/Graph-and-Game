import java.awt.Graphics;

import javax.swing.JComponent;

public class picture extends JComponent{
	table a = new table(10, 10);
	table b = new table(510, 10);
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
		else if(count>=5&&count<11)
		{
		b.draw2(g);
		}
		if(countturn>=0)
		{
			a.drawa1(g);
			b.drawa2(g);
		}
	}
	public void setships(boolean l)
	{
		if(0<=count&&count<5)
		{
		a.setships(l);
		}
		else if(count>=5&&count<11)
		{
		b.setships(l);
		}
	}
}
