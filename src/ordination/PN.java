package ordination;

import gui.OrdinationDetailsPane;
import gui.TypeOrdination;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class PN extends Ordination {

    private double antalEnheder;
    private ArrayList<Dosis> antalgivetDoser;

    public PN(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel, double antalEnheder) {
        super(startDen, slutDen, laegemiddel);
        this.antalEnheder = antalEnheder;
        this.antalgivetDoser = new ArrayList<>();
    }


    /**
     * Registrerer at der er givet en dosis paa dagen givesDen
     * Returnerer true hvis givesDen er inden for ordinationens gyldighedsperiode og datoen huskes
     * Retrurner false ellers og datoen givesDen ignoreres
     *
     * @param givesDen
     * @return
     */
    public boolean givDosis(LocalDate givesDen, Dosis dosis) {
        if (LocalDate.now().compareTo(getStartDen()) > 0 && LocalDate.now().compareTo(getSlutDen()) < 0) {
            antalgivetDoser.add(dosis);
            return true;
        } else {
            return false;
        }
    }

    public double doegnDosis() {
        double gnsDoegnDosis = 0;
        gnsDoegnDosis = samletDosis() / antalDage();
        return gnsDoegnDosis;
    }

    @Override
    public String getType() {
        String type = TypeOrdination.PN.toString();
        return type;
    }


    public double samletDosis() {
        double samletDosisPeriode = 0.0;
        for (int i = 0; i < antalgivetDoser.size(); i++) {
            samletDosisPeriode += antalgivetDoser.get(i).getAntal();
        }
        return samletDosisPeriode;
    }

    /**
     * Returnerer antal gange ordinationen er anvendt
     *
     * @return
     */
    public int getAntalGangeGivet() {
        return antalgivetDoser.size();
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }
}