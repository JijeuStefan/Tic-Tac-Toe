package com.example.tictactoe2.Domain;

public class User {
    private final int id;
    private final String username;
    private String symbol;
    private boolean turn;

    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setSymbol(String symbol) {this.symbol = symbol;}

    public String getSymbol() {return symbol;}

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public boolean getTurn() {
        return turn;
    }
}
