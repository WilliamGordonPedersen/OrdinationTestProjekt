package ordination;

import java.time.LocalDate;
import java.time.LocalTime;

public class DagligSkaev extends Ordination{
    public DagligSkaev(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel) {
        super(startDen, slutDen, laegemiddel);
    }
    // TODO


    public void opretDosis(LocalTime tid, double antal) {
        // TODO
    }

    @Override
    public double samletDosis() {
        return 0;
    }

    @Override
    public double doegnDosis() {
        return 0;
    }

    @Override
    public String getType() {
        return null;
    }
}
