package dagligFastTests;

import ordination.DagligFast;
import ordination.Dosis;
import ordination.Laegemiddel;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class doegnDosisTests {

    @Test
    void doegnDosisTC1() {
        Laegemiddel laegemiddel = new Laegemiddel("paracetamol", 5.0, 5.0, 5.0, "");
        Dosis dosis = new Dosis(LocalTime.of(8, 30), 4);
        DagligFast fast = new DagligFast(LocalDate.of(2024, 2, 11), LocalDate.of(2024, 2, 20), laegemiddel, 2, 1, 0, 1);
        double actual = fast.doegnDosis();
        assertEquals(4, actual);
    }

    @Test
    void doegnDosisTC2() {
        Laegemiddel laegemiddel = new Laegemiddel("paracetamol", 5.0, 5.0, 5.0, "");
        Dosis dosis = new Dosis(LocalTime.of(8, 30), 2);
        DagligFast fast = new DagligFast(LocalDate.of(2024, 2, 11), LocalDate.of(2024, 2, 20), laegemiddel, 2, 0, 0, 0);
        double actual = fast.doegnDosis();
        assertEquals(2, actual);
    }

    @Test
    void doegnDosisTC3() {
        Laegemiddel laegemiddel = new Laegemiddel("paracetamol", 5.0, 5.0, 5.0, "");
        Dosis dosis = new Dosis(LocalTime.of(8, 30), 4);
        DagligFast fast = new DagligFast(LocalDate.of(2024, 2, 11), LocalDate.of(2024, 2, 16), laegemiddel, 2, 1, 0, 1);
        double actual = fast.doegnDosis();
        assertEquals(4, actual);
    }

    @Test
    void doegnDosisTC4() {
        Laegemiddel laegemiddel = new Laegemiddel("paracetamol", 5.0, 5.0, 5.0, "");
        Dosis dosis = new Dosis(LocalTime.of(8, 30), 5);
        DagligFast fast = new DagligFast(LocalDate.of(2024, 2, 11), LocalDate.of(2024, 2, 16), laegemiddel, 5, 0, 0, 0);
        double actual = fast.doegnDosis();
        assertEquals(5, actual);
    }

    @Test
    void doegnDosisTC5() {
        Laegemiddel laegemiddel = new Laegemiddel("paracetamol", 5.0, 5.0, 5.0, "");
        Dosis dosis = new Dosis(LocalTime.of(8, 30), 4);
        DagligFast fast = new DagligFast(LocalDate.of(2024, 2, 11), LocalDate.of(2024, 2, 11), laegemiddel, 2, 1, 0, 1);
        double actual = fast.doegnDosis();
        assertEquals(4, actual);
    }
}
