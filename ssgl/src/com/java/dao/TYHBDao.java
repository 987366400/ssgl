package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.model.PageBean;
import com.java.model.TYHB;
import com.java.util.StringUtil;

public class TYHBDao {
	/**
	 * 用户表添加
	 * 
	 * @param con
	 * @param charge
	 * @return
	 * @throws Exception
	 */
	public int yhbAdd(Connection con, TYHB yhb) throws Exception {
		String sql = "insert into t_yhb values(null,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, yhb.getDlm());
		pstmt.setString(2, yhb.getDlmm());
		pstmt.setString(3, yhb.getYhsf());
		pstmt.setString(4, yhb.getLxfs());
		pstmt.setString(5, yhb.getYhzt());
		pstmt.setString(6, yhb.getYx());
		return pstmt.executeUpdate();
	}

	public List<TYHB> yhbList(Connection con, PageBean pageBean,
			TYHB s_yhb) throws SQLException {
		List<TYHB> yhbList = new ArrayList<TYHB>();
		StringBuffer sb = new StringBuffer("select * from t_yhb ");
		if (s_yhb != null) {
			if (StringUtil.isNotEmpty(s_yhb.getDlm())) {
				sb.append(" and DLM like '%"
						+ s_yhb.getDlm() + "%'");
			}
		}
		if (pageBean != null) {
			sb.append(" limit " + pageBean.getStart() + ","
					+ pageBean.getPageSize());
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString()
				.replaceFirst("and", "where"));
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			TYHB yhb = new TYHB();
			yhb.setId(rs.getInt("ID"));
			yhb.setDlm(rs.getString("DLM"));
			yhb.setDlmm(rs.getString("DLMM"));
			yhb.setYhsf(rs.getString("YHSF"));
			yhb.setLxfs(rs.getString("LXFS"));
			yhb.setYhzt(rs.getString("YHZT"));
			yhb.setYx(rs.getString("YX"));
			yhbList.add(yhb);
		}
		return yhbList;
	}

	public int yhbCount(Connection con, TYHB s_yhb) throws SQLException {
		StringBuffer sb = new StringBuffer(
				"select count(*) as total from t_yhb ");
		if (s_yhb != null) {
			if (StringUtil.isNotEmpty(s_yhb.getDlm())) {
				sb.append(" and DLM like '%"
						+ s_yhb.getDlm() + "%'");
			}
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString()
				.replaceFirst("and", "where"));
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			return rs.getInt("total");
		} else {
			return 0;
		}
	}

	public TYHB loadYhbById(Connection con, String id) throws SQLException {
		String sql = "select * from t_yhb where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		int i_id=Integer.valueOf(id);
		pstmt.setInt(1, i_id);
		ResultSet rs = pstmt.executeQuery();

		TYHB yhb=new TYHB();
		while (rs.next()) {
			yhb.setId(rs.getInt("ID"));
			yhb.setDlm(rs.getString("DLM"));
			yhb.setDlmm(rs.getString("DLMM"));
			yhb.setYhsf(rs.getString("YHSF"));
			yhb.setLxfs(rs.getString("LXFS"));
			yhb.setYhzt(rs.getString("YHZT"));
			yhb.setYx(rs.getString("YX"));
		}
		return yhb;
	}

	public int chargeUpdate(Connection con, TYHB s_yhb)
			throws SQLException {
		String sql = "update t_yhb set DLM=?,DLMM=?,YHSF=? ,LXFS=?,YHZT=?,YX=? where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, s_yhb.getDlm());
		pstmt.setString(2, s_yhb.getDlmm());
		pstmt.setString(3, s_yhb.getYhsf());
		pstmt.setString(4, s_yhb.getLxfs());
		pstmt.setString(5, s_yhb.getYhzt());
		pstmt.setString(6, s_yhb.getYx());
		pstmt.setInt(7, s_yhb.getId());
		return pstmt.executeUpdate();
	}

	public int chargeDelete(Connection con, String id) throws Exception {
		String sql = "delete from t_yhb where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		int i_id=Integer.valueOf(id);
		pstmt.setInt(1, i_id);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 管理员登录
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public TYHB login(Connection con,TYHB yhb)throws Exception{
		TYHB resultYhb=null;
		String sql="select * from t_yhb where DLM=? and DLMM=? and YHSF=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, yhb.getDlm());
		pstmt.setString(2, yhb.getDlmm());
		pstmt.setString(3, yhb.getYhsf());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			resultYhb=new TYHB();
			resultYhb.setId(rs.getInt("ID"));
			resultYhb.setDlm(rs.getString("DLM"));
			resultYhb.setDlmm(rs.getString("DLMM"));
			resultYhb.setYhsf(rs.getString("YHSF"));
			resultYhb.setLxfs(rs.getString("LXFS"));
			resultYhb.setYhzt(rs.getString("YHZT"));
			resultYhb.setYx(rs.getString("YX"));
		}
		return resultYhb;
	}
}
