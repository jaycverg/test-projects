package com.catapult.em.model;

import java.io.Serializable;
import java.rmi.server.UID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jvergara
 */

@Entity
@Table(name="employee")
public class Employee implements Serializable
{
    @Id
    private long id;
    
    private String employeeNumber;
    private String lastName;
    private String firstName;
    private String middleName;
    private String address;
    private String emailAddress;
    private String contactNumber;
    
    public Employee() {
        setId(0);
    }

    @Override
    public boolean equals(Object o)
    {
        if( !(o instanceof Employee) ) return false;
        return ((Employee) o).hashCode() == hashCode();
    }

    @Override
    public int hashCode()
    {
        return (Employee.class.getName() + id).hashCode();
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        if( id <= 0 ) 
            this.id = (getClass().getName() + new UID()).hashCode();
        else
            this.id = id;
    }

    public String getEmployeeNumber()
    {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber)
    {
        this.employeeNumber = employeeNumber;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getMiddleName()
    {
        return middleName;
    }

    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public String getContactNumber()
    {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber)
    {
        this.contactNumber = contactNumber;
    }

}
