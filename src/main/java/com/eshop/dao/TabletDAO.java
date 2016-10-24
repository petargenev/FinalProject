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
import com.eshop.exceptions.ArticleException;
import com.eshop.exceptions.InvalidInputException;
import com.eshop.interfaces.DAO;
import com.eshop.models.Article;
import com.eshop.models.Tablet;

public class TabletDAO implements DAO {
	private static final String SHOW_ALL_QUERY = "SELECT t.*, l.*, c.*,r.* FROM tablet t " + "JOIN label l ON (t.label_id = l.id) "
			+ "JOIN cpu c ON (t.cpu_id = c.id) " + "JOIN resolution r ON (t.resolution_id = r.id);";
	
	Connection connection = DBConnection.getInstance().getConnection();

	public Tablet getArticleById(int tabletId) throws SQLException, InvalidInputException {
		String query = "SELECT t.*, l.*, c.*,r.* FROM tablet t " + "JOIN label l ON (t.label_id = l.id) "
				+ "JOIN cpu c ON (t.cpu_id = c.id) " + "JOIN resolution r ON (t.resolution_id = r.id) "
				+ "WHERE t.id LIKE '" + tabletId + "';";
		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		Tablet tablet = null;
		while (rs.next()) {
			String label = rs.getString("label");
			String model = rs.getString("model");
			double price = rs.getDouble("price");
			String image = rs.getString("image");
			double displaySize = rs.getDouble("display_size");
			String cpu = rs.getString("cpu");
			String displayType = rs.getString("display_type");
			String resolution = rs.getString("resolution");
			int id = rs.getInt("id");

			tablet = new Tablet(label, model, price, cpu, displaySize, displayType, resolution, image, id);
		}
		return tablet;
	}

	public Collection<Article> getArticleByLabel(String tabletLabel) throws SQLException, InvalidInputException {
		List<Article> tablets = new ArrayList<Article>();
		String query = "SELECT t.*, l.*, c.*,r.* FROM tablet t " + 
						"JOIN label l ON (t.label_id = l.id) "
						+ "JOIN cpu c ON (t.cpu_id = c.id) " + "JOIN resolution r ON (t.resolution_id = r.id) "
						+ "WHERE l.label LIKE '" + tabletLabel + "';";

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
			int id = rs.getInt("id");

			tablets.add(new Tablet(label, model, price, cpu, displaySize, displayType, resolution, image, id));
		}
		return Collections.unmodifiableList(tablets);
	}

	public Collection<Article> showAll() throws SQLException, InvalidInputException, InvalidInputException {
		List<Article> tablets = new ArrayList<Article>();
		String query = SHOW_ALL_QUERY;

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
			int id = rs.getInt("id");

			tablets.add(new Tablet(label, model, price, cpu, displaySize, displayType, resolution, image, id));
		}
		return Collections.unmodifiableList(tablets);
	}

	public void deleteArticleById(int id) throws SQLException {
		String deleteQuery = "DELETE FROM tablet WHERE id LIKE '" + id + "';";
		PreparedStatement deletePs = connection.prepareStatement(deleteQuery);
		deletePs.executeUpdate();

	}

	public void insertArticle(Article tablet) {
		try {
			if (tablet instanceof Tablet) {
				// inserting lable
				connection.setAutoCommit(false);
				int labelId = getOrInsertLable(tablet);
				// inserting cpu

				int cpuId = getOrInsertCpu(tablet);
				// inserting resolution
				int resolutionId = getOrInsertResolution(tablet);

				// inserting tablet

				PreparedStatement ps1 = connection
						.prepareStatement("INSERT INTO tablet VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?)");
				ps1.setDouble(1, ((Tablet) tablet).getDisplaySize());
				ps1.setString(2, ((Tablet) tablet).getDisplayType());
				ps1.setDouble(3, tablet.getPrice());
				ps1.setString(4, tablet.getImage());
				ps1.setString(5, tablet.getModel());
				ps1.setInt(6, labelId);
				ps1.setInt(7, cpuId);
				ps1.setInt(8, resolutionId);

				ps1.executeUpdate();
				connection.commit();
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private int getOrInsertResolution(Article tablet) throws SQLException {
		String resolutionQuery = "SELECT * FROM resolution WHERE resolution LIKE '" + ((Tablet) tablet).getResolution()
				+ "';";
		PreparedStatement resolutionPs = connection.prepareStatement(resolutionQuery);
		ResultSet resolutionRs = resolutionPs.executeQuery();
		int resolutionId = 0;

		if (resolutionRs.next()) {
			resolutionId = resolutionRs.getInt("id");
		} else {
			resolutionId = new KeysDAO().insertResolution(((Tablet) tablet).getResolution());
		}
		return resolutionId;
	}

	private int getOrInsertCpu(Article tablet) throws SQLException {
		String cpuQuery = "SELECT * FROM cpu WHERE cpu LIKE '" + ((Tablet) tablet).getCpu() + "';";
		PreparedStatement cpuPs = connection.prepareStatement(cpuQuery);
		ResultSet cpuRs = cpuPs.executeQuery();
		int cpuId = 0;

		if (cpuRs.next()) {
			cpuId = cpuRs.getInt("id");
		} else {
			cpuId = new KeysDAO().insertCpu(((Tablet) tablet).getCpu());
		}
		return cpuId;
	}

	private int getOrInsertLable(Article tablet) throws SQLException {
		String query = "SELECT * FROM label WHERE label LIKE '" + tablet.getLabel() + "';";
		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		int labelId = 0;

		if (rs.next()) {
			labelId = rs.getInt("id");
		} else {
			labelId = new KeysDAO().insertLabel(tablet.getLabel());
		}
		return labelId;
	}

}