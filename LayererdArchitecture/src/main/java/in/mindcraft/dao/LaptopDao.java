package in.mindcraft.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import in.mindcraft.pojos.Laptop;
import in.mindcraft.utils.DBUtils;

public class LaptopDao {
	
	private Connection cn;
	private PreparedStatement pst1;
	
	public boolean addLaptop(Laptop laptop) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		cn = DBUtils.openConnection();
		pst1 = cn.prepareStatement("insert into laptop values(?,?,?)");
		pst1.setInt(1, laptop.getLid());
		pst1.setString(2, laptop.getMake());
		pst1.setDouble(3, laptop.getCost());
		if(pst1.executeUpdate()>0) {
			DBUtils.closeConnection();
			return true;
		}else {
			return false;
		}
	}
	
	
	 public List<Laptop> getAllLaptops() throws SQLException{
		List<Laptop> laptops = new ArrayList<>();
		cn = DBUtils.openConnection();
		pst1 = cn.prepareStatement("select * from laptop");
		ResultSet rs = pst1.executeQuery();
		
		while(rs.next()) {
			int lid = rs.getInt("lid");
		    String make = rs.getString("make");
		    double cost = rs.getDouble("cost");
		    
		    if (lid > 0 && !make.isEmpty() && cost > 0.0) { // Adjust conditions based on your data
		        Laptop laptop = new Laptop(lid, make, cost);
		        laptops.add(laptop);
		    }	
		}
		
		rs.close();
		DBUtils.closeConnection();
		return laptops;
			
	}

}
