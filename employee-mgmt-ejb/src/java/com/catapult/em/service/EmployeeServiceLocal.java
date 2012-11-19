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

    void remove(long id);

    List<Employee> getList();
}
