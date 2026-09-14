package com.spring_mvc.jdbc2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring_mvc.jdbc2.dto.ProductDTO;

@Repository
public class ProductDAO {
	

	private DataSource dataFactory;
	
	@Autowired
	public ProductDAO(DataSource dataSource) {
		try {
			this.dataFactory = dataSource;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<ProductDTO> productSelect(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<ProductDTO> prdList = new ArrayList<>();
		
		try {
			System.out.println("check"); // 커넥션이 일어나면 관례적으로 콘솔에 찍어봄
			con = dataFactory.getConnection(); // db con 객체 connection pool로부터 할당
			
			String sql = "select * from PRODUCT";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(); 
			
			while(rs.next()) {
				String prdNo = rs.getString("prdNo"); // 일반 변수 / 데이터 컬럼명
				String prdName = rs.getString("prdName");
				String prdPrice = rs.getString("prdPrice");
				String prdStock = rs.getString("prdStock");
				Date prdJoindate = rs.getDate("prdJoindate");
				
				ProductDTO dto = new ProductDTO();
				dto.setPrdNo(prdNo);
				dto.setPrdName(prdName);
				dto.setPrdPrice(prdPrice);
				dto.setPrdStock(prdStock);
				dto.setPrdJoinDate(prdJoindate);
				
				// ArrayList 에 추가
				prdList.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				System.out.println("con : " +con);
				rs.close();
				pstmt.close();
				con.close(); // 커넥션 풀로 객체 반환
			}catch(Exception e) {
				
			}
		}
		
		return prdList;
	}
}
