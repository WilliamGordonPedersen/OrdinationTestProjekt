package ordination;

import gui.TypeOrdination;

import java.time.LocalDate;
import java.time.LocalTime;

public class DagligFast extends Ordination {
    private Dosis[] doser;

    public DagligFast(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel,
                      double morgenAntal, double middagAntal, double aftenAntal, double natAntal) {
        super(startDen, slutDen, laegemiddel);
        this.doser = new Dosis[4];
        doser[0] = new Dosis(LocalTime.of(8, 0), morgenAntal);
        doser[1] = new Dosis(LocalTime.of(12, 0), middagAntal);
        doser[2] = new Dosis(LocalTime.of(18, 0), aftenAntal);
        doser[3] = new Dosis(LocalTime.of(22, 0), natAntal);
    }

    public Dosis[] getDoser() {
        return doser;
    }

    @Override
    public double samletDosis() {
        double samletAntal = 0.0;
        for (int i = 0; i < doser.length; i++) {
            samletAntal += doser[i].getAntal() * antalDage();
        }
        return samletAntal;
    }

    @Override
    public double doegnDosis() {
        double gnsDoegnDos = 0;
        gnsDoegnDos = samletDosis() / antalDage();
        return gnsDoegnDos;
    }

    @Override
    public String getType() {
        String type = TypeOrdination.FAST.toString();
        return type;
    }
}
