package com.catapult.em.service;

import com.catapult.em.model.Employee;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author jvergara
 */
public interface EmployeeServiceLocal
{

    Employee create(Employee emp);

    Employee read(long id);

    Employee update(Employee emp);

    void delete(Employee emp);

    void delete(List<String> ids);

    List<Employee> getList(Map param);

    List<Employee> find(String lastname, String firstname);

    List<Employee> find(String lastname, String firstname, int maxResults);

    long getRowCount();
}
