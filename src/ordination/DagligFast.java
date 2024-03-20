package ordination;

import gui.TypeOrdination;

import java.time.LocalDate;
import java.time.LocalTime;

public class DagligFast extends Ordination {
    private static Dosis[] doser;

    public DagligFast(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel,
                      double morgenAntal, double middagAntal, double aftenAntal, double natAntal) {
        super(startDen, slutDen, laegemiddel);
        this.doser = new Dosis[4];
        doser[0] = new Dosis(LocalTime.of(8, 0), morgenAntal);
        doser[1] = new Dosis(LocalTime.of(12, 0), middagAntal);
        doser[2] = new Dosis(LocalTime.of(18, 0), aftenAntal);
        doser[3] = new Dosis(LocalTime.of(22, 0), natAntal);
    }

    public static Dosis[] getDoser() {
        return doser;
    }

    @Override
    public double samletDosis() {
        double samletDosisPeriode = 0;
        for (Dosis dosis : doser) {
            samletDosisPeriode = dosis.getAntal() * antalDage();
        }
        return samletDosisPeriode;
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
