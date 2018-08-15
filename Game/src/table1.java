import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class table1	extends Abstact2DDrawing {
	int p1;
	int q1;
	int count;
	int countturn;
	int[] d1 = new int[1000];
	int[] a1 = new int[1000];
	int[] a2 = new int[1000];
	int[] m1 = new int[1000];
	int[] m2 = new int[1000];
	int in=0;
	int[] health1 = new int[1000];
	int healtha1=17;
	int[] hit1 = new int[1000];
	int[] miss1 = new int[1000];
	int hita1 = 0;
	int missa1 = 0;
	private boolean ships = true;
	public void setships(boolean b)
	{
		ships = b;
	}
	void getdirection(int d)
	{
		d1[count]=d;
	}
	public table1(int x1, int y1) {
		super(x1, y1);
	}
	void draw1(Graphics g) 
	{
		g.setColor(Color.black);
		g.fillRect(x, y, 400, 400);
		g.setColor(Color.WHITE);
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				g.fillRect(2+x+i*40, 2+y+j*40, 35, 35);
			}
		}
		if(0<=count&&count<5)
		{
			for(int i=0;i<=count;i++)
			{
				drawship1(g,a1[i],a2[i],i,d1[i]);
			}
		}
	}
	void drawship1(Graphics g,int x,int y,int z1,int d)
	{
		int[] z = new int[1000];
		z[0]=5;
		z[1]=4;
		z[2]=3;
		z[3]=3;
		z[4]=2;
		if(ships)
		{
		g.setColor(Color.WHITE);
		}
		else
		{
		g.setColor(Color.BLUE);
		}
		if(d==1)
		{
			for(int a1=0;a1<z[z1];a1++)
			{
				g.fillRect(2+10+(x+a1)*40, 2+10+y*40, 35, 35);
			}
		}
		else if(d==0)
		{
			for(int a1=0;a1<z[z1];a1++)
			{
				g.fillRect(2+10+x*40, 2+10+(y+a1)*40, 35, 35);
			}
		}
	}
	void getxy1(int x1,int y1,int i)
	{
		p1=x1-1;
		q1=y1-1;
		if(i<5)
		{
			a1[i]=p1;
			a2[i]=q1;
			count=i;
			System.out.println("you set the ship coordines at :"+a1[i]+" "+a2[i]);
		}
	}
	void drawa1(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(x, y, 400, 400);
		g.setColor(Color.WHITE);
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				g.fillRect(2+x+i*40, 2+y+j*40, 35, 35);
			}
		}
		for(int i=1;i<=countturn;i++)
		{
			attack1(g,m1[i],m2[i]);
		}
		healtha1 = healtha1-health1[countturn];
		if(healtha1==0)
		{
			System.out.println("<game over,player win>");
		}
		if(m1[countturn]>0&&m2[countturn]>0)
		{
			hita1 = hita1+hit1[countturn];
			missa1 = missa1+miss1[countturn];
		}
		System.out.println("player hits:"+hita1+" miss:"+missa1);
	}
	void attack1(Graphics g,int x,int y)
	{
		if(ships)
		{
		g.setColor(Color.WHITE);
		}
		else
		{
			inside1(x,y);
			if(in==1)
			{
				g.setColor(Color.PINK);
				in=0;
				health1[countturn]=1;
				hit1[countturn]=1;
				miss1[countturn]=0;
			}
			else
			{
				g.setColor(Color.GRAY);
				health1[countturn]=0;
				hit1[countturn]=0;
				miss1[countturn]=1;
			}
		}
		g.fillRect(2+10+x*40, 2+10+y*40, 35, 35);
	}
	void getxya1(int x1,int y1,int i)
	{
		p1=x1-1;
		q1=y1-1;
		m1[i]=p1;
		m2[i]=q1;
		countturn=i;
		
	}
	void inside1(int x,int y)
	{
		checkshipa1(x,y);
		checkshipa2(x,y);
		checkshipa3(x,y);
		checkshipa4(x,y);
		checkshipa5(x,y);
	}
	void checkshipa1(int x,int y)
	{
		if(d1[0]==1)
		{
			Rectangle r1 = new Rectangle(a1[0],a2[0],5,1);
			boolean aq = r1.contains(x,y);
			if(aq)
			{
				in=1;
			}
		}
		else
		{
			Rectangle r1 = new Rectangle(a1[0],a2[0],1,5);
			boolean aq = r1.contains(x,y);
			if(aq)
			{
				in=1;
			}
		}
	}
	void checkshipa2(int x,int y)
	{
		if(d1[1]==1)
		{
			Rectangle r2 = new Rectangle(a1[1],a2[1],4,1);
			boolean aq = r2.contains(x,y);
			if(aq)
			{
				in=1;
			}
		}
		else
		{
			Rectangle r2 = new Rectangle(a1[1],a2[1],1,4);
			boolean aq = r2.contains(x,y);
			if(aq)
			{
				in=1;
			}
		}
	}
	void checkshipa3(int x,int y)
	{
		if(d1[2]==1)
		{
			Rectangle r3 = new Rectangle(a1[2],a2[2],3,1);
			boolean aq = r3.contains(x,y);
			if(aq)
			{
				in=1;
			}
		}
		else
		{
			Rectangle r3 = new Rectangle(a1[2],a2[2],1,3);
			boolean aq = r3.contains(x,y);
			if(aq)
			{
				in=1;
			}
		}
	}
	void checkshipa4(int x,int y)
	{
		if(d1[3]==1)
		{
			Rectangle r4 = new Rectangle(a1[3],a2[3],3,1);
			boolean aq = r4.contains(x,y);
			if(aq)
			{
				in=1;
			}
		}
		else
		{
			Rectangle r4 = new Rectangle(a1[3],a2[3],1,3);
			boolean aq = r4.contains(x,y);
			if(aq)
			{
				in=1;
			}
		}
	}
	void checkshipa5(int x,int y)
	{
		if(d1[4]==1)
		{
			Rectangle r5 = new Rectangle(a1[4],a2[4],2,1);
			boolean aq = r5.contains(x,y);
			if(aq)
			{
				in=1;
			}
		}
		else
		{
			Rectangle r5 = new Rectangle(a1[4],a2[4],1,2);
			boolean aq = r5.contains(x,y);
			if(aq)
			{
				in=1;
			}
		}
	}
	void draw2(Graphics g) {
	}
}
