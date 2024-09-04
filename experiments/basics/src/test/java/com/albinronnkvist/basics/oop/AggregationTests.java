package com.albinronnkvist.basics.oop;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.albinronnkvist.basics.oop.aggregation.Car;
import com.albinronnkvist.basics.oop.aggregation.Engine;
import static org.assertj.core.api.Assertions.assertThat;

public class AggregationTests {

    @Test
    @Disabled("Not sure how to test this properly (can't force gc)")
    public void testAggregationLifecycleSingle() {
        var engine = new Engine("V8");
        var car = new Car(engine);
        car = null;
        
        // The enginge should live on even if the car is destroyed
        // Not sure how to test this properly (can't force gc)
        assertThat(car).isNull();
        assertThat(engine.getType()).isEqualTo("V8");
    }
    
    @Test
    @Disabled("Not sure how to test this properly (can't force gc)")
    public void testEngineIndependence() {
        var engine = new Engine("V6");
        var car = new Car(engine);

        engine = null;
        
        // The engine should be removed from the car
        assertThat(car.getEngineType()).isNull();
    }

    @Test
    public void testAggregationLifecycleMultiple() {
        var sharedEngine = new Engine("V8");
        var car1 = new Car(sharedEngine);

        sharedEngine.setType("V6");
        var car2 = new Car(sharedEngine);

        var car1EngineType = car1.getEngineType();
        var car2EngineType = car2.getEngineType();

        assertThat(car1EngineType).isEqualTo("V6");
        assertThat(car2EngineType).isEqualTo("V6");
    }
}