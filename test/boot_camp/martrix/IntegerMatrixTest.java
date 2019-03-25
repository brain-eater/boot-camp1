package boot_camp.martrix;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntegerMatrixTest {


    @Test
    void ShouldAddTwoIntegerMatrix() {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        row.add(1);
        row.add(2);
        matrix.add(row);
        matrix.add(row);
        IntegerMatrix integerMatrix = new IntegerMatrix(matrix);
        IntegerMatrix actualMatrix = integerMatrix.add(new IntegerMatrix(matrix));
        assertEquals(actualMatrix, actualMatrix);
    }

    @Test
    void ShouldAddTwoIntegerMatrixOfDifferentColumnAndRow() {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        row.add(1);
        row.add(2);
        row.add(3);
        matrix.add(row);
        matrix.add(row);
        IntegerMatrix integerMatrix = new IntegerMatrix(matrix);
        IntegerMatrix actualMatrix = integerMatrix.add(new IntegerMatrix(matrix));
        assertEquals(actualMatrix, actualMatrix);
    }

    @Test
    void ShouldAddTwoDifferentMatrix() {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>(Arrays.asList(1, 2, 3));
        matrix.add(row);
        matrix.add(row);
        IntegerMatrix integerMatrix = new IntegerMatrix(matrix);
        IntegerMatrix actualMatrix = integerMatrix.add(new IntegerMatrix(matrix));


        ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>(Arrays.asList(2, 4, 6));
        expected.add(row1);
        expected.add(row1);

        assertEquals(new IntegerMatrix(expected), actualMatrix);
    }

    @Test
    void ShouldGiveTransposeOfMatrix() {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>(Arrays.asList(1, 2, 3));
        matrix.add(row);
        matrix.add(row);
        IntegerMatrix integerMatrix = new IntegerMatrix(matrix);
        IntegerMatrix actualMatrix = integerMatrix.transpose();

        ArrayList<ArrayList<Integer>> expectedMatrix = new ArrayList<>();
        row = new ArrayList<>(Arrays.asList(1, 1));
        expectedMatrix.add(row);
        row = new ArrayList<>(Arrays.asList(2, 2));
        expectedMatrix.add(row);
        row = new ArrayList<>(Arrays.asList(3, 3));
        expectedMatrix.add(row);
        assertEquals(new IntegerMatrix(expectedMatrix), actualMatrix);

    }
}