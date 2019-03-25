package boot_camp.martrix;

import java.util.ArrayList;
import java.util.Objects;

class IntegerMatrix implements Matrix<IntegerMatrix> {
    private ArrayList<ArrayList<Integer>> matrix;

    IntegerMatrix(ArrayList<ArrayList<Integer>> matrix) {
        this.matrix = matrix;
    }

    public IntegerMatrix add(IntegerMatrix integerMatrix) {
        ArrayList<ArrayList<Integer>> inputMatrix = integerMatrix.matrix;
        ArrayList<ArrayList<Integer>> sumMatrix = new ArrayList<>();

        int row = this.getRowCount();
        for (int i = 0; i < row; i++) {
            ArrayList<Integer> rowMatrix = addRowElements(inputMatrix, i);
            sumMatrix.add(rowMatrix);
        }
        return new IntegerMatrix(sumMatrix);
    }

    private ArrayList<Integer> addRowElements(ArrayList<ArrayList<Integer>> inputMatrix, int rowIndex) {
        ArrayList<Integer> rowMatrix = new ArrayList<>();
        int column = this.getColumnCount();
        for (int j = 0; j < column; j++) {
            int sum = this.matrix.get(rowIndex).get(j) + inputMatrix.get(rowIndex).get(j);
            rowMatrix.add(sum);
        }
        return rowMatrix;
    }

    private int getRowCount() {
        try {
            return this.matrix.size();
        } catch (Exception ex) {
            return 0;
        }

    }

    private int getColumnCount() {
        try {
            return this.matrix.get(0).size();
        } catch (Exception ex) {
            return 0;
        }

    }

    IntegerMatrix transpose() {
        ArrayList<ArrayList<Integer>> transposeMatrix = new ArrayList<>();
        int columns = this.getColumnCount();
        for (int row = 0; row < columns; row++) {
            transposeMatrix.add(getTransposedRow(row));
        }
        return new IntegerMatrix(transposeMatrix);
    }

    private ArrayList<Integer> getTransposedRow(Integer row) {
        ArrayList<Integer> resultRow = new ArrayList<>();
        for (ArrayList<Integer> rowElements : this.matrix) {
            resultRow.add(rowElements.get(row));
        }
        return resultRow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerMatrix that = (IntegerMatrix) o;
        return Objects.equals(matrix, that.matrix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matrix);
    }
}
