package objects3D;

import org.lwjgl.opengl.GL11;

import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;

public class Icosahedron {

	public Icosahedron() {
	}
	 
	// Implement using notes and examine Tetrahedron to aid in the coding  look at lecture  7 , 7b and 8 
	//remember to pre calculate out X and Z 
public void DrawIcosahedron()
{
	float X = 0.525731112119133606f;
	float Z = 0.850650808352039932f;
	Point4f vertices[] = {new Point4f(-X, 0.0f, Z ,0.0f) , new Point4f(X, 0.0f, Z,0.0f),
			new Point4f(-X, 0.0f, -Z,0.0f), new Point4f(X, 0.0f, -Z,0.0f),
			new Point4f(0.0f, Z, X,0.0f), new Point4f(0.0f, Z, -X,0.0f),
			new Point4f(0.0f, -Z, X,0.0f), new Point4f(0.0f, -Z, -X,0.0f),
			new Point4f(Z, X, 0.0f,0.0f), new Point4f(-Z, X, 0.0f,0.0f),
			new Point4f(Z, -X, 0.0f,0.0f), new Point4f(-Z, -X, 0.0f,0.0f)};

	int faces[][] = { {0,4,1}, {0,9,4},
			{9,5,4}, {4,5,8},
			{4,8,1}, {8,10,1},
			{8,3,10},{5,3,8},
			{5,2,3}, {2,7,3},
			{7,10,3}, {7,6,10},
			{7,11,6}, {11,0,6},
			{0,1,6},{6,1,10},
			{9,0,11}, {9,11,2},
			{9,2,5}, {7,2,11}};
	//Find the points that make up each face
	GL11.glBegin(GL11.GL_TRIANGLES);
	for (int face = 0; face < 20; face++) { // per face
		//Because a icosahedron is made up of 20 faces, each face is made up of one triangles, so there are 20 faces in total
		Vector4f v = vertices[faces[face][1]].MinusPoint(vertices[faces[face][0]]);
		Vector4f w = vertices[faces[face][2]].MinusPoint(vertices[faces[face][0]]);
		//Find two vectors
		Vector4f normal = v.cross(w).Normal();
		//Find the normal vector to these two vectors
		GL11.glNormal3f(normal.x, normal.y, normal.z);

		GL11.glVertex3f(vertices[faces[face][0]].x, vertices[faces[face][0]].y, vertices[faces[face][0]].z);
		GL11.glVertex3f(vertices[faces[face][1]].x, vertices[faces[face][1]].y, vertices[faces[face][1]].z);
		GL11.glVertex3f(vertices[faces[face][2]].x, vertices[faces[face][2]].y, vertices[faces[face][2]].z);
		//Drawing a icosahedron
	} // per face
	GL11.glEnd();
	 
}
}
 