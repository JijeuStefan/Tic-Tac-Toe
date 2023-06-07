package com.example.tictactoe2.Controller.Login;

import com.example.tictactoe2.Domain.User;
import com.example.tictactoe2.Listener.SessionListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Logout")
public class Logout extends HttpServlet {

    public Logout() {super();}

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);

        User user = (User) session.getAttribute("user");
        SessionListener.user_logout(user.getId());

        if (SessionListener.getActiveUsers().size() != 0) {
            SessionListener.getActiveUsers().get(0).setTurn(true);
            SessionListener.getActiveUsers().get(0).setSymbol("X");
        }

        request.getSession().invalidate();
    }
}
