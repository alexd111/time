package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.Timestamp;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void currentUTCTime() {
    	renderJSON(Timestamp.nowUTC());
    }
    
    public static void currentTime() {
    	renderJSON(Timestamp.now());
    }
}