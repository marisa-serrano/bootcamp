package org.academiadecodigo.wizards;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer = new Customer();
        customer.setName("Rui Ferrão");
        customer.setEmail("rui.ferrao@academiadecodigo.org");
        customer.setPhone(916667789);

        RequestDispatcher indexDispatcher = getServletContext().getRequestDispatcher("/index.jsp");

        req.setAttribute("customer", customer);

        indexDispatcher.forward(req, resp);
    }
}
