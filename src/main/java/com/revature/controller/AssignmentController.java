package com.revature.controller;

import com.revature.model.User;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class AssignmentController implements Controller{

    private Handler test = (ctx) -> {

        User currentlyLoggedInUser = (User) ctx.req.getSession().getAttribute("current_user");

        if(currentlyLoggedInUser != null){
            ctx.json(currentlyLoggedInUser);
        } else {
            ctx.json("No user is logged in!");
        }
//        System.out.println(currentlyLoggedInUser);
    };



    @Override
    public void mapEndpoints(Javalin app) {
        app.get("/test", test);
    }
}
