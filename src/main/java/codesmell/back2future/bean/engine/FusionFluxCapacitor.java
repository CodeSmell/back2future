package codesmell.back2future.bean.engine;

import org.springframework.stereotype.Component;

@Component
public class FusionFluxCapacitor implements FluxCapacitor {

    public void engage() {
        System.out.println("Great Scott!");
    }
}
