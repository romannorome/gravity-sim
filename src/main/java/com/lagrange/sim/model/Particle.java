package com.lagrange.sim.model;

import java.util.List;

import com.lagrange.sim.math.Vector2D;

public class Particle {
    private Vector2D position;
    private Vector2D velocity;

    public Particle(Vector2D position, Vector2D velocity) {
        this.position = position;
        this.velocity = velocity;
    }

    public Vector2D getPosition() {
        return position;
    }

    public Vector2D getVelocity(){
        return velocity;
    }

    public Vector2D accelerationFromBodies(List<Body> bodies, double G) {
        Vector2D totalAcceleration = new Vector2D(0, 0);

        for (Body b : bodies){
            Vector2D delta = b.getPosition().subtract(this.position);
            double distance = delta.magnitude();

            if (distance == 0) continue;

            double magnitude = G * b.getMass()/ (distance * distance); // Newton's Law of Gravitation where particle mass = 1
            totalAcceleration = totalAcceleration.add(delta.normalize().scale(magnitude));
        }

        return totalAcceleration; // Vector sum of all gravitational forces
    }

    public void update(double dt) {
        position = position.add(velocity.scale(dt));
    }

    public void applyForce(Vector2D acceleration, double dt) {
        velocity = velocity.add(acceleration.scale(dt));
    }

    @Override
    public String toString(){
        return "Particle(pos=" + position.toString() + ", vel=" + velocity.toString() + ")";
    }    
}
