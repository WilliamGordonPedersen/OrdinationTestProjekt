package controller;

import ordination.DagligSkaev;
import ordination.Laegemiddel;
import ordination.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void opretDagligSkaevOrdination() {

        Controller controller1 = Controller.getController();
        Patient p = new Patient("12", "Palle", 60);
        Laegemiddel laegemiddel = new Laegemiddel("paracetamol", 5.0, 5.0, 5.0, "ml");
        LocalTime[] klokkeslet = new LocalTime[10];
        klokkeslet[0]=LocalTime.of(10, 30);

        double[]antalEnheder = new double[10];
        antalEnheder[0]=5;




        DagligSkaev actual = controller1.opretDagligSkaevOrdination(LocalDate.of(2024, 2, 6), LocalDate.of(2024, 2, 4), p, laegemiddel, klokkeslet, antalEnheder);
        assertEquals(new IllegalArgumentException(), actual);








    }
}