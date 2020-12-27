package com.company;


import java.awt.*;

public class Rectangle { //This class will soon be replaced with JavaFX classes but yeah 'console'
    private Color color;
    private final java.awt.Rectangle rectangle;

    public Rectangle(Color color, int sizeX, int sizeY){

        this.color = color;
        this.rectangle = new java.awt.Rectangle(sizeX, sizeY);
    }
    public void setColor(Color color){
        this.color = color;
    }
    public Color getColor() { return color; }
}
