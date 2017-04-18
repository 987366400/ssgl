package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.naming.java.javaURLContextFactory;

import com.java.model.Bxxx;
import com.java.model.PageBean;
import com.java.util.DateUtil;
import com.java.util.StringUtil;

/**
 * 报修Dao类
 * @author Administrator
 *
 */
public class BxxxDao {

	/**
	 * 报修信息查询
	 * @param con
	 * @param pageBean
	 * @param s_student
	 * @return
	 * @throws Exception
	 */
	public List<Bxxx> bxxxList(Connection con,PageBean pageBean,Bxxx s_bxxx)throws Exception{
		List<Bxxx> bxxxList=new ArrayList<Bxxx>();
		StringBuffer sb=new StringBuffer("select * from t_bxxx ");
		if(s_bxxx!=null){
			if(StringUtil.isNotEmpty(s_bxxx.getBxr())){
				sb.append(" and BXR like '%"+s_bxxx.getBxr()+"%'");
			}			
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			Bxxx bxxx=new Bxxx();
			bxxx.setId(rs.getInt("ID"));
			bxxx.setBxss(rs.getString("BXSS"));
			bxxx.setBxnr(rs.getString("BXNR"));
			bxxx.setBxdd(rs.getString("BXDD"));
			bxxx.setLxfs(rs.getString("LXFS"));
			bxxx.setBxr(rs.getString("BXR"));
			bxxx.setBxzt(rs.getString("BXZT"));
			bxxx.setBxsj(rs.getDate("BXSJ"));
			bxxxList.add(bxxx);
		}
		return bxxxList;
	}
	
	/**
	 * 查询记录数
	 * @param con
	 * @param s_student
	 * @return
	 * @throws Exception
	 */
	public int bxxxCount(Connection con,Bxxx s_bxxx)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from t_bxxx ");
		if(s_bxxx!=null){
			if(StringUtil.isNotEmpty(s_bxxx.getBxr())){
				sb.append(" and BXR like '%"+s_bxxx.getBxr()+"%'");
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
	 * 报修添加
	 * @param con
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public int bxxxAdd(Connection con,Bxxx bxxx)throws Exception{
		String sql="insert into t_bxxx values(null,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, bxxx.getBxss());
		pstmt.setString(2, bxxx.getBxnr());
		pstmt.setString(3, bxxx.getLxfs());
		pstmt.setString(4, bxxx.getBxdd());
		pstmt.setString(5, bxxx.getBxr());//转成sql.date
		pstmt.setString(6, bxxx.getBxzt());
		pstmt.setDate(7, new java.sql.Date(bxxx.getBxsj().getTime()));
		
		return pstmt.executeUpdate();
	}
	
	/**
	 * 报修信息更新
	 * @param con
	 * @param student
	 * @return
	 * @throws Exception
	 */

	public int bxxxUpdate(Connection con,Bxxx bxxx)throws Exception{
		String sql="update t_bxxx set BXSS=?,BXNR=?,LXFS=?,BXDD=?,BXR=?,BXZT=?,BXSJ=?  where ID=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, bxxx.getBxss());
		pstmt.setString(2, bxxx.getBxnr());
		pstmt.setString(3, bxxx.getLxfs());
		pstmt.setString(4, bxxx.getBxdd());
		pstmt.setString(5, bxxx.getBxr());//转成sql.date
		pstmt.setString(6, bxxx.getBxzt());
		pstmt.setDate(7, new java.sql.Date(bxxx.getBxsj().getTime()));
		pstmt.setInt(8, bxxx.getId());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 报修删除
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int bxxxDelete(Connection con,String id)throws Exception{
		String sql="delete from t_bxxx where ID=?";
		int i_id=Integer.valueOf(id);
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, i_id);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 根据id查询报修信息
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Bxxx loadBxxxById(Connection con, String id) throws Exception {
		String sql = "select * from t_bxxx where ID=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		int i_id=Integer.valueOf(id);
		pstmt.setInt(1, i_id);
		ResultSet rs = pstmt.executeQuery();
		Bxxx bxxx=new Bxxx();
		while (rs.next()) {
			bxxx.setId(rs.getInt("ID"));
			bxxx.setBxss(rs.getString("BXSS"));
			bxxx.setBxnr(rs.getString("BXNR"));
			bxxx.setBxdd(rs.getString("BXDD"));
			bxxx.setLxfs(rs.getString("LXFS"));
			bxxx.setBxr(rs.getString("BXR"));
			bxxx.setBxzt(rs.getString("BXZT"));
			bxxx.setBxsj(rs.getDate("BXSJ"));
		}
		return bxxx;
	}

	public List<Bxxx> loadYbxlbByXh(Connection con, String xh) throws SQLException {
		List<Bxxx> bxxxList=new ArrayList<Bxxx>();
		String sql="select * from t_xsxx t1 , t_bxxx t2 where t1.XM = t2.BXR and XH=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, xh);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			Bxxx bxxx=new Bxxx();
			bxxx.setId(rs.getInt("ID"));
			bxxx.setBxss(rs.getString("BXSS"));
			bxxx.setBxnr(rs.getString("BXNR"));
			bxxx.setBxdd(rs.getString("BXDD"));
			bxxx.setLxfs(rs.getString("LXFS"));
			bxxx.setBxr(rs.getString("BXR"));
			bxxx.setBxzt(rs.getString("BXZT"));
			bxxx.setBxsj(rs.getDate("BXSJ"));
			bxxxList.add(bxxx);
		}
		
		return bxxxList;
	}
}
