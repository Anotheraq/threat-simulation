package com.threat.sim.repositories;

import com.threat.sim.models.UserBAC;
import com.threat.sim.models.UserSQLI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserRepository {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    @Qualifier("JdbcBuilder")
    public void setJdbcTemplate(DataSource ds){
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    public List<UserSQLI> getSQLIUsers(String username, String password){
        return jdbcTemplate.query("SELECT * FROM sqli.users WHERE username = '"+username+"' AND password = '"+password+"';",
                (rs, rowNum) -> new UserSQLI(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("data")
                )
        );
    }

    public UserBAC getBACUser(String username, String password){
//        return jdbcTemplate.query("SELECT * FROM sqli.users WHERE username = '"+username+"' AND password = '"+password+"';",
        UserBAC userBAC;
        try {
             userBAC = jdbcTemplate.queryForObject("SELECT * FROM bac.users WHERE username = ? AND password = ?;",
                    (rs, rowNum) -> new UserBAC(
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getBoolean("is_admin")
                    ),
                    username,
                    password
            );
        }catch (EmptyResultDataAccessException e){
            return null;
        }

        return userBAC;
    }
}
