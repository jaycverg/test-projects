package com.catapult.em.service;

import com.catapult.em.model.Employee;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author jvergara
 */
public interface EmployeeServiceRemote
{

    Employee create(Employee emp);

    Employee read(long id);

    Employee update(Employee emp);

    void remove(long id);

    void removeAll(List<Long> ids);

    List<Employee> getList();

    List<Employee> getList(Map param);

    List<Employee> find(String lastname, String firstname);

    List<Employee> find(String lastname, String firstname, int maxResults);

    long getRowCount();
}
