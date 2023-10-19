package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.AdminModel;
import Model.standard;
import Model.student;
import connection.DBConnection;

public class AdminDao {
	
	public static boolean checkEmail(String email) {
		boolean flag = false;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from admin where email=?";
			PreparedStatement pst =  conn.prepareStatement(sql);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				flag = true;
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
		
	}
	
	public static AdminModel adminSignIn(AdminModel a)
	{
		AdminModel a1 = null;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from admin where email=? and password=?";
			PreparedStatement pst =  conn.prepareStatement(sql);
			pst.setString(1, a.getEmail());
			pst.setString(2, a.getPassword());
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				a1 = new AdminModel();
				a1.setEmail(rs.getString("email"));
				a1.setPassword(rs.getString("password"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return a1;
		
	}
	
	public static void addstandard(standard s)
	{
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "insert into standard (name,status) values(?,?)";
			PreparedStatement pst =  conn.prepareStatement(sql);
			pst.setString(1, s.getName());
			pst.setString(2, s.getStatus());
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static List<standard> getStandardList(){
		List<standard> standardlist =  new ArrayList<standard>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from standard";
			PreparedStatement pst =  conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				standard s = new standard();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setStatus(rs.getString("status"));
				standardlist.add(s);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return standardlist;
		
	}
	
	public static void regStudent(student s) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "insert into stud (fname,lname,standard,dob,img,cd,status) values(?,?,?,?,?,?,?)";
			PreparedStatement pst =  conn.prepareStatement(sql);
			
			pst.setString(1, s.getFname());
			pst.setString(2, s.getLname());
			pst.setString(3, s.getStandard());
			pst.setString(4, s.getDob());
			pst.setString(5, s.getImg());
			
			pst.setString(6, s.getCd()); 
			pst.setString(7, s.getStatus());
			pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static String getStandardById(int id) {
		String sname = "";
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select name from standard where id=?";
			PreparedStatement pst =  conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				sname = rs.getString("name");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return sname;
	}
	
	public static List<student> getStudentList(){
		List<student> studentlist = new ArrayList<student>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from stud";
			PreparedStatement pst =  conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				student s1 = new student();
				s1.setS_id(rs.getInt("s_id"));
				s1.setFname(rs.getString("fname"));
				s1.setLname(rs.getString("lname"));
				s1.setStandard(rs.getString("standard"));
				s1.setDob(rs.getString("dob"));
				s1.setImg(rs.getString("img"));
				s1.setCd(rs.getString("cd"));
				s1.setStatus(rs.getString("status"));
				studentlist.add(s1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return studentlist;
	}
	
	public static String getStandardStatusById(int id) {
		String status = "";
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select status from standard where id=?";
			PreparedStatement pst =  conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				status = rs.getString("status");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
	}

}
