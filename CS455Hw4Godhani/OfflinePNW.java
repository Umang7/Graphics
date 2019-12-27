 /*
Name : Umang Godhani
Class : CS455
Homework 4
*/

import renderer.scene.*;
import renderer.models.*;
import renderer.pipeline.*;
import renderer.framebuffer.*;

import java.awt.Color;

public class OfflinePNW
{
   public static void main(String[] args)
   {
      // Create the Scene object that we shall render.
      final Scene scene = new Scene();

      // Create a set of x and y axes.
      Model axes = new Axes2D(-2, +2, -2, +4, 8, 12);
      ModelShading.setColor(axes, Color.red);
      Position axes_p = new Position( axes );
      scene.addPosition( axes_p );
      // Push the axes away from where the camera is.
      axes_p.matrix = Matrix.translate(0, 0, -3);

      // Add the letters to the Scene.
      scene.addPosition(new Position( new P() ),
                        new Position( new N() ),
                        new Position( new W() ));

      // Give the letters random colors.
      for (Position p : scene.positionList)
      {
         ModelShading.setRandomColor(p.model);
      }

      // Create a FrameBuffer to render our scene into.
      int width  = 900;
      int height = 900;
      FrameBuffer fb = new FrameBuffer(width, height);
      int a = 1,b=1, c=1,d=0;
      // Create the animation frames.
      for (int i = 0; i < 360; i++)
      {
         // Push the letters away from the camera.
         scene.positionList.get(1).matrix = Matrix.translate(-2, 0, -3); // P
         scene.positionList.get(2).matrix = Matrix.translate(-0.5, 0, -3); // N
         scene.positionList.get(3).matrix = Matrix.translate(1, 0, -3); // W

         // do P

       scene.positionList.get(1).matrix.mult(Matrix.translate(2, 0, 0));
       scene.positionList.get(1).matrix.mult(Matrix.rotateZ(-i));
       scene.positionList.get(1).matrix.mult(Matrix.translate(-2,0,0));
                                                             

         // do N
if(i <= 90)  
{
    scene.positionList.get(2).matrix.mult(Matrix.translate(i*0.0055, i*-0.0223, 0));
    scene.positionList.get(2).matrix.mult(Matrix.rotateY(i));
    }
else if ((i > 90) && (i <= 270))  
{  
  if(i<180)
  {
     scene.positionList.get(2).matrix.mult(Matrix.translate(i*0.0055,-2.007+ a*0.0223, 0)); 
     a++;
     scene.positionList.get(2).matrix.mult(Matrix.rotateY(i));
  }
  else
  {
    scene.positionList.get(2).matrix.mult(Matrix.translate(0.99-c*0.0055,-2.007+ a*0.0223, 0)); 
     a++;
     c++;
     scene.positionList.get(2).matrix.mult(Matrix.rotateY(i));
  }
    }
else  
{
     scene.positionList.get(2).matrix.mult(Matrix.translate(0.495-d*0.0055, 2.007 -b*0.0223, 0)); // The l variable is used as the down value
     b++;
     d++;
     scene.positionList.get(2).matrix.mult(Matrix.rotateY(i));
    }
     
         // do W
      scene.positionList.get(3).matrix.mult(Matrix.translate(1.0, 1.0, 0));
      scene.positionList.get(3).matrix.mult(Matrix.rotateZ(2*i));  // choose any axis
      scene.positionList.get(3).matrix.mult(Matrix.translate(-1.0, -1.0, 0));
      
         // Render again.
         fb.clearFB(Color.black);
         Pipeline.render(scene, fb.vp);
         fb.dumpFB2File(String.format("PPM_PNW_Frame%03d.ppm", i));
      }
   }
}
