package ordination;

import gui.TypeOrdination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev extends Ordination{
    private double antalCounter=0;
    // TODO Kompositionen mellem DagligSkæv og Dosis skal realiseres ved en ArrayList<Dosis>
    private ArrayList<Dosis> doser = new ArrayList<>();
    private ArrayList<Boolean> datoer = new ArrayList<Boolean>();

    public DagligSkaev(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel, ArrayList<Dosis> doser) {
        super(startDen, slutDen, laegemiddel);
        this.doser = doser;

    }

    public ArrayList<Dosis> getDoser() {
        return doser;
    }

    public void opretDosis(LocalTime tid, double antal) {
        Dosis dosis = new Dosis(tid, antal);
       /*
        Storage storage = new Storage();
        storage.addDosisTilList(dosis);
       */
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
        double doegndosis = samletDosis() / antalDage();
        return doegndosis;
    }
    public boolean givDosis() {
        if(getStartDen().isBefore(getSlutDen()) && getSlutDen().isAfter(getStartDen())) {
            datoer.add(givDosis());
            antalCounter++;
            return true;
        } else
            return false;

    }

    private double getAntalGangeGivet() {
        return antalCounter;
    }

    @Override
    public String getType() {
    String type=TypeOrdination.SKAEV.toString();
        return type;
    }
}
