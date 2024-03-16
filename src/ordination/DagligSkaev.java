package ordination;

import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev extends Ordination{
    // TODO Kompositionen mellem DagligSkæv og Dosis skal realiseres ved en ArrayList<Dosis>
    private ArrayList<Dosis> doser = new ArrayList<>();

    public DagligSkaev(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel, ArrayList<Dosis> doser) {
        super(startDen, slutDen);
        this.doser = doser;
    }

    public ArrayList<Dosis> getDoser() {
        return doser;
    }

    public void opretDosis(LocalTime tid, double antal) {
        Dosis dosis = new Dosis(tid, antal);
        Storage storage = new Storage();
        storage.addDosisTilList(dosis);

    }

    @Override
    public double samletDosis() {
        double samlet = 0;
        for (Dosis dosis : doser) {
            samlet = dosis.getAntal();
        }
        return samlet;
    }

    @Override
    public double doegnDosis() {
        double samlet = 0;
        samlet = samletDosis() / antalDage();
        return samlet;
    }

    @Override
    public String getType() {
        return null;
    }
}
