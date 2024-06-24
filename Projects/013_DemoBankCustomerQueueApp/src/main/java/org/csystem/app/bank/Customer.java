package org.csystem.app.bank;

import java.util.Objects;

public class Customer implements Comparable<Customer> {
    private String m_id;
    private CustomerPriority m_priority;
    private String m_name;

    public Customer(String customerId, CustomerPriority customerPriority, String name)
    {
        m_id = customerId;
        m_priority = customerPriority;
        m_name = name;
    }

    public void setId(String id)
    {
        m_id = id;
    }

    public void setPriority(CustomerPriority priority)
    {
        m_priority = priority;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public String getId()
    {
        return m_id;
    }

    public CustomerPriority getPriority()
    {
        return m_priority;
    }

    public String getName()
    {
        return m_name;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(m_id, m_priority, m_name);
    }
    @Override
    public boolean equals(Object other )
    {
        return other instanceof Customer c && c.m_id.equals(m_id) && c.m_priority == m_priority && c.m_name.equals(m_name) ;
    }
    @Override
    public String toString()
    {
        return "%s, %s, %s".formatted(m_id, m_priority, m_name);
    }

    @Override
    public int compareTo(Customer other)
    {
        return m_priority.compareTo(other.m_priority);
    }
}
