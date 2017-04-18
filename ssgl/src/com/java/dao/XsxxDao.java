package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.java.model.PageBean;
import com.java.model.TXSXX;
import com.java.util.StringUtil;

/**
 * 学生Dao类
 * @author Administrator
 *
 */
public class XsxxDao {

	/**
	 * 学生登录
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
//	public User login(Connection con,User user)throws Exception{
//		User resultUser=null;
//		String sql="select * from t_student where userName=? and password=?";
//		PreparedStatement pstmt=con.prepareStatement(sql);
//		pstmt.setString(1, user.getUserName());
//		pstmt.setString(2, user.getPassword());
//		ResultSet rs=pstmt.executeQuery();
//		if(rs.next()){
//			resultUser=new User();
//			resultUser.setUserId(rs.getInt("id"));
//			resultUser.setUserName(rs.getString("userName"));
//			resultUser.setPassword(rs.getString("password"));
//			resultUser.setUserType("学生");
//		}
//		return resultUser;
//	}
//	
	/**
	 * 学生信息查询
	 * @param con
	 * @param pageBean
	 * @param s_student
	 * @return
	 * @throws Exception
	 */
	public List<TXSXX> xsxxList(Connection con,PageBean pageBean,TXSXX s_xsxx)throws Exception{
		List<TXSXX> xsxxList=new ArrayList<TXSXX>();
		StringBuffer sb=new StringBuffer("select * from t_xsxx ");
		if(s_xsxx!=null){
			if(StringUtil.isNotEmpty(s_xsxx.getXm())){
				sb.append(" and XM like '%"+s_xsxx.getXm()+"%'");
			}			
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			TXSXX xsxx=new TXSXX();
			xsxx.setXm(rs.getString("XM"));
			xsxx.setXh(rs.getString("XH"));
			xsxx.setXb(rs.getString("XB"));
			xsxx.setMz(rs.getString("MZ"));
			xsxx.setCs(rs.getString("CS"));
			xsxx.setZy(rs.getString("ZY"));
			xsxx.setJtdz(rs.getString("JTDZ"));
			xsxx.setYzbm(rs.getString("YZBM"));
			xsxx.setSfzhm(rs.getString("SFZHM"));
			xsxx.setJzxm(rs.getString("JZXM"));
			xsxx.setSsh(rs.getString("SSH"));
			xsxx.setSjh(rs.getString("SJH"));
			xsxx.setBz(rs.getString("BZ"));
			
			xsxxList.add(xsxx);
		}
		return xsxxList;
	}
	
	/**
	 * 查询记录数
	 * @param con
	 * @param s_student
	 * @return
	 * @throws Exception
	 */
	public int xsxxCount(Connection con,TXSXX s_xsxx)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from t_xsxx ");
		if(s_xsxx!=null){
			if(StringUtil.isNotEmpty(s_xsxx.getXm())){
				sb.append(" and XM like '%"+s_xsxx.getXm()+"%'");
			}			
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}
	
	/**
	 * 学生添加
	 * @param con
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public int xsxxAdd(Connection con,TXSXX xsxx)throws Exception{
		String sql="insert into t_xsxx values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, xsxx.getXm());
		pstmt.setString(2, xsxx.getXh());
		pstmt.setString(3, xsxx.getXb());
		pstmt.setString(4, xsxx.getMz());
		pstmt.setString(5, xsxx.getCs());
		pstmt.setString(6, xsxx.getZy());
		pstmt.setString(7, xsxx.getJtdz());
		pstmt.setString(8, xsxx.getYzbm());
		pstmt.setString(9, xsxx.getSfzhm());
		pstmt.setString(10, xsxx.getJzxm());
		pstmt.setString(11, xsxx.getSsh());
		pstmt.setString(12, xsxx.getSjh());
		pstmt.setString(13, xsxx.getBz());
		
		
		return pstmt.executeUpdate();
	}
	
	/**
	 * 学生更新
	 * @param con
	 * @param student
	 * @return
	 * @throws Exception
	 */

	public int xsxxUpdate(Connection con,TXSXX xsxx)throws Exception{
		String sql="update t_xsxx set XM=?,XB=?,MZ=?,CS=?,ZY=?,JTDZ=?,YZBM=?,SFZHM=?,JZXM=?,SSH=?,SJH=?,BZ=? where XH=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, xsxx.getXm());
		pstmt.setString(2, xsxx.getXb());
		pstmt.setString(3, xsxx.getMz());
		pstmt.setString(4, xsxx.getCs());
		pstmt.setString(5, xsxx.getZy());
		pstmt.setString(6, xsxx.getJtdz());
		pstmt.setString(7, xsxx.getYzbm());
		pstmt.setString(8, xsxx.getSfzhm());
		pstmt.setString(9, xsxx.getJzxm());
		pstmt.setString(10, xsxx.getSsh());
		pstmt.setString(11, xsxx.getSjh());
		pstmt.setString(12, xsxx.getBz());
		pstmt.setString(13, xsxx.getXh());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 学生删除
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int xsxxDelete(Connection con,String xh)throws Exception{
		String sql="delete from t_xsxx where XH=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, xh);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 根据学号查询学生
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public TXSXX loadXsxxByXh(Connection con, String xh) throws Exception {
		String sql = "select * from t_xsxx where XH=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, xh);
		ResultSet rs = pstmt.executeQuery();
		TXSXX xsxx = new TXSXX();
		while (rs.next()) {
			xsxx.setXm(rs.getString("XM"));
			xsxx.setXh(rs.getString("XH"));
			xsxx.setXb(rs.getString("XB"));
			xsxx.setMz(rs.getString("MZ"));
			xsxx.setCs(rs.getString("CS"));
			xsxx.setZy(rs.getString("ZY"));
			xsxx.setJtdz(rs.getString("JTDZ"));
			xsxx.setYzbm(rs.getString("YZBM"));
			xsxx.setSfzhm(rs.getString("SFZHM"));
			xsxx.setJzxm(rs.getString("JZXM"));
			xsxx.setSsh(rs.getString("SSH"));
			xsxx.setSjh(rs.getString("SJH"));
			xsxx.setBz(rs.getString("BZ"));
		}
		return xsxx;
	}
}
