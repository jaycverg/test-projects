package employee.mgmt.client.controller;

import com.catapult.em.model.Employee;
import com.catapult.em.service.EmployeeServiceRemote;
import employee.mgmt.client.EmployeeListPage;
import employee.mgmt.client.RemoteServiceLoader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import simplemvc.annotations.Controller;
import simplemvc.annotations.Page;
import simplemvc.common.MsgBox;
import simplemvc.common.TableModel;

/**
 *
 * @author JAYROME VERGARA
 */

@Controller(pages = {
    @Page(template = EmployeeListPage.class)
})
public class EmployeeMgmtController
{
    private AbstractTableModel tableModel;
    private EmployeeServiceRemote service;
    
    public EmployeeMgmtController()
    {
        tableModel = new EmployeeTableModel();
    }

    public void add()
    {
        MsgBox.alert("adding...");
    }

    /**
     * @return the tableModel
     */
    public AbstractTableModel getTableModel()
    {
        return tableModel;
    }

    /**
     * @return the service
     */
    public EmployeeServiceRemote getService()
    {
        if( service == null )
            service = RemoteServiceLoader.load(EmployeeServiceRemote.class);
        
        return service;
    }

    private class EmployeeTableModel extends TableModel<Employee>
    {

        EmployeeTableModel()
        {
            addColumn("firstName", "First Name");
            addColumn("lastName", "Last Name");
            addColumn("address", "Address");
        }
        
        @Override
        public List<Employee> getList()
        {
            System.out.println("fetching data...");
            return getService().getList();
        }
     
    }
}
