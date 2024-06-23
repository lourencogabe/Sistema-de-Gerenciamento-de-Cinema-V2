package com.cinema.Controller;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Model.userSession;

public class SessionManager {
      private static final Logger logger = LogManager.getLogger(Main.class);
    public static Map<String, userSession> sessionMap = new HashMap<>();

    public static void addSession(String email, UUID userId, String userName) {
        logger.info("adding user to the session");
        sessionMap.put(email, new userSession(userId, userName));
    }

    public static void removeSession(String email) {
        logger.info("Retriving email to unloag");
        sessionMap.remove(email);
    }

    public static boolean isUserLoggedIn(String email) {
        logger.info("veryfing if login");
        return sessionMap.containsKey(email);
    }

    public static userSession getUserSession(String email) {
        logger.info("retriving user session");
        return sessionMap.get(email);
    }

    public static userSession getUserDataFromSession(UUID userId) {
        logger.info("checking if the user id maches with values of email ou name");
        for (Map.Entry<String, userSession> entry : sessionMap.entrySet()) {
            if (entry.getValue().getUserId().equals(userId)) {
                logger.info("returning my user value");
                return entry.getValue();
            }
        }
        return null;
    }

}