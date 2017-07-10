package codesmell.back2future.bean.engine;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component(value="twin")
public class LegendTwinTurbo implements Engine {

    @Override
    public void accelerate() {
        System.out.println("0–60 mph in 5.8 seconds");
    }

    @Override
    public Integer horsePower() {
        return 283;
    }

    @Override
    public BigDecimal displacementInLitres() {
        return new BigDecimal(3.0);
    }

}
