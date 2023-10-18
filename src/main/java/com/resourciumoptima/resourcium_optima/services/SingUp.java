package com.resourciumoptima.resourcium_optima.services;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {

        final String HTML  = "<h1>hello Abdellah</h1>";
        PrintWriter writer = response.getWriter();
        writer.write(HTML);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){

    }
}
