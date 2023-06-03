package com.example.tictactoe2.Controller.GameLogic;


import com.example.tictactoe2.GameTable.Table;

import java.util.Objects;

public class Game{
    private static Table game_table = new Table();

    public Game(){
        super();
    }

    public static boolean game_draw(){
        for (String[] row : game_table.getTable()) {
            for (String elem : row) {
                if (Objects.equals(elem, ""))
                    return false;
            }
        }
        return true;
    }

    public static boolean game_won(){
        String[][] table = game_table.getTable();

        for (int i = 0; i < 3; i++){
            if (Objects.equals(table[i][0], table[i][1]) && Objects.equals(table[i][1], table[i][2]))
                return true;

            if (Objects.equals(table[0][i], table[1][i]) && Objects.equals(table[1][i], table[2][i]))
                return true;
        }

        if (Objects.equals(table[0][0], table[1][1]) && Objects.equals(table[1][1], table[2][2]))
            return true;

        if (Objects.equals(table[0][2], table[1][1]) && Objects.equals(table[1][1], table[2][0]))
            return true;

        return false;
    }

    public static void make_move(int row, int col, String symb){
        game_table.add_move(row,col,symb);
    }

    public static String[][] get_table() {return game_table.getTable();}

}
