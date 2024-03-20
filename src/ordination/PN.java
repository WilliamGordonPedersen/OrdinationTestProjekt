package ordination;

import java.time.LocalDate;
import java.util.ArrayList;

public class PN extends Ordination {

    private double antalEnheder;
    private ArrayList<LocalDate> AlleDoserGivet;
    private int antalGivetDosis=0;

    public PN(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel) {
        super(startDen, slutDen, laegemiddel);
        this.antalEnheder = antalEnheder;
    }
    /**
     * Registrerer at der er givet en dosis paa dagen givesDen
     * Returnerer true hvis givesDen er inden for ordinationens gyldighedsperiode og datoen huskes
     * Retrurner false ellers og datoen givesDen ignoreres
     * @param givesDen
     * @return
     */
    public boolean givDosis(LocalDate givesDen) {
        // TODO
        if (givesDen.isAfter(getStartDen()) && givesDen.isBefore(getSlutDen())) {
            AlleDoserGivet.add(givesDen);
            return true;}
        else
            return false;
        }
    public double doegnDosis() {
        double dosis = (getAntalGangeGivet() * antalEnheder) / antalDage();
        return dosis;
    }

    @Override
    public String getType() {
        return null;
    }


    public double samletDosis() {
        return 0.0;
    }

    /**
     * Returnerer antal gange ordinationen er anvendt
     * @return
     */
    public int getAntalGangeGivet() {
        return antalGivetDosis;
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }

    public Laegemiddel getLaegemiddel() {

        return null;
    }
}
