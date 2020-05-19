package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CakeMapper {
	public static ArrayList<Cake> list = new ArrayList<Cake>();
	public static Connection get() {
		final String url="jdbc:mysql://localhost:3306/locpham";
		final String user= "root";
		final String password= "maboy918";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("That bai 1"+e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("That bai 2"+e);
		}
		return null;
	}
	public static void connect() throws Exception
	{
		Connection connection= get();
		if(connection != null) {
			System.out.println("Successful server connection!");
		}
		else {
			System.out.println("That Bai!");
		}
			java.sql.Statement statement = connection.createStatement();
		if(statement != null) {
			System.out.println("Successful server connection!");
		}
		else {
			System.out.println("That Bai!");
		}
		String sql = "select stt,ma_banh,tenBanh,loaiBanh,thoiGian,khauPhan,doKho,nguyenLieu,cachLam,linkAnh from cakes_edit";
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			 	Cake cake= new Cake();
			 	cake.setStt(rs.getInt(1));
			 	cake.setMa_banh(rs.getInt(2));
			 	cake.setTen_banh(rs.getString(3));
			 	cake.setLoai_banh(rs.getString(4));
			 	cake.setThoi_gian(rs.getString(5));
			 	cake.setKhau_phan(rs.getString(6));
			 	cake.setDo_kho(rs.getString(7));
			 	cake.setNguyen_lieu(rs.getString(8));
			 	cake.setCach_lam(rs.getString(9));
			 	cake.setLink_anh(rs.getString(10));
//				System.out.println(cake.getStt());
//				System.out.println(cake.getMa_banh());
//				System.out.println(cake.getTen_banh());
//				System.out.println(cake.getLoai_banh());
//				System.out.println(cake.getThoi_gian());
//				System.out.println(cake.getKhau_phan());
//				System.out.println(cake.getDo_kho());
//				System.out.println(cake.getNguyen_lieu());
//				System.out.println(cake.getCach_lam());
//				System.out.println(cake.getLink_anh());
				list.add(cake);
		 }
	}

}
