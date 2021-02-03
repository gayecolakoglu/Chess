package com.Chess;

import java.util.ArrayList;

public class Square{
    protected Piece piece = null;
    private String column;
    private String row;
    private ChessBoard chessBoard;


    public Square(String column, String row, ChessBoard chessBoard) {
        this.column = column;
        this.row = row;
        this.chessBoard = chessBoard;
    }

    public void addPiece(Piece piece) {
        this.piece = piece;
    }



    public ChessBoard getBoard() {
        return this.chessBoard;
    }

    @Override
    public String toString() {
        return column+row;
    }

    public int getRowDistance(Square location) {
        Integer currentRow = Integer.parseInt(this.row);
        Integer otherRow = Integer.parseInt(location.getRow());

        return currentRow-otherRow;
    }

    public String getColumn() {
        return column;
    }

    public String getRow() {
        return row;
    }

    public boolean isAtSameColumn(Square targetLocation) {
        int columnLocation = arrayLocation(targetLocation.getColumn() + targetLocation.getRow())[1];
        int columnThis = arrayLocation(column + row)[1];
        return columnLocation == columnThis;
    }

    public boolean isDiagonal(Square targetLocation) {
        ArrayList<Square> answer = new ArrayList<>();
        int[] arrayLocation = arrayLocation(this.getColumn() + this.getRow());
        int x = arrayLocation[0];//array row
        int y = arrayLocation[1];//array column

        int xNew = x - 1;
        int yNew = y - 1;

        while (isValid(xNew, yNew)) {
            answer.add(getBoard().board[xNew][yNew]);
            xNew--;
            yNew--;
        }

        xNew = x + 1;
        yNew = y - 1;
        while (isValid(xNew, yNew)) {
            answer.add(getBoard().board[xNew][yNew]);
            yNew--;
            xNew++;
        }
        xNew = x + 1;
        yNew = y + 1;

        while (isValid(xNew, yNew)) {
            answer.add(getBoard().board[xNew][yNew]);
            yNew++;
            xNew++;
        }

        xNew = x - 1;
        yNew = y + 1;
        while (isValid(xNew, yNew)) {
            answer.add(getBoard().board[xNew][yNew]);
            yNew++;
            xNew++;
        }


        return answer.contains(targetLocation);
    }

    public boolean isEmpty() {
        return this.piece == null;
    }

    public boolean isNeighborColumn(Square targetLocation) {
        int[] arrayLocationOfTarget = arrayLocation(targetLocation.getColumn() + targetLocation.getRow());
        int[] arrayLocationOfThis = arrayLocation(column + row);
        int targetRow = arrayLocationOfTarget[0];
        int targetColumn = arrayLocationOfTarget[1];
        int thisRow = arrayLocationOfThis[0];
        int thisColumn = arrayLocationOfThis[1];

        //current piece color
        int color = piece.getColor();
        if(color == ChessBoard.WHITE) {
            return thisRow - targetRow == 1 && Math.abs(targetColumn - thisColumn) == 1;
        } else {
            return thisRow - targetRow == -1 && Math.abs(targetColumn - thisColumn) == 1;
        }
    }

    public Piece getPiece() {
        return piece;
    }

    public void clear() {
        this.piece = null;
    }

    public boolean isAtLastRow(int color) {
        color = getBoard().turn;
        if (getBoard().turn == 0) {
            return getRow().equals("8");
        } else {
            return getRow().equals("1");
        }
    }

    public void putNewQueen(int color) {
        this.piece = new Queen(color, this);
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int[] arrayLocation(String destination) {
        return getBoard().arrayLocation(destination);
    }

    public boolean isAtSameRow(Square targetLocation) {
        int rowLocation = arrayLocation(targetLocation.getColumn() + targetLocation.getRow())[0];
        int rowThis = arrayLocation(column + row)[0];

        return rowLocation == rowThis;
    }

    public ArrayList<Square> possibleMovementsForKnight() {
        ArrayList<Square> answer = new ArrayList<>();
        int[] arrayLocation = arrayLocation(column + row);
        int currentRow = arrayLocation[0];
        int currentColumn = arrayLocation[1];

        for (int row=-2; row <= 2; row++) {
            for(int column=-2; column<=2; column++) {
                if(Math.abs(row * column) == 2 && isValid(row+currentRow,column+currentColumn)) {
                    answer.add(getBoard().board[row+currentRow][column+currentColumn]);
                }
            }
        }

        return answer;
    }

    public ArrayList<Square> possibleMovementsForKing() {
        ArrayList<Square> answer = new ArrayList<>();
        int[] arrayLocation = arrayLocation(column + row);
        int currentRow = arrayLocation[0];
        int currentColumn = arrayLocation[1];


        int[][] sets = {{1, 0}, {0, 1},{-1, 0},{0, -1},{1, 1},{-1, 1},{-1, -1},{1, -1}};
        for(int[] set : sets) {
            int newRow = currentRow+set[0];
            int newColumn = currentColumn+set[1];
            if(isValid(newRow, newColumn )) {
                answer.add(getBoard().board[newRow][newColumn]);
            }
        }

        return answer;
    }

    public boolean isValid(int row, int column) {
        return row >= 0 && row <= 7 && column >= 0 && column <= 7;
    }
}
