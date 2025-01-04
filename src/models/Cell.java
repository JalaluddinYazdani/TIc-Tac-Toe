package models;

public class Cell {
    private Player player;
    private int row;

    public Cell(int i, int j) {
        this.row = i;
        this.col = j;
        this.cellState= cellState.EMPTY;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    private int col;
    private CellState cellState;
}
