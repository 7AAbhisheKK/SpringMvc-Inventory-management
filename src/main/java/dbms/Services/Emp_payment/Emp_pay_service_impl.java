package dbms.Services.Emp_payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

@Component
public class Emp_pay_service_impl implements Emp_pay_service {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	public int insert(final String username, final String date, final int amount, final String description) {
		
		
			final String query="insert into employee_payment(amount,description,date,username) values(?,?,?,?)";
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(
			    new PreparedStatementCreator() {
			        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
			            PreparedStatement ps =
			                connection.prepareStatement(query, new String[] {"payment_id"});
			            ps.setInt(1, amount);
			            ps.setString(2, description);
			            ps.setString(3, date);
			            ps.setString(4, username);
			            return ps;
			        }
			    },
			    keyHolder);
			System.out.println( keyHolder.getKey());
			return (int) keyHolder.getKey().intValue();

	}
}
