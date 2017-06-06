package codesmell.back2future.bean.engine;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component(value="prv")
public class PeugeotRenaultVolvo implements Engine {

    public void accelerate() {
        System.out.println("0–60 mph in 9.5 seconds");
    }

    public Integer horsePower() {
        return 130;
    }

    public BigDecimal displacementInLitres() {
        return new BigDecimal(2.85);
    }


}
