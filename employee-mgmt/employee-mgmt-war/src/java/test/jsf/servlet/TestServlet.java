/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jsf.servlet;

import java.io.IOException;
import java.io.Writer;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author jvergara
 */
@WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet"})
public class TestServlet extends HttpServlet
{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Object resource = null;
        try {
            InitialContext ctx = new InitialContext();
            resource = ctx.lookup("java:/testDS");
        }
        catch(Exception e) {}
        
        resp.setContentType("text/html");
        Writer w = resp.getWriter();
        w.write("resource is " + resource + "<br/>");
        w.write("result from test servlet.");
    }

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }
}
