/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.app.spring.dao;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jvergara
 */

@Repository
public class EmployeeDAO
{
    @Resource(name="jdbcTemplate")
    private JdbcTemplate jdbc;
    
    public List<Map<String, Object>> getList(Map param) {
        return jdbc.queryForList("select * from employee");
    }
}
