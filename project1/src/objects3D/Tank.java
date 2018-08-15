package objects3D;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

import GraphicsObjects.Point4f;
import GraphicsObjects.Utils;
import GraphicsObjects.Vector4f;
public class Tank {
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
			
			public  Tank(){
				
			}
			
			public void drawtank(Texture myTexture,Texture myTexture1,Texture myTexture2,float delta,float number) {
				float theta = (float) (delta * 2 * Math.PI);
				  float Rotation;
				  if(number>=445&&number<720)
				  {
					  Rotation = (float) Math.cos(theta)*360;
				  }
				  else {
					  Rotation = 0;
				}
				  
				TexSphere texSphere = new TexSphere();  
				Sphere sphere= new Sphere();
				Cylinder cylinder= new Cylinder();
				Cube cube = new Cube();
				TexCube texCube = new TexCube();
				Wheel wheel = new Wheel();
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
  
 		              
 		                 GL11.glScalef(6.0f,0.6f , 2.9f);            
 		                texCube.DrawTexCube(myTexture);
 		               GL11.glDisable(GL11.GL_TEXTURE_2D);
 		               //wheel1
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
 	  	
 	 		                 GL11.glTranslatef(0.6f, -3.0f, -1.0f);
 	 		               GL11.glScalef(0.16f,1.67f , 0.34f); 
 	 		                 GL11.glRotated(Rotation, 0.0f, 0.0f, 1.0f);
 	 		               GL11.glScalef(6.0f,0.6f , 2.9f); 
 	 		               GL11.glScalef(0.25f, 2.5f, 0.3f);
 	 		                wheel.DrawWheel(1.0f, 1.2f, 20, myTexture1);
 	 		               GL11.glDisable(GL11.GL_TEXTURE_2D);
 		            	   
 		            	   GL11.glPopMatrix();
 		               }
 		               //wheel2
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
	  	
	 		                 GL11.glTranslatef(0.6f, -3.0f, 0.6f);
	 		                GL11.glScalef(0.16f,1.67f , 0.34f); 
	 		                 GL11.glRotated(Rotation, 0.0f, 0.0f, 1.0f);
	 		               GL11.glScalef(6.0f,0.6f , 2.9f); 
	 		               GL11.glScalef(0.25f, 2.5f, 0.3f);
	 		                wheel.DrawWheel(1.0f, 1.2f, 20, myTexture1);
	 		               GL11.glDisable(GL11.GL_TEXTURE_2D);
		            	   
		            	   GL11.glPopMatrix();
		               }
		               //wheel3
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
	  	
	 		                 GL11.glTranslatef(-0.6f, -3.0f, 0.6f); 
	 		                GL11.glScalef(0.16f,1.67f , 0.34f); 
	 		                 GL11.glRotated(Rotation, 0.0f, 0.0f, 1.0f);
	 		               GL11.glScalef(6.0f,0.6f , 2.9f); 
	 		               GL11.glScalef(0.25f, 2.5f, 0.3f);
	 		                wheel.DrawWheel(1.0f, 1.2f, 20, myTexture1);
	 		               GL11.glDisable(GL11.GL_TEXTURE_2D);
		            	   
		            	   GL11.glPopMatrix();
		               }
		               //wheel3
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
	  	
	 		                 GL11.glTranslatef(-0.6f, -3.0f, -1.0f); 
	 		                GL11.glScalef(0.16f,1.67f , 0.34f); 
	 		                 GL11.glRotated(Rotation, 0.0f, 0.0f, 1.0f);
	 		               GL11.glScalef(6.0f,0.6f , 2.9f); 
	 		               GL11.glScalef(0.25f, 2.5f, 0.3f);
	 		                wheel.DrawWheel(1.0f, 1.2f, 20, myTexture1);
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
 		    			    myTexture.bind();
 		    			    GL11.glEnable(GL11.GL_TEXTURE_2D);    
 		    			    GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);
 		    			  
 		    			    GL11.glTranslatef(1.0f, 0.3f, 0.0f);
 	 		                 GL11.glScalef(0.4f,2.0f , 1.0f);
 	 		             GL11.glRotatef(45.0f, 0.0f, 0.0f, 1.0f);
 	 		                texCube.DrawTexCube(myTexture);
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
		    			    myTexture.bind();
		    			    GL11.glEnable(GL11.GL_TEXTURE_2D);    
		    			    GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);
		    			  
		    			    GL11.glTranslatef(0.0f, 2.0f, 0.0f);
	 		                 GL11.glScalef(1.1f,1.0f , 0.8f);
	 		                texCube.DrawTexCube(myTexture);
	 		               GL11.glDisable(GL11.GL_TEXTURE_2D);
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
			    			  
			    			    GL11.glTranslatef(-0.3f, 3.0f, 0.0f);
			    			    GL11.glScalef(0.2f, 3.5f, 0.4f);
			    			    GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
		 		               wheel.DrawWheel(2.0f, 1.0f, 32, myTexture);
		 		               GL11.glDisable(GL11.GL_TEXTURE_2D);
	 		            	   GL11.glPushMatrix();
	 		            	   {
	 		            		  GL11.glColor3f(black[0], black[1], black[2]);
			                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(black));
			                       GL11.glTranslatef(1.2f, 0.0f, 0.3f);
			                       
			                       GL11.glScalef(1.0f, 0.5f, 0.5f);
			                       
			                       if(number>720&&number<745)
			                       {
			                    	   GL11.glRotatef(number-720, 0.0f, 1.0f, 0.0f);
			                       }
			                       if(number>=745&&number<749)
			                       {
			                    	   GL11.glRotatef(35, 0.0f, 1.0f, 0.0f);
			                    	   GL11.glTranslatef(1.2f-(number-745)/10, 0.0f, 0.3f);
			                       }
			                       if(number>=749&&number<753)
			                       {
			                    	   GL11.glRotatef(35, 0.0f, 1.0f, 0.0f);
			                    	   GL11.glTranslatef(1.0f+(number-749)/10, 0.0f, 0.3f);
			                       }
			                       if(number>=753&&number<755)
			                       {
			                    	   GL11.glRotatef(35, 0.0f, 1.0f, 0.0f);
			                       }
			                       if(number>=755&&number<759)
			                       {
			                    	   GL11.glRotatef(35, 0.0f, 1.0f, 0.0f);
			                    	   GL11.glTranslatef(1.2f-(number-755)/10, 0.0f, 0.3f);
			                       }
			                       if(number>=759&&number<763)
			                       {
			                    	   GL11.glRotatef(35, 0.0f, 1.0f, 0.0f);
			                    	   GL11.glTranslatef(1.0f+(number-759)/10, 0.0f, 0.3f);
			                       }
			                       if(number>=763&&number<765)
			                       {
			                    	   GL11.glRotatef(35, 0.0f, 1.0f, 0.0f);
			                       }
			                       if(number>=765&&number<769)
			                       {
			                    	   GL11.glRotatef(35, 0.0f, 1.0f, 0.0f);
			                    	   GL11.glTranslatef(1.2f-(number-765)/10, 0.0f, 0.3f);
			                       }
			                       if(number>=769&&number<773)
			                       {
			                    	   GL11.glRotatef(35, 0.0f, 1.0f, 0.0f);
			                    	   GL11.glTranslatef(1.0f+(number-769)/10, 0.0f, 0.3f);
			                       }
			                       sphere.DrawSphere(1.0f, 32, 32);
	 		            		   GL11.glPushMatrix();
			 		               {
			 		            	  GL11.glColor3f(magenta[0], magenta[1], magenta[2]);
				                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(magenta));
				                       GL11.glTranslatef(6.0f,0.0f,-0.1f);
			                            
			                            GL11.glRotatef(-90.0f,0.0f,1.0f,0.0f);
			                            GL11.glScalef(1.0f, 1.5f, 1.0f);
			                            cylinder.DrawCylinder(0.15f,5f,32);
			 		            	   GL11.glPopMatrix();
			 		               }
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
