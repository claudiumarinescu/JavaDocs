package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Claudiu.Marinescu on 7/19/2017.
 */
public class ZeroToHeroServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().write(handleRequest(request));
    }

    private String handleRequest(HttpServletRequest request) {
        String name = request.getParameter("name");
        return "Hello <b>" + name + "</b>! Enjoying ZeroToHero yet?";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
