package com.example.tictactoe2.Controller.ActiveUsers;

import com.example.tictactoe2.Listener.SessionListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

    public UserServlet() {super();}

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        PrintWriter out = new PrintWriter(response.getOutputStream());
        out.println(SessionListener.get_user(id).getTurn());
        out.flush();
    }
}
