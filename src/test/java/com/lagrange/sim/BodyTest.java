package com.lagrange.sim;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.lagrange.sim.math.Vector2D;
import com.lagrange.sim.model.Body;

public class BodyTest {
    
    @Test
    void testDistance(){
        Body b1 = new Body(new Vector2D(0,0), new Vector2D(0,0), 1.0, 1.0);
        Body b2 = new Body(new Vector2D(3,4), new Vector2D(0,0), 1.0, 1.0);

        assertEquals(5.0, b1.distance(b2), 1e-6);
    }

    @Test
    void testForceFrom(){
        Body b1 = new Body(new Vector2D(0,0), new Vector2D(0,0), 2.0, 1.0);
        Body b2 = new Body(new Vector2D(1,0), new Vector2D(0,0), 3.0, 1.0);
        double G = 1.0;

        Vector2D force = b1.forceFrom(b2, G);
        
        assertTrue(force.getX() > 0); //Force expected alomg +X direction
        assertEquals(0.0, force.getY(), 1e-9);

        // Magnitude = G * m1 * m2 / r^2 = 1 * 2 * 3 / 1^2 = 6
        assertEquals(6.0, force.getX(), 1e-9); 
    }

    @Test
    void testApplyForce(){
        Body b = new Body(new Vector2D(0,0), new Vector2D(0,0), 2.0, 1.0);
        b.applyForce(new Vector2D(4,0), 1.0); // F = 4N, m = 2kg, dt = 1s

        assertEquals(2.0, b.getVelocity().getX(), 1e-9);
        assertEquals(0.0, b.getVelocity().getY(), 1e-9);
    }

    @Test
    void testUpdate(){
        Body b = new Body(new Vector2D(0,0), new Vector2D(1,0), 2.0, 1.0);
        b.update(2.0);

        assertEquals(2.0, b.getPosition().getX(), 1e-9);
        assertEquals(0.0, b.getPosition().getY(), 1e-9);

        assertEquals(1.0, b.getVelocity().getX(), 1e-9);
        assertEquals(0.0, b.getVelocity().getY(), 1e-9);
    }
}
