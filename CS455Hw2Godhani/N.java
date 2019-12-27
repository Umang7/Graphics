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
   The letter N.
*/
public class N extends Model
{
   /**
      The letter N.
   */
  
  public N()
   {
      super("N");

      int n = 20; // number of vertices

      Vertex[] v = new Vertex[n];

      // Create vertices.
        v[0] = new Vertex(0, 0, 0);
        v[1] = new Vertex(0.25, 0, 0);
        v[2] = new Vertex(0, 1, 0);
        v[3] = new Vertex(0.25, 1, 0);
        v[4] = new Vertex(0.25, 0.75, 0);
        v[5] = new Vertex(0.75, 0.25, 0);
        v[6] = new Vertex(0.75, 0, 0);
        v[7] = new Vertex(1, 0, 0);
        v[8] = new Vertex(0.75, 1, 0);
        v[9] = new Vertex(1, 1, 0);

        // back face
        v[10] = new Vertex(0, 0, 0.25);
        v[11] = new Vertex(0.25, 0, 0.25);
        v[12] = new Vertex(0, 1, 0.25);
        v[13] = new Vertex(0.25, 1, 0.25);
        v[14] = new Vertex(0.25, 0.75, 0.25);
        v[15] = new Vertex(0.75, 0.25, 0.25);
        v[16] = new Vertex(0.75, 0, 0.25);
        v[17] = new Vertex(1, 0, 0.25);
        v[18] = new Vertex(0.75, 1, 0.25);
        v[19] = new Vertex(1, 1, 0.25);

        addVertex(v);
      


      // Create line segments.
        LineSegment l1 = new LineSegment(0, 1);
        LineSegment l2 = new LineSegment(0, 2);
        LineSegment l3 = new LineSegment(2, 3);
        LineSegment l4 = new LineSegment(1, 4);
        LineSegment l5 = new LineSegment(3, 5);
        LineSegment l6 = new LineSegment(4, 6);
        LineSegment l7 = new LineSegment(6, 7);
        LineSegment l8 = new LineSegment(7, 9);
        LineSegment l9 = new LineSegment(5, 8);
        LineSegment l10 = new LineSegment(8, 9);

        // back face
        LineSegment l11 = new LineSegment(10, 11);
        LineSegment l12= new LineSegment(10, 12);
        LineSegment l13= new LineSegment(12, 13);
        LineSegment l14= new LineSegment(11, 14);
        LineSegment l15= new LineSegment(13, 15);
        LineSegment l16= new LineSegment(14, 16);
        LineSegment l17= new LineSegment(16, 17);
        LineSegment l18= new LineSegment(17, 19);
        LineSegment l19= new LineSegment(15, 18);
        LineSegment l20= new LineSegment(18, 19);
        
        LineSegment l21 = new LineSegment(0, 10);
        LineSegment l22= new LineSegment(1, 11);
        LineSegment l23= new LineSegment(2, 12);
        LineSegment l24= new LineSegment(3, 13);
        LineSegment l25= new LineSegment(4, 14);
        LineSegment l26= new LineSegment(5, 15);
        LineSegment l27= new LineSegment(6, 16);
        LineSegment l28= new LineSegment(7, 17);
        LineSegment l29= new LineSegment(8, 18);
        LineSegment l30= new LineSegment(9, 19);
        
        this.addLineSegment(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13
                        , l14, l15, l16, l17, l18, l19, l20,l21,l22,l23,l24,l25,l26,l27,l28,l29,l30);

   }
}
