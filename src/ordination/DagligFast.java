package ordination;

import java.time.LocalDate;

public class DagligFast extends Ordination{
    // TODO Kompositionen mellem DagligFast og Dosis skal realiseres ved et array af doser: Dosis[4]
    private Dosis[] doser = new Dosis[4];

    public DagligFast(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel, Dosis[] doser) {
        super(startDen, slutDen, laegemiddel);
        this.doser = doser;
    }

    public Dosis[] getDoser() {
        return doser;
    }

    @Override
    public double samletDosis() {
        double samletDosis = doegnDosis() * antalDage();
        return samletDosis;
    }

    // Vi skal have fundet måden af finde ud af om patienten er let/normal/tung. Jeg har kun normal metode
    @Override
    public double doegnDosis() {
        double samlet = getLaegemiddel().getEnhedPrKgPrDoegnNormal() * 4;
        return samlet;
    }

    @Override
    public String getType() {
        return null;
    }
}
