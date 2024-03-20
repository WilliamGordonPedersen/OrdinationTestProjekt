package dagligFastTests;

import controller.Controller;
import ordination.DagligFast;
import ordination.DagligSkaev;
import ordination.Dosis;
import ordination.Laegemiddel;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SamletDosisTests {

    @Test
    void samletDosisTC1() {
        Laegemiddel laegemiddel = new Laegemiddel("paracetamol", 5.0, 5.0, 5.0, "");
        Dosis dosis = new Dosis(LocalTime.of(8, 30), 4);
        DagligFast fast = new DagligFast(LocalDate.of(2024, 2, 11), LocalDate.of(2024, 2, 20), laegemiddel,1,1,1,1);
        double actual = fast.samletDosis();
        assertEquals(40, actual);
    }

@Test
    void samletDosisTC2() {
        Laegemiddel laegemiddel = new Laegemiddel("paracetamol", 5.0, 5.0, 5.0, "");
        Dosis dosis = new Dosis(LocalTime.of(8, 30), 2);
        DagligFast fast = new DagligFast(LocalDate.of(2024, 2, 11), LocalDate.of(2024, 2, 20), laegemiddel,2,0,0,0);
        double actual = fast.samletDosis();
        assertEquals(20, actual);
    }

    @Test
    void samletDosisTC3() {
        Laegemiddel laegemiddel = new Laegemiddel("paracetamol", 5.0, 5.0, 5.0, "");
        Dosis dosis = new Dosis(LocalTime.of(8, 30), 4);
        DagligFast fast = new DagligFast(LocalDate.of(2024, 2, 11), LocalDate.of(2024, 2, 16), laegemiddel,2,1,0,1);
        double actual = fast.samletDosis();
        assertEquals(24, actual);
    }

    @Test
    void samletDosisTC4() {
        Laegemiddel laegemiddel = new Laegemiddel("paracetamol", 5.0, 5.0, 5.0, "");
        Dosis dosis = new Dosis(LocalTime.of(8, 30), 5);
        DagligFast fast = new DagligFast(LocalDate.of(2024, 2, 11), LocalDate.of(2024, 2, 16), laegemiddel,5,0,0,0);
        double actual = fast.samletDosis();
        assertEquals(30, actual);
    }

    @Test
    void samletDosisTC5() {
        Laegemiddel laegemiddel = new Laegemiddel("paracetamol", 5.0, 5.0, 5.0, "");
        Dosis dosis = new Dosis(LocalTime.of(8, 30), 4);
        DagligFast fast = new DagligFast(LocalDate.of(2024, 2, 11), LocalDate.of(2024, 2, 11), laegemiddel,2,1,0,1);
        double actual = fast.samletDosis();
        assertEquals(4, actual);
    }
}
