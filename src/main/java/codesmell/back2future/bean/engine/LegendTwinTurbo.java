package codesmell.back2future.bean.engine;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component(value="twin")
public class LegendTwinTurbo implements Engine {

    public void accelerate() {
        System.out.println("0–60 mph in 5.8 seconds");
    }

    public Integer horsePower() {
        return 283;
    }

    public BigDecimal displacementInLitres() {
        return new BigDecimal(3.0);
    }

}
