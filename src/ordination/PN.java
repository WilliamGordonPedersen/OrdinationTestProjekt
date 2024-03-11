package ordination;

import gui.OrdinationDetailsPane;

import java.time.LocalDate;
import java.time.LocalTime;

public class PN extends Ordination {

    private double antalEnheder;
    private int antalGivetDosis;

    public PN(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel) {
        super(startDen, slutDen, laegemiddel);
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
        givesDen= LocalDate.now();
        antalGivetDosis++;
        return false;   
    }

    public double doegnDosis() {
        // TODO
        return 0.0;
    }

    @Override
    public String getType() {
        return null;
    }


    public double samletDosis() {
        // TODO
        double dosis=0.0;
        return dosis;
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

}
