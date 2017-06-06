import codesmell.back2future.bean.car.Delorean;
import codesmell.back2future.bean.engine.PeugeotRenaultVolvo;

beans {

    groovyEngine(PeugeotRenaultVolvo) {
    }
    
    groovyDelorean(Delorean) {
        engine = groovyEngine
    }

}
