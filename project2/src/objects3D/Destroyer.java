package objects3D;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

import GraphicsObjects.Point4f;
import GraphicsObjects.Utils;
import GraphicsObjects.Vector4f;

public class Destroyer {
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
	
	
	public Destroyer(){
		
	}
	
	public void drawDestroyer(Texture texture,Texture texture2,float number){
		TexSphere texSphere = new TexSphere();  
		Sphere sphere= new Sphere();
		Cylinder cylinder= new Cylinder();
		Cube cube = new Cube();
		TexCube texCube = new TexCube();
		Wheel wheel = new Wheel();
		Tetrahedron tetrahedron = new Tetrahedron();
		Icosahedron icosahedron = new Icosahedron();
		TexIcosahedron texIcosahedron = new TexIcosahedron();
		Texface texface = new Texface();
		Texface1 texface1 = new Texface1();
		Face face = new Face();
		Face1 face1 = new Face1();
		GL11.glPushMatrix();
		{
			 GL11.glColor3f(grey[0], grey[1], grey[2]);
             GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(grey));
			GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
			GL11.glScalef(7.0f, 1.0f, 1.0f);
			//GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
             cylinder.DrawCylinder(2.0f, 2.0f, 32);
             GL11.glPushMatrix();
             {
            	 GL11.glColor3f(grey[0], grey[1],grey[2]);
                 GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(grey));
                 GL11.glTranslatef(1.4f,0.0f, 1.0f);
                 GL11.glRotatef(45.0f, 0.0f, 0.0f, 1.0f);
                 cube.DrawCube();
                 GL11.glPushMatrix();
                 {
                	 GL11.glColor3f(black[0], black[1],black[2]);
                     GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(black));
                     GL11.glTranslatef(0.0f, 0.0f, -0.3f);
                	 face.drawFace();
                	 GL11.glPopMatrix();
                 }
                 GL11.glPushMatrix();
                 {
                	 GL11.glColor3f(black[0], black[1],black[2]);
                     GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(black));
                     GL11.glTranslatef(0.0f, 0.0f,-0.3f);
                	//GL11.glRotatef(45.0f, 1.0f, 0.0f, 0.0f);
                     face1.drawFace();
                	 GL11.glPopMatrix();
                 }
            	 GL11.glPopMatrix();
             }
             GL11.glPushMatrix();
             {
            	 GL11.glColor3f(grey[0], grey[1],grey[2]);
                 GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(grey));
                 GL11.glScalef(1.0f, 1.7f, 1.0f);
                 cube.DrawCube();
                 GL11.glPushMatrix();
                 {
                	 GL11.glColor3f(grey[0], grey[1],grey[2]);
                     GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(grey));
                     GL11.glTranslatef(1.0f, 0.0f, 0.0f);
                     GL11.glScalef(0.5f, 0.5f, 0.5f);
                     cube.DrawCube();
                	 GL11.glPopMatrix();
                 }
                 GL11.glPushMatrix();
                 {
                	 GL11.glColor3f(black[0], black[1],black[2]);
                     GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(black));
                     GL11.glTranslatef(1.0f, 0.0f, -0.9f);
                     GL11.glScalef(0.2f, 0.5f, 0.6f);
                     GL11.glRotatef(15.0f, 0.0f, 1.0f, 0.0f);
                     cube.DrawCube();
                     GL11.glPushMatrix();
                     {
                    	 GL11.glColor3f(grey[0], grey[1],grey[2]);
                         GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(grey));
                         GL11.glTexParameteri(
			    					GL11.GL_TEXTURE_2D, 	GL11.GL_TEXTURE_WRAP_T, 
			    					GL11.GL_CLAMP);	
						Color.white.bind();
		    			    texture.bind();
		    			    GL11.glEnable(GL11.GL_TEXTURE_2D);    
		    			    GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);
		    			    GL11.glTranslatef(0.01f, 0.0f, 0.0f);
		    			    texface1.drawFace(texture,3,4);
		    			    GL11.glDisable(GL11.GL_TEXTURE_2D);
                    	 GL11.glPopMatrix();
                     }
                    
                    
                	 GL11.glPopMatrix();
                 }
                 GL11.glPushMatrix();
                 {
                	 GL11.glColor3f(black[0], black[1],black[2]);
                     GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(black));
                    
                     GL11.glTranslatef(0.9f, 0.0f, -1.0f);
                     GL11.glScalef(0.1f, 0.4f, 1.5f);
                     cube.DrawCube();
                	 GL11.glPopMatrix();
                 }
                 GL11.glPushMatrix();
                 {
                	 GL11.glColor3f(grey[0], grey[1],grey[2]);
                     GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(grey));
                    
                     GL11.glTranslatef(0.3f, 0.0f, -1.0f);
                     GL11.glScalef(0.1f, 0.4f, 1.2f);
                     cube.DrawCube();
                	 GL11.glPopMatrix();
                 }
                 GL11.glPushMatrix();
                 {
                	 GL11.glColor3f(grey[0], grey[1],grey[2]);
                     GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(grey));
                    
                     GL11.glTranslatef(0.0f, 0.0f, -1.0f);
                     GL11.glScalef(0.2f, 0.3f, 0.9f);
                     cube.DrawCube();
                	 GL11.glPopMatrix();
                 }
                 GL11.glPushMatrix();
                 {
                	 GL11.glColor3f(grey[0], grey[1],grey[2]);
                     GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(grey));
                    
                     GL11.glTranslatef(-0.3f, 0.0f, -1.0f);
                     GL11.glScalef(0.1f, 0.4f, 1.2f);
                     cube.DrawCube();
                	 GL11.glPopMatrix();
                 }
                 GL11.glPopMatrix();
                 GL11.glPushMatrix();
                 {
                	 GL11.glColor3f(black[0], black[1],black[2]);
                     GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(black));
                     GL11.glTranslatef(-0.7f, 0.0f, -1.0f);
                     GL11.glScalef(0.22f,1.5f , 0.1f);
                     cube.DrawCube();
                	 GL11.glPopMatrix();
                 }
                 GL11.glPushMatrix();
                 {
                	 GL11.glColor3f(white[0], white[1],white[2]);
                     GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(white));
                     if(number<0)
                     {
                    	 GL11.glTranslatef(-0.8f, -0.4f, -1.0f);
                     }
                     if(number>=0&&number<30)
                     {
                    	 GL11.glTranslatef(-0.8f-number/300, -0.4f-number/150, -1.0f);
                     }
                     if(number>30)
                     {
                    	 GL11.glTranslatef(-0.9f, -0.6f, -1.0f);
                     }
                     
                     GL11.glScalef(0.05f,0.35f , 0.2f);
                    cube.DrawCube();
                	 GL11.glPopMatrix();
                 }
                 GL11.glPushMatrix();
                 {
                	 GL11.glColor3f(white[0], white[1],white[2]);
                     GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(white));
                     if(number<0)
                     {
                    	 GL11.glTranslatef(-0.8f, 0.4f, -1.0f);
                     }
                     if(number>=0&&number<30)
                     {
                    	 GL11.glTranslatef(-0.8f-number/300, 0.4f+number/150, -1.0f);
                     }
                     if(number>30)
                     {
                    	 GL11.glTranslatef(-0.9f, 0.6f, -1.0f);
                     }
                     GL11.glScalef(0.05f,0.35f , 0.2f);
                    cube.DrawCube();
                	 GL11.glPopMatrix();
                 }
                 GL11.glPushMatrix();
                 {
                	 GL11.glColor3f(white[0], white[1],white[2]);
                     GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(white));
                     if(number<0)
                     {
                    	 GL11.glTranslatef(-0.6f, -0.4f, -1.0f);
                     }
                     if(number>=0&&number<30)
                     {
                    	 GL11.glTranslatef(-0.6f+number/300, -0.4f-number/150, -1.0f);
                     }
                     if(number>30)
                     {
                    	 GL11.glTranslatef(-0.5f, -0.6f, -1.0f);
                     }
                     //GL11.glTranslatef(-0.6f, -0.4f, -1.0f);
                     GL11.glScalef(0.05f,0.35f , 0.2f);
                    cube.DrawCube();
                	 GL11.glPopMatrix();
                 }
                 GL11.glPushMatrix();
                 {
                	 GL11.glColor3f(white[0], white[1],white[2]);
                     GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(white));
                     if(number<0)
                     {
                    	 GL11.glTranslatef(-0.6f, 0.4f, -1.0f);
                     }
                     if(number>=0&&number<30)
                     {
                    	 GL11.glTranslatef(-0.6f+number/300, 0.4f+number/150, -1.0f);
                     }
                     if(number>30)
                     {
                    	 GL11.glTranslatef(-0.5f, 0.6f, -1.0f);
                     }
                     //GL11.glTranslatef(-0.6f, 0.4f, -1.0f);
                     GL11.glScalef(0.05f,0.35f , 0.2f);
                    cube.DrawCube();
                	 GL11.glPopMatrix();
                 }
             }
            
             GL11.glPushMatrix();
             {
            	 GL11.glColor3f(grey[0], grey[1],grey[2]);
                 GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(grey));
           
                 GL11.glTranslatef(-1.0f, 0.0f, 1.0f);
                 GL11.glScalef(1.0f, 1.5f, 1.0f);
                 cube.DrawCube();
                 GL11.glPushMatrix();
                 {
                	 GL11.glTexParameteri(
		    					GL11.GL_TEXTURE_2D, 	GL11.GL_TEXTURE_WRAP_T, 
		    					GL11.GL_CLAMP);	
					Color.white.bind();
	    			    texture2.bind();
	    			    GL11.glEnable(GL11.GL_TEXTURE_2D);    
	    			    GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);
                	 GL11.glTranslatef(-0.5f, 0.0f, -0.01f);
                	 GL11.glScalef(0.5f, 1.0f, 1.0f);
	    			    texface1.drawFace(texture2, 1, 2);
                	 GL11.glDisable(GL11.GL_TEXTURE_2D);
                	 GL11.glPopMatrix();
           
                 }
            	 GL11.glPopMatrix();
             }
             GL11.glPushMatrix();
             {
            	 GL11.glColor3f(grey[0], grey[1],grey[2]);
                 GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(grey));
                 GL11.glTranslatef(2.0f, 0.0f, -0.5f);
                 GL11.glScalef(0.1f, 0.2f, 0.5f);
                 GL11.glPushMatrix();
                 cube.DrawCube();
                 {
                	 GL11.glColor3f(black[0], black[1],black[2]);
                     GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(black));
                     GL11.glTranslatef(3.0f, 0.0f, -3.0f);
                     GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
                     cylinder.DrawCylinder(0.2f, 5.0f, 32);
                	 GL11.glPopMatrix();
                 }
            	 GL11.glPopMatrix();
             }
			GL11.glPopMatrix();
		}
	}
}
