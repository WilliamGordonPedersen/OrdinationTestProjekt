package ordination;

import gui.TypeOrdination;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev extends Ordination {
    private ArrayList<Dosis> doser;

    public DagligSkaev(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel) {
        super(startDen, slutDen, laegemiddel);
        this.doser = new ArrayList<Dosis>();
    }

    public ArrayList<Dosis> getDoser() {
        return doser;
    }

    public void opretDosis(LocalTime tid, double antal) {
        Dosis dagligSkaevDos = new Dosis(tid, antal);
        doser.add(dagligSkaevDos);
    }


    @Override
    public double samletDosis() {
        double samletDosisPeriode = 0.0;
        for (int i = 0; i < doser.size(); i++) {
            samletDosisPeriode += doser.get(i).getAntal();
        }
        return samletDosisPeriode;
    }

    @Override
    public double doegnDosis() {
        double gnsDoegnDosis = 0;
        gnsDoegnDosis = samletDosis() / antalDage();
        return gnsDoegnDosis;
    }


    @Override
    public String getType() {
        String type = TypeOrdination.SKAEV.toString();
        return type;
    }
}
