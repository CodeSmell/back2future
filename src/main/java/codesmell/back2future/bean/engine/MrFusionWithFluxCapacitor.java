package codesmell.back2future.bean.engine;

import codesmell.back2future.bean.car.BackToFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@BackToFuture
@Component(value="flux")
public class MrFusionWithFluxCapacitor extends LegendTwinTurbo {

    @Autowired
    private FluxCapacitor flux;

    public MrFusionWithFluxCapacitor() {
    }

    public MrFusionWithFluxCapacitor(FluxCapacitor  flux) {
        this.flux = flux;
    }

    @Override
    public void accelerate() {
        flux.engage();
        System.out.println("we don't need roads");
    }

}
