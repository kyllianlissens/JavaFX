package be.kdg.java.model;


import java.awt.*;

public class Rectangle { //This class will soon be replaced with JavaFX classes but yeah 'console'
    private Color color;

    public Rectangle(Color color){
        this.color = color;
    }
    public void setColor(Color color){
        this.color = color;
    }
    public Color getColor() { return color; }


}
