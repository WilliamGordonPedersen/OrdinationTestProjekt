package ordination;

import gui.OrdinationDetailsPane;

import java.time.LocalDate;
import java.time.LocalTime;

public class PN extends Ordination {

    private double antalEnheder;
    private double antalGivetDosis;

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
        return 0.0;
    }

    /**
     * Returnerer antal gange ordinationen er anvendt
     * @return
     */
    public int getAntalGangeGivet() {
        // TODO
        return-1;
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }

    public Laegemiddel getLaegemiddel() {
        return null;
    }
}
