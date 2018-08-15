import java.util.Scanner;

import javax.swing.JFrame;

public class Window {
	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setSize(1000, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		picture pic = new picture();
		picture1 pic1 = new picture1();
		System.out.println("please choise 1 player mode or 2 player mode");
		Scanner in = new Scanner(System.in);
		int a1 = in.nextInt();
		if(a1==2)
		{
			window.add(pic);
			lightlistener a = new lightlistener(pic);
			window.addMouseListener(a);
		}
		if(a1==1)
		{
			window.add(pic1);
			LightListener1 a2 = new LightListener1(pic1);
			window.addMouseListener(a2);
		}
		window.setVisible(true);
	}
}
