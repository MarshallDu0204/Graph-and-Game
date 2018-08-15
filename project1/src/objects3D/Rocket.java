package objects3D;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

import GraphicsObjects.Point4f;
import GraphicsObjects.Utils;
import GraphicsObjects.Vector4f;
public class Rocket {
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
	
	public Rocket(){
		
	}
	
	public void drawRocket() {
		TexSphere texSphere = new TexSphere();  
		Sphere sphere= new Sphere();
		Cylinder cylinder= new Cylinder();
		Cube cube = new Cube();
		TexCube texCube = new TexCube();
		Wheel wheel = new Wheel();
		Icosahedron icosahedron = new Icosahedron();
		Tetrahedron tetrahedron = new Tetrahedron();
		Cone cone = new Cone();
		GL11.glPushMatrix();
		{
			  GL11.glColor3f(orange[0], orange[1], orange[2]);
              GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
              GL11.glRotatef(90.0f,1.0f, 0.0f, 0.0f);
              cylinder.DrawCylinder(4.0f, 20.0f, 32);
              GL11.glPushMatrix();
              {
            	  GL11.glColor3f(red[0], red[1], red[2]);
                  GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(red));
                  GL11.glTranslatef(0.0f, 0.0f, 0.0f);
                 GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
                 cone.drawCone(4.0f, 10.0f, 32);
            	  GL11.glPopMatrix();
              }
              GL11.glPushMatrix();
              {
            	  GL11.glColor3f(blue[0],blue[1], blue[2]);
                  GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
                 
                  GL11.glTranslatef(0.0f, 4.0f, 15.0f);
                  GL11.glScalef(0.3f, 2.0f, 2.0f);
                  GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
                  cube.DrawCube();
            	  GL11.glPopMatrix();
              }
              GL11.glPushMatrix();
              {
            	  GL11.glColor3f(blue[0],blue[1], blue[2]);
                  GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
                 
                  GL11.glTranslatef(0.0f, -4.0f, 15.0f);
                  GL11.glScalef(0.3f, 2.0f, 2.0f);
                  GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
                  cube.DrawCube();
            	  GL11.glPopMatrix();
              }
              GL11.glPushMatrix();
              {
            	  GL11.glColor3f(blue[0],blue[1], blue[2]);
                  GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
                 
                  GL11.glTranslatef(-4.0f, 0.0f, 15.0f);
                  GL11.glScalef(2.0f, 0.3f, 2.0f);
                  GL11.glRotatef(45.0f, 1.0f, 0.0f, 0.0f);
                  cube.DrawCube();
            	  GL11.glPopMatrix();
              }
              GL11.glPushMatrix();
              {
            	  GL11.glColor3f(blue[0],blue[1], blue[2]);
                  GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
                 
                  GL11.glTranslatef(4.0f, 0.0f, 15.0f);
                  GL11.glScalef(2.0f,  0.3f, 2.0f);
                  GL11.glRotatef(45.0f, 1.0f, 0.0f, 0.0f);
                  cube.DrawCube();
            	  GL11.glPopMatrix();
              }
              GL11.glPopMatrix();
		}
		
	}
}
