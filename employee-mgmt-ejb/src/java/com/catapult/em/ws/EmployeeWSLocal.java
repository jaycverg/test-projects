package com.catapult.em.ws;

import com.catapult.em.model.Employee;
import java.util.List;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author jvergara
 */
public interface EmployeeWSLocal
{

    public Employee read(long id);

    public List<Employee> find(String lastName, String firstName);
}
