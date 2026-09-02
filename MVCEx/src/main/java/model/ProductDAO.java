package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import util.Util;

public class ProductDAO {

	public ArrayList<ProductDTO>prdSelect(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<ProductDTO> memList = new ArrayList<>();
		
		try {
			con = Util.getConn();
			String query = "select * from product";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String prdNo = rs.getString("prdNo");
				String prdName = rs.getString("prdName");
				int prdPrice = rs.getInt("prdPrice");
				int prdStock = rs.getInt("prdStock");
				Date prdJoinDate = rs.getDate("prdJoinDate");
				
				ProductDTO vo = new ProductDTO();
				vo.setPrdNo(prdNo);
				vo.setPrdName(prdName);
				vo.setPrdPrice(prdPrice);
				vo.setPrdStock(prdStock);
				vo.setPrdJoinDate(prdJoinDate);
				
				memList.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return memList;
	}
}
