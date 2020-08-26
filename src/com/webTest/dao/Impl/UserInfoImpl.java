package com.webTest.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webTest.dao.UserInfoDAO;
import com.webTest.servlet.InitServlet;
import com.webTest.vo.UserInfoVO;

public class UserInfoImpl implements UserInfoDAO {

	public int insertUser(UserInfoVO user) {
		String sql = "insert into user_info_test(uit_num,uit_name,uit_age,uit_id,uit_prd,uit_admin) ";
				sql+= "VALUES(seq_uit_num.nextval,?,?,?,?,?)";
			Connection con =null;
			PreparedStatement ps = null;
			
			try {
				con = InitServlet.getConnection();
				ps=con.prepareStatement(sql);
				ps.setString(1, user.getUit_id());
				ps.setString(2, user.getUit_name());
				ps.setString(3, user.getUit_prd());
				ps.setInt(4, user.getUit_age());
				ps.setInt(5, user.getUit_admin());
				int cnt = ps.executeUpdate();
				con.commit();
				return cnt;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				InitServlet.close(ps, con);
			}
		return 0;
	}

	public int deleteUser(UserInfoVO user) {
		String sql = "delete from user_info_test where uit_num=?";
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = InitServlet.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, user.getUit_num());
			int cnt = ps.executeUpdate();
			con.commit();
			return cnt;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			InitServlet.close(ps,con);
		}
		
		return 0;
	}

	public int updateUser(UserInfoVO user) {
		String sql = 
				"update user_info_test SET\r\n" + 
				"UIT_NAME=?,\r\n" + 
				"UIT_ID=?,\r\n" + 
				"UIT_PRD=?,\r\n" + 
				"UIT_AGE=?,\r\n" + 
				"UIT_ADMIN=?,\r\n" + 
				"where UIT_NUM=?"; 
				
		return 0;
	}

	public UserInfoVO selectUser(UserInfoVO user) {
		String sql = "select *from user_info_test where UIT_NUM = ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = InitServlet.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, user.getUit_num());
			rs=ps.executeQuery();
			if (rs.next()) {
				UserInfoVO ui =new UserInfoVO();
				ui.setUit_num(rs.getInt("uit_num"));
				ui.setUit_name(rs.getString("uit_name"));
				ui.setUit_id(rs.getString("uit_id"));
				ui.setUit_prd(rs.getString("uit_prd"));
				ui.setUit_age(rs.getInt("uit_age"));
				ui.setUit_admin(rs.getInt("uit_admin"));
				return ui;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			InitServlet.close(rs, ps,con);
		}
		return null;
	}

	public UserInfoVO selectUserById(String uiId) {
		String sql = "select * from user_info_test where uit_id=?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			con = InitServlet.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				UserInfoVO ui =new UserInfoVO();
				ui.setUit_num(rs.getInt("uit_num"));
				ui.setUit_name(rs.getString("uit_name"));
				ui.setUit_id(rs.getString("uit_id"));
				ui.setUit_prd(rs.getString("uit_prd"));
				ui.setUit_age(rs.getInt("uit_age"));
				ui.setUit_admin(rs.getInt("uit_admin"));
				return ui;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			InitServlet.close(rs,ps, con);
		}
		return null;
	}

	public UserInfoVO selectUserForLogin(UserInfoVO user) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserInfoVO> selectUserList(UserInfoVO user) {
		List<UserInfoVO> userList = new ArrayList<>();
		String sql = "select * from user_info_test";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			con=InitServlet.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
					while(rs.next()) {
						UserInfoVO ui =new UserInfoVO();
						ui.setUit_num(rs.getInt("uit_num"));
						ui.setUit_name(rs.getString("uit_name"));
						ui.setUit_id(rs.getString("uit_id"));
						ui.setUit_prd(rs.getString("uit_prd"));
						ui.setUit_age(rs.getInt("uit_age"));
						ui.setUit_admin(rs.getInt("uit_admin"));
						userList.add(ui);
						
					}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			InitServlet.close(rs,ps,con);
		}
		return userList;
	}

}
