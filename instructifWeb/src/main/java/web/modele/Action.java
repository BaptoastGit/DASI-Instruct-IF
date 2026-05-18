package web.modele;

import jakarta.servlet.http.HttpServletRequest;

public abstract class Action {
    
    protected static boolean ACTION_LOG_ACTIVE = true;
    
    public Action() {
    }

    public abstract void execute(HttpServletRequest request);
}

