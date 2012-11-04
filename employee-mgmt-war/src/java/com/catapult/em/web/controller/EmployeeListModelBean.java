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
import org.primefaces.model.SortOrder;

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
    public void setRowIndex(int rowIndex)
    {
        if(rowIndex == -1 || getPageSize() == 0) {
            super.setRowIndex(-1);
        }
        else {
            super.setRowIndex(rowIndex % getPageSize());
        }
    }
    
    @Override
    public int getRowCount()
    {
        return (int) svc.getRowCount();
    }

    @Override
    public List<Employee> load(int start, int pageSize, String sortField, SortOrder sorder, Map<String, String> filter)
    {
        try {
            System.out.println("laoding list......");
            Map m = new HashMap();
            m.put("start", start);
            m.put("limit", pageSize);
            if( sorder != SortOrder.UNSORTED ) {
                m.put("sortedBy", sortField);
                m.put("ascending", sorder == SortOrder.ASCENDING ? true : false );
            }
            System.out.println("getting the list using params: " + m);
            return svc.getList(m);
        }
        catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    
}
