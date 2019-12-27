/*
Name: Umang Godhani
Class: CS455
*/

import renderer.scene.*;

/**
   The letter W.
*/
public class W extends Model
{
   /**
      The letter W.
   */
   public W()
   {
      super("W");

      int n = 26; // number of vertices

      Vertex[] v = new Vertex[n];

      // Create vertices.
        v[0] = new Vertex(0, 0.75, 0);

        // right side of the intersect
        v[1] = new Vertex(0.125, 0, 0);
        v[2] = new Vertex(0.375, 0, 0);
        v[3] = new Vertex(0.50, 1, 0);
        v[4] = new Vertex(0.375, 1, 0);
        v[5] = new Vertex(0.25, 0.25, 0);
        v[6] = new Vertex(0.125, 1, 0);

        // left side of the intersect
        v[7] = new Vertex(-0.125, 0, 0);
        v[8] = new Vertex(-0.375, 0, 0);
        v[9] = new Vertex(-0.50, 1, 0);
        v[10] = new Vertex(-0.375, 1, 0);
        v[11] = new Vertex(-0.25, 0.25, 0);
        v[12] = new Vertex(-0.125, 1, 0);

        //back shadow
        v[13] = new Vertex(0, 0.75, 0.25);

        // right side
        v[14] = new Vertex(0.125, 0, 0.25);
        v[15] = new Vertex(0.375, 0, 0.25);
        v[16] = new Vertex(0.50, 1, 0.25);
        v[17] = new Vertex(0.375, 1, 0.25);
        v[18] = new Vertex(0.25, 0.25, 0.25);
        v[19] = new Vertex(0.125, 1, 0.25);

        // left side
        v[20] = new Vertex(-0.125, 0, 0.25);
        v[21] = new Vertex(-0.375, 0, 0.25);
        v[22] = new Vertex(-0.50, 1, 0.25);
        v[23] = new Vertex(-0.375, 1, 0.25);
        v[24] = new Vertex(-0.25, 0.25, 0.25);
        v[25] = new Vertex(-0.125, 1, 0.25);

        addVertex(v);


      // Create line segments.
        LineSegment l1 = new LineSegment(0, 1);
        LineSegment l2 = new LineSegment(1, 2);
        LineSegment l3 = new LineSegment(2, 3);
        LineSegment l4 = new LineSegment(3, 4);
        LineSegment l5 = new LineSegment(4, 5);
        LineSegment l6 = new LineSegment(5, 6);
        
        LineSegment l7 = new LineSegment(6, 12);
        
        LineSegment l8 = new LineSegment(0, 7);
        LineSegment l9 = new LineSegment(7, 8);
        LineSegment l10 = new LineSegment(8, 9);
        LineSegment l11 = new LineSegment(9, 10);
        LineSegment l12 = new LineSegment(10, 11);
        LineSegment l13 = new LineSegment(11, 12);

        int vector = 13;
        
        LineSegment l14 = new LineSegment(0+vector, 1+vector);
        LineSegment l15 = new LineSegment(1+vector, 2+vector);
        LineSegment l16 = new LineSegment(2+vector, 3+vector);
        LineSegment l17 = new LineSegment(3+vector, 4+vector);
        LineSegment l18 = new LineSegment(4+vector, 5+vector);
        LineSegment l19 = new LineSegment(5+vector, 6+vector);
        
        LineSegment l20 = new LineSegment(6+vector, 12+vector);
        
        LineSegment l21 = new LineSegment(0+vector, 7+vector);
        LineSegment l22 = new LineSegment(7+vector, 8+vector);
        LineSegment l23 = new LineSegment(8+vector, 9+vector);
        LineSegment l24 = new LineSegment(9+vector, 10+vector);
        LineSegment l25 = new LineSegment(10+vector, 11+vector);
        LineSegment l26 = new LineSegment(11+vector, 12+vector);
        
        LineSegment l27 = new LineSegment(0, 0+vector);
        LineSegment l28 = new LineSegment(1, 1+vector);
        LineSegment l29 = new LineSegment(2, 2+vector);
        LineSegment l30 = new LineSegment(3, 3+vector);
        LineSegment l31 = new LineSegment(4, 4+vector);
        LineSegment l32 = new LineSegment(5, 5+vector);
        
        LineSegment l33 = new LineSegment(6, 6+vector);
        LineSegment l34 = new LineSegment(7, 7+vector);
        LineSegment l35 = new LineSegment(8, 8+vector);
        LineSegment l36 = new LineSegment(9, 9+vector);
        LineSegment l37 = new LineSegment(10, 10+vector);
        LineSegment l38 = new LineSegment(11, 11+vector);
        LineSegment l39 = new LineSegment(12, 12+vector);
        
        this.addLineSegment(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13
                        , l14, l15, l16, l17, l18, l19, l20,l21,l22,l23,l24,l25,l26
                         ,l27,l28,l29,l30,l31,l32,l33,l34,l35,l36,l37,l38,l39  );

   }
}
