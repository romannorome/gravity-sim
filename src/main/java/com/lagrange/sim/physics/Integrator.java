package com.lagrange.sim.physics;

import java.util.List;
import com.lagrange.sim.model.Body;
import com.lagrange.sim.model.Particle;

public interface Integrator {
    void step(List<Body> bodies, List<Particle> particles,  double dt, double G);
}
