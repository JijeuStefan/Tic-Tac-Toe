package com.example.tictactoe2.GameTable;

public class Table {

    private String[][] table;

    public Table(){
        reset_table();
    }

    public void reset_table(){
        table = new String[3][3];
        for (String[] elem : table) {
            elem[0] = "";
            elem[1] = "";
            elem[2] = "";
        }
    }

    public void add_move(int row, int col, String symbol){
        table[row][col] = symbol;
    }

    public String[][] getTable(){return table;}
}
