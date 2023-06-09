package com.example.tictactoe2.Listener;


import com.example.tictactoe2.Model.User;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import java.util.*;

@WebListener
public class SessionListener implements HttpSessionListener {

    private static int activeSessions = 0;

    private static List<User> activeUsers = new ArrayList<>();

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

    public static void user_login(User user){
        if (is_user_logged(user.getId()))
            return;
        activeUsers.add(user);
    }

    public static void user_logout(int id){
        activeUsers.removeIf(user -> user.getId() == id);
    }

    public static boolean is_user_logged(int id) {
        for (User user: activeUsers)
            if (user.getId() == id)
                return true;
        return false;
    }

    public static User get_user(int id){
        for (User user : activeUsers)
            if (user.getId() == id)
                return user;
        return null;
    }

    public static List<User> getActiveUsers(){ return activeUsers;}

    public static void change_turns(){
        for (User user : activeUsers)
            user.setTurn(!user.getTurn());
    }
}
