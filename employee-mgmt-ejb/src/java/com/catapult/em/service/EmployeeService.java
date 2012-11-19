package com.catapult.em.service;

import com.catapult.em.model.Employee;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jvergara
 */

@Stateless
@Local(EmployeeServiceLocal.class)
public class EmployeeService implements EmployeeServiceLocal
{
    @PersistenceContext
    private EntityManager em;
    
    
    @Override
    public Employee create(Employee emp)
    {
        em.persist(emp);
        return emp;
    }

    @Override
    public Employee read(long id)
    {
        return em.find(Employee.class, id);
    }

    @Override
    public Employee update(Employee emp)
    {
        em.merge(emp);
        return emp;
    }

    @Override
    public void remove(long id)
    {
        em.createQuery("delete from Employee where id=:id")
          .setParameter("id", id)
          .executeUpdate();
    }
    
    @Override
    public List<Employee> getList()
    {
        return em.createQuery("select o from Employee o")
                 .getResultList();
    }

}
