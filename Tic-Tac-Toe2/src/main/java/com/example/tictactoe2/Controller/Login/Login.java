package com.example.tictactoe2.Controller.Login;

import com.example.tictactoe2.Controller.Listener.SessionListener;
import com.example.tictactoe2.DataBase.DataBase;
import com.example.tictactoe2.Domain.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/Login")
public class Login extends HttpServlet {

    public Login() {super();}

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        RequestDispatcher rd;

        DataBase db = new DataBase();
        User user = db.authenticate(username,password);

        if (user != null) {
            HttpSession session = request.getSession();

            if (SessionListener.getActiveSessions() == 3) {
                rd = request.getRequestDispatcher("/error.jsp");
            } else {

                if (session.getAttribute("user") == null) {
                    if (SessionListener.getActiveSessions() == 1) {
                        user.setSymbol("X");
                        user.setTurn(true);
                    } else if (SessionListener.getActiveSessions() == 2) {
                        user.setSymbol("O");
                        user.setTurn(false);
                    }

                    session.setAttribute("user", user);

                    SessionListener.user_login(user.getId());
                }

                rd = request.getRequestDispatcher("/success.jsp");
            }

        }
        else{
            rd = request.getRequestDispatcher("/error.jsp");
        }

        rd.forward(request,response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        SessionListener.user_logout(user.getId());

        request.getSession().invalidate();
    }
}
