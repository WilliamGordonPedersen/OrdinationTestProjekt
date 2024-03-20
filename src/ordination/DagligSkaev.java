package ordination;

import gui.TypeOrdination;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev extends Ordination{
    private double antalCounter=0;
    // TODO Kompositionen mellem DagligSkæv og Dosis skal realiseres ved en ArrayList<Dosis>
    private ArrayList<Dosis> doser = new ArrayList<>();

    public DagligSkaev(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel) {
        super(startDen, slutDen, laegemiddel);
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
        double samletAntal = 0.0;
        for (int i = 0; i < doser.size(); i++) {
            samletAntal+=doser.get(i).getAntal();
        }
        return samletAntal;
    }

    @Override
    public double doegnDosis() {
        double gnsDoegnDosis = 0;
        gnsDoegnDosis = samletDosis() / antalDage();
        return gnsDoegnDosis;
    }


    @Override
    public String getType() {
    String type=TypeOrdination.SKAEV.toString();
        return type;
    }
}
