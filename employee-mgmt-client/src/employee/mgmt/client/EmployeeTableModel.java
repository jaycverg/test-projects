package employee.mgmt.client;

import com.catapult.em.model.Employee;
import com.catapult.em.service.EmployeeServiceRemote;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jvergara
 */
public class EmployeeTableModel extends DefaultTableModel
{

    private EmployeeServiceRemote svc;
    private List<Employee> employees;
    private List<String> columns;

    public void load()
    {
        if (svc == null) {
            svc = (EmployeeServiceRemote) RemoteServiceLoader.load(EmployeeServiceRemote.class);
            columns = new ArrayList();
            columns.add("lastName");
            columns.add("firstName");
        }

        employees = svc.getList(null);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount()
    {
        return employees != null ? employees.size() : 0;
    }

    @Override
    public String getColumnName(int i)
    {
        return columns.get(i);
    }

    @Override
    public Object getValueAt(int row, int col)
    {
        Employee emp = employees.get(row);
        String colname = columns.get(col);
        
    }
}
