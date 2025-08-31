package com.lagrange.sim;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.lagrange.sim.math.Vector2D;

public class Vector2DTest {
    @Test
    void testAdd(){
        Vector2D v1 = new Vector2D(1, 2);
        Vector2D v2 = new Vector2D(3, 4);
        Vector2D result = v1.add(v2);
        assertEquals(4, result.getX());
        assertEquals(6, result.getY());
    }

    @Test
    void testSubtract(){
        Vector2D v1 = new Vector2D(1, 2);
        Vector2D v2 = new Vector2D(3, 4);
        Vector2D result = v1.subtract(v2);
        assertEquals(-2, result.getX());
        assertEquals(-2, result.getY());
    }

    @Test
    void testScale(){
        Vector2D v = new Vector2D(3, 4);
        Vector2D r = v.scale(2);
        assertEquals(6, r.getX());
        assertEquals(8, r.getY());
    }

    @Test
    void testMagnitude(){
        Vector2D v = new Vector2D(3, 4);
        assertEquals(5, v.magnitude(), 1e-6);
    }

    @Test
    void testNormalize(){
        Vector2D v = new Vector2D(0, 5);
        Vector2D n = v.normalize();
        assertEquals(0, n.getX(), 1e-6);
        assertEquals(1, n.getY(), 1e-6);
    }

    @Test
    void testDot(){
        Vector2D v1 = new Vector2D(1, 2);
        Vector2D v2 = new Vector2D(3, 4);
        double dotProduct = v1.dot(v2);
        assertEquals(11, dotProduct, 1e-6);
    }

    @Test
    void testDistance(){
        Vector2D v1 = new Vector2D(1, 2);
        Vector2D v2 = new Vector2D(4, 6);
        double distance = v1.distance(v2);
        assertEquals(5, distance, 1e-6);
    }
}
