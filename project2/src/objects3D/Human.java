package objects3D;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

import GraphicsObjects.Point4f;
import GraphicsObjects.Utils;
import GraphicsObjects.Vector4f;

public class Human {

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
	
	
	public Human() {

	}
	
	// Implement using notes  in Animation lecture  
	public void DrawHuman(float delta,boolean GoodAnimation,Texture myTexture,Texture myTexture1,Texture myTexture2) 
 { 
		 float theta = (float) (delta * 2 * Math.PI);
		  float LimbRotation;
		 if (GoodAnimation)
		 {
			 LimbRotation = (float) Math.cos(theta)*45;
		 }else
		 {
			 LimbRotation =0;
		 } 
		TexSphere texSphere = new TexSphere();  
		Sphere sphere= new Sphere();
		Cylinder cylinder= new Cylinder();
		Cube cube = new Cube();
		TexCube texCube = new TexCube();
		 GL11.glPushMatrix(); 
		 
		 {
			  GL11.glTranslatef(0.0f,0.5f,0.0f);
			 sphere.DrawSphere(0.5f, 32, 32); 

		        //  chest
			 GL11.glColor3f(green[0], green[1], green[2]);
			 GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(green));
			 GL11.glTexParameteri(
 					GL11.GL_TEXTURE_2D, 	GL11.GL_TEXTURE_WRAP_T, 
 					GL11.GL_CLAMP);
 		  
 			Color.white.bind();
 			    myTexture2.bind();
 			    GL11.glEnable(GL11.GL_TEXTURE_2D);    
 			    GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);
			 GL11.glPushMatrix(); {
				 
		            GL11.glTranslatef(0.0f,0.5f,0.0f);
		            
		            texSphere.DrawTexSphere(0.5f, 32, 32, myTexture2);
		            GL11.glDisable(GL11.GL_TEXTURE_2D);
		           // GL11.glRotated(90.0f, 0.0f, 1.0f, 0.0f);


		            // neck
		       	 GL11.glColor3f(orange[0], orange[1], orange[2]);
		           GL11.glMaterial( GL11.GL_FRONT,  GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
		            GL11.glPushMatrix(); {
		                GL11.glTranslatef(0.0f,0.0f, 0.0f);
		               GL11.glRotatef(-90.0f,1.0f,0.0f,0.0f);
		                                 //  GL11.glRotatef(45.0f,0.0f,1.0f,0.0f); 
		                cylinder.DrawCylinder(0.15f,0.7f,32);


		                // head
		           	 GL11.glColor3f(red[0], red[1], red[2]);
		               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(red));
		               GL11.glTexParameteri(
		    					GL11.GL_TEXTURE_2D, 	GL11.GL_TEXTURE_WRAP_T, 
		    					GL11.GL_CLAMP);
		    		  
		    			Color.white.bind();
		    			    myTexture.bind();
		    			    GL11.glEnable(GL11.GL_TEXTURE_2D);    
		    			    GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);
		    		        //GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		                GL11.glPushMatrix(); {
		                    GL11.glTranslatef(0.0f,0.0f,1.0f);
		                    GL11.glRotated(50.0f, 0.0f, 0.0f, 1.0f);
		                    GL11.glRotated(160.0f, 1.0f, 0.0f, 0.0f);
		                   GL11.glRotated(-30.0f, 0.0f, 1.0f, 0.0f);//rotate the head to the correct position
		                    texSphere.DrawTexSphere(0.5f, 32, 32,myTexture);
		                    GL11.glDisable(GL11.GL_TEXTURE_2D);
		                    
		                    	//nose
		                    	//add the nose to the front of the head to make the clown look more vivid
		                    	GL11.glColor3f(red[0], red[1], red[2]);
		                    	 GL11.glMaterial( GL11.GL_FRONT,  GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(red));
		                    	 GL11.glPushMatrix(); {
		     		                GL11.glTranslatef(0.3f,-0.27f, -0.30f);
		     		               //GL11.glRotatef(-90.0f,1.0f,0.0f,0.0f);
		     		                                 //  GL11.glRotatef(45.0f,0.0f,1.0f,0.0f); 
		     		                sphere.DrawSphere(0.15f, 32, 32);
		                    	 
		                    	 
		                    	 GL11.glPopMatrix();
		                    	 } 
		                    	 
		                    	 //hat
		                    	 //add a  texturecube to the top of the head
		                    	 GL11.glColor3f(magenta[0], magenta[1], magenta[2]);
		                    	 GL11.glMaterial( GL11.GL_FRONT,  GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(magenta));
		                    	 GL11.glTexParameteri(
		 		    					GL11.GL_TEXTURE_2D, 	GL11.GL_TEXTURE_WRAP_T, 
		 		    					GL11.GL_CLAMP);
		 		    		  
		 		    			Color.white.bind();
		 		    			    myTexture1.bind();
		 		    			    GL11.glEnable(GL11.GL_TEXTURE_2D);    
		 		    			    GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);
		                    	 GL11.glPushMatrix(); {
			     		                GL11.glTranslatef(-0.3f,0.3f, -0.7f);
			     		                GL11.glScalef(0.3f, 0.3f, 0.4f);
			     		               GL11.glRotatef(30.0f,1.0f,1.0f,0.0f);
			     		                             
			     		                texCube.DrawTexCube(myTexture1);
			     		               GL11.glDisable(GL11.GL_TEXTURE_2D);
			                    	 
			                    	 GL11.glPopMatrix();
			                    	 } 
		                    	 
		                    	 GL11.glPopMatrix();
		                } GL11.glPopMatrix();
		                //pop back to chest

		                // left shoulder
		           	 GL11.glColor3f(blue[0],blue[1], blue[2]);
		               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
		                GL11.glPushMatrix(); {
		                    GL11.glTranslatef(0.5f,0.4f,0.0f);
		                    sphere.DrawSphere(0.2f, 32, 32); 
		                    

		                    // left arm
		               	 GL11.glColor3f(orange[0], orange[1], orange[2]);
		                   GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
		                    GL11.glPushMatrix(); {
		                        GL11.glTranslatef(0.0f,0.0f,0.0f);
		                        GL11.glRotatef(90.0f,1.0f,0.0f,0.0f);
		                        
		                        
		                        GL11.glRotatef(LimbRotation,1.0f,0.0f,0.0f); 
		                     //   GL11.glRotatef(27.5f,0.0f,1.0f,0.0f);  
		                        cylinder.DrawCylinder(0.15f,0.7f,32);


		                        // left elbow
		                   	 GL11.glColor3f(blue[0], blue[1], blue[2]);
		                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
		                        GL11.glPushMatrix(); {
		                            GL11.glTranslatef(0.0f,0.0f,0.75f);
		                            sphere.DrawSphere(0.1f, 32, 32); 
		                            
		                            //left forearm
		                       	 GL11.glColor3f(orange[0], orange[1], orange[2]);
		                           GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
		                            GL11.glPushMatrix(); {
		                                GL11.glTranslatef(0.0f,0.0f,0.0f);
		                                               GL11.glRotatef(60.0f,1.0f,0.0f,0.0f);
		                                               GL11.glRotatef(LimbRotation/1.2f,1.0f,0.0f,0.0f); //let the forearm move as the up arm move
		                             //   GL11.glRotatef(90.0f,0.0f,1.0f,0.0f); 
		                                cylinder.DrawCylinder(0.1f,0.7f,32);

		                                // left hand
		                           	 GL11.glColor3f(blue[0], blue[1], blue[2]);
		                               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
		                                GL11.glPushMatrix(); {
		                                    GL11.glTranslatef(0.0f,0.0f,0.75f);
		                                    sphere.DrawSphere(0.1f, 32, 32); 
		                                    


		                                } GL11.glPopMatrix();
		                            } GL11.glPopMatrix();
		                        } GL11.glPopMatrix();
		                    } GL11.glPopMatrix ();
		                } GL11.glPopMatrix ();
		                // to chest

		                // right shoulder
		                GL11.glColor3f(blue[0],blue[1], blue[2]);
			               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
			                GL11.glPushMatrix(); {
			                    GL11.glTranslatef(-0.5f,0.4f,0.0f);
			                    sphere.DrawSphere(0.2f, 32, 32); 

		                    // right arm
			                    GL11.glColor3f(orange[0], orange[1], orange[2]);
				                   GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
				                    GL11.glPushMatrix(); {
				                        GL11.glTranslatef(0.0f,0.0f,0.0f);
				                        GL11.glRotatef(90.0f,1.0f,0.0f,0.0f);
				                        
				                        
				                        GL11.glRotatef(LimbRotation,-1.0f,0.0f,0.0f); 
				                      // GL11.glRotatef(27.5f,0.0f,1.0f,0.0f);  
				                        cylinder.DrawCylinder(0.15f,0.7f,32);
		                        // right elbow
				                        GL11.glColor3f(blue[0], blue[1], blue[2]);
					                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
					                        GL11.glPushMatrix(); {
					                            GL11.glTranslatef(0.0f,0.0f,0.75f);
					                            sphere.DrawSphere(0.1f, 32, 32);
		                            //right forearm
					                            GL11.glColor3f(orange[0], orange[1], orange[2]);
						                           GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
						                            GL11.glPushMatrix(); {
						                                GL11.glTranslatef(0.0f,0.0f,0.0f);
						                             
						                                               GL11.glRotatef(60.0f,1.0f,0.0f,0.0f);
						                                               GL11.glRotatef(-LimbRotation/1.2f,1.0f,0.0f,0.0f);//let the forearm move as the up arm move 
						                                //GL11.glRotatef(90.0f,0.0f,1.0f,0.0f); 
						                                cylinder.DrawCylinder(0.1f,0.7f,32);
		                                // right hand
						                                GL11.glColor3f(blue[0], blue[1], blue[2]);
							                               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
							                                GL11.glPushMatrix(); {
							                                    GL11.glTranslatef(0.0f,0.0f,0.75f);
							                                    sphere.DrawSphere(0.1f, 32, 32); 
							                                      
		                                   
		                         
							                                } GL11.glPopMatrix();
						                            } GL11.glPopMatrix();
						                        } GL11.glPopMatrix();
						                    } GL11.glPopMatrix ();
						                } GL11.glPopMatrix ();
		                //chest


		            } GL11.glPopMatrix();


		            // pelvis

		            // left hip
		       	 GL11.glColor3f(blue[0], blue[1], blue[2]);
		           GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
		            GL11.glPushMatrix(); {
		                GL11.glTranslatef(-0.4f,-0.2f,0.0f);
		               
		                sphere.DrawSphere(0.15f, 32, 32); 


		                // left high leg
		           	 GL11.glColor3f(orange[0], orange[1], orange[2]);
		               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
		                GL11.glPushMatrix(); {
		                    GL11.glTranslatef(0.0f,0.0f,0.0f);
		                    GL11.glRotatef(0.0f,0.0f,0.0f,0.0f);
		                
		                    
		                    GL11.glRotatef((LimbRotation/2)+90,1.0f,0.0f,0.0f); 
		                            //   GL11.glRotatef(90.0f,1.0f,0.0f,0.0f); 
		                    cylinder.DrawCylinder(0.15f,0.7f,32);


		                    // left knee
		               	 GL11.glColor3f(blue[0], blue[1], blue[2]);
		                   GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
		                    GL11.glPushMatrix(); {
		                        GL11.glTranslatef(0.0f,0.0f,0.75f);
		                        GL11.glRotatef(0.0f,0.0f,0.0f,0.0f); 
		                        sphere.DrawSphere(0.15f, 32, 32); 

		                        //left low leg
		                   	 GL11.glColor3f(orange[0], orange[1], orange[2]);
		                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
		                        GL11.glPushMatrix(); {
		                            GL11.glTranslatef(0.0f,0.0f,0.0f);
		                           // GL11.glRotatef(120.0f,1.0f,0.0f,0.0f);
		                            GL11.glRotatef(-20.0f,1.0f,0.0f,0.0f); 
		                            GL11.glRotatef((LimbRotation/(1.4f)),1.0f,0.0f,0.0f);//let the log leg move as the high leg move
		                            cylinder.DrawCylinder(0.15f,0.7f,32);

		                            // left foot
		                       	 GL11.glColor3f(blue[0], blue[1], blue[2]);
		                           GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
		                            GL11.glPushMatrix(); {
		                                GL11.glTranslatef(0.0f,0.0f,0.75f);
		                                sphere.DrawSphere(0.2f, 32, 32);  

		                            } GL11.glPopMatrix();
		                        } GL11.glPopMatrix();
		                    } GL11.glPopMatrix();
		                } GL11.glPopMatrix();
		            } GL11.glPopMatrix();

		            // pelvis
		            

		            // right hip
		            GL11.glColor3f(blue[0], blue[1], blue[2]);
			           GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
			            GL11.glPushMatrix(); {
			                GL11.glTranslatef(0.4f,-0.2f,0.0f);
			               
			                sphere.DrawSphere(0.15f, 32, 32); 
			                // right high leg
				           	 GL11.glColor3f(orange[0], orange[1], orange[2]);
				               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
				                GL11.glPushMatrix(); {
				                    GL11.glTranslatef(0.0f,0.0f,0.0f);
				                    GL11.glRotatef(0.0f,0.0f,0.0f,0.0f);
				                
				                    
				                    GL11.glRotatef((-LimbRotation/2)+90,1.0f,0.0f,0.0f); 
				                            //   GL11.glRotatef(90.0f,1.0f,0.0f,0.0f); 
				                    cylinder.DrawCylinder(0.15f,0.7f,32);


				                    // right knee
				               	 GL11.glColor3f(blue[0], blue[1], blue[2]);
				                   GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
				                    GL11.glPushMatrix(); {
				                        GL11.glTranslatef(0.0f,0.0f,0.75f);
				                        GL11.glRotatef(0.0f,0.0f,0.0f,0.0f); 
				                        sphere.DrawSphere(0.15f, 32, 32); 

				                        //right low leg
				                   	 GL11.glColor3f(orange[0], orange[1], orange[2]);
				                       GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
				                        GL11.glPushMatrix(); {
				                            GL11.glTranslatef(0.0f,0.0f,0.0f);
				                            
				                           // GL11.glRotatef(120.0f,1.0f,0.0f,0.0f);
				                            GL11.glRotatef(-20.0f,1.0f,0.0f,0.0f); 
				                            GL11.glRotatef((-LimbRotation/1.4f),1.0f,0.0f,0.0f);//let the log leg move as the high leg move
				                            cylinder.DrawCylinder(0.15f,0.7f,32);

				                            // right foot
				                       	 GL11.glColor3f(blue[0], blue[1], blue[2]);
				                           GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(blue));
				                            GL11.glPushMatrix(); {
				                                GL11.glTranslatef(0.0f,0.0f,0.75f);
				                                sphere.DrawSphere(0.2f, 32, 32);  

				                            } GL11.glPopMatrix();
				                        } GL11.glPopMatrix();
				                    } GL11.glPopMatrix();
				                } GL11.glPopMatrix();
				            } GL11.glPopMatrix();
		        } GL11.glPopMatrix();
		         
		    } 

		

	}
	
	
	
}
 
	/*
	 
	 
}

	*/
	 