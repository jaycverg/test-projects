/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catapult.em.web.controller;

import com.catapult.em.model.Employee;
import com.catapult.em.service.EmployeeServiceLocal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Transient;
import org.primefaces.model.LazyDataModel;

/**
 *
 * @author jvergara
 */

@ManagedBean
@ViewScoped
public class EmployeeListModelBean extends LazyDataModel<Employee>
{
    @EJB(name = "EmployeeService")
    @Transient
    private EmployeeServiceLocal svc;
    

    @Override
    public int getRowCount()
    {
        return (int) svc.getRowCount();
    }
    
    @Override
    public List<Employee> load(int start, int pageSize, String sortField, boolean ascending, Map<String, String> filter)
    {
        Map m = new HashMap();
        m.put("start", start);
        m.put("limit", pageSize);
        m.put("sortedBy", sortField);
        m.put("ascending", ascending);
        return svc.getList(m);
    }
    
}
