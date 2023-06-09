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
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        String action = request.getParameter("action");

        if (action != null && action.equals("move")) {

            int row = Integer.parseInt(request.getParameter("id")) / 3;
            int col = Integer.parseInt(request.getParameter("id")) % 3;
            String symb = request.getParameter("symb");

            Game.make_move(row, col, symb);
            SessionListener.change_turns();
        }
        else if (action != null && action.equals("reset"))
            Game.reset();

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");

        PrintWriter out = new PrintWriter(response.getOutputStream());
        if (action != null && action.equals("status")) {

            if (Game.game_won() != null)
                out.println(Game.game_won());

            if (Game.game_draw())
                out.println("Game is a draw!");

            out.flush();
        }
        else if (action != null && action.equals("table")){
            String[][] table = Game.get_table();
            JSONArray jsonTable = new JSONArray();
            for (String[] row : table) {
                for (String elem : row) {
                    JSONObject jObj = new JSONObject();
                    jObj.put("symbol", elem);
                    jsonTable.add(jObj);
                }
            }

            response.setContentType("application/json");
            out.println(jsonTable.toJSONString());
            out.flush();
        }
    }
}


