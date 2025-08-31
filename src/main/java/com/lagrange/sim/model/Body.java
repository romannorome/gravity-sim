package com.lagrange.sim.model;

import com.lagrange.sim.math.Vector2D;

public class Body {
    private Vector2D position;
    private Vector2D velocity;
    private double mass;
    private double radius;

    public Body(Vector2D position, Vector2D velocity, double mass, double radius){
        this.position = position;
        this.velocity = velocity;
        this.mass = mass;
        this.radius = radius;
    }

    public Vector2D getPosition(){
        return position;
    }

    public Vector2D getVelocity(){
        return velocity;
    }

    public double getMass(){
        return mass;
    }

    public double getRadius(){
        return radius;
    }

    public void setPosition(Vector2D pos){
        position = pos;
    }

    public void setVelocity(Vector2D vel){
        velocity = vel;
    }

    public void setMass(double m){
        mass = m;
    }

    public void setRadius(double r){
        radius = r;
    }

    public void applyForce(Vector2D force, double dt){
        Vector2D acceleration = force.scale(1.0/mass);  // f = ma | a = f/m == f * 1/m
        velocity = velocity.add(acceleration.scale(dt));
    }
    
    public Vector2D forceFrom(Body other, double G){
        Vector2D delta = other.position.subtract(this.position);
        double distance = delta.magnitude();
        double magnitude = G * this.mass * other.mass / (distance * distance); // Newtons law of Gravitation

        return delta.normalize().scale(magnitude);

    }

    public void update(double dt){
        position = position.add(velocity.scale(dt));
    }

    public double distance(Body other){
        return this.position.distance(other.position);
    }
    
    @Override
    public String toString(){
        return "Body(pos=" + position.toString() + ", vel=" + velocity.toString() + ", mass=" + mass + ", radius=" + radius + ")";
    }
    
}
