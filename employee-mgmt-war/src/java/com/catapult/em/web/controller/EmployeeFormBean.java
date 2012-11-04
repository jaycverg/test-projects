package com.catapult.em.web.controller;

import com.catapult.em.model.Employee;
import com.catapult.em.service.EmployeeServiceLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Transient;

/**
 *
 * @author JAYROME VERGARA
 */
@ManagedBean
@ViewScoped
public class EmployeeFormBean implements Serializable
{
    @EJB(name = "EmployeeService")
    @Transient
    private EmployeeServiceLocal svc;
    
    private Employee employee;
    private String editmode;
    
    
    public void add()
    {
        employee = new Employee();
        editmode = "create";
    }
    
    public void edit(Employee emp) 
    {
        this.employee = emp;
        editmode = "edit";
    }
    
    public void save()
    {
        if( "create".equals(editmode) )
            svc.create(employee);
        else
            svc.update(employee);
        
        employee = null;
        editmode = null;
    }
    
    public void remove(Employee emp) 
    {
        svc.remove(emp.getId());
    }
        
    //<editor-fold defaultstate="collapsed" desc=" getters / setters ">
    public Employee getEmployee()
    {
        return employee;
    }
    
    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }
    //</editor-fold>

}
