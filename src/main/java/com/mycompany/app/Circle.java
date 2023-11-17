package com.mycompany.app;
import java.awt.*;
import java.util.ArrayList;

public class Circle
{
    private int x;
    private int y;
    private int radius;
    private Color color;
    private int dx;
    private int dy;

    public Circle(int x, int y, int radius, Color color)
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;

    }
    public Circle(int x, int y, int radius, Color color, int dx, int dy)
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        this.dx = dx;
        this.dy = dy;
    }
    public void draw()
    {
        StdDraw.setPenColor(color);//set the current color of the drawing window
        StdDraw.filledCircle(x, y, radius); //draw a filled circle at <x, y>, diam of radius*2
        StdDraw.show();
    }
    boolean overlaps(Circle other)
    {
        double distance = Math.sqrt(Math.pow(other.x - this.x ,2) + Math.pow(other.y - this.y, 2));
        if(distance < this.radius + other.radius)
        {
            return true;
        }
        return false;
    }
    public void update()
    {
        x += dx;
        y += dy;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public int getRadius()
    {
        return radius;
    }
    public Color getColor()
    {
        return color;
    }
    public void setVelocityX(int vx)
    {
        this.dx = vx;
    }
    public void setVelocityY(int vy)
    {
        this.dy = vy;
    }
}