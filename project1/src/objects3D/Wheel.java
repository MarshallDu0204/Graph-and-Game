package objects3D;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;
import java.math.*;

public class Wheel {
	
	public Wheel(){
		
	}
	
	public void DrawWheel(float radius, float height, int nSegments,Texture myTexture) 
	{
		 for(float i=0.0f;i<nSegments;i=i+1.0f)	 
		 {
			 float angle = (float) (Math.PI*i*2.0/nSegments);
			 float nextangle = (float) (Math.PI*(i+1.0)*2.0/nSegments);
			 float x1=(float) Math.sin(angle)*radius;
			 float y1 = (float) Math.cos(angle)*radius;
			 float x2 = (float) Math.sin(nextangle)*radius;
			 float y2 = (float) Math.cos(nextangle)*radius;
			 
			 Point4f verticesA[] = { 	new Point4f(x1,y1,0.0f,0.0f), 
						new Point4f(x2,y2,height,0.0f),
						new Point4f(x1,y1,height,0.0f),};//green triangle
			 
			 int[][] faces = { 	{ 0,1,2 }};
			 
			 Point4f verticesB[] = { 	new Point4f(x1,y1,0.0f,0.0f), 
						new Point4f(x2,y2,0.0f,0.0f),
						new Point4f(x2,y2,height,0.0f),};//red triangle
			 int[][] faces1 = { 	{ 0,1,2 }};
			 
			 Point4f verticesC[] = {	new Point4f(x1,y1,0.0f,0.0f), 
						new Point4f(x2,y2,0.0f,0.0f),
						new Point4f(0.0f,0.0f,0.0f,0.0f),};//bottom triangle
			 
			 int[][] faces2 = {{ 0,1,2 }};
			 Point4f verticesD[] = {	new Point4f(x1,y1,height,0.0f), 
						new Point4f(x2,y2,height,0.0f),
						new Point4f(0.0f,0.0f,height,0.0f),};//top triangle
			 
			 int[][] faces3 = {{ 0,1,2 }};
			
			 GL11.glBegin(GL11.GL_TRIANGLES);
				for (int face = 0; face < 1; face++) { // per face
					Vector4f v = verticesA[faces[face][1]].MinusPoint(verticesA[faces[face][0]]); 
					Vector4f w = verticesA[faces[face][2]].MinusPoint(verticesA[faces[face][0]]);
					
				 	
					GL11.glNormal3f(verticesA[faces[face][0]].x, verticesA[faces[face][0]].y, verticesA[faces[face][0]].z);
					GL11.glVertex3f(verticesA[faces[face][0]].x, verticesA[faces[face][0]].y, verticesA[faces[face][0]].z);
					GL11.glTexCoord2f(0.0f,0.0f);
					GL11.glNormal3f(verticesA[faces[face][1]].x, verticesA[faces[face][1]].y, verticesA[faces[face][1]].z);
					GL11.glVertex3f(verticesA[faces[face][1]].x, verticesA[faces[face][1]].y, verticesA[faces[face][1]].z);
					GL11.glTexCoord2f(0.0f,1.0f);
					GL11.glNormal3f(verticesA[faces[face][2]].x, verticesA[faces[face][2]].y, verticesA[faces[face][2]].z);
					GL11.glVertex3f(verticesA[faces[face][2]].x, verticesA[faces[face][2]].y, verticesA[faces[face][2]].z);
					GL11.glTexCoord2f(1.0f,1.0f);
					GL11.glTexCoord2f(1.0f,0.0f);
					Vector4f v1 = verticesB[faces[face][1]].MinusPoint(verticesB[faces[face][0]]); 
					Vector4f w1 = verticesB[faces[face][2]].MinusPoint(verticesB[faces[face][0]]);
					
				 	
					GL11.glNormal3f(verticesB[faces[face][0]].x, verticesB[faces[face][0]].y, verticesB[faces[face][0]].z);
					GL11.glVertex3f(verticesB[faces[face][0]].x, verticesB[faces[face][0]].y, verticesB[faces[face][0]].z);
					GL11.glTexCoord2f(0.0f,0.0f);
					GL11.glNormal3f(verticesB[faces[face][1]].x, verticesB[faces[face][1]].y, verticesB[faces[face][1]].z);
					GL11.glVertex3f(verticesB[faces[face][1]].x, verticesB[faces[face][1]].y, verticesB[faces[face][1]].z);
					GL11.glTexCoord2f(0.0f,1.0f);
					GL11.glNormal3f(verticesB[faces[face][2]].x, verticesB[faces[face][2]].y, verticesB[faces[face][2]].z);
					GL11.glVertex3f(verticesB[faces[face][2]].x, verticesB[faces[face][2]].y, verticesB[faces[face][2]].z);
					GL11.glTexCoord2f(1.0f,1.0f);
					GL11.glTexCoord2f(1.0f,0.0f);
					Vector4f v2 = verticesC[faces[face][1]].MinusPoint(verticesC[faces[face][0]]); 
					Vector4f w2 = verticesC[faces[face][2]].MinusPoint(verticesC[faces[face][0]]);
					Vector4f normal2 = v2.cross(w2).Normal();
					
				 	GL11.glNormal3f(normal2.x, normal2.y, normal2.z);
				 	
					GL11.glVertex3f(verticesC[faces[face][0]].x, verticesC[faces[face][0]].y, verticesC[faces[face][0]].z);
					GL11.glTexCoord2f(0.0f,0.0f);
					GL11.glVertex3f(verticesC[faces[face][1]].x, verticesC[faces[face][1]].y, verticesC[faces[face][1]].z);
					GL11.glTexCoord2f(0.0f,1.0f);
					GL11.glVertex3f(verticesC[faces[face][2]].x, verticesC[faces[face][2]].y, verticesC[faces[face][2]].z);
					GL11.glTexCoord2f(1.0f,1.0f);
					GL11.glTexCoord2f(1.0f,0.0f);
					
					Vector4f v3 = verticesD[faces[face][1]].MinusPoint(verticesD[faces[face][0]]); 
					Vector4f w3 = verticesD[faces[face][2]].MinusPoint(verticesD[faces[face][0]]);
					Vector4f normal3 = v3.cross(w3).Normal();
					
				 	GL11.glNormal3f(normal3.x, normal3.y, normal3.z);
				 	
					GL11.glVertex3f(verticesD[faces[face][0]].x, verticesD[faces[face][0]].y, verticesD[faces[face][0]].z);
					GL11.glTexCoord2f(0.0f,0.0f);
					GL11.glVertex3f(verticesD[faces[face][1]].x, verticesD[faces[face][1]].y, verticesD[faces[face][1]].z);
					GL11.glTexCoord2f(0.0f,1.0f);
					GL11.glVertex3f(verticesD[faces[face][2]].x, verticesD[faces[face][2]].y, verticesD[faces[face][2]].z);
					GL11.glTexCoord2f(1.0f,1.0f);
					GL11.glTexCoord2f(1.0f,0.0f);
				} // per face
				GL11.glEnd();
		 }
	}

}
