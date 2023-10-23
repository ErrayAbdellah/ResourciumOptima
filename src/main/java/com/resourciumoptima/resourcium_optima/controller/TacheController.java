package com.resourciumoptima.resourcium_optima.controller;

import com.resourciumoptima.resourcium_optima.models.entities.Tache;
import com.resourciumoptima.resourcium_optima.models.entities.User;
import com.resourciumoptima.resourcium_optima.services.ITacheService;
import com.resourciumoptima.resourcium_optima.services.impl.TacheSeviceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "TacheController",urlPatterns = {"*.t"})
public class TacheController extends HttpServlet {

    private final ITacheService tacheService ;
    public TacheController(){
        tacheService = new TacheSeviceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Tache tache = new Tache();
        String path = request.getServletPath();
        RequestDispatcher dispatcher = null;
        System.out.println(path);
        switch (path){
            case "/dashboard/tache.t":
                List<Tache> taches = tacheService.findAll();
                System.out.println(taches);
                request.setAttribute("tacheList", taches);
                request.getRequestDispatcher("/dashboard/tache.jsp").forward(request,response);


                break;
            case "/dashboard/update-tache.t":
                int id = Integer.parseInt(request.getParameter("id_tache"));
                tache = tacheService.findById(id);
                request.setAttribute("tache", tache);
                request.getRequestDispatcher("/dashboard/tacheUpdate.jsp").forward(request,response);
                break;
            case "/dashboard/update.u":

                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Tache tache = new Tache();
        String path = request.getServletPath();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println(path);
        switch (path){
            case "/dashboard/save.t":
                try {
                    tache.setDescription(request.getParameter("description"));
                    tache.setStartDate(dateFormat.parse(request.getParameter("dateStart")));
                    tache.setDateLimite(dateFormat.parse(request.getParameter("dateEnd")));
                    tache.setPriorite(Integer.parseInt(request.getParameter("priorite")));
                    System.out.println(tache);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(tache);
                tacheService.save(tache);
                break;
            case "/dashboard/update.t":
                SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

                try {
                    int id = Integer.parseInt(request.getParameter("id"));
                    tache.setId(id);
                    tache.setDescription(request.getParameter("description"));
                    tache.setStartDate(dateFormat1.parse(request.getParameter("dateStart")));
                    tache.setDateLimite(dateFormat1.parse(request.getParameter("dateEnd")));
                    tache.setPriorite(Integer.parseInt(request.getParameter("priorite")));
                    System.out.println(tache);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                tacheService.update(tache);
                break;
            case "/dashboard/delete.u":
                System.out.println("Delete");
                break;
        }
    }
}
