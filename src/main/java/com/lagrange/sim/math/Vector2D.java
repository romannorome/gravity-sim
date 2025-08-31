package com.lagrange.sim.math;

public class Vector2D {
    private double x;
    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double newX){
        x = newX;
    }

    public void setY(double newY){
        y = newY;
    }

    public Vector2D add(Vector2D addend) {
        return new Vector2D(this.x + addend.x, this.y + addend.y);
    }

    public Vector2D subtract(Vector2D subtrahend) {
        return new Vector2D(this.x - subtrahend.x, this.y - subtrahend.y);
    }

    public Vector2D scale(double scalar) {
        return new Vector2D(this.x * scalar, this.y * scalar);
    }

    public double magnitude() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public Vector2D normalize() {
        double mag = magnitude();
        if (mag == 0) {
            return new Vector2D(0.0, 0.0);
        }
        return new Vector2D(this.x / mag, this.y / mag);
    }

    public double dot(Vector2D other){
        return this.x * other.x + this.y * other.y;
    }

    public double distance(Vector2D other){
        return this.subtract(other).magnitude();
    }

    @Override
    public String toString(){
        return "(" + this.x + ", " + this.y + ")"; 
    }
}

