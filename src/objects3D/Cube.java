package objects3D;

import org.lwjgl.opengl.GL11;
import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;

public class Cube {

	
	public Cube() {

	}
	
	// Implement using notes and examine Tetrahedron to aid in the coding  look at lecture  7 , 7b and 8 
	public void DrawCube() 
 {
	 Point4f vertices[] = { 	new Point4f(-1.0f, -1.0f, -1.0f,0.0f),
			 new Point4f(-1.0f, -1.0f, 1.0f,0.0f),
			 new Point4f(-1.0f, 1.0f, -1.0f,0.0f),
			 new Point4f(-1.0f, 1.0f, 1.0f,0.0f),
			 new Point4f(1.0f, -1.0f, -1.0f,0.0f),
			 new Point4f(1.0f, -1.0f, 1.0f,0.0f),
			 new Point4f(1.0f, 1.0f, -1.0f,0.0f),
			 new Point4f(1.0f, 1.0f, 1.0f,0.0f),};

	 int faces[][] = {
			 {0, 1, 3}, {0, 3, 2},
			 {0, 2, 4}, {2, 6, 4},
			 {0, 1, 4}, {1, 4, 5},
			 {1, 5, 7}, {1, 7, 3},
			 {5, 4, 6}, {5, 6, 7},
			 {2, 3, 7}, {2, 7, 6}};
	 //Find the points that make up each face

	 GL11.glBegin(GL11.GL_TRIANGLES);
	 for (int face = 0; face < 12; face++) { // per face
		 //Because a cube is made up of six faces, each face is made up of two triangles, so there are twelve faces in total
		 Vector4f v = vertices[faces[face][1]].MinusPoint(vertices[faces[face][0]]);
		 Vector4f w = vertices[faces[face][2]].MinusPoint(vertices[faces[face][0]]);
		 //Find two vectors
		 Vector4f normal = v.cross(w).Normal();
		 //Find the normal vector to these two vectors

		 GL11.glNormal3f(normal.x, normal.y, normal.z);

		 GL11.glVertex3f(vertices[faces[face][0]].x, vertices[faces[face][0]].y, vertices[faces[face][0]].z);
		 GL11.glVertex3f(vertices[faces[face][1]].x, vertices[faces[face][1]].y, vertices[faces[face][1]].z);
		 GL11.glVertex3f(vertices[faces[face][2]].x, vertices[faces[face][2]].y, vertices[faces[face][2]].z);
		 //Drawing a cube
	 } // per face
	 GL11.glEnd();

 };






 }
	

	/*
	 

}

	*/
	 