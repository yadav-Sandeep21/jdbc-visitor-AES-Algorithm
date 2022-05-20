package com.ty.visitor.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ty.visitor.dto.Visitor;
import com.ty.visitor.util.AES;
import com.ty.visitor.util.ConnectionObject;
import static com.ty.visitor.util.AppConstants.SECRET_KEY;

public class VisitorCrud {
	
	public int saveVisitor(Visitor visitor)
	{
		String sql = "INSERT INTO visitor VALUES (?,?,?,?,?,?,?,?)";
		Connection connection = ConnectionObject.getConnection();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, visitor.getId());
			
			String encName = AES.encrypt(visitor.getName(), SECRET_KEY);
			preparedStatement.setString(2, encName);
			
			String encEmail = AES.encrypt(visitor.getEmail(), SECRET_KEY);
			preparedStatement.setString(3, encEmail);
			
			String encPhone = AES.encrypt(visitor.getPhone(), SECRET_KEY);
			preparedStatement.setString(4, encPhone);
			
			preparedStatement.setInt(5, visitor.getAge());
			preparedStatement.setString(6, visitor.getGender());
			preparedStatement.setString(7, visitor.getDob());
			preparedStatement.setString(8, visitor.getVisitdatetime());

			System.out.println("Data Inserted...");
			return preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			if (connection != null)
				try {
					connection.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return 0;
	}
	public Visitor getVisitorById(int id) {
		String query = "SELECT * FROM visitor WHERE id = ?";
		Connection connection = ConnectionObject.getConnection();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				Visitor visitor = new Visitor();
				
				visitor.setId(resultSet.getInt(1));
				
				visitor.setAge(resultSet.getInt(5));
				visitor.setGender(resultSet.getString(6));
				visitor.setDob(resultSet.getDate(7).toString());
				visitor.setVisitdatetime(resultSet.getDate(8).toString());
				System.out.println("Printing User..");
				return visitor;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (connection != null)
				try {
					connection.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return null;
	}
	public List<Visitor> getVisitorByDate(String visitdatetime) {
		String query = "SELECT * FROM visitor WHERE visitDatetime = ?";
		Connection connection = ConnectionObject.getConnection();
		List<Visitor> list = new ArrayList<Visitor>();
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setDate(1, Date.valueOf(visitdatetime));

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Visitor visitor = new Visitor();
				visitor.setId(resultSet.getInt(1));
				visitor.setName(AES.decrypt(resultSet.getString(2), SECRET_KEY));
				visitor.setEmail(AES.decrypt(resultSet.getString(3), SECRET_KEY));
				visitor.setPhone(AES.decrypt(resultSet.getString(4), SECRET_KEY));
				visitor.setAge(resultSet.getInt(5));
				visitor.setGender(resultSet.getString(6));
				visitor.setDob(resultSet.getDate(7).toString());
				visitor.setVisitdatetime(resultSet.getDate(8).toString());
				list.add(visitor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return list;
	}
	public List<Visitor> getVisitorByAgeRange(int start, int end) {
		String query = "SELECT * FROM visitor WHERE age BETWEEN ? AND ?";
		Connection connection = ConnectionObject.getConnection();
		List<Visitor> list = new ArrayList<Visitor>();
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, start - 1);
			preparedStatement.setInt(2, end + 1);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Visitor visitor = new Visitor();
				visitor.setId(resultSet.getInt(1));
				visitor.setName(AES.decrypt(resultSet.getString(2), SECRET_KEY));
				visitor.setEmail(AES.decrypt(resultSet.getString(3), SECRET_KEY));
				visitor.setPhone(AES.decrypt(resultSet.getString(4), SECRET_KEY));
				visitor.setAge(resultSet.getInt(5));
				visitor.setGender(resultSet.getString(6));
				visitor.setDob(resultSet.getDate(7).toString());
				visitor.setVisitdatetime(resultSet.getDate(8).toString());
				list.add(visitor);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return list;
	}
}
