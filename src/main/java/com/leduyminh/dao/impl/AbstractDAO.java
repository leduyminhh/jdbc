package com.leduyminh.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.leduyminh.dao.GenericDAO;
import com.leduyminh.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {
	public Connection getConnection() {
		try {
			ResourceBundle mybundle = ResourceBundle.getBundle("database");
			Class.forName(mybundle.getString("DriveName"));
			String url = mybundle.getString("url");
			String user = mybundle.getString("user");
			String password = mybundle.getString("password");
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> lst = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			setParameter(ps, parameters);
			rs = ps.executeQuery();
			while (rs.next()) {
				lst.add(rowMapper.mapRow(rs));
			}
			return lst;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				conn.close();
				rs.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void setParameter(PreparedStatement ps, Object... parameters) {
		try {
			int idx = 0;
			for(Object parameter : parameters)
			{
				idx++;
				if (parameter instanceof Integer) {
					ps.setInt(idx, (Integer) parameter);
				} else if (parameter instanceof String) {
					ps.setString(idx, (String) parameter);
				} else if (parameter instanceof Timestamp) {
					ps.setTimestamp(idx, (Timestamp) parameter);
				}
			}
//			for (int i = 0; i < parameters.length; i++) {
//				Object parameter = parameters[i];
//				int idx = i + 1;
//				if (parameter instanceof Integer) {
//					ps.setInt(idx, (Integer) parameter);
//				} else if (parameter instanceof String) {
//					ps.setString(idx, (String) parameter);
//				} else if (parameter instanceof Timestamp) {
//					ps.setTimestamp(idx, (Timestamp) parameter);
//				}
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			setParameter(ps, parameters);
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	@SuppressWarnings("static-access")
	@Override
	public Integer insert(String sql, Object... parameters) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Integer id = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql, ps.RETURN_GENERATED_KEYS);
			setParameter(ps, parameters);
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			conn.commit();
			return id;
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public int count(String sql, Object... parameters) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			int count = 0;
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			setParameter(ps, parameters);
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			return 0;
		} finally {
			try {
				conn.close();
				rs.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				return 0;
			}
		}
	}
}
