/*
 * Name: Umang Godhani 
 * Class: CS 455
*/

import renderer.scene.*;
import renderer.models.*;
import renderer.pipeline.*;
import renderer.framebuffer.*;
import renderer.gui.*;
import java.awt.Color;
import java.awt.event.*;


public class Hw3 extends MouseAdapter {
  private int pos_X;   //coordinate of X
  private int pos_Y;   //coordinate of Y
  private Vertex[] pos_Center = new Vertex[5];
  private double[] size = new double[5];
  private boolean[] click = new boolean[5];
  private Vertex cameraVertex;
  protected Vertex prevVertex;
  public static boolean debugging = false;

  /**
   * This constructor instantiates the Scene object and initializes it with appropriate geometry.
   */
  public Hw3() {
    // Define initial dimensions for a FrameBuffer.
    final int fbWidth = 1024;
    final int fbHeight = 1024;


    // Create a FrameBufferFrame holding a FrameBufferPanel.
    FrameBufferFrame fbf = new FrameBufferFrame("Renderer 2", fbWidth, fbHeight);
    fbf.setResizable(false);

    // Create the Scene object that we shall render
    Scene scene = new Scene();

    // Create several Model objects.
    scene.addModel(new Square(1));
    scene.addModel(new Square(2));
    scene.addModel(new Square(3));
    scene.addModel(new Circle(3, 4));
    scene.addModel(new Circle(3, 64));

    // Give each model a useful name.
    scene.modelList.get(0).name = "Square_1";
    scene.modelList.get(1).name = "Square_2";
    scene.modelList.get(2).name = "Square_3";
    scene.modelList.get(3).name = "Diamond";
    scene.modelList.get(4).name = "Circle";

    // Push the models away from where the camera is.
    for (Model m : scene.modelList) {
      for (Vertex v : m.vertexList) {
        v.z -= 10;
      }
    }

    // Give each model an initial position in the scene.
    for (Vertex v : scene.modelList.get(0).vertexList) {
      v.x += 0;
      v.y += 0;
    }
    for (Vertex v : scene.modelList.get(1).vertexList) {
      v.x -= 5;
      v.y -= 5;
    }
    for (Vertex v : scene.modelList.get(2).vertexList) {
      v.x += 5;
      v.y += 5;
    }
    for (Vertex v : scene.modelList.get(3).vertexList) {
      v.x += 5;
      v.y -= 5;
    }
    for (Vertex v : scene.modelList.get(4).vertexList) {
      v.x -= 5;
      v.y += 5;
    }

    // Render.
    FrameBuffer fb = fbf.fbp.getFrameBuffer();
    fb.clearFB(Color.black);
    Pipeline.render(scene, fb.vp);
    fbf.fbp.update();
    fbf.repaint();

    //Center of each model in camera space
    pos_Center[0] = new Vertex(0.0, 0.0, -10.0);
    pos_Center[1] = new Vertex(-5.0, -5.0, -10.0);
    pos_Center[2] = new Vertex(5.0, 5.0, -10.0);
    pos_Center[3] = new Vertex(5.0, -5.0, -10.0);
    pos_Center[4] = new Vertex(-5.0, 5.0, -10.0);
    
    //Length/radius of the model
    size[0] = 1.0;
    size[1] = 2.0;
    size[2] = 3.0;
    size[3] = 3.0;
    size[4] = 3.0;

    //figuring out if the the model has been clicked/not
    for (int i = 0; i < click.length; i++) {
      click[i] = false;
    }

    // An anonymous local inner class constructor.
    fbf.addKeyListener(new KeyListener() { 
      // Implement the three methods of the KeyListener interface.
      @Override
      public void keyPressed(KeyEvent e) {}

      @Override
      public void keyReleased(KeyEvent e) {}

      @Override
      public void keyTyped(KeyEvent e) {
        logMessage(e.toString());
        char c = e.getKeyChar();
        if ('d' == c) { // Toggle debugging
          debugging = !debugging;
          System.out.print("Model debugging is turned ");
          System.out.println(debugging ? "On" : "Off");
          
        } else if ('c' == c) { // Toggle Clipping
          Pipeline.doClipping = !Pipeline.doClipping;
          System.out.print("Clipping is turned ");
          System.out.println(Pipeline.doClipping ? "On" : "Off");
          
        } else if ('h' == c) { // Reprint help message
          print_help_message();
        }
      }
    });

    // An anonymous local inner class constructor.
    fbf.addMouseListener(new MouseListener() {
    // Implement the five methods of the MouseListener interface.

     @Override
     public void mouseClicked(MouseEvent arg0) {}

      @Override
      public void mouseEntered(MouseEvent arg0) {}

      @Override
      public void mouseExited(MouseEvent arg0) {
        pos_X = arg0.getX() - 2; //Subtract by 2 to offset Java window left border
        pos_Y = arg0.getY() - 31; // Subtract by 31 to offset Java window title space
        cameraVertex = pixel2Camera(pos_X, pos_Y, fb); // transform pixel to camera space

        for (int i = 0; i < click.length; i++) { // Setting the flag back to false once the mouse exits the screen
          click[i] = false;
        }
        logMessage(arg0.toString());
        logMessage("Pixel Coord: (" + pos_X + ", " + pos_Y + " )");
        logMessage("Camera Coord: (" + cameraVertex.x + ", " + cameraVertex.y + " )");
      }

      @Override
      public void mousePressed(MouseEvent arg0) {
        pos_X = arg0.getX() - 2; //Subtract by 2 to offset Java window left border
        pos_Y = arg0.getY() - 31; // Subtract by 31 to offset Java window title space
        cameraVertex = pixel2Camera(pos_X, pos_Y, fb); // transform pixel to camera space

        logMessage(arg0.toString());
        logMessage("Pixel Coord: (" + pos_X + ", " + pos_Y + " )");
        logMessage("Camera Coord: (" + cameraVertex.x + ", " + cameraVertex.y + " )");

        for (int i = 0; i < 3; i++) {
          if (click_square(pos_Center[i], cameraVertex, size[i])) { // Check if a square model is click
            logMessage("The model clicked on is " + scene.modelList.get(i).name);            
            click[i] = true;
          }
        }
        for (int i = 3; i < 5; i++) { // check if a circle model is click
          if (click_circle(pos_Center[i], cameraVertex, size[i])) {
            logMessage("The model clicked on is " + scene.modelList.get(i).name);            
            click[i] = true;
          }
        }
      }

      @Override
      public void mouseReleased(MouseEvent arg0) {
        pos_X = arg0.getX() - 2; //Subtract by 2 to offset Java window left border
        pos_Y = arg0.getY() - 31; // Subtract by 31 to offset Java window title space
        cameraVertex = pixel2Camera(pos_X, pos_Y, fb); // transform pixel to camera space

        for (int i = 0; i < click.length; i++) { // setting flag to false when mouse is released
          click[i] = false;
        }

        logMessage(arg0.toString()); 
        logMessage("Pixel Coord: ("+ pos_X + ", " + pos_Y + " )");
        logMessage("Camera Coord: ("+ cameraVertex.x + ", " + cameraVertex.y + " )");
      }
    });

    // An anonymous local inner class constructor.
    fbf.addMouseMotionListener(new MouseMotionListener() {
    // Implements the two methods of the MouseMotionListener interface.


      @Override
      public void mouseDragged(MouseEvent arg0) {
        pos_X = arg0.getX() - 2; //Subtract by 2 to offset Java window left border
        pos_Y = arg0.getY() - 31; // Subtract by 31 to offset Java window title space
        prevVertex = cameraVertex; // Previous vertex (either mouse clicked if it's the first call, or consecutive mouse dragged vertices)
        cameraVertex = pixel2Camera(pos_X, pos_Y, fb); // transform pixel to camera space
        
        logMessage(arg0.toString()); 
        logMessage("Pixel Coord: ("+ pos_X + ", " + pos_Y + " )");
        logMessage("Camera Coord: ("+ cameraVertex.x + ", " + cameraVertex.y + " )");

        for (int i = 0; i < click.length; i++) {
          if (click[i]) {
            for (Vertex v : scene.modelList.get(i).vertexList) { // move vertices x and y in camera space
              v.x -= prevVertex.x - cameraVertex.x;
              v.y -= prevVertex.y - cameraVertex.y;
            }
            // update pos_Center accordingly
            pos_Center[i] = new Vertex(pos_Center[i].x - (prevVertex.x - cameraVertex.x), 
                pos_Center[i].y - (prevVertex.y - cameraVertex.y), -10.0);
            fb.clearFB(Color.black);
            Pipeline.render(scene, fb.vp);
            fbf.fbp.update();
            fbf.repaint();           
          }
        }
      }

      @Override
      public void mouseMoved(MouseEvent arg0) {
       pos_X = arg0.getX() - 2; //Subtract by 2 to offset Java window left border
        pos_Y = arg0.getY() - 31; // Subtract by 31 to offset Java window title space
     logMessage("Mouse Moved to : Pixel Coord ("+ pos_X + ", " + pos_Y + " )");
      logMessage(arg0.toString()); 
      }

    });
  }

  /**
   * Converts Pixels to Camera Coordinates.
   * @param x position of X axis
   * @param y position of Y axis
   * @param fb FrameBuffer
   * @return Corresponding to the camera space.
   */
  private Vertex pixel2Camera(int x, int y, FrameBuffer fb) {
    int width = fb.width;
    int height = fb.height;
    double z_c = -10.0D;
    double x_c = z_c - ((z_c * 2.0D * x) / width) - (z_c / width);
    double y_c = -z_c + ((z_c * 2.0D * y) / height) + (z_c / height);
    return new Vertex(x_c, y_c, z_c);
  }

  /**
   * Checks whether the mouse pointer clicks on a Sqaure
   * @param pos_Center Center of the square
   * @param vertex Mouse pointer's coordinate
   * @param size Length of the square 
   * @return true if the Square is clicked
   */
  private boolean click_square(Vertex pos_Center, Vertex vertex, double size) {
    return Math.abs(pos_Center.x - vertex.x) < size && Math.abs(pos_Center.y - vertex.y) < size;
  }

  /**
   * Checks whether the mouse pointer clicks on the circle 
   * @param pos_Center Center of the circle
   * @param vertex Mouse pointer coordinate
   * @param size radius 
   * @return true if the circle is clicked
   */
  private boolean click_circle(Vertex pos_Center, Vertex vertex, double size) {
    return distance(pos_Center, vertex) < size;
  }

  /**
   * Calculates the distance between two vertices center and given vertex.
   * @param pos_Center Vertex 1
   * @param vertex Vertex 2
   * @return distance between the vertices.
   */
  private double distance(Vertex pos_Center, Vertex vertex) {
    return Math.sqrt((vertex.x - pos_Center.x) * (vertex.x - pos_Center.x)
        + (vertex.y - pos_Center.y) * (vertex.y - pos_Center.y));
  }

  /**
   * Prints error message
   * @param message String to be printed
   */
  private static void logMessage(String message) {
    if (debugging) {
      System.err.println(message);
    }
  }

  /**
   * Create an instance of this class which has the affect of creating the GUI application.
   */
  public static void main(String[] args) {
    print_help_message();

    // We need to call the program's constructor in the
    // Java GUI Event Dispatch Thread, otherwise we get a
    // race condition between the constructor (running in
    // the main() thread) and the very first ComponentEvent
    // (running in the EDT).
    javax.swing.SwingUtilities.invokeLater(new Runnable() { // an anonymous inner class constructor
      public void run() { // implement the Runnable interface
        new Hw3(); // call the constructor that builds the gui
      }
    });
  }


  private static void print_help_message() {
    System.out.println("Use the 'd' key to toggle debugging information on and off.");
    System.out.println("Use the 'c' key to toggle line clipping on and off.");
    System.out.println("Use the 'h' key to redisplay this help message.");
  }
}
