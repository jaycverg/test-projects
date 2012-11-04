package com.catapult.em.ws;

import com.catapult.em.model.Employee;
import com.catapult.em.service.EmployeeServiceLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author jvergara
 */
@WebService
@Stateless
public class EmployeeWS implements EmployeeWSLocal
{
    @EJB(name="EmployeeService")
    private EmployeeServiceLocal svc;

    @Override
    public Employee read(long id)
    {
        return svc.read(id);
    }

    @Override
    public List<Employee> find(String lastName, String firstName)
    {
        return svc.find(lastName, firstName);
    }
}
