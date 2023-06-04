package com.example.tictactoe2.Listener;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {

    public SessionServlet() {super();}

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = new PrintWriter(response.getOutputStream());
        out.println(SessionListener.getActiveUsers().size());
        out.flush();
    }
}
