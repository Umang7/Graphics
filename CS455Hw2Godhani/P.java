/*
Name: Umang Godhani
Class: CS455
*/

import renderer.scene.*;
import renderer.pipeline.*;
import renderer.framebuffer.*;
import renderer.gui.*;
import renderer.*;

import java.awt.Color;
import java.awt.event.*;
import java.util.*;
/**
   The letter P.
*/
public class P extends Model
{
   /**
      The letter P.
   */
  
   public P()
   {
      super("P");
    int n = 24; // assignment for number of vertices

        Vertex[] v = new Vertex[n];
        // Create vertices.
        // Create the geometry of letter P.
        // The vertices for the front face
        v[0] = new Vertex(0, 0, 0);
        v[1] = new Vertex(0, 1, 0);
        v[2] = new Vertex(0.50, 1, 0);
        v[3] = new Vertex(0.675, 0.85, 0);
        v[4] = new Vertex(0.675, 0.60, 0);
        v[5] = new Vertex(0.50, 0.5, 0);
        v[6] = new Vertex(0.20, 0.5, 0);
        v[7] = new Vertex(0.20, 0, 0);
        v[8] = new Vertex(0.20, 0.85, 0);
        v[9] = new Vertex(0.50, 0.85, 0);
        v[10] = new Vertex(0.50, 0.65, 0);
        v[11] = new Vertex(0.20, 0.65, 0);

        // I defined d as 12 because there is symmetry between points of back sides and front sides,
        // The difference between points of back sides and front sides is 12. So, I have taken constant term 'd' as 12
  // This gives extra vertices designators as needed and starts a unique set for the back face. Eases troubleshooting.
        int d = 12;
        // The vertices for the back face
        v[d + 0] = new Vertex(0, 0, 0.25);
        v[d + 1] = new Vertex(0, 1, 0.25);
        v[d + 2] = new Vertex(0.50, 1, 0.25);
        v[d + 3] = new Vertex(0.675, 0.85, 0.25);
        v[d + 4] = new Vertex(0.675, 0.60, 0.25);
        v[d + 5] = new Vertex(0.50, 0.5, 0.25);
        v[d + 6] = new Vertex(0.20, 0.5, 0.25);
        v[d + 7] = new Vertex(0.20, 0, 0.25);
        v[d + 8] = new Vertex(0.20, 0.85, 0.25);
        v[d + 9] = new Vertex(0.50, 0.85, 0.25);
        v[d + 10] = new Vertex(0.50, 0.65, 0.25);
        v[d + 11] = new Vertex(0.20, 0.65, 0.25);

        addVertex(v);

        // Create line segments.
        // This is connecting the lines of the front face
        LineSegment l1 = new LineSegment(0, 1);
        LineSegment l2 = new LineSegment(1, 2);
        LineSegment l3 = new LineSegment(2, 3);
        LineSegment l4 = new LineSegment(3, 4);
        LineSegment l5 = new LineSegment(4, 5);
        LineSegment l6 = new LineSegment(5, 6);
        LineSegment l7 = new LineSegment(6, 7);
        LineSegment l8 = new LineSegment(8, 9);
        LineSegment l9 = new LineSegment(9, 10);
        LineSegment l10 = new LineSegment(10, 11);
        LineSegment l11= new LineSegment(11, 8);
        LineSegment l12 = new LineSegment(0, 7);

        // This is connecting the lines of the back face
         LineSegment l13 = new LineSegment(0 + d, 1 + d);
         LineSegment l14 = new LineSegment(1 + d, 2 + d);
         LineSegment l15 = new LineSegment(2 + d, 3 + d);
         LineSegment l16 = new LineSegment(3 + d, 4 + d);
         LineSegment l17 = new LineSegment(4 + d, 5 + d);
         LineSegment l18 = new LineSegment(5 + d, 6 + d);
         LineSegment l19 = new LineSegment(6 + d, 7 + d);
         LineSegment l20 = new LineSegment(8 + d, 9 + d);
         LineSegment l21 = new LineSegment(9 + d, 10 + d);
         LineSegment l22 = new LineSegment(10 + d, 11 + d);
         LineSegment l23 = new LineSegment(11 + d, 8 + d);
         LineSegment l24 = new LineSegment(0 + d, 7 + d);

         
         LineSegment l25 = new LineSegment(0 , d+0);
         LineSegment l26 = new LineSegment(1 , d+1);
         LineSegment l27 = new LineSegment(2 , d+2);
         LineSegment l28 = new LineSegment(3 , d+3);
         LineSegment l29 = new LineSegment(4 , d+4);
         LineSegment l30 = new LineSegment(5 , d+5);
         LineSegment l31 = new LineSegment(6 , d+6);
         LineSegment l32 = new LineSegment(7 , d+7);
         LineSegment l33 = new LineSegment(8 , d+8);
         LineSegment l34 = new LineSegment(9 ,d+9);
         LineSegment l35 = new LineSegment(10 ,d+10);
         LineSegment l36 = new LineSegment(11 ,d+11);
         
        // This connects the back and front sides together
    this.addLineSegment(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13
                        , l14, l15, l16, l17, l18, l19, l20, l21, l22, l23, l24,l25,l26,l27,l28,l29,l30,l31,l32,l33
                       ,l34,l35,l36);
      

   }
}
