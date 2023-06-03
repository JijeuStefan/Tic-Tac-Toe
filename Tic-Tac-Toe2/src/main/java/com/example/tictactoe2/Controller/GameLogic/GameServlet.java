package com.example.tictactoe2.Controller.GameLogic;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import org.json.simple.JSONArray;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/move")
public class GameServlet extends HttpServlet {

    GameServlet(){super();}

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int row = Integer.parseInt(request.getParameter("id")) / 3;
        int col = Integer.parseInt(request.getParameter("id")) % 3;
        String symb = request.getParameter("symb");

        Game.make_move(row,col,symb);

        PrintWriter out = new PrintWriter(response.getOutputStream());

        if (Game.game_draw())
            out.println("Game is a draw!");

        if (Game.game_won())
            out.println("Game is won!");

        out.flush();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String[][] table = Game.get_table();
//        JSONArray jsonTable = new JSONArray();
//        for (String[] row: table) {
//            for (String elem: row){
//            JSONObject jObj = new JSONObject();
//            jObj.put("id", asset.getId());
//            jObj.put("userid", asset.getUserid());
//            jObj.put("description", asset.getDescription());
//            jObj.put("value", asset.getValue());
//            jsonAssets.add(jObj);
//            }
//        }
//        PrintWriter out = new PrintWriter(response.getOutputStream());
//        out.println(jsonTable.toJSONString());
//        out.flush();
    }
}
