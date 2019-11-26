/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.omnifaces.filter.HttpFilter;
import org.omnifaces.util.Servlets;

/**
 *
 * @author Ellet
 */
//@WebFilter("/view/*")
public class AuthorizationFilter extends HttpFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, HttpSession session, FilterChain chain) throws ServletException, IOException {
        String loginURL = request.getContextPath() + "/view/iniciodesesion.xhtml";
        boolean loggedIn = (session != null) && (session.getAttribute("loggedUser") != null);
        boolean loginRequest = request.getRequestURI().equals(loginURL);
        boolean resourceRequest = Servlets.isFacesResourceRequest(request);

        if (loggedIn || loginRequest || resourceRequest) {
            if (!resourceRequest) {
                Servlets.setNoCacheHeaders(response);
            }

            chain.doFilter(request, response);
        } else {
            Servlets.facesRedirect(request, response, loginURL);
        }
    }

    
    
}
