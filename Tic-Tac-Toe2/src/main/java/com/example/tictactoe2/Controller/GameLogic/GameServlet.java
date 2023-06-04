package com.example.tictactoe2.Controller.GameLogic;


import com.example.tictactoe2.Listener.SessionListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/GameServlet")
public class GameServlet extends HttpServlet {

    public GameServlet() {super();}

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int row = Integer.parseInt(request.getParameter("id")) / 3;
        int col = Integer.parseInt(request.getParameter("id")) % 3;
        String symb = request.getParameter("symb");

        Game.make_move(row,col,symb);
        SessionListener.change_turns();

        PrintWriter out = new PrintWriter(response.getOutputStream());

        if (Game.game_draw())
            out.println("Game is a draw!");

        if (Game.game_won() != null)
            out.println(Game.game_won());

        out.flush();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[][] table = Game.get_table();
        JSONArray jsonTable = new JSONArray();
        for (String[] row: table) {
            for (String elem: row){
            JSONObject jObj = new JSONObject();
            jObj.put("symbol",elem);
            jsonTable.add(jObj);
            }
        }

        PrintWriter out = new PrintWriter(response.getOutputStream());
        response.setContentType("application/json");
        out.println(jsonTable.toJSONString());
        out.flush();
    }
}


