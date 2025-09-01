package com.lagrange.sim.physics;

import java.util.List;

import com.lagrange.sim.math.Vector2D;
import com.lagrange.sim.model.Body;
import com.lagrange.sim.model.Particle;

public class EulerIntegrator implements Integrator {
    
    @Override
    public void step(List<Body> bodies, List<Particle> particles, double dt, double G) {
        for (Body b : bodies) {
            Vector2D netForce = new Vector2D(0,0);

            for (Body other : bodies){
                if (b != other){
                    netForce = netForce.add(b.forceFrom(other, G));
                }
            }
            
            b.applyForce(netForce, dt);
            b.update(dt);
        }

        for (Particle p : particles){
            Vector2D acceleration = p.accelerationFromBodies(bodies, G);
            p.applyForce(acceleration, dt);
            p.update(dt);
        }
    }

}
