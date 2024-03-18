package ordination;

import java.time.LocalDate;
import java.time.LocalTime;

public class DagligFast extends Ordination{
    // TODO Kompositionen mellem DagligFast og Dosis skal realiseres ved et array af doser: Dosis[4]
    private Dosis[] doser;

    public DagligFast(LocalDate startDen, LocalDate slutDen, double morgenAntal, double middagAntal, double aftenAntal, double natAntal) {
        super(startDen, slutDen);
        this.doser = new Dosis[4];
        doser[0] = new Dosis(LocalTime.of(8,0),morgenAntal);
        doser[0] = new Dosis(LocalTime.of(12,0),middagAntal);
        doser[0] = new Dosis(LocalTime.of(20,0),aftenAntal);
        doser[0] = new Dosis(LocalTime.of(2,0),natAntal);
    }

    public Dosis[] getDoser() {
        return doser;
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
