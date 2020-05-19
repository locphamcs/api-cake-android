package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Repository;
import com.model.Cake;
import com.model.CakeMapper;

@Repository
public class CakeDao {
	private static final List<Cake> cakeMap = new ArrayList<Cake>();
	static {
        try {
			initEmps();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	 
	 private static void initEmps() throws Exception {
		 CakeMapper cakeMapper = new CakeMapper();
		 cakeMapper.connect();
		 ArrayList<Cake> list = cakeMapper.list;
		 for(Cake a:list)
		 {
			 cakeMap.add(a);
		 }
	 }
	 
	 	public Cake getCake(int ID) {
	        return cakeMap.get(ID-1);
	    }
	 	
	 	public List<Cake> getListMaBanh(int MaBanh) {
	 		List<Cake> ListMaBanh = new ArrayList<Cake>();
	 		for(int i=0;i<cakeMap.size();i++) {
	 			if(MaBanh==cakeMap.get(i).getMa_banh()) {
	 				Cake cake=cakeMap.get(i);
	 				ListMaBanh.add(cake);
	 			}		
	 		}
	 		System.out.println("size:"+cakeMap.size());
			return ListMaBanh;
	 	}
	 	
//	 	public Giamkhao getGiamkhao1(int ID,int Age) {
//	 		return giamMap.get(ID-1);
//	 	}
	 
	    public Cake addCake(Cake cake) {
	    	try {
	    	CakeMapper giamMapper = new CakeMapper();
	    	Connection conn= giamMapper.get();
	    	Calendar calendar = Calendar.getInstance();
	        java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
	        String query = " insert into cakes(stt,ma_banh,tenBanh,loaiBanh,thoiGian,khauPhan,doKho,nguyenLieu,cachLam,linkAnh)"
	                + " values (?,?,?,?,?,?,?,?,?,?)";
	        PreparedStatement preparedStmt = conn.prepareStatement(query);
	        preparedStmt.setInt(1,cake.getStt());
	        preparedStmt.setInt(2,cake.getMa_banh());
	        preparedStmt.setString(3,cake.getTen_banh());
	        preparedStmt.setString(4,cake.getLoai_banh());
	        preparedStmt.setString(5,cake.getThoi_gian());
	        preparedStmt.setString(6,cake.getKhau_phan());
	        preparedStmt.setString(7,cake.getDo_kho());
	        preparedStmt.setString(8,cake.getNguyen_lieu());
	        preparedStmt.setString(9,cake.getCach_lam());
	        preparedStmt.setString(10,cake.getLink_anh());
	        preparedStmt.execute();
	        conn.close();
	    	}catch(Exception e){
	    		System.out.println("Add false");
	    	}
	        cakeMap.add(cake);
	        return cake;
	    }
	 
	    public Cake updateCake(Cake cake) {
	    	try {
		    	CakeMapper giamMapper = new CakeMapper();
		    	Connection conn= giamMapper.get();
		    	Calendar calendar = Calendar.getInstance();
		        java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
		        String query = "update giamkhao set ma_banh = ?,tenBanh= ?,loaiBanh=?,thoiGian=?,khauPhan = ?,doKho= ?,nguyenLieu=?,cachLam=?,linkAnh=? where stt=?";
		        PreparedStatement preparedStmt = conn.prepareStatement(query);
		        preparedStmt.setInt(1, cake.getMa_banh());
		        preparedStmt.setString(2,cake.getTen_banh());
		        preparedStmt.setString(3,cake.getLoai_banh());
		        preparedStmt.setString(4,cake.getThoi_gian());
		        preparedStmt.setString(5,cake.getKhau_phan());
		        preparedStmt.setString(6,cake.getDo_kho());
		        preparedStmt.setString(7,cake.getNguyen_lieu());
		        preparedStmt.setString(8,cake.getCach_lam());
		        preparedStmt.setString(9,cake.getLink_anh());
		        preparedStmt.setInt(10,cake.getStt());
		        preparedStmt.executeUpdate();
		        conn.close();
		    	}catch(Exception e){
		    		System.out.println("Update false");
		    	}
	        cakeMap.set(cake.getStt()-1, cake);
	        return cake;
	    }
	 
	    public void deleteCake(int STT) {
	    	try {
	    	CakeMapper cakeMapper = new CakeMapper();
	    	Connection conn= cakeMapper.get();
	    	PreparedStatement st = conn.prepareStatement("DELETE FROM cakes WHERE stt=" +STT+ ";");
	    	st.executeUpdate();
	    	}catch(Exception e) {
	    		System.out.println("Delete That Bai");
	    	}
	    	int	dem = 0;
	 		for(int i=0;i<cakeMap.size();i++) {
	 			if(cakeMap.get(i).getStt()==STT) {
	 				dem=i;
	 			}		
	 		}
	 		cakeMap.remove(dem);
	    }
	 
	    public List<Cake> getAllCakes() {
	        List<Cake> list= new ArrayList<Cake>();
	        list=cakeMap;
	        return list;
	    }
}