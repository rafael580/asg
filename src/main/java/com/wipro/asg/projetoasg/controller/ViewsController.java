package com.wipro.asg.projetoasg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewsController {

    @RequestMapping({"/","/login"})
    public String index(){
        return "index.html";
    }
    @RequestMapping({"/Registration/Create"})
    public String create(){
        return "create.html";
    }
    @RequestMapping("/UserDetail/index")
    public String userlist(){return "userdetails.html";}
    @RequestMapping("/UserDetail/index/{id}")
    public String editlist(){return "edituser.html";}
    //DASHBOARD
    @RequestMapping("/Dashboard/Index")
    public String dashboard(){
        return "dashboard.html";
    }
    // VEHICLE
    @RequestMapping("/VehicleDetails/index")
    public String listvechile(){
        return "listvehicle.html";
    }
    @RequestMapping("/VehicleDetails/Create")
    public String createvehicle(){
        return "createvehile.html";
    }

    // @RequestMapping("/VehicleDetails/edit/{id}")

}
