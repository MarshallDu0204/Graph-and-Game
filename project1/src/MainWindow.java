
import java.io.IOException;
import java.nio.FloatBuffer;

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
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import GraphicsObjects.Arcball;
import GraphicsObjects.Utils;
import objects3D.TexCube;
import objects3D.TexSphere;
import objects3D.Texface;
import objects3D.Battleship;
import objects3D.Cone;
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
	private boolean BadAnimation = true;
	private boolean Earth= false;
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
			  //OrthoNumber += 10;
			 
		  }
		  
		  if(WheelPostion<0)
		  {
			 // OrthoNumber -= 10;
			  if( OrthoNumber<610)
			  {
				  //OrthoNumber=610;
			  }
			  
			//  System.out.println("Orth nubmer = " +  OrthoNumber);
			  
		  }
		  OrthoNumber = 1900;
		  
		  /** rest key is R*/
		  if (Keyboard.isKeyDown(Keyboard.KEY_R))
			  MyArcball.reset();
		  
		  /* bad animation can be turn on or off using A key)*/
		  
		if (Keyboard.isKeyDown(Keyboard.KEY_A))
			BadAnimation=!BadAnimation;
		if (Keyboard.isKeyDown(Keyboard.KEY_D))
			x += 0.35f * delta;

		if (Keyboard.isKeyDown(Keyboard.KEY_W))
			y += 0.35f * delta;
		if (Keyboard.isKeyDown(Keyboard.KEY_S))
			y -= 0.35f * delta;

		if (Keyboard.isKeyDown(Keyboard.KEY_Q))
			rotation += 0.35f * delta;
		if (Keyboard.isKeyDown(Keyboard.KEY_E))
		{
			Earth=!Earth;
		} 
		
		 if(waitForKeyrelease) // check done to see if key is released 
		 {
		if (Keyboard.isKeyDown(Keyboard.KEY_G))
		{
			
			DRAWGRID = !DRAWGRID;
			Keyboard.next();
			if(Keyboard.isKeyDown(Keyboard.KEY_G))
			{
				waitForKeyrelease=true;
			}else
			{
				waitForKeyrelease=false;
				
			}
		}
		 }
		 
		 /** to check if key is released */
		 if(Keyboard.isKeyDown(Keyboard.KEY_G)==false)
			{
				waitForKeyrelease=true;
			}else
			{
				waitForKeyrelease=false;
				
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

		GL11.glLight(GL11.GL_LIGHT0, GL11.GL_POSITION, lightPos); // specify the
																	// position
																	// of the
																	// light
		// GL11.glEnable(GL11.GL_LIGHT0); // switch light #0 on // I've setup specific materials so in real light it will look abit strange 

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
		  float deltaplane = ((float) myDelta)/500;
		  if (deltaplane>42) {
			deltaplane=42;
		}
		  //System.out.println(deltaplane);
		  float deltaup = ((float) myDelta)/126;//100,130
		  //System.out.println(deltaup);
		  int speed = 10;//scale the speed
		  // code to aid in animation 
		 float theta = (float) (delta * 2 * Math.PI);
		 float thetaFast = (float) (delta * 4*speed * Math.PI);//let the man jump more fast
		 float thetaDeg = delta * 360; 
		  float posn_x = (float) Math.cos(theta); // same as your circle code in your notes 
		  float posn_y  = (float) Math.sin(theta);
		  float a = (float) Math.cos(thetaFast);
		  float b=0;
		  if(a<-0.5)
		  {
			  b = -0.5f;//to let human jump, so the z axis should stop.
		  }
		  else{
			  b = a;//jump
		  }
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
		
		GL11.glPushMatrix();
		 
		if(!BadAnimation)
		{
			
			// insert your animation code to correct the postion for the human rotating
			//GL11.glTranslatef(-posn_x*6.0f, b*0.1f,-posn_y*6.0f);//x,z regulate the move,y axis regulate the movement
			//GL11.glRotatef(-thetaDeg,0.0f,1.0f,0.0f);
		 
		}else
		{ 
			
			//bad animation  version 
			 //GL11.glTranslatef(posn_x*3.0f, 0.0f, posn_y*3.0f);
		}
		//MyHuman.DrawHuman(delta*speed,!BadAnimation,texture,texture1,texture2); // give a delta for the Human object ot be animated 
		// tank.drawtank(texture1, texture, texture2);
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		{
			Tank tank = new Tank();
			float time = deltaup-225;
			if(deltaup<=225)
			{
				GL11.glTranslatef(300, 350,0 ); 
			}
			if(deltaup>225&&deltaup<412){
				GL11.glTranslatef(300+time*4, 350,0 ); 
			}
			if(deltaup>=412&&deltaup<445)
			{
				GL11.glTranslatef(1050, 350+(deltaup-412)*4,0 ); 
			}
			if(deltaup>=445&&deltaup<720)
			{
				GL11.glTranslatef(1050-(deltaup-445)*2, 480,0 );
			}
			if(deltaup>=720)
			{
				GL11.glTranslatef(500, 480,0 );
			}
			GL11.glScalef(20f, 20f, 20f); 
			 tank.drawtank(texture1, texture, texture2,delta*speed/2,deltaup);//265
			GL11.glPopMatrix();
			
		}
		GL11.glPushMatrix();
		{
					
			float high = deltaup-230;
			Rocket rocket = new Rocket();
			if(deltaup<230)
			{
				GL11.glTranslatef(-20, 370,620 ); 
			}
			if(deltaup>=230)
			{
				GL11.glTranslatef(-20, 370+high*high*5,620); 
			}
			if(deltaup>2000)
			{
				GL11.glTranslatef(-20, 370+3000,620 );
			}
			GL11.glScalef(3.0f, 3.0f,3.0f);
			rocket.drawRocket();
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
					
			float high = deltaup-230;
			Rocket rocket = new Rocket();
			if(deltaup<230)
			{
				GL11.glTranslatef(-20, 370,580 ); 
			}
			if(deltaup>=230)
			{
				GL11.glTranslatef(-20, 370+high*high*5,580); 
			}
			if(deltaup>2000)
			{
				GL11.glTranslatef(-20, 370+3000,580 );
			}
			GL11.glScalef(3.0f, 3.0f,3.0f);
			rocket.drawRocket();
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
					
			float high = deltaup-230;
			Rocket rocket = new Rocket();
			if(deltaup<230)
			{
				GL11.glTranslatef(20, 370,580 ); 
			}
			if(deltaup>=230)
			{
				GL11.glTranslatef(20, 370+high*high*5,580); 
			}
			if(deltaup>2000)
			{
				GL11.glTranslatef(20, 370+3000,580 );
			}
			GL11.glScalef(3.0f, 3.0f,3.0f);
			rocket.drawRocket();
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
					
			float high = deltaup-230;
			Rocket rocket = new Rocket();
			if(deltaup<230)
			{
				GL11.glTranslatef(20, 370,620 ); 
			}
			if(deltaup>=230)
			{
				GL11.glTranslatef(20, 370+high*high*5,620); 
			}
			if(deltaup>2000)
			{
				GL11.glTranslatef(20, 370+3000,620 );
			}
			GL11.glScalef(3.0f, 3.0f,3.0f);
			rocket.drawRocket();
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			Destroyer destroyer = new Destroyer();
			GL11.glTranslatef(200, 350,600 ); 
			GL11.glScalef(40f, 40f, 40f);
			destroyer.drawDestroyer(texture10, texture11,deltaup-200);
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
					
			float high = deltaup-230;
			Rocket rocket = new Rocket();
			if(deltaup<230)
			{
				GL11.glTranslatef(20, 370,-580 ); 
			}
			if(deltaup>=230)
			{
				GL11.glTranslatef(20, 370+high*high*5,-580 ); 
			}
			if(deltaup>2000)
			{
				GL11.glTranslatef(20, 370+3000,-580 );
			}
			GL11.glScalef(3.0f, 3.0f,3.0f);
			rocket.drawRocket();
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
					
			float high = deltaup-230;
			Rocket rocket = new Rocket();
			if(deltaup<230)
			{
				GL11.glTranslatef(20, 370,-620 ); 
			}
			if(deltaup>=230)
			{
				GL11.glTranslatef(20, 370+high*high*5,-620 ); 
			}
			if(deltaup>2000)
			{
				GL11.glTranslatef(20, 370+3000,-620 );
			}
			GL11.glScalef(3.0f, 3.0f,3.0f);
			rocket.drawRocket();
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
					
			float high = deltaup-230;
			Rocket rocket = new Rocket();
			if(deltaup<230)
			{
				GL11.glTranslatef(-20, 370,-580 ); 
			}
			if(deltaup>=230)
			{
				GL11.glTranslatef(-20, 370+high*high*5,-580 ); 
			}
			if(deltaup>2000)
			{
				GL11.glTranslatef(-20, 370+3000,-580 );
			}
			GL11.glScalef(3.0f, 3.0f,3.0f);
			rocket.drawRocket();
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
					
			float high = deltaup-230;
			Rocket rocket = new Rocket();
			if(deltaup<230)
			{
				GL11.glTranslatef(-20, 370,-620 ); 
			}
			if(deltaup>=230)
			{
				GL11.glTranslatef(-20, 370+high*high*5,-620 ); 
			}
			if(deltaup>2000)
			{
				GL11.glTranslatef(-20, 370+3000,-620 );
			}
			GL11.glScalef(3.0f, 3.0f,3.0f);
			rocket.drawRocket();
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			Destroyer destroyer = new Destroyer();
			GL11.glTranslatef(200, 350,-600 ); 
			GL11.glScalef(40f, 40f, 40f);
			destroyer.drawDestroyer(texture10, texture11,deltaup-200);
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			Battleship battleship = new Battleship();
			GL11.glTranslatef(300, 400,0 ); 
			GL11.glScalef(70f, 70f, 70f);
			battleship.drawship(deltaup-200,texture2,texture4,texture3,texture7,delta,texture8);
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
					
			float high = deltaup-230;
			Rocket rocket = new Rocket();
			if(deltaup<230)
			{
				GL11.glTranslatef(1050, 370,0 ); 
			}
			if(deltaup>=230)
			{
				GL11.glTranslatef(1050, 370+high*high*5,0 ); 
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
		
		
		GL11.glPushMatrix();
		{
			Tank tank = new Tank();
			GL11.glTranslatef(600, 330, 0); 
			GL11.glScalef(40f, 40f, 40f); 
			// tank.drawtank(texture1, texture, texture2,0,0);//265
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			Battleship battleship = new Battleship();
			GL11.glTranslatef(500, 330, 0); 
			GL11.glScalef(80f, 80f, 80f); 
			//battleship.drawship(0,texture2,texture4,texture3,texture7,0,texture8);
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			Plane plane = new Plane();
			GL11.glTranslatef(500, 330, 0); 
			GL11.glScalef(10f, 10f, 10f); 
			//plane.drawPlane(delta*speed,texture5,texture6);
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			Rocket rocket = new Rocket();
			GL11.glTranslatef(500, 330, 0); 
			GL11.glScalef(10f, 10f, 10f); 
			//rocket.drawRocket();
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		{
			Destroyer destroyer = new Destroyer();
			GL11.glTranslatef(600, 430, 0); 
			GL11.glScalef(60f, 60f, 60f); 
			//destroyer.drawDestroyer(texture10,texture11);
			GL11.glPopMatrix();
		}
		
		/*
		 * This code puts the earth code in which is larger than the human so it appears to change the scene 
		 */
		if(Earth)
		{
			
			//Globe in the centre of the scene 
			GL11.glPushMatrix();
			//TexSphere MyGlobe = new TexSphere();
			TexCube MyGlobe = new TexCube();
			GL11.glTranslatef(500, 500,500 ); 
			GL11.glScalef(140f, 140f,  140f);
			 
			GL11.glTexParameteri(
					GL11.GL_TEXTURE_2D, 	GL11.GL_TEXTURE_WRAP_T, 
					GL11.GL_CLAMP);
		  
			 Color.white.bind();
			    texture1.bind();
			    GL11.glEnable(GL11.GL_TEXTURE_2D);    
			    GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);
	  
		 	//MyGlobe.DrawTexSphere(1f,70,70,texture); 
			MyGlobe.DrawTexCube(texture); 
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glPopMatrix();
			
		}
		
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
	}
}
