/*
Name : Umang Godhani
Class : CS455
*/

import framebuffer.*;
import java.awt.*;

public class Hw_1
{
   public static void main(String[] args)
   {
      // Check for a file name on the command line.
      if ( 0 == args.length )
      {
         System.err.println("Usage: java Hw_1 <PPM-file-name>");
         System.exit(-1);
      }

      // This framebuffer holds the image that will be embedded
      // within a viewport of our larger framebuffer.
      FrameBuffer fbEmbedded = new FrameBuffer( args[0] );

      /******************************************/

      // Your code goes here.
      FrameBuffer fb = new FrameBuffer(1000,600);//making new fb refrence to FrameBuffer object
      // Create a framebuffer. Fill it with the checkerboard pattern. 
     for (int Vertical = 0;  Vertical < 6;  Vertical++ ) 
       {
           for (int Horizontal = 0;  Horizontal < 10;  Horizontal++)
           {
             int Vert = Vertical * 100;
             int Hori = Horizontal * 100;

             // a way to findout which color to put and where
             if (((Vertical + Horizontal) % 2) == 0 )

               for(int i=0; i<100; i++)
             {
               for (int j=0; j<100;j++)
               {
                fb.setPixelFB(Hori,Vert,new Color(255,189,96));//setting the darker sqaures
                Hori++;
               } 
              Hori=Hori-100;
              Vert++;
              }
             else
                for(int i=0; i<100; i++)
             {
               for (int j=0; j<100;j++)
               {
                fb.setPixelFB(Hori,Vert,new Color(192,56,14));//setting the lighter sqaures
                Hori++;
               } 
              Hori=Hori-100;
              Vert++;
            }
          }
     }
      // Create a viewport to hold the given PPM file. Put the PPM file in the viewport.
     FrameBuffer.Viewport vpfirstTrooper = fb.new Viewport(75,125,"RebelTrooper.ppm");// trooper one
        
      // Create another viewport and fill it with a flipped copy of the PPM file.
     FrameBuffer.Viewport vpsecondTrooper = fb.new Viewport(331,125,256,256);// trooper two
    
     for (int i = 0; i < 256; i++)
        for(int j = 0; j < 256; j++)
         {
            vpsecondTrooper.setPixelVP(255-i, j, vpfirstTrooper.getPixelVP(i,j) );  // flipping second trooper
       }
     
      // Create another viewport and fill it with the striped pattern.
         FrameBuffer.Viewport vpStripes= fb.new Viewport(610,420,300,120);
         
         for (int i=0; i <300 ;  i++)
         {
           for (int j=0; j <120; j++)
           {
            int pixelCounter = i+j;   //weird but working way to findout which color goes where
            if ((pixelCounter/30)%3==0)
           vpStripes.setPixelVP(i,j,new Color(241,95,116));// pinkish
            else if ((pixelCounter/30)%3==1)
           vpStripes.setPixelVP(i,j,new Color (152,203,74));// greenish
            else
           vpStripes.setPixelVP(i,j,new Color (84,129,230));// blueish
           }
         }

      // Create another viewport that covers the selected region of the framebuffer.
           FrameBuffer.Viewport vpGraySpace= fb.new Viewport(725,25,250,350);
            for (int i = 0; i < 250; i++)
        for(int j = 0; j < 350; j++)
         {
            vpGraySpace.setPixelVP(i, j, new Color (192,192,192) );  //filling with grayish color
       }
            
      // Create another viewport inside the last one.
             FrameBuffer.Viewport vpSpecialP= fb.new Viewport(750,50,200,300);// assigning the place in middle of gray space
      
      // Copy the selected region's viewport into this last viewport.
           for(int i=0;i<200;i++)
             for(int j=0;j<300;j++)
           {
            vpSpecialP.setPixelVP(i,j,fb.getPixelFB(500+i,200+j)) ;
           }

      /******************************************/
      // Save the resulting image in a file.
      String savedFileName = "Hw_1.ppm";
      fb.dumpFB2File( savedFileName );
      System.err.println("Saved " + savedFileName);
   }
}

