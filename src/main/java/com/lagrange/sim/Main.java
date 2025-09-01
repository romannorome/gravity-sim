package com.lagrange.sim;

import java.util.ArrayList;
import java.util.List;

import com.lagrange.sim.math.Vector2D;
import com.lagrange.sim.model.Body;
import com.lagrange.sim.model.Particle;
import com.lagrange.sim.physics.EulerIntegrator;
import com.lagrange.sim.physics.Integrator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Label label = new Label("Hello Lagrange!");
        Scene scene = new Scene(label, 400, 200);

        stage.setTitle("Lagrange Simulator Test");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        double G = 1.0;

        Body sun = new Body(
            new Vector2D(0,0), 
            new Vector2D(0,0),
            1e6,
            10);

        Body planet = new Body(
            new Vector2D(100,0),
            new Vector2D(0, 10),
            1,
            1);

        List<Body> bodies = new ArrayList<>();
        bodies.add(sun);
        bodies.add(planet);

        Particle testParticle1 = new Particle(
            new Vector2D(50, 0),
            new Vector2D(0, 5)
        
        );
        List<Particle> particles = new ArrayList<>();
        particles.add(testParticle1);

        Integrator integrator = new EulerIntegrator();

        double dt = 0.01;
        for(int step = 0; step < 100; step++){
            integrator.step(bodies, particles, dt, G);

            System.out.printf("\nStep %d: \nPlanet at (%.3f, %.3f) with velocity (%.3f, %.3f)\n", 
                step, 
                planet.getPosition().getX(), planet.getPosition().getY(),
                planet.getVelocity().getX(), planet.getVelocity().getY()
            );

            System.out.printf("Particle at (%.3f, %.3f) with velocity (%.3f, %.3f)\n",  
                testParticle1.getPosition().getX(), testParticle1.getPosition().getY(),
                testParticle1.getVelocity().getX(), testParticle1.getVelocity().getY()
            );
        }
        //launch(args);
    }
}
