import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Scanner;

import javax.swing.event.MouseInputAdapter;

public class lightlistener extends MouseInputAdapter {
	int count=0;
	int countturn;
	private picture picture;
	private boolean lightOn = true;
	public lightlistener(picture p)
	{
		picture = p;
	}
	Point p1;
	public void mousePressed(MouseEvent e)
	{
		p1=e.getPoint();
		p1.x=p1.x-10;
		p1.y=p1.y-40;
		int x1=-1;
		int y1=-1;
		int x2=-1;
		int y2=-1;
		for(int i=0;i<10;i++)
		{
			if(2+10+i*40<p1.x&&p1.x<2+10+i*40+35)
			{
				x1=i+1;	
			}
		}
		for(int j=0;j<10;j++)
		{
			if(2+10+j*40<p1.y&&p1.y<2+10+j*40+35)
			{
				y1=j+1;
			}
		}
		for(int i=0;i<10;i++)
		{
			if(2+510+i*40<p1.x&&p1.x<2+510+i*40+35)
			{
				x2=i+1;	
			}
		}
		for(int j=0;j<10;j++)
		{
			if(2+10+j*40<p1.y&&p1.y<2+10+j*40+35)
			{
				y2=j+1;
			}
		}
		Scanner in = new Scanner(System.in);	
		countturn=count-11;
		int[] z = new int[1000];
		picture.getcount(count,countturn);
		if(0<=count&&count<5)
		{
			System.out.println(" please enter the direction of the boat,press 1 for horizontal,0 for verical");
			z[count]=in.nextInt();
			picture.a.getxy1(x1,y1,count);
			picture.a.getdirection(z[count]);
		}
		else if(5<count&&count<11)
		{
			System.out.println(" please enter the direction of the boat,press 1 for horizontal,0 for verical");
			z[count]=in.nextInt();
			picture.b.getxy2(x2, y2,count);	
			picture.b.getdirection(z[count]);
		}
		else if(countturn>=0)
		{
			picture.a.getxya1(x1, y1, countturn);
			picture.b.getxya2(x2, y2, countturn);
		}
		lightOn=false;
		picture.setships(lightOn);
		picture.repaint();	
		count++;
	}
}
