package ordination;

import gui.OrdinationDetailsPane;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class PN extends Ordination {

    private double antalEnheder;
    private int antalGivetDosis;
    private ArrayList<Dosis> doser = new ArrayList<>();

    public PN(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel, double antalEnheder, int antalGivetDosis) {
        super(startDen, slutDen, laegemiddel);
        this.antalEnheder = antalEnheder;
        this.antalGivetDosis = antalGivetDosis;
        this.doser = doser;
    }


    /**
     * Registrerer at der er givet en dosis paa dagen givesDen
     * Returnerer true hvis givesDen er inden for ordinationens gyldighedsperiode og datoen huskes
     * Retrurner false ellers og datoen givesDen ignoreres
     *
     * @param givesDen
     * @return
     */
    public boolean givDosis(LocalDate givesDen) {
        if (LocalDate.now().compareTo(getStartDen()) > 0 && LocalDate.now().compareTo(getSlutDen()) < 0) {
            givesDen = LocalDate.now();
            antalGivetDosis++;
            return true;
        } else {
            return false;
        }
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
        double samletAntal = 0.0;
        for (int i = 0; i < doser.size(); i++) {
            samletAntal+=doser.get(i).getAntal();
        }
        return samletAntal;
    }

    /**
     * Returnerer antal gange ordinationen er anvendt
     *
     * @return
     */
    public int getAntalGangeGivet() {
        return antalGivetDosis;
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }

    public ArrayList<Dosis> getDoser() {
        return doser;
    }

    public Laegemiddel getLaegemiddel() {

        return null;
    }
}
