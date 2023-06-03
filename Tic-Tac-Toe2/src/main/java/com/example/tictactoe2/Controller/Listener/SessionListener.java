package com.example.tictactoe2.Controller.Listener;


import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import java.util.*;

@WebListener
public class SessionListener implements HttpSessionListener {

    private static int activeSessions = 0;

    private static Set<Integer> activeUsers = new HashSet<>();

    public SessionListener(){super();}

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessions++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        if(activeSessions > 0)
            activeSessions--;
    }

    public static int getActiveSessions() {
        return activeSessions;
    }

    public static void user_login(int id){
        activeUsers.add(id);
    }

    public static void user_logout(int id){
        activeUsers.remove(id);
    }

    public static Set<Integer> getActiveUsers(){ return activeUsers;}
}
