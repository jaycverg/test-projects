package com.catapult.em.ws;

import com.catapult.em.model.Employee;
import com.catapult.em.service.EmployeeServiceLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
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
    @WebMethod(operationName="read")
    public Employee read(@WebParam(name="id") long id)
    {
        return svc.read(id);
    }

    @Override
    @WebMethod(operationName="find")
    public List<Employee> find(
            @WebParam(name="lastName") String lastName,
            @WebParam(name="firstName") String firstName)
    {
        return svc.find(lastName, firstName);
    }
}
