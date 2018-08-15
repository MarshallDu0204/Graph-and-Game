package objects3D;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

import GraphicsObjects.Point4f;
import GraphicsObjects.Utils;
import GraphicsObjects.Vector4f;
public class Plane {
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
	
	
	public Plane (){
		
	}
	
	public void drawPlane(float delta,Texture texture,Texture texture2){
		float theta = (float) (delta * 2 * Math.PI);
		  float Rotation;
		  Rotation = (float) Math.cos(theta)*180;
		
		TexSphere texSphere = new TexSphere();  
		Sphere sphere= new Sphere();
		Cylinder cylinder= new Cylinder();
		Cube cube = new Cube();
		TexCube texCube = new TexCube();
		Wheel wheel = new Wheel();
		Icosahedron icosahedron = new Icosahedron();
		Tetrahedron tetrahedron = new Tetrahedron();
		Cone cone = new Cone();
		Blade blade = new Blade();
		GL11.glPushMatrix();
		{
			 GL11.glColor3f(red[0], red[1], red[2]);
             GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(red));
             GL11.glRotatef(90.0f,0.0f, 1.0f, 0.0f);
             GL11.glScalef(1.0f, 1.3f, 1.0f);
             cylinder.DrawCylinder(4.0f, 35.0f, 32);
             GL11.glPushMatrix();
             {
            	 GL11.glColor3f(black[0],black[1], black[2]);
                 GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(black));
                 
                 GL11.glTranslatef(0.0f, 2.0f, 35.0f);
                 GL11.glScalef(1.0f, 0.67f, 1.0f);
                 GL11.glRotatef(Rotation, 0.0f, 0.0f, 1.0f);
                 cone.drawCone(3.0f, 4.0f, 32);
                 GL11.glPushMatrix();
                 {
                	 GL11.glColor3f(red[0], red[1], red[2]);
		               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(red));
		               GL11.glTexParameteri(
		    					GL11.GL_TEXTURE_2D, 	GL11.GL_TEXTURE_WRAP_T, 
		    					GL11.GL_CLAMP);	
		               Color.white.bind();
	    			    texture.bind();
	    			    GL11.glEnable(GL11.GL_TEXTURE_2D);    
	    			    GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);
	
		                GL11.glTranslatef(0.0f, 0.0f, 2.0f);
		                blade.drawblade(10.0f, 1.2f, 20, texture);
		               GL11.glDisable(GL11.GL_TEXTURE_2D);
                	 GL11.glPopMatrix();
                 }
                 GL11.glPopMatrix();
             }
             GL11.glPushMatrix();
             {
            	 GL11.glColor3f(black[0], black[1], black[2]);
                 GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(black));
                 GL11.glScalef(1.0f, 1.0f, 2.0f);
                 GL11.glTranslatef(0.0f, 3.0f, 5.0f);
                 sphere.DrawSphere(3.0f, 32, 32);
            	 GL11.glPopMatrix();
             }
             GL11.glPushMatrix();
             {
            	 GL11.glColor3f(grey[0], grey[1], grey[2]);
                 GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(grey));
                 GL11.glTexParameteri(
	    					GL11.GL_TEXTURE_2D, 	GL11.GL_TEXTURE_WRAP_T, 
	    					GL11.GL_CLAMP);	
	               Color.white.bind();
 			    texture2.bind();
 			    GL11.glEnable(GL11.GL_TEXTURE_2D);    
 			    GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);
                 GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                 GL11.glTranslatef(-10.0f, -2.0f, 0.0f);
                 GL11.glScalef(10.0f, 0.5f, 5.0f);
                 wheel.DrawWheel(1.0f, 10.0f,10, texture2);
                 GL11.glDisable(GL11.GL_TEXTURE_2D);
            	 GL11.glPopMatrix();
             }
             GL11.glPushMatrix();
             {
            	 GL11.glColor3f(grey[0], grey[1], grey[2]);
                 GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(grey));
                 GL11.glTexParameteri(
	    					GL11.GL_TEXTURE_2D, 	GL11.GL_TEXTURE_WRAP_T, 
	    					GL11.GL_CLAMP);	
	               Color.white.bind();
 			    texture2.bind();
 			    GL11.glEnable(GL11.GL_TEXTURE_2D);    
 			    GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);
                 GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
                 GL11.glTranslatef(10.0f, -2.0f, 0.0f);
                 GL11.glScalef(10.0f, 0.5f, 5.0f);
                 wheel.DrawWheel(1.0f, 10.0f,10, texture2);
                 GL11.glDisable(GL11.GL_TEXTURE_2D);
            	 GL11.glPopMatrix();
             }
             GL11.glPushMatrix();
             {
            	 GL11.glColor3f(red[0], red[1], red[2]);
                 GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(red));
                 GL11.glRotatef(180.0f,0.0f, 1.0f, 0.0f);
                 cone.drawCone(4.0f, 10f, 32);
                 GL11.glPushMatrix();
                 {
                	 GL11.glColor3f(red[0], red[1], red[2]);
                     GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(red));
                     GL11.glTranslatef(0.0f, 1.0f, 0.0f);
                     cylinder.DrawCylinder(3.0f, 25.0f,32);
                     GL11.glPushMatrix();
                     {
                    	 GL11.glColor3f(brown[0], brown[1], brown[2]);
                         GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(brown));
                         GL11.glTranslatef(0.0f, 0.0f, 25.0f);
                         sphere.DrawSphere(3.0f, 32, 32);
                    	 GL11.glPopMatrix();
                     }
                     GL11.glPushMatrix();
                     {
                    	 GL11.glColor3f(red[0], red[1], red[2]);
                         GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(red));
                         GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                         GL11.glTranslatef(-20.0f, 0.0f, 0.0f);
                         GL11.glScalef(3.0f, 0.5f, 1.5f);
                         cylinder.DrawCylinder(1.0f, 10.0f,32);
                    	 GL11.glPopMatrix();
                     }
                     GL11.glPushMatrix();
                     {
                    	 GL11.glColor3f(red[0], red[1], red[2]);
                         GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(red));
                         GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
                         GL11.glTranslatef(20.0f, 0.0f, 0.0f);
                         GL11.glScalef(3.0f, 0.5f, 1.5f);
                         cylinder.DrawCylinder(1.0f, 10.0f,32);
                    	 GL11.glPopMatrix();
                     }
                     GL11.glPushMatrix();
                     {
                    	 GL11.glColor3f(red[0], red[1], red[2]);
                         GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(red));
                         GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                         GL11.glTranslatef(5.0f, 0.0f, 15.0f);
                         GL11.glScalef(5.0f, 1.0f, 0.8f);
                         cylinder.DrawCylinder(1.0f, 10.0f,32);
                    	 GL11.glPopMatrix();
                     }
                	 GL11.glPopMatrix();
                 }
            	 GL11.glPopMatrix();
            	 
             }
			GL11.glPopMatrix();
		}
		
	}
}
