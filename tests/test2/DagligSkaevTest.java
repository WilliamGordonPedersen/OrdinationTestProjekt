package test2;

import ordination.DagligSkaev;
import ordination.Dosis;
import ordination.Laegemiddel;
import ordination.Ordination;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DagligSkaevTest {

    @Test
    void samletDosis() {
        Laegemiddel laegemiddel = new Laegemiddel("paracetamol", 5.0, 5.0, 5.0, "");
        ArrayList<Dosis> doser = new ArrayList<>();
        Dosis dosis = new Dosis(LocalTime.of(8, 30), 5);
        doser.add(dosis);
        DagligSkaev skaev = new DagligSkaev(LocalDate.of(2024, 2, 11), LocalDate.of(2024, 2, 20), laegemiddel, doser);
        double actual = skaev.samletDosis();
        assertEquals(14, actual);

        //tager ikke højde for at det er over flere dage
    }
}