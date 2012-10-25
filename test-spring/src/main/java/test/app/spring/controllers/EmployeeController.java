/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.app.spring.controllers;

import java.io.IOException;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import test.app.spring.dao.EmployeeDAO;
import test.app.spring.model.Employee;

/**
 *
 * @author jvergara
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController
{

    @Autowired
    private EmployeeDAO empDAO;

    @RequestMapping(method = RequestMethod.GET)
    public void getEmployee(HttpServletResponse resp) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(), empDAO.getList(null));
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createEmployee(@ModelAttribute Employee emp, HttpServletResponse resp) throws IOException
    {
        System.out.println("about to lastname: " + emp.getLastName());
        System.out.println("about to firstname: " + emp.getFirstName());
        
        resp.getWriter().write("ok");
    }
}
