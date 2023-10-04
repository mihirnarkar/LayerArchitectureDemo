package in.mindcraft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.mindcraft.pojos.User;
import in.mindcraft.utils.DBUtils;

public class UserDao {
	
	private Connection cn;
	private PreparedStatement ps;
	
	
	public boolean addUser(User user) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		cn = DBUtils.openConnection();
		ps = cn.prepareStatement("insert into users values(?,?,?)");
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getPassword());
		if(ps.executeUpdate()>0) {
			System.out.println("data inserted");
			return true;
		}else {
			return false;
		}
	}

}
