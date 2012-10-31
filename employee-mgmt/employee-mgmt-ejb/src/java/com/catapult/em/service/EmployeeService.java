package com.catapult.em.service;

import com.catapult.em.model.Employee;
import com.catapult.em.util.CollectionUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jvergara
 */

@Stateless
@Local(EmployeeServiceLocal.class)
@Remote(EmployeeServiceRemote.class)
public class EmployeeService implements EmployeeServiceLocal, EmployeeServiceRemote
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
        //em.removeAll(emp); -- object is detached
        em.createQuery("delete from Employee where id=:id")
          .setParameter("id", id)
          .executeUpdate();
    }
    
    @Override
    public void removeAll(List<Long> ids)
    {
        em.createQuery("delete from Employee where id in :idList")
          .setParameter("idList", ids)
          .executeUpdate();
    }
    
    @Override
    public List<Employee> getList()
    {
        return getList(null);
    }

    @Override
    public List<Employee> getList(Map param)
    {
        if( param == null ) param = new HashMap();
        
        StringBuilder buff = new StringBuilder();
        buff.append("select o from Employee o");
        if( param.get("sortedBy") != null ) {
            buff.append(" order by " + param.get("sortedBy"));
        }
        else {
            buff.append(" order by id");
        }
        
        if( "false".equals(param.get("ascending") + "")) {
            buff.append(" desc ");
        }
        
        Query qry = em.createQuery(buff.toString());
        
        int start = 0;
        int limit = -1;        
        if( param.get("start") != null ) 
            start = (Integer) param.get("start");
        if( param.get("limit") != null)
            limit = (Integer) param.get("limit");
        
        if( start >= 0 ) qry.setFirstResult(start);
        if( limit > -1 ) qry.setMaxResults(limit);
        
        return qry.getResultList();
    }

    @Override
    public List<Employee> find(String lastName, String firstName)
    {
        return find(lastName, firstName, 50);
    }

    @Override
    public List<Employee> find(String lastName, String firstName, int maxResults)
    {
        StringBuilder buff = new StringBuilder();
        buff.append("select o from Employee o");
        
        List cond = new ArrayList();
        if( lastName != null )  cond.add("lastName like :lastName");
        if( firstName != null ) cond.add("firstName like :firstName");
        
        if( cond.size() > 0 ){
            buff.append(" where ");
            buff.append( CollectionUtil.join(cond, " and "));
        }
        
        Query qry = em.createQuery(buff.toString());
        if( lastName != null )  qry.setParameter("lastName", lastName+"%");
        if( firstName != null ) qry.setParameter("firstName", firstName+"%");
        
        if( maxResults > 0 ) qry.setMaxResults(maxResults);
        
        return qry.getResultList();
    }

    @Override
    public long getRowCount()
    {
        return (Long) em.createQuery("select count(o) from Employee o").getSingleResult();
    }
    
}
