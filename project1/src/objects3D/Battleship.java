package objects3D;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

import GraphicsObjects.Point4f;
import GraphicsObjects.Utils;
import GraphicsObjects.Vector4f;
public class Battleship {
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
				
				public Battleship(){
					
				}
				
				public void drawship(float number,Texture myTexture,Texture myTexture1,Texture myTexture2,Texture myTexture3,float delta,Texture myTexture4){
					float theta = (float) (delta * 2 * Math.PI);
					  float Rotation;
					  Rotation = (float) Math.cos(theta)*360;
					TexSphere texSphere = new TexSphere();  
					Sphere sphere= new Sphere();
					Cylinder cylinder= new Cylinder();
					Cube cube = new Cube();
					TexCube texCube = new TexCube();
					Wheel wheel = new Wheel();
					Icosahedron icosahedron = new Icosahedron();
					TexIcosahedron texIcosahedron = new TexIcosahedron();
					GL11.glPushMatrix();
					{
						GL11.glColor3f(red[0], red[1], red[2]);
			               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(red));
			               GL11.glTexParameteri(
			    					GL11.GL_TEXTURE_2D, 	GL11.GL_TEXTURE_WRAP_T, 
			    					GL11.GL_CLAMP);	
						Color.white.bind();
		    			    myTexture.bind();
		    			    GL11.glEnable(GL11.GL_TEXTURE_2D);    
		    			    GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);
	  
	 		              
	 		                 GL11.glScalef(8.0f,0.2f , 2.4f); 
	 		                 GL11.glRotated(180, 1.0f, 0.0f, 0.0f);
	 		                GL11.glRotated(180, 0.0f, 1.0f, 0.0f);
	 		                texCube.DrawTexCube(myTexture);
	 		               GL11.glDisable(GL11.GL_TEXTURE_2D);
	 		               
	 		               GL11.glPushMatrix();
	 		               {
	 		            	  GL11.glColor3f(grey[0], grey[1], grey[2]);
		                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(grey));
		                       	GL11.glScalef(1.3f,4.0f, 0.9f);
	                            GL11.glTranslatef(-0.3f,2.0f, 0.0f);
	                            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
	                           cylinder.DrawCylinder(1.0f, 2.0f, 32);
	 		            	   
	 		            	   GL11.glPopMatrix();
	 		               }
	 		               GL11.glPushMatrix();
	 		               {
	 		            	  GL11.glColor3f(grey[0], grey[1], grey[2]);
		                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(grey));
		                       	GL11.glScalef(1.0f,3.0f, 0.6f);
	                            GL11.glTranslatef(-0.6f,1.0f, 0.0f);
	                            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
	                          cube.DrawCube();
	 		            	   
	 		            	   GL11.glPopMatrix();
	 		               }
	 		               GL11.glPushMatrix();
	 		               {
	 		            	  GL11.glColor3f(pink[0], pink[1],pink[2]);
		                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(pink));
		                       GL11.glTexParameteri(
				    					GL11.GL_TEXTURE_2D, 	GL11.GL_TEXTURE_WRAP_T, 
				    					GL11.GL_CLAMP);	
							Color.white.bind();
			    			    myTexture3.bind();
			    			    GL11.glEnable(GL11.GL_TEXTURE_2D);    
			    			    GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);
		                       GL11.glScalef(0.15f,5.0f, 0.2f);
		                       GL11.glTranslatef(-0.6f,-1.2f, -4.0f);
		                       texCube.DrawTexCube(myTexture3);
		                       GL11.glDisable(GL11.GL_TEXTURE_2D);
		                       GL11.glPopMatrix();
	 		            	   GL11.glPushMatrix();
	 		            	   {
	 		            		  GL11.glColor3f(black[0], black[1], black[2]);
			                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(black));
			                       GL11.glScalef(0.2f, 3.5f, 0.4f);
			                       GL11.glTranslatef(-1.0f,-4.3f, -2.8f);
			                       cylinder.DrawCylinder(0.05f,2f,32);
	 		            		   
	 		            		   GL11.glPopMatrix();
	 		            	   }
	 		            	  GL11.glPushMatrix();
	 		            	   {
	 		            		   
	 		            		  GL11.glColor3f(black[0], black[1], black[2]);
			                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(black));
			                       GL11.glScalef(0.2f, 3.5f, 0.4f);
			                       GL11.glTranslatef(-1.0f,-5.3f, -2.8f);
			                       cylinder.DrawCylinder(0.05f,2f,32);
	 		            		   
	 		            		   GL11.glPopMatrix();
	 		            		   
	 		            	   }
	 		            	  GL11.glPushMatrix();
	 		            	   {
	 		            		   
	 		            		  GL11.glColor3f(black[0], black[1], black[2]);
			                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(black));
			                     GL11.glTranslatef(-1.0f,-5.3f, -2.8f);
			                       GL11.glScalef(0.2f, 3.5f, 0.4f);
			                       GL11.glRotated(90.0f, 1.0f, 0.0f, 0.0f);
			                       GL11.glTranslatef(4.0f,5.0f,0.8f);
			                       cylinder.DrawCylinder(0.05f,3f,32);
	 		            		   GL11.glPushMatrix();
	 		            		   {
	 		            			  GL11.glColor3f(pink[0], pink[1], pink[2]);
				                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(black));
				                       
				                       GL11.glTexParameteri(
						    					GL11.GL_TEXTURE_2D, 	GL11.GL_TEXTURE_WRAP_T, 
						    					GL11.GL_CLAMP);	
									Color.white.bind();
					    			    myTexture4.bind();
					    			    GL11.glEnable(GL11.GL_TEXTURE_2D);    
					    			    GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);
				                       GL11.glTranslatef(1.0f, 0.0f, 2.3f);
				                 
				                       GL11.glScalef(0.5f, 0.7f, 1.0f);
				                       GL11.glRotatef(Rotation, 0.0f, 0.0f, 1.0f);
				                       texIcosahedron.drawTexIcosahedron(myTexture4);
				                       GL11.glDisable(GL11.GL_TEXTURE_2D);
	 		            			   GL11.glPopMatrix();
	 		            		   }
	 		            		   GL11.glPopMatrix();
	 		            		   
	 		            	   }
	 		            	  GL11.glPushMatrix();
	 		            	   {
	 		            		   
	 		            		  GL11.glColor3f(black[0], black[1], black[2]);
			                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(black));
			                     GL11.glTranslatef(-1.0f,-5.3f, -2.8f);
			                       GL11.glScalef(0.2f, 3.5f, 0.4f);
			                       GL11.glRotated(90.0f, 1.0f, 0.0f, 0.0f);
			                       GL11.glTranslatef(5.0f,5.0f,0.8f);
			                       cylinder.DrawCylinder(0.05f,2f,32);
	 		            		   
	 		            		   GL11.glPopMatrix();
	 		            		   
	 		            	   }
	 		            	   
	 		               }
	 		              GL11.glPushMatrix();
	 		               {
	 		            	  GL11.glColor3f(grey[0], grey[1], grey[2]);
		                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(grey));
		                       GL11.glScalef(0.2f,0.2f, 0.3f);
		                       GL11.glTranslatef(-0.6f,-17.3f, -2.8f);
		                       cube.DrawCube();
	 		            	   GL11.glPopMatrix();
	 		               }
	 		              GL11.glPushMatrix();
	 		               {
	 		            	  GL11.glColor3f(grey[0], grey[1], grey[2]);
		                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(grey));
		                       GL11.glScalef(0.2f,0.2f, 0.3f);
		                       GL11.glTranslatef(-0.6f,-25.3f, -2.8f);
		                       cube.DrawCube();
	 		            	   GL11.glPopMatrix();
	 		               }
	 		              GL11.glPushMatrix();
	 		               {
	 		            	  GL11.glColor3f(grey[0], grey[1], grey[2]);
		                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(grey));
		                       GL11.glScalef(0.2f,0.2f, 0.3f);
		                       GL11.glTranslatef(-0.6f,-33.3f, -2.8f);
		                       cube.DrawCube();
	 		            	   GL11.glPopMatrix();
	 		               }
	 		               GL11.glPushMatrix();
	 		               {
	 		            	   
	 		            	  GL11.glColor3f(red[0], red[1], red[2]);
				               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(red));
				               GL11.glTexParameteri(
				    					GL11.GL_TEXTURE_2D, 	GL11.GL_TEXTURE_WRAP_T, 
				    					GL11.GL_CLAMP);	
							Color.white.bind();
			    			    myTexture1.bind();
			    			    GL11.glEnable(GL11.GL_TEXTURE_2D);    
			    			    GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);
			    			    if(number>=0&&number<30)
			    			    {
			    			    	 GL11.glTranslatef(-1.5f, 0.0f, 0.5f+number/60);
			    			    }
			    			    if(number>30&&number<405){
			    			    	GL11.glTranslatef(-1.5f, 0.0f, 1f);
			    			    }
			    			    if(number<0)
			    			    {
			    			    	 GL11.glTranslatef(-1.5f, 0.0f, 0.5f);
			    			    }
			    			    if(number>=405&&number<=435)
			    			    {
			    			    	GL11.glTranslatef(-1.5f, 0.0f, 1.0f-(number-405)/60);
			    			    }
			    			    if(number>435)
			    			    {
			    			    	GL11.glTranslatef(-1.5f, 0.0f, 0.5f);
			    			    }
		 		                 GL11.glScalef(0.5f,1.0f , 0.5f); 
		 		                 //GL11.glRotated(45.0f, 0.0f, 1.0f, 0.0f);
		 		                texCube.DrawTexCube(myTexture1);
		 		               GL11.glDisable(GL11.GL_TEXTURE_2D);
	 		            	   GL11.glPopMatrix();
	 		               }
	 		              GL11.glPushMatrix();
	 		               {
	 		            	   
	 		            	  GL11.glColor3f(red[0], red[1], red[2]);
				               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(red));
				               GL11.glTexParameteri(
				    					GL11.GL_TEXTURE_2D, 	GL11.GL_TEXTURE_WRAP_T, 
				    					GL11.GL_CLAMP);	
							Color.white.bind();
			    			    myTexture2.bind();
			    			    GL11.glEnable(GL11.GL_TEXTURE_2D);    
			    			    GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);
			    			    if(number>=0&&number<30)
			    			    {
			    			    	 GL11.glTranslatef(-1.5f, 0.0f, -0.5f-number/60);
			    			    }
			    			    if(number>30&&number<405){
			    			    	GL11.glTranslatef(-1.5f, 0.0f, -1f);
			    			    }
			    			    if(number<0)
			    			    {
			    			    	 GL11.glTranslatef(-1.5f, 0.0f, -0.5f);
			    			    }
			    			    if(number>=405&&number<=435)
			    			    {
			    			    	GL11.glTranslatef(-1.5f, 0.0f, -1.0f+(number-405)/60);
			    			    }
			    			    if(number>435)
			    			    {
			    			    	GL11.glTranslatef(-1.5f, 0.0f, -0.5f);
			    			    }
		 		                 GL11.glScalef(0.5f,1.0f , 0.5f); 
		 		                 //GL11.glRotated(45.0f, 0.0f, 1.0f, 0.0f);
		 		                texCube.DrawTexCube(myTexture2);
		 		               GL11.glDisable(GL11.GL_TEXTURE_2D);
	 		            	   GL11.glPopMatrix();
	 		               }
						
						GL11.glPopMatrix();
					}
				}
}
