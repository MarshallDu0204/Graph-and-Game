import java.awt.Graphics;

public abstract class Abstact2DDrawing {
	int x;
	int y;
	public Abstact2DDrawing(int x1,int y1)
	{
		x=x1;
		y=y1;
	}
	public void move(int x1,int y1)
	{
		x = x+x1;
		y = y+y1;
	}
	abstract void draw1(Graphics g);
	abstract void draw2(Graphics g);
}
