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

    public DagligSkaev(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel, double antalCounter, ArrayList<Dosis> doser) {
        super(startDen, slutDen, laegemiddel);
        this.antalCounter = antalCounter;
        this.doser = doser;
        doser.add(0, new Dosis(LocalTime.of(9, 30), 2));
        doser.add(1, new Dosis(LocalTime.of(10, 30), 1));
        doser.add(2, new Dosis(LocalTime.of(13, 30), 2));
        doser.add(3, new Dosis(LocalTime.of(13, 30), 1));
        doser.add(4, new Dosis(LocalTime.of(19, 30), 2));
        doser.add(5, new Dosis(LocalTime.of(20, 30), 1));

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
        double doegndosis = (getAntalGangeGivet() * antalCounter) / antalDage();
        return doegndosis;
    }
    public double givDosis() {
        antalCounter++;
        return 0;
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
