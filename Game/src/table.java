import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class table extends Abstact2DDrawing {
	int p1;
	int q1;
	int p2;
	int q2;
	int l;
	int[] d1 = new int[1000];
	int count;
	int countturn;
	int turn = 0;
	int[] a1 = new int[1000];
	int[] a2 = new int[1000];
	int[] b1 = new int[1000];
	int[] b2 = new int[1000];
	int[] m1 = new int[1000];
	int[] m2 = new int[1000];
	int[] n1 = new int[1000];
	int[] n2  =new int[1000];
	int in=0;
	int[] health1 = new int[1000];
	int[] health2 = new int[1000];
	int healtha1=17;
	int healtha2=17;
	int[] hit1 = new int[1000];
	int[] hit2 = new int[1000];
	int[] miss1 = new int[1000];
	int[] miss2 = new int[1000];
	int hita1 = 0;
	int hita2 = 0;
	int missa1 = 0;
	int missa2 = 0;
	private boolean ships = true;
	public void setships(boolean b)
	{
		ships = b;
	}
	public table(int x, int y) {
		super(x, y);
	}
	void getdirection(int d)
	{
		d1[count]=d;
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
	void draw2(Graphics g) {
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
		if(6<=count&&count<11)
		{
			for(int i=6;i<=count;i++)
			{
				drawship2(g,b1[i],b2[i],i,d1[i]);
			}
		}
	}
	void drawship2(Graphics g,int x,int y,int z1,int d)
	{
		int[] z = new int[1000];
		z[6]=5;
		z[7]=4;
		z[8]=3;
		z[9]=3;
		z[10]=2;
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
			g.fillRect(2+510+(x+a1)*40, 2+10+y*40, 35, 35);
		}
	}
	else if(d==0)
	{
		for(int a1=0;a1<z[z1];a1++)
		{
			g.fillRect(2+510+x*40, 2+10+(y+a1)*40, 35, 35);
		}
	}
	}
	void getxy2(int x1,int y1,int i)
	{
		p2=x1-1;
		q2=y1-1;
		if(5<i&&i<11)
		{
			b1[i]=p2;
			b2[i]=q2;
			count=i;
			System.out.println("you set the ship coordines at:"+b1[i]+" "+b2[i]);
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
			System.out.println("<game over,player 2 win>");
		}
		if(m1[countturn]>0&&m2[countturn]>0)
		{
			if(turn==1)
			{
				System.out.println("Please player 2 attack");
			}
			if(turn==2)
			{
				System.out.println("Please player 1 attack");
			}
			hita1 = hita1+hit1[countturn];
			missa1 = missa1+miss1[countturn];
		}
		System.out.println("player 2 hits:"+hita1+"player 2 miss:"+missa1);
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
				if(x>=0&&y>=0)
				{
					turn=1;
				}
			}
			else
			{
				g.setColor(Color.GRAY);
				health1[countturn]=0;
				hit1[countturn]=0;
				miss1[countturn]=1;
				if(x>=0&&y>=0)
				{
					turn=2;
				}
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
	void drawa2(Graphics g) {
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
			attack2(g,n1[i],n2[i]);
		}
		healtha2 = healtha2-health2[countturn];
		if(healtha2==0)
		{
			System.out.println("<game over,player 1 win>");
		}
		if(n1[countturn]>0&&n2[countturn]>0)
		{
			if(turn==1)
			{
				System.out.println("Please player 2 attack");
			}
			if(turn==2)
			{
				System.out.println("Please player 1 attack");
			}
			hita2 = hita2+hit2[countturn];
			missa2 = missa2+miss2[countturn];
		}
		System.out.println("player 1 hits:"+hita2+"player 1 miss:"+missa2);
	}
	void attack2(Graphics g,int x,int y)
	{
		if(ships)
		{
		g.setColor(Color.WHITE);
		}
		else
		{
			inside2(x,y);
			if(in==1)
			{
				g.setColor(Color.PINK);
				in=0;
				health2[countturn]=1;
				hit2[countturn]=1;
				miss2[countturn]=0;
				if(x>0&&y>0)
				{
					turn=2;
				}
			}
			else
			{
				g.setColor(Color.GRAY);
				health2[countturn]=0;
				hit2[countturn]=0;
				miss2[countturn]=1;
				if(x>0&&y>0)
				{
					turn=1;
				}
			}
		}
		g.fillRect(2+510+x*40, 2+10+y*40, 35, 35);
	}
	void getxya2(int x1,int y1,int i)
	{
		p2=x1-1;
		q2=y1-1;
		n1[i]=p2;
		n2[i]=q2;
		countturn=i;
	}
	void inside2(int x,int y)
	{
		checkshipb1(x,y);
		checkshipb2(x,y);
		checkshipb3(x,y);
		checkshipb4(x,y);
		checkshipb5(x,y);
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
	void checkshipb1(int x,int y)
	{
		if(d1[6]==1)
		{
			Rectangle s1 = new Rectangle(b1[6],b2[6],5,1);
			boolean as = s1.contains(x,y);
			if(as)
			{
				in=1;
			}
		}
		else
		{
			Rectangle s1 = new Rectangle(b1[6],b2[6],1,5);
			boolean as = s1.contains(x,y);
			if(as)
			{
				in=1;
			}
		}
	}
	void checkshipb2(int x,int y)
	{
		if(d1[7]==1)
		{
			Rectangle s2 = new Rectangle(b1[7],b2[7],4,1);
			boolean as = s2.contains(x,y);
			if(as)
			{
				in=1;
			}
		}
		else
		{
			Rectangle s2 = new Rectangle(b1[7],b2[7],1,4);
			boolean as = s2.contains(x,y);
			if(as)
			{
				in=1;
			}
		}
	}
	void checkshipb3(int x,int y)
	{
		if(d1[8]==1)
		{
			Rectangle s3 = new Rectangle(b1[8],b2[8],3,1);
			boolean as = s3.contains(x,y);
			if(as)
			{
				in=1;
			}
		}
		else
		{
			Rectangle s3 = new Rectangle(b1[8],b2[8],1,3);
			boolean as = s3.contains(x,y);
			if(as)
			{
				in=1;
			}
		}
	}
	void checkshipb4(int x,int y)
	{
		if(d1[9]==1)
		{
			Rectangle s4 = new Rectangle(b1[9],b2[9],3,1);
			boolean as = s4.contains(x,y);
			if(as)
			{
				in=1;
			}
		}
		else
		{
			Rectangle s4 = new Rectangle(b1[9],b2[9],1,3);
			boolean as = s4.contains(x,y);
			if(as)
			{
				in=1;
			}
		}
	}
	void checkshipb5(int x,int y)
	{
		if(d1[10]==1)
		{
			Rectangle s5 = new Rectangle(b1[10],b2[10],2,1);
			boolean as = s5.contains(x,y);
			if(as)
			{
				in=1;
			}
		}
		else
		{
			Rectangle s5 = new Rectangle(b1[10],b2[10],1,2);
			boolean as = s5.contains(x,y);
			if(as)
			{
				in=1;
			}
		}
	}
}
