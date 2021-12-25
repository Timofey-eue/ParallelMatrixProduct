import java.util.Random;

public class UsualMatrix {
    protected int[][] matrix;
    protected int col;
    protected int row;


    public UsualMatrix(int data) {
        this.row = data;
        this.col = data;
        this.matrix = new int[data][data];
    }

    public UsualMatrix(int size, int val) {
        this.row = size;
        this.col = size;
        this.matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = val;
            }
        }
    }

    public UsualMatrix(int r, int c, int value) {
        this.row = r;
        this.col = c;
        this.matrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = value;
            }
        }
    }

    public void setEl(int row, int col, int value) {
        this.matrix[row][col] = value;
    }

    public int getEl(int row, int col) {
        return this.matrix[row][col];
    }

    public UsualMatrix mult(UsualMatrix mtx) {
        if (this.col == mtx.row) {
            UsualMatrix result = new UsualMatrix(this.row, mtx.col, 0);
            for (int i = 0; i < this.row; i++) {
                for (int j = 0; j < mtx.col; j++) {
                    for (int k = 0; k < this.col; k++) {
                        result.setEl(i, j, result.getEl(i, j) + this.getEl(i, j) * mtx.getEl(k, j));
                    }
                }
            }
            return result;
        } else {
            System.out.println("-1000");
            return this;
        }
    }

    public void randNum() {
        Random r = new Random();
        this.matrix = new int[this.row][this.col];
        for (int i = 0; i != this.row; i++) {
            for (int j = 0; j != this.col; j++) {
                this.matrix[i][j] = r.nextInt(9) + 1;
            }
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i != this.row; i++) {
            for (int j = 0; j != this.col; j++) {
                result.append("|").append(this.getEl(i, j)).append("|");
            }
            result.append("\n");
        }
        return result.toString();
    }

}