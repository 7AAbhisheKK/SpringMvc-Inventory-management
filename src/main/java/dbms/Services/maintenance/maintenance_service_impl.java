package dbms.Services.maintenance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import dbms.Entity.maintenance;

@Component("maintenance")
public class maintenance_service_impl implements maintenance_service {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	public int insert(final maintenance m) {
		final String query="insert into maintenance(description,date,amount) values(?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(
		    new PreparedStatementCreator() {
		        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
		            PreparedStatement ps =
		                connection.prepareStatement(query, new String[] {"id"});
		            ps.setString(1, m.getDescription());
		            ps.setString(2, m.getDate());
		            ps.setInt(3, m.getAmount());
		            return ps;
		        }
		    },
		    keyHolder);
		System.out.println( keyHolder.getKey());
		return (int) keyHolder.getKey().intValue();
	}

}
