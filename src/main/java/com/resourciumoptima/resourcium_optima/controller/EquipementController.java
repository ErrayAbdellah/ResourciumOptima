package com.resourciumoptima.resourcium_optima.controller;

import com.resourciumoptima.resourcium_optima.enums.Etat;
import com.resourciumoptima.resourcium_optima.models.entities.Equipement;
import com.resourciumoptima.resourcium_optima.models.entities.Equipement;
import com.resourciumoptima.resourcium_optima.services.IEquipementService;
import com.resourciumoptima.resourcium_optima.services.impl.EquipementServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "EquipementController",urlPatterns = {"*.e"})
public class EquipementController extends HttpServlet {

    private final IEquipementService equipementService ;

    public EquipementController(){
        equipementService = new EquipementServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Equipement equipement = new Equipement();
        String path = request.getServletPath();
        RequestDispatcher dispatcher = null;
        System.out.println(path);
        switch (path){
            case "/dashboard/equipement.e":
                List<Equipement> equipements = equipementService.findAll();
                System.out.println(equipements);
                request.setAttribute("equipementList", equipements);
                request.getRequestDispatcher("/dashboard/equipement.jsp").forward(request,response);
                break;
            case "/dashboard/update-equipement.t":
                int id = Integer.parseInt(request.getParameter("id_equipement"));
                equipement = equipementService.findById(id);
                request.setAttribute("equipement", equipement);
                request.getRequestDispatcher("/dashboard/equipementUpdate.jsp").forward(request,response);
                break;
            case "/dashboard/delete-equipement.t":
                int id_delete = Integer.parseInt(request.getParameter("id_equipement"));
                equipementService.delete(id_delete);
                break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Equipement equipement = new Equipement();
        String path = request.getServletPath();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println(path);
        System.out.println("1");
        switch (path){
            case "/dashboard/save.e":
                System.out.println("2");
                try {
                    equipement.setName(request.getParameter("name"));
                    equipement.setType(request.getParameter("type"));
//                    equipement.setEtat(Etat.valueOf(request.getParameter("etat")));
                    equipement.setDateAchat(dateFormat.parse(request.getParameter("date_achat")));
                    equipement.setDateMaintenance(dateFormat.parse(request.getParameter("date_maintenance")));
                    System.out.println(equipement);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(equipement);
                equipementService.save(equipement);
                break;
            case "/dashboard/update.t":
                SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

//                try {
//                    int id = Integer.parseInt(request.getParameter("id"));
//                    equipement.setId(id);
//                    equipement.setDescription(request.getParameter("description"));
//                    equipement.se(dateFormat1.parse(request.getParameter("dateStart")));
//                    equipement.setDateLimite(dateFormat1.parse(request.getParameter("dateEnd")));
//                    equipement.setPriorite(Integer.parseInt(request.getParameter("priorite")));
//                    System.out.println(equipement);
//                } catch (ParseException e) {
//                    throw new RuntimeException(e);
//                }
                equipementService.update(equipement);
                break;
//            case "/dashboard/delete-equipement.t":
//                System.out.println("Delete");
//                break;
        }
    }
}
