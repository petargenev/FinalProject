package com.eshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.eshop.connection.DBConnection;
import com.eshop.exceptions.InvalidInputException;
import com.eshop.interfaces.DAO;
import com.eshop.models.Article;
import com.eshop.models.Tablet;

public class TabletDAO implements DAO{
Connection connection = DBConnection.getInstance().getConnection();
	
	public Collection<Article> showAll()
			throws SQLException, InvalidInputException, InvalidInputException {
		List<Article> tablets = new ArrayList<Article>();
		String query = "SELECT t.*, l.*, c.*,r.* FROM tablet t"+
						"JOIN label l ON (t.label_id = l.id)"+
						"JOIN cpu c ON (t.cpu_id = c.id)"+
						"JOIN resolution r ON (t.resolution_id = r.id);";

		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			String label = rs.getString("label");
			String model = rs.getString("model");
			double price = rs.getDouble("price");
			String image = rs.getString("image");
			double displaySize = rs.getDouble("display_size");
			String cpu = rs.getString("cpu");
			String displayType = rs.getString("display_type");
			String resolution = rs.getString("resolution");
			
			
			
			tablets.add(new Tablet(label, model, price, cpu, displaySize, displayType, resolution, image));
		}
		return Collections.unmodifiableList(tablets);
	}
	
	public void insertTable(Tablet tablet){
		try {
			//inserting lable
			System.out.println("vuvejdam label");
			String query = "SELECT * FROM label WHERE label LIKE '" + tablet.getLabel() + "';";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			int labelId = 0;

			if (rs.next()) {
				labelId = rs.getInt("id");
			} else {
				labelId = new KeysDAO().insertLabel(tablet.getLabel());
			}
			//inserting cpu
			System.out.println("vuvejdam cpu");
			String cpuQuery = "SELECT * FROM cpu WHERE cpu LIKE '" + tablet.getCpu() + "';";
			PreparedStatement cpuPs = connection.prepareStatement(cpuQuery);
			ResultSet cpuRs = cpuPs.executeQuery();
			int cpuId = 0;

			if (cpuRs.next()) {
				cpuId = cpuRs.getInt("id");
			} else {
				cpuId = new KeysDAO().insertCpu(tablet.getCpu());
			}
			//inserting resolution 
			String resolutionQuery = "SELECT * FROM resolution WHERE resolution LIKE '" + tablet.getResolution() + "';";
			PreparedStatement resolutionPs = connection.prepareStatement(resolutionQuery);
			ResultSet resolutionRs = resolutionPs.executeQuery();
			int resolutionId = 0;
			
			if(resolutionRs.next()){
				resolutionId = resolutionRs.getInt("id");
			}else{
				resolutionId = new KeysDAO().insertResolution(tablet.getResolution());
			}
			
			//inserting tablet
			System.out.println("vuvejdam TABLET");
			System.out.println(cpuId);
			System.out.println(resolutionId);
			PreparedStatement ps1 = connection.prepareStatement("INSERT INTO tablet VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps1.setDouble(1, tablet.getDisplaySize());
			ps1.setString(2, tablet.getDisplayType());
			ps1.setDouble(3, tablet.getPrice());
			ps1.setString(4, tablet.getImage());
			ps1.setString(5, tablet.getModel());
			ps1.setInt(6, labelId);
			ps1.setInt(7, cpuId);
			ps1.setInt(8, resolutionId);
			
			ps1.executeUpdate();
			System.out.println("VUVEDOH TABLET");

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
