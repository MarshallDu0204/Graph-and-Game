
import java.awt.RenderingHints.Key;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.util.Random;

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.openal.AL10;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.Sphere;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
import org.omg.CORBA.PUBLIC_MEMBER;

import GraphicsObjects.Arcball;
import GraphicsObjects.Utils;
import objects3D.TexCube;
import objects3D.TexSphere;
import objects3D.Texface;
import objects3D.Texface1;
import objects3D.Battleship;
import objects3D.Cone;
import objects3D.Cube;
import objects3D.Cylinder;
import objects3D.Destroyer;
import objects3D.Grid;
import objects3D.Human;
import objects3D.Plane;
import objects3D.Rocket;
import objects3D.Tank; 

//Main windows class controls and creates the 3D virtual world , please do not change this class but edit the other classes to complete the assignment. 
// Main window is built upon the standard Helloworld LWJGL class which I have heavily modified to use as your standard openGL environment. 
// 

// Do not touch this class, I will be making a version of it for your 3rd Assignment 
public class MainWindow {

	private  boolean MouseOnepressed = true;
	private boolean  dragMode=false;
	private boolean forward = false;
	private boolean set  = true;
	private boolean lunch = false;
	
	private boolean air = false;
	
	private long lunchtime=0;
	private long taketime = 0;
	/** position of pointer */
	float x = 400, y = 300;
	/** angle of rotation */
	float rotation = 0;
	/** time at last frame */
	long lastFrame;
	/** frames per second */
	int fps;
	/** last fps time */
	long lastFPS;
	
	long  myDelta =0 ; //to use for animation
	float Alpha =0 ; //to use for animation
	long StartTime; // beginAnimiation 

	Arcball MyArcball= new Arcball();
	
	boolean DRAWGRID =false;
	boolean waitForKeyrelease= true;
	/** Mouse movement */
	int LastMouseX = -1 ;
	int LastMouseY= -1;
	
	 float pullX = 0.0f; // arc ball  X cord. 
	 float pullY = 0.0f; // arc ball  Y cord. 

	 
	int OrthoNumber = 1200; // using this for screen size, making a window of 1200 x 800 so aspect ratio 3:2 // do not change this for assignment 3 but you can change everything for your project 
	
	// basic colours
	static float black[] = { 0.0f, 0.0f, 0.0f, 1.0f };
	static float white[] = { 1.0f, 1.0f, 1.0f, 1.0f };

	static float grey[] = { 0.5f, 0.5f, 0.5f, 1.0f };
	static float spot[] = { 0.1f, 0.1f, 0.1f, 0.5f };

	// primary colours
	static float red[] = { 1.0f, 0.0f, 0.0f, 1.0f };
	static float green[] = { 0.0f, 1.0f, 0.0f, 1.0f };
	static float blue[] = { 0.0f, 0.0f, 1.0f, 1.0f };

	// secondary colours
	static float yellow[] = { 1.0f, 1.0f, 0.0f, 1.0f };
	static float magenta[] = { 1.0f, 0.0f, 1.0f, 1.0f };
	static float cyan[] = { 0.0f, 1.0f, 1.0f, 1.0f };

	// other colours
	static float orange[] = { 1.0f, 0.5f, 0.0f, 1.0f, 1.0f };
	static float brown[] = { 0.5f, 0.25f, 0.0f, 1.0f, 1.0f };
	static float dkgreen[] = { 0.0f, 0.5f, 0.0f, 1.0f, 1.0f };
	static float pink[] = { 1.0f, 0.6f, 0.6f, 1.0f, 1.0f };

	// static GLfloat light_position[] = {0.0, 100.0, 100.0, 0.0};

	//support method to aid in converting a java float array into a Floatbuffer which is faster for the opengl layer to process 
	

	public void start() {
		
		StartTime = getTime();
		try {
			Display.setDisplayMode(new DisplayMode(1200, 800));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
	
		initGL(); // init OpenGL
		GLU.gluLookAt(-20000, -30000, 90000, 300, 400, 0, 0,1,0);
		getDelta(); // call once before loop to initialise lastFrame
		lastFPS = getTime(); // call before loop to initialise fps timer
		 
		while (!Display.isCloseRequested()) {
			int delta = getDelta();
			update(delta);
			renderGL();
			Display.update();
			Display.sync(120); // cap fps to 120fps
		}

		Display.destroy();
	}

	public void update(int delta) {
		// rotate quad
		//rotation += 0.01f * delta;
		  
		  
		int MouseX= Mouse.getX();
		  int MouseY= Mouse.getY();
		  int WheelPostion = Mouse.getDWheel();
	  
		  
		  boolean  MouseButonPressed= Mouse.isButtonDown(0);
		  
		 
		  
		  if(MouseButonPressed && !MouseOnepressed )
		  {
			  MouseOnepressed =true;
			//  System.out.println("Mouse drag mode");
			  MyArcball.startBall( MouseX, MouseY, 1200, 800);
			  dragMode=true;
				
				
		  }else if( !MouseButonPressed)
		  { 
				// System.out.println("Mouse drag mode end ");
			  MouseOnepressed =false;
			  dragMode=false;
		  }
		  
		  if(dragMode)
		  {
			  MyArcball.updateBall( MouseX  , MouseY  , 1200, 800);
		  }
		  
		  if(WheelPostion>0)
		  {
			 // OrthoNumber += 10;
			 
		  }
		  
		  if(WheelPostion<0)
		  {
			 // OrthoNumber -= 10;
			  if( OrthoNumber<610)
			  {
				 // OrthoNumber=610;
			  }
			  
			//  System.out.println("Orth nubmer = " +  OrthoNumber);
			  
		  }
		  OrthoNumber = 1900;
		  
		  /** rest key is R*/
		  if (Keyboard.isKeyDown(Keyboard.KEY_R))
		  {
			  System.out.println("reset");
			 lunch=false;
			 air=false;
		  }
			  //MyArcball.reset();
		  
		  /* bad animation can be turn on or off using A key)*/
		  
		
		
			
		if(Keyboard.isKeyDown(Keyboard.KEY_L))
		{
			
			System.out.println("lunch");
			lunch=!lunch;
			lunchtime = getTime();
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_M))
		{
			
			System.out.println("map");
			set=!set;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A))
		{
			System.out.println("takeoff");
			air = !air;
			taketime = getTime();
		}
		
		
		
		 
		 
			

		// keep quad on the screen
		if (x < 0)
			x = 0;
		if (x > 1200)
			x = 1200;
		if (y < 0)
			y = 0;
		if (y > 800)
			y = 800;

		updateFPS(); // update FPS Counter
		
		LastMouseX= MouseX;
		LastMouseY= MouseY ;
	}

	/**
	 * Calculate how many milliseconds have passed since last frame.
	 * 
	 * @return milliseconds passed since last frame
	 */
	public int getDelta() {
		long time = getTime();
		int delta = (int) (time - lastFrame);
		lastFrame = time;

		return delta;
	}

	/**
	 * Get the accurate system time
	 * 
	 * @return The system time in milliseconds
	 */
	public long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}

	/**
	 * Calculate the FPS and set it in the title bar
	 */
	public void updateFPS() {
		if (getTime() - lastFPS > 1000) {
			Display.setTitle("FPS: " + fps);
			fps = 0;
			lastFPS += 1000;
		}
		fps++;
	}

	public void initGL() {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		changeOrth();
		MyArcball.startBall(0, 0, 1200,800); 
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		FloatBuffer lightPos = BufferUtils.createFloatBuffer(4);
		lightPos.put(10000f).put(1000f).put(1000).put(0).flip();

		FloatBuffer lightPos2 = BufferUtils.createFloatBuffer(4);
		lightPos2.put(0f).put(1000f).put(0).put(-1000f).flip();

		FloatBuffer lightPos3 = BufferUtils.createFloatBuffer(4);
		lightPos3.put(-10000f).put(1000f).put(1000).put(0).flip();

		FloatBuffer lightPos4 = BufferUtils.createFloatBuffer(4);
		lightPos4.put(1000f).put(1000f).put(1000f).put(0).flip();
		
		
		FloatBuffer lightPos5 = BufferUtils.createFloatBuffer(4);
		lightPos4.put(1000f).put(1000f).put(-10000f).put(0).flip();

		GL11.glLight(GL11.GL_LIGHT0, GL11.GL_POSITION, lightPos); // specify the
																	// position
																	// of the
																	// light
		 GL11.glEnable(GL11.GL_LIGHT0); // switch light #0 on // I've setup specific materials so in real light it will look abit strange 

		GL11.glLight(GL11.GL_LIGHT1, GL11.GL_POSITION, lightPos); // specify the
																	// position
																	// of the
																	// light
		GL11.glEnable(GL11.GL_LIGHT1); // switch light #0 on
		GL11.glLight(GL11.GL_LIGHT1, GL11.GL_DIFFUSE, Utils.ConvertForGL(spot));

		GL11.glLight(GL11.GL_LIGHT2, GL11.GL_POSITION, lightPos3); // specify
																	// the
																	// position
																	// of the
																	// light
		GL11.glEnable(GL11.GL_LIGHT2); // switch light #0 on
		GL11.glLight(GL11.GL_LIGHT2, GL11.GL_DIFFUSE, Utils.ConvertForGL(grey));

		GL11.glLight(GL11.GL_LIGHT3, GL11.GL_POSITION, lightPos4); // specify
																	// the
																	// position
																	// of the
																	// light
		GL11.glEnable(GL11.GL_LIGHT3); // switch light #0 on
		 GL11.glLight(GL11.GL_LIGHT3, GL11.GL_DIFFUSE, Utils.ConvertForGL(grey));
		 
		 GL11.glLight(GL11.GL_LIGHT4, GL11.GL_POSITION, lightPos5);
		 GL11.glEnable(GL11.GL_LIGHT4); 
		 GL11.glLight(GL11.GL_LIGHT4, GL11.GL_DIFFUSE, Utils.ConvertForGL(grey));

		GL11.glEnable(GL11.GL_LIGHTING); // switch lighting on
		GL11.glEnable(GL11.GL_DEPTH_TEST); // make sure depth buffer is switched
											// on
	 	GL11.glEnable(GL11.GL_NORMALIZE); // normalize normal vectors for safety
	 	GL11.glEnable(GL11.GL_COLOR_MATERIAL);
		
		   GL11.glEnable(GL11.GL_BLEND);
       GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
          try {
			init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //load in texture
          

	}

	 
	public void changeOrth() {

		 GL11.glMatrixMode(GL11.GL_PROJECTION);
		 GL11.glLoadIdentity();
		  GL11.glOrtho(1200 -  OrthoNumber , OrthoNumber, (800 - (OrthoNumber  * 0.66f)) , (OrthoNumber * 0.66f), 100000, -100000);
		 	GL11.glMatrixMode(GL11.GL_MODELVIEW); 
		 	
		 	FloatBuffer CurrentMatrix = BufferUtils.createFloatBuffer(16); 
		 	GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, CurrentMatrix);
		 
		 //	if(MouseOnepressed)
		 //	{
		  
	 	//MyArcball.getMatrix(CurrentMatrix); 
		 //	}
		 	
		    GL11.glLoadMatrix(CurrentMatrix);
		 	
	}

	/*
	 * You can edit this method to add in your own objects /  remember to load in textures in the INIT method as they take time to load 
	 * 
	 */
	
	public void renderGL() { 
		changeOrth();
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT); 
		GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
		GL11.glColor3f(0.5f, 0.5f, 1.0f); 
		 
		 myDelta =   getTime() - StartTime; 
		  float delta =((float) myDelta)/10000;
		  float x1 = 0;
		  if(air&&x1<23010)
		  {
			  x1 = getTime()-taketime; 
			 
		  }
		  else {
			x1=0;
		}
		 
		
		  float deltaplane = ((float) x1)/500;
		  if (deltaplane>42) {
			deltaplane=42;
		}
		float lunchset1 = 0;
		float lunchset=0;
		if(lunch){
		  lunchset1 = getTime()-lunchtime;
		}
		else{
			lunchset1=0;
		}
		  lunchset = ((float)lunchset1)/300;
		 
	
		  float deltaup = ((float) x1)/126;//100,130
		
		  int speed = 10;//scale the speed
		  // code to aid in animation 
		 float theta = (float) (delta * 2 * Math.PI);
		 float thetaDeg = delta * 360; 
		  float posn_x = (float) Math.cos(theta); // same as your circle code in your notes 
		  float posn_y  = (float) Math.sin(theta);
		  /*
		   * This code draws a grid to help you view the human models movement 
		   *  You may change this code to move the grid around and change its starting angle as you please 
		   */
		if(DRAWGRID)
		{
		Grid MyGrid = new Grid();
		GL11.glTranslatef(600, 330, 0); 
		GL11.glScalef(200f, 200f,  200f); 
		 MyGrid.DrawGrid();
		GL11.glPopMatrix();
		}
		
		
		
		if(set&&x1<23000&&lunchset<50){
		
			
		GL11.glPushMatrix();
		{
			Destroyer destroyer = new Destroyer();
			GL11.glTranslatef(200, 350,600 ); 
			GL11.glScalef(40f, 40f, 40f);
			destroyer.drawDestroyer(texture10, texture11,lunchset*2);
			GL11.glPushMatrix();
			{
						
				
				Rocket rocket = new Rocket();
				if(!lunch||lunchset<17)
				{
					GL11.glTranslatef(-5.5f, 0,-0.5f ); 
				}
				if(lunch&&lunchset>=17)
				{
					GL11.glTranslatef(-5.5f,  (lunchset-17)*(lunchset-17)/2,-0.5f ); 
				}
				if(deltaup>2000)
				{
					GL11.glTranslatef(-5.5f, 370+3000,-0.5f );
				}
				GL11.glScalef(0.06f, 0.1f,0.06f);
				rocket.drawRocket();
				GL11.glPopMatrix();
			}
			GL11.glPushMatrix();
			{
						
				
				Rocket rocket = new Rocket();
				if(!lunch||lunchset<17)
				{
					GL11.glTranslatef(-4.5f, 0,-0.5f ); 
				}
				if(lunch&&lunchset>=17)
				{
					GL11.glTranslatef(-4.5f,   (lunchset-17)*(lunchset-17)/2,-0.5f ); 
				}
				if(deltaup>2000)
				{
					GL11.glTranslatef(-4.5f, 370+3000,-0.5f );
				}
				GL11.glScalef(0.06f, 0.1f,0.06f);
				rocket.drawRocket();
				GL11.glPopMatrix();
			}
			GL11.glPushMatrix();
			{
						
			
				Rocket rocket = new Rocket();
				if(!lunch||lunchset<17)
				{
					GL11.glTranslatef(-5.5f, 0,0.5f ); 
				}
				if(lunch&&lunchset>=17)
				{
					GL11.glTranslatef(-5.5f,  (lunchset-17)*(lunchset-17)/2,0.5f ); 
				}
				if(deltaup>2000)
				{
					GL11.glTranslatef(-5.5f, 370+3000,0.5f );
				}
				GL11.glScalef(0.06f, 0.1f,0.06f);
				rocket.drawRocket();
				GL11.glPopMatrix();
			}
			GL11.glPushMatrix();
			{
				
				Rocket rocket = new Rocket();
				if(!lunch||lunchset<17)
				{
					GL11.glTranslatef(-4.5f, 0,0.5f ); 
				}
				if(lunch&&lunchset>=17)
				{
					GL11.glTranslatef(-4.5f,  (lunchset-17)*(lunchset-17)/2,0.5f ); 
				}
				if(deltaup>2000)
				{
					GL11.glTranslatef(-4.5f, 370+3000,0.5f );
				}
				GL11.glScalef(0.06f, 0.1f,0.06f);
				rocket.drawRocket();
				GL11.glPopMatrix();
			}
			GL11.glPopMatrix();
		}
			
		GL11.glPushMatrix();
		{
			Destroyer destroyer = new Destroyer();
			GL11.glTranslatef(200, 350,-600 ); 
			GL11.glScalef(40f, 40f, 40f);
			if(forward)
			{
				//System.out.println("true");
				GL11.glTranslatef(deltaup/10,0,0);
			}
			destroyer.drawDestroyer(texture10, texture11,lunchset*2);
			GL11.glPushMatrix();
			{
						
			
				Rocket rocket = new Rocket();
				if(!lunch||lunchset<17)
				{
					GL11.glTranslatef(-5.5f, 0,-0.5f ); 
				}
				if(lunch&&lunchset>=17)
				{
					GL11.glTranslatef(-5.5f,   (lunchset-17)*(lunchset-17)/2,-0.5f ); 
				}
				if(deltaup>2000)
				{
					GL11.glTranslatef(-5.5f, 370+3000,-0.5f );
				}
				GL11.glScalef(0.06f, 0.1f,0.06f);
				rocket.drawRocket();
				GL11.glPopMatrix();
			}
			GL11.glPushMatrix();
			{
						
				
				Rocket rocket = new Rocket();
				if(!lunch||lunchset<17)
				{
					GL11.glTranslatef(-4.5f, 0,-0.5f ); 
				}
				if(lunch&&lunchset>=17)
				{
					GL11.glTranslatef(-4.5f, (lunchset-17)*(lunchset-17)/2,-0.5f ); 
				}
				if(deltaup>2000)
				{
					GL11.glTranslatef(-4.5f, 370+3000,-0.5f );
				}
				GL11.glScalef(0.06f, 0.1f,0.06f);
				rocket.drawRocket();
				GL11.glPopMatrix();
			}
			GL11.glPushMatrix();
			{
						
				
				Rocket rocket = new Rocket();
				if(!lunch||lunchset<17)
				{
					GL11.glTranslatef(-5.5f, 0,0.5f ); 
				}
				if(lunch&&lunchset>=17)
				{
					GL11.glTranslatef(-5.5f,  (lunchset-17)*(lunchset-17)/2,0.5f ); 
				}
				if(deltaup>2000)
				{
					GL11.glTranslatef(-5.5f, 370+3000,0.5f );
				}
				GL11.glScalef(0.06f, 0.1f,0.06f);
				rocket.drawRocket();
				GL11.glPopMatrix();
			}
			GL11.glPushMatrix();
			{
						
				
				Rocket rocket = new Rocket();
				if(!lunch||lunchset<17)
				{
					GL11.glTranslatef(-4.5f, 0,0.5f ); 
				}
				if(lunch&&lunchset>=17)
				{
					GL11.glTranslatef(-4.5f,  (lunchset-17)*(lunchset-17)/2,0.5f ); 
				}
				if(deltaup>2000)
				{
					GL11.glTranslatef(-4.5f, 370+3000,0.5f );
				}
				GL11.glScalef(0.06f, 0.1f,0.06f);
				rocket.drawRocket();
				GL11.glPopMatrix();
			}
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			Battleship battleship = new Battleship();
			GL11.glTranslatef(300, 400,0 ); 
			GL11.glScalef(70f, 70f, 70f);
			battleship.drawship(lunchset*2,texture2,texture4,texture3,texture7,delta,texture8);
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
					
			
			Rocket rocket = new Rocket();
			if(!lunch||lunchset<17)
			{
				GL11.glTranslatef(1050, 370,0 ); 
			}
			if(lunch&&lunchset>=17)
			{
				GL11.glTranslatef(1050, 370+(lunchset-17)*(lunchset-17)*20,0 ); 
			}
			if(deltaup>2000)
			{
				GL11.glTranslatef(1050, 370+3000,0 );
			}
			GL11.glScalef(4.0f, 4.0f,4.0f);
			rocket.drawRocket();
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			float up = deltaup-100;
			float takeoff = up-20;
			Plane plane = new Plane();
			if(up<20)
			{
				GL11.glTranslatef(-100+deltaplane*deltaplane, 430,20 );
			}
			if (up>=20) {
				float up1=0;
				if(up-20<1)
				{
					up1 = 1;
					
				}	
				if(up-20>1&&up-20<10)
				{
					up1 = (up-20);
				
				}
				if(up<=65){
					up1  = 10.0f;
					
				}
				if(up>65&&up<66){
					  up1=10;
				}
				if(up>=66)
				{
					GL11.glTranslatef(0, 430+45*10-430,0 );
				}	
				GL11.glTranslatef(-100+deltaplane*deltaplane, 430+takeoff*up1,20 );
			}
			
			if(up>=0&&up<=30)
			{
				GL11.glRotatef(up/2, 0.0f,0.0f,1.0f);
			}
			if(up>30){
				GL11.glRotatef(15, 0.0f,0.0f,1.0f);
			}
			if(up>65)
			{
				GL11.glTranslatef(-posn_x*1400.0f,400,-posn_y*800.0f);//x,z regulate the move,y axis regulate the movement
				GL11.glRotatef(-15, 0.0f,0.0f,1.0f);
				GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
				GL11.glRotatef(-thetaDeg,0.0f,1.0f,0.0f);
			}
			GL11.glScalef(2.0f, 2.0f,2.0f);
			plane.drawPlane(delta*speed,texture5,texture6);
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			Texface texface = new Texface();
			GL11.glColor3f(red[0], red[1], red[2]);
               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(red));
               GL11.glTexParameteri(
    					GL11.GL_TEXTURE_2D, 	GL11.GL_TEXTURE_WRAP_T, 
    					GL11.GL_CLAMP);	
			Color.white.bind();
			    texture9.bind();
			    GL11.glEnable(GL11.GL_TEXTURE_2D);    
			    GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);

	              
	                 GL11.glScalef(8000.0f,1.0f , 8000.0f); 
	                 GL11.glTranslatef(0.0f, 300.0f, 0.0f);
	                texface.drawFace(texture9);
	               GL11.glDisable(GL11.GL_TEXTURE_2D);
	               GL11.glPopMatrix();
		}
		}
		if(!set&&x1<23000&&lunchset<50){
			//GLU.gluLookAt(-20000, -30000, 90000, 300, 400, 0, 0,1,0);
			//GLU.gluLookAt(0, 0, 0, 0, 0, 0, 0,0,0);
			GL11.glPushMatrix();
			{
				TexCube texface = new TexCube();
				GL11.glColor3f(red[0], red[1], red[2]);
	               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(red));
	               GL11.glTexParameteri(
	    					GL11.GL_TEXTURE_2D, 	GL11.GL_TEXTURE_WRAP_T, 
	    					GL11.GL_CLAMP);	
				Color.white.bind();
				    texture12.bind();
				    GL11.glEnable(GL11.GL_TEXTURE_2D);    
				    GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);

		         
		                 
		                 GL11.glTranslatef(900.0f, 900.0f, 0.0f);
		                 GL11.glScalef(1300.0f,900.0f, 0.1f);
		                 GL11.glRotatef(-87.5f, 0.0f, 0.0f, 1.0f);
		                 //GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
		                texface.DrawTexCube(texture12);
		               GL11.glDisable(GL11.GL_TEXTURE_2D);
		               if(Mouse.isButtonDown(0))
		               {
		            	   MouseOnepressed=true;
		               }
		              if(MouseOnepressed){
		     			 int x = Mouse.getX();
		     			 int y = Mouse.getY();
		    
		     			 GL11.glPushMatrix();
		     			 {
		     				 Sphere sphere = new Sphere();
		     				 GL11.glColor3f(red[0], red[1], red[2]);
		                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(grey));
		                       GL11.glTranslatef((float)(400-y)/400,(float)(x-600)/600, 10);
		                      GL11.glScalef(0.0032f, 0.0025f, 10.0f);
		                       sphere.draw(30.0f, 8, 8);
		     				 GL11.glPopMatrix();
		     			 }
		              }
		     				
		     		  
		     		  
		               GL11.glPopMatrix();
			}
		}
		
		
		if(lunchset>=50&&lunchset<75||x1>=23000&&x1<34500)
		{
			float x =(float)(lunchset-50);
			float sphere1 = 0;
			if(x>5&&x<15)
			{
				sphere1 = x-5;
			}
			else {
				sphere1 = 0;
			}
			float x2 =(float)( x1 - 23000);
			float sphere2 = 0;
			if(x1>25300&&x1<29900)
			{
				sphere2 = (float)(x1-25300)/460;
			}
			else {
				sphere2 = 0;
			}
			GL11.glPushMatrix();
			{
				Texface texface = new Texface();
				GL11.glColor3f(red[0], red[1], red[2]);
	               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(red));
	               GL11.glTexParameteri(
	    					GL11.GL_TEXTURE_2D, 	GL11.GL_TEXTURE_WRAP_T, 
	    					GL11.GL_CLAMP);	
	               Color.white.bind();
				    texture13.bind();
				    GL11.glEnable(GL11.GL_TEXTURE_2D);    
				    GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);

		              
		                 GL11.glScalef(8000.0f,1.0f , 8000.0f); 
		                 GL11.glTranslatef(0.0f, 300.0f, 0.0f);
		                 
		                texface.drawFace(texture13);
		                GL11.glDisable(GL11.GL_TEXTURE_2D);
		                if(x<15&&x1<29900){
		                GL11.glPushMatrix();
		                {
		                	TexCube texCube = new TexCube();
		                	GL11.glColor3f(red[0], red[1], red[2]);
		 	               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(red));
		 	               GL11.glTexParameteri(
		 	    					GL11.GL_TEXTURE_2D, 	GL11.GL_TEXTURE_WRAP_T, 
		 	    					GL11.GL_CLAMP);	
		 	               Color.white.bind();
		 				    texture7.bind();
		 				    GL11.glEnable(GL11.GL_TEXTURE_2D);    
		 				    GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);
		 				    
		 				   
		                	GL11.glScalef(0.0125f,1000.0f , 0.0125f); 
		                	texCube.DrawTexCube(texture7);
		                	
		                	
		                	 GL11.glDisable(GL11.GL_TEXTURE_2D);
		                	GL11.glPopMatrix();
		                }
		                GL11.glPushMatrix();
		                {
		                	TexCube texCube = new TexCube();
		                	GL11.glColor3f(red[0], red[1], red[2]);
		 	               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(red));
		 	               GL11.glTexParameteri(
		 	    					GL11.GL_TEXTURE_2D, 	GL11.GL_TEXTURE_WRAP_T, 
		 	    					GL11.GL_CLAMP);	
		 	               Color.white.bind();
		 				    texture7.bind();
		 				    GL11.glEnable(GL11.GL_TEXTURE_2D);    
		 				    GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);
		 				    
		 				   GL11.glTranslatef(0.1f, 0.0f, 0.0f);
		                	GL11.glScalef(0.0125f,800.0f , 0.0125f); 
		                	texCube.DrawTexCube(texture7);
		                	
		                	
		                	 GL11.glDisable(GL11.GL_TEXTURE_2D);
		                	GL11.glPopMatrix();
		                }
		                GL11.glPushMatrix();
		                {
		                	TexCube texCube = new TexCube();
		                	GL11.glColor3f(red[0], red[1], red[2]);
		 	               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(red));
		 	               GL11.glTexParameteri(
		 	    					GL11.GL_TEXTURE_2D, 	GL11.GL_TEXTURE_WRAP_T, 
		 	    					GL11.GL_CLAMP);	
		 	               Color.white.bind();
		 				    texture7.bind();
		 				    GL11.glEnable(GL11.GL_TEXTURE_2D);    
		 				    GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);
		 				    
		 				   GL11.glTranslatef(0.0f, 0.0f, 0.1f);
		                	GL11.glScalef(0.0125f,800.0f , 0.0125f); 
		                	texCube.DrawTexCube(texture7);
		                	
		                	
		                	 GL11.glDisable(GL11.GL_TEXTURE_2D);
		                	GL11.glPopMatrix();
		                }
		                GL11.glPushMatrix();
	 		               {
	 		            	  Cylinder cylinder = new Cylinder();
	 		            	   GL11.glColor3f(grey[0], grey[1], grey[2]);
		                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(grey));
		                       GL11.glTranslatef(0.0f, 0.0f, 0.2f);
			                	GL11.glScalef(0.0125f,800.0f , 0.0125f); 
	                           cylinder.DrawCylinder(1.0f, 2.0f, 32);
	 		            	   
	 		            	   GL11.glPopMatrix();
	 		               }
	 		              GL11.glPushMatrix();
	 		               {
	 		            	  Cylinder cylinder = new Cylinder();
	 		            	   GL11.glColor3f(grey[0], grey[1], grey[2]);
		                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(grey));
		                       GL11.glTranslatef(0.1f, 0.0f, 0.2f);
			                	GL11.glScalef(0.0125f,800.0f , 0.0125f); 
	                           cylinder.DrawCylinder(1.0f, 2.0f, 32);
	 		            	   
	 		            	   GL11.glPopMatrix();
	 		               }
	 		              GL11.glPushMatrix();
	 		               {
	 		            	  Cube cube = new Cube();
	 		            	   GL11.glColor3f(grey[0], grey[1], grey[2]);
		                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(grey));
		                       GL11.glTranslatef(0.05f, 0.0f, 0.1f);
			                	GL11.glScalef(0.0125f,700.0f , 0.0125f); 
	                           cube.DrawCube();
	 		            	   
	 		            	   GL11.glPopMatrix();
	 		               }
	 		              GL11.glPushMatrix();
	 		               {
	 		            	  Cube cube = new Cube();
	 		            	   GL11.glColor3f(grey[0], grey[1], grey[2]);
		                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(grey));
		                       GL11.glTranslatef(-0.05f, 0.0f, 0.1f);
			                	GL11.glScalef(0.0125f,700.0f , 0.0125f); 
	                           cube.DrawCube();
	 		            	   
	 		            	   GL11.glPopMatrix();
	 		               }
	 		              GL11.glPushMatrix();
	 		               {
	 		            	  Cube cube = new Cube();
	 		            	   GL11.glColor3f(grey[0], grey[1], grey[2]);
		                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(grey));
		                       GL11.glTranslatef(0.05f, 0.0f, -0.05f);
			                	GL11.glScalef(0.0125f,700.0f , 0.0125f); 
	                           cube.DrawCube();
	 		            	   
	 		            	   GL11.glPopMatrix();
	 		               }
		                }
	 		              GL11.glPushMatrix();
	 		               {
	 		            	  Rocket rocket = new Rocket();
	 		            	  
	 		            	  
		                       GL11.glTranslatef(0.05f, 2000.0f-400*x,0.05f);
			                	GL11.glScalef(0.00125f,14.0f , 0.00125f);
			                	GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
	                           rocket.drawRocket();
	 		            	   
	 		            	   GL11.glPopMatrix();
	 		               }
	 		              GL11.glPushMatrix();
	 		               {
	 		            	  Rocket rocket = new Rocket();
	 		            	  
	 		            	  
		                       GL11.glTranslatef(0.05f, 2000.0f-1.15f*x2,0.05f);
			                	GL11.glScalef(0.00125f,14.0f , 0.00125f);
			                	GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
	                           rocket.drawRocket();
	 		            	   
	 		            	   GL11.glPopMatrix();
	 		               }
	 		              GL11.glPushMatrix();
	 		               {
	 		            	  Sphere sphere = new Sphere();
	 		            	   GL11.glColor3f(red[0], red[1], red[2]);
		                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(red));
		                      GL11.glTranslatef(0.05f,0.0f, 0.05f);
			                	GL11.glScalef(0.0125f,70.0f , 0.0125f); 
	                           sphere.draw(sphere1, 8, 8);
	 		            	   
	 		            	   GL11.glPopMatrix();
	 		               }
	 		              GL11.glPushMatrix();
	 		               {
	 		            	  Sphere sphere = new Sphere();
	 		            	   GL11.glColor3f(red[0], red[1], red[2]);
		                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(red));
		                      GL11.glTranslatef(0.05f,0.0f, 0.05f);
			                	GL11.glScalef(0.0125f,70.0f , 0.0125f); 
	                           sphere.draw(sphere2, 8, 8);
	 		            	   
	 		            	   GL11.glPopMatrix();
	 		               }
		               GL11.glDisable(GL11.GL_TEXTURE_2D);
				GL11.glPopMatrix();
			}
		}
		if(lunchset>=75&&lunchset<100||x1>=34500&&x1<46000)
		{
			float x =(float)(lunchset-75);
			float sphere1 = 0;
			if(x>5&&x<15)
			{
				sphere1 = x-5;
			}
			else {
				sphere1 = 0;
			}
			float x2 =(float)( x1 - 34500);
			float sphere2 = 0;
			if(x1>36800&&x1<41400)
			{
				sphere2 = (float)(x1-36800)/460;
			}
			else {
				sphere2 = 0;
			}
			GL11.glPushMatrix();
			{
				Texface texface = new Texface();
				GL11.glColor3f(red[0], red[1], red[2]);
	               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(red));
	               GL11.glTexParameteri(
	    					GL11.GL_TEXTURE_2D, 	GL11.GL_TEXTURE_WRAP_T, 
	    					GL11.GL_CLAMP);	
				Color.white.bind();
				    texture14.bind();
				    GL11.glEnable(GL11.GL_TEXTURE_2D);    
				    GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);

		              
		                 GL11.glScalef(8000.0f,1.0f , 8000.0f); 
		                 GL11.glTranslatef(0.0f, 300.0f, 0.0f);
		                texface.drawFace(texture14);
		                if(x<15&&x1<41400){
		                GL11.glPushMatrix();
		                {
		                	Tank tank = new Tank();
		                	GL11.glTranslatef(0.0f, 60.0f, 0.0f);
		                	GL11.glScalef(0.0025f,20.0f , 0.0025f); 
		                	tank.drawtank(texture1, texture, texture2);
		                	
		                	
		                	GL11.glPopMatrix();
		                }
		                GL11.glPushMatrix();
		                {
		                	Tank tank = new Tank();
		                	GL11.glTranslatef(0.0f, 60.0f, 0.05f);
		                	GL11.glScalef(0.0025f,20.0f , 0.0025f); 
		                	tank.drawtank(texture1, texture, texture2);
		                	
		                	
		                	GL11.glPopMatrix();
		                }
		                GL11.glPushMatrix();
		                {
		                	Tank tank = new Tank();
		                	GL11.glTranslatef(0.0f, 60.0f, 0.10f);
		                	GL11.glScalef(0.0025f,20.0f , 0.0025f); 
		                	tank.drawtank(texture1, texture, texture2);
		                	
		                	
		                	GL11.glPopMatrix();
		                }
		                GL11.glPushMatrix();
		                {
		                	Tank tank = new Tank();
		                	GL11.glTranslatef(0.0f, 60.0f, 0.15f);
		                	GL11.glScalef(0.0025f,20.0f , 0.0025f); 
		                	tank.drawtank(texture1, texture, texture2);
		                	
		                	
		                	GL11.glPopMatrix();
		                }
		                GL11.glPushMatrix();
		                {
		                	Tank tank = new Tank();
		                	GL11.glTranslatef(0.1f, 60.0f, 0.0f);
		                	GL11.glScalef(0.0025f,20.0f , 0.0025f); 
		                	tank.drawtank(texture1, texture, texture2);
		                	
		                	
		                	GL11.glPopMatrix();
		                }
		                GL11.glPushMatrix();
		                {
		                	Tank tank = new Tank();
		                	GL11.glTranslatef(0.1f, 60.0f, 0.05f);
		                	GL11.glScalef(0.0025f,20.0f , 0.0025f); 
		                	tank.drawtank(texture1, texture, texture2);
		                	
		                	
		                	GL11.glPopMatrix();
		                }
		                GL11.glPushMatrix();
		                {
		                	Tank tank = new Tank();
		                	GL11.glTranslatef(0.1f, 60.0f, 0.1f);
		                	GL11.glScalef(0.0025f,20.0f , 0.0025f); 
		                	tank.drawtank(texture1, texture, texture2);
		                	
		                	
		                	GL11.glPopMatrix();
		                }
		                GL11.glPushMatrix();
		                {
		                	Tank tank = new Tank();
		                	GL11.glTranslatef(0.1f, 60.0f, 0.15f);
		                	GL11.glScalef(0.0025f,20.0f , 0.0025f); 
		                	tank.drawtank(texture1, texture, texture2);
		                	
		                	
		                	GL11.glPopMatrix();
		                }
		                }
		                GL11.glPushMatrix();
	 		               {
	 		            	  Rocket rocket = new Rocket();
	 		            	  
	 		            	  
		                       GL11.glTranslatef(0.05f, 2000.0f-400*x,0.05f);
			                	GL11.glScalef(0.00125f,14.0f , 0.00125f);
			                	GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
	                           rocket.drawRocket();
	 		            	   
	 		            	   GL11.glPopMatrix();
	 		               }
	 		              GL11.glPushMatrix();
	 		               {
	 		            	  Rocket rocket = new Rocket();
	 		            	  
	 		            	  
		                       GL11.glTranslatef(0.05f, 2000.0f-1.15f*x2,0.05f);
			                	GL11.glScalef(0.00125f,14.0f , 0.00125f);
			                	GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
	                           rocket.drawRocket();
	 		            	   
	 		            	   GL11.glPopMatrix();
	 		               }
	 		              GL11.glPushMatrix();
	 		               {
	 		            	  Sphere sphere = new Sphere();
	 		            	   GL11.glColor3f(red[0], red[1], red[2]);
		                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(red));
		                      GL11.glTranslatef(0.05f,0.0f, 0.05f);
			                	GL11.glScalef(0.0125f,70.0f , 0.0125f); 
	                           sphere.draw(sphere1, 8, 8);
	 		            	   
	 		            	   GL11.glPopMatrix();
	 		               }
	 		              GL11.glPushMatrix();
	 		               {
	 		            	  Sphere sphere = new Sphere();
	 		            	   GL11.glColor3f(red[0], red[1], red[2]);
		                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(red));
		                      GL11.glTranslatef(0.05f,0.0f, 0.05f);
			                	GL11.glScalef(0.0125f,70.0f , 0.0125f); 
	                           sphere.draw(sphere2, 8, 8);
	 		            	   
	 		            	   GL11.glPopMatrix();
	 		               }
		               GL11.glDisable(GL11.GL_TEXTURE_2D);
				GL11.glPopMatrix();
			}
		}
		if(lunchset>=100||x1>=46000)
		{
			float x =(float)(lunchset-100);
			float sphere1 = 0;
			if(x>5&&x<15)
			{
				sphere1 = x-5;
			}
			else {
				sphere1 = 0;
			}
			float x2 =(float)( x1 - 46000);
			float sphere2 = 0;
			if(x1>48300&&x1<52900)
			{
				sphere2 = (float)(x1-48300)/460;
			}
			else {
				sphere2 = 0;
			}
			GL11.glPushMatrix();
			{
				Texface texface = new Texface();
				GL11.glColor3f(red[0], red[1], red[2]);
	               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(red));
	               GL11.glTexParameteri(
	    					GL11.GL_TEXTURE_2D, 	GL11.GL_TEXTURE_WRAP_T, 
	    					GL11.GL_CLAMP);	
				Color.white.bind();
				    texture9.bind();
				    GL11.glEnable(GL11.GL_TEXTURE_2D);    
				    GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);

		              
		                 GL11.glScalef(8000.0f,1.0f , 8000.0f); 
		                 GL11.glTranslatef(0.0f, 300.0f, 0.0f);
		                texface.drawFace(texture9);
		                GL11.glDisable(GL11.GL_TEXTURE_2D);
		                if(x<15&&x1<52900){
		                GL11.glPushMatrix();
		                {
		                	Destroyer destroyer  = new Destroyer();
		                	GL11.glTranslatef(0.0f, 30.0f, 0.0f);
		                	GL11.glScalef(0.0025f,20.0f , 0.0025f); 
		                	destroyer.drawDestroyer(texture10, texture11,0);
		                	GL11.glPopMatrix();
		                	
		                }
		                GL11.glPushMatrix();
		                {
		                	Destroyer destroyer  = new Destroyer();
		                	GL11.glTranslatef(0.0f, 30.0f, 0.1f);
		                	GL11.glScalef(0.0025f,20.0f , 0.0025f); 
		                	destroyer.drawDestroyer(texture10, texture11,0);
		                	GL11.glPopMatrix();
		                	
		                }
		                }
		                GL11.glPushMatrix();
	 		               {
	 		            	  Rocket rocket = new Rocket();
	 		            	  
	 		            	  
		                       GL11.glTranslatef(0.05f, 2000.0f-400*x,0.05f);
			                	GL11.glScalef(0.00125f,14.0f , 0.00125f);
			                	GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
	                           rocket.drawRocket();
	 		            	   
	 		            	   GL11.glPopMatrix();
	 		               }
	 		              GL11.glPushMatrix();
	 		               {
	 		            	  Rocket rocket = new Rocket();
	 		            	  
	 		            	  
		                       GL11.glTranslatef(0.05f, 2000.0f-1.15f*x2,0.05f);
			                	GL11.glScalef(0.00125f,14.0f , 0.00125f);
			                	GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
	                           rocket.drawRocket();
	 		            	   
	 		            	   GL11.glPopMatrix();
	 		               }
	 		              GL11.glPushMatrix();
	 		               {
	 		            	  Sphere sphere = new Sphere();
	 		            	   GL11.glColor3f(red[0], red[1], red[2]);
		                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(red));
		                      GL11.glTranslatef(0.05f,0.0f, 0.05f);
			                	GL11.glScalef(0.0125f,70.0f , 0.0125f); 
	                           sphere.draw(sphere1, 8, 8);
	 		            	   
	 		            	   GL11.glPopMatrix();
	 		               }
	 		              GL11.glPushMatrix();
	 		               {
	 		            	  Sphere sphere = new Sphere();
	 		            	   GL11.glColor3f(red[0], red[1], red[2]);
		                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(red));
		                      GL11.glTranslatef(0.05f,0.0f, 0.05f);
			                	GL11.glScalef(0.0125f,70.0f , 0.0125f); 
	                           sphere.draw(sphere2, 8, 8);
	 		            	   
	 		            	   GL11.glPopMatrix();
	 		               }
				GL11.glPopMatrix();
			}
		}
		
		/*
		 * This code puts the earth code in which is larger than the human so it appears to change the scene 
		 */
		
		
	}
		  
	public static void main(String[] argv) {
		MainWindow hello = new MainWindow();
		hello.start();
	}
	 
	Texture texture;
	Texture texture1;
	Texture texture2;
	Texture texture3;
	Texture texture4;
	Texture texture5;
	Texture texture6;
	Texture texture7;
	Texture texture8;
	Texture texture9;
	Texture texture10;
	Texture texture11;
	Texture texture12;
	Texture texture13;
	Texture texture14;
	/*
	 * Any additional textures for your assignment should be written in here. 
	 * Make a new texture variable for each one so they can be loaded in at the beginning 
	 */
	public void init() throws IOException {
	         
	  texture = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("res/timg.jpg"));	  
	  System.out.println("Texture loaded okay ");
	  
	  texture1 = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("res/timg1.jpg"));
	  System.out.println("Texture1 loaded okay ");
	  
	  texture2 = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("res/timg2.jpg"));
	  System.out.println("Texture2 loaded okay ");
	  
	  texture3 = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("res/timg3-1.jpg"));
	  System.out.println("Texture3-1 loaded okay ");
	  
	  texture4 = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("res/timg3-2.jpg"));
	  System.out.println("Texture3-2 loaded okay ");
	  
	  texture5 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/timg-1.png"));
	  System.out.println("Texture-1 loaded okay ");
	  
	  texture6 = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("res/timg4.jpg"));
	  System.out.println("Texture4 loaded okay ");
	  
	  texture7 = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("res/timg5.jpg"));
	  System.out.println("Texture5 loaded okay ");
	  
	  texture8 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/2017.png"));
	  System.out.println("Texture2017 loaded okay ");
	  
	  texture9 = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("res/timg6.jpg"));
	  System.out.println("Texture6 loaded okay ");
	  
	  texture10 = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("res/timg7.jpg"));
	  System.out.println("Texture7 loaded okay ");
	  
	  texture11 = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("res/timg8.jpg"));
	  System.out.println("Texture8 loaded okay ");
	  
	  texture12 = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("res/timg9.jpg"));
	  System.out.println("Texture9 loaded okay ");
	  
	  texture13 = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("res/timg10.jpg"));
	  System.out.println("Texture10 loaded okay ");
	  
	  texture14 = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("res/timg11.jpg"));
	  System.out.println("Texture11 loaded okay ");
	}
}
