package com.albinronnkvist.basics.oop;

import org.junit.jupiter.api.Test;
import com.albinronnkvist.basics.oop.composition.Car;
import static org.assertj.core.api.Assertions.assertThat;

public class CompositionTests {

    @Test
    public void testCompositionLifecycle() {
        var car = new Car("V8");

        var engineType = car.getEngineType();

        assertThat(engineType).isEqualTo("V8");
    }

    @Test
    public void testCompositionLifecycleMultiple() {
        var car1 = new Car("V8");
        var car2 = new Car("V6");

        car1.setEngineType("V12");

        var car1EngineType = car1.getEngineType();
        var car2EngineType = car2.getEngineType();

        assertThat(car1EngineType).isEqualTo("V12");
        assertThat(car2EngineType).isEqualTo("V6");
    }
}