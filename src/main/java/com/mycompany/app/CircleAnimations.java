package com.mycompany.app;
import java.awt.Color;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CircleAnimations
{
    private ArrayList<Circle> circles; //the circles to animate
    private int               size;    //canvas width and height (will be square)
    private Random            rng;     //use to make random numbers

    /** create a drawing pane of a particular size */
    public CircleAnimations(int s) {
        circles = new ArrayList<>();
        size    = s;
        rng     = new Random();
        //don't mess with this
        StdDraw.setCanvasSize(size, size); //set up drawing canvas
        StdDraw.setXscale(0, size);        //<0, 0> is bottom left.  <size-1, size-1> is top right
        StdDraw.setYscale(0, size);
    }
   public void drawCircles()
   {
       for(int x = 0; x < circles.size(); x++)
       {
           this.circles.get(x).draw(); //iterates circle list and draws them
       }
   }
   public void addCircles()
   {
       Color color = new Color((int) (255 * rng.nextDouble()), (int) (255 * rng.nextDouble()), (int) (255 * rng.nextDouble()));
       Circle d = new Circle((int) (size * rng.nextDouble()), (int) (size * rng.nextDouble()), (int) (size * rng.nextDouble()), color  );
       circles.add(d);
       Color color1 = new Color((int) (255 * rng.nextDouble()), (int) (255 * rng.nextDouble()), (int) (255 * rng.nextDouble()));
       Circle s = new Circle((int) (size * rng.nextDouble()), (int) (size * rng.nextDouble()), (int) (size * rng.nextDouble()), color1  );
       circles.add(s);
       Color color2 = new Color((int) (255 * rng.nextDouble()), (int) (255 * rng.nextDouble()), (int) (255 * rng.nextDouble()));
       Circle a = new Circle((int) (size * rng.nextDouble()), (int) (size * rng.nextDouble()), (int) (size * rng.nextDouble()), color2  );
       circles.add(a);
   }
   public void addCircles(int input)
   {
       noOverlapping(input);
   }
    boolean isOverlapping(double x2, double y2,double radius)
    {
        for(int d = 0; d < this.circles.size(); d++)
        {
            double distance = Math.sqrt(Math.pow(circles.get(d).getX() - x2, 2) + Math.pow(circles.get(d).getY() - y2, 2));
            if (distance < circles.get(d).getRadius() + radius)
            {
                return true;
            }
        }
        return false;
    }
    public void noOverlapping(int sfm)
    {
        for(int x = 0; x < sfm; x++)
        {
            int rad = rng.nextInt(1, 40);
            Color col = new Color(rng.nextInt(0, 255), rng.nextInt(0, 255), rng.nextInt(0,255));
            Circle circ = new Circle(rng.nextInt(1, size-rad), rng.nextInt(1, size-rad), rad, col);
            if(!isOverlapping(circ.getX(),circ.getY() , circ.getRadius()))
            {
                this.circles.add(circ);
            }
            else
            {
                sfm++;
            }
        }
    }
    public void movingCircles(int nodfg)
    {
        addCircles(nodfg);
        for(int t = 0; t < circles.size(); t++)
        {
            this.circles.get(t).setVelocityX(rng.nextInt(1,5));
            this.circles.get(t).setVelocityY(rng.nextInt(1,5));
        }
        while (true) {
            this.drawCircles();
            for (int i = 0; i < circles.size(); i++) {
                this.circles.get(i).update();
            }
            StdDraw.show(1000);
            StdDraw.clear();
        }
    }

    public void bounce() {
        
    }
}