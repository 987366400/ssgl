package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.naming.java.javaURLContextFactory;

import com.java.model.Fkxx;
import com.java.model.PageBean;
import com.java.util.DateUtil;
import com.java.util.StringUtil;

/**
 * ����Dao��
 * @author Administrator
 *
 */
public class FkxxDao {

	/**
	 * �ÿ���Ϣ��ѯ
	 * @param con
	 * @param pageBean
	 * @param s_student
	 * @return
	 * @throws Exception
	 */
	public List<Fkxx> fkxxList(Connection con,PageBean pageBean,Fkxx s_fkxx)throws Exception{
		List<Fkxx> fkxxList=new ArrayList<Fkxx>();
		StringBuffer sb=new StringBuffer("select * from t_fkxx ");
		if(s_fkxx!=null){
			if(StringUtil.isNotEmpty(s_fkxx.getFkxm())){
				sb.append(" and FKXM like '%"+s_fkxx.getFkxm()+"%'");
			}			
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			Fkxx fkxx=new Fkxx();
			fkxx.setFkxm(rs.getString("FKXM"));
			fkxx.setId(rs.getInt("ID"));
			fkxx.setSfzh(rs.getString("SFZH"));
			fkxx.setSfr(rs.getString("SFR"));
			fkxx.setSfss(rs.getString("SFSS"));
			fkxx.setKssj(rs.getDate("KSSJ"));
			fkxx.setJssj(rs.getDate("JSSJ"));
			fkxx.setZt(rs.getString("ZT"));
			fkxx.setLxfs(rs.getString("LXFS"));
			fkxx.setFwyy(rs.getString("FWYY"));
			fkxxList.add(fkxx);
		}
		return fkxxList;
	}
	
	/**
	 * ��ѯ��¼��
	 * @param con
	 * @param s_student
	 * @return
	 * @throws Exception
	 */
	public int fkxxCount(Connection con,Fkxx s_fkxx)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from t_fkxx ");
		if(s_fkxx!=null){
			if(StringUtil.isNotEmpty(s_fkxx.getFkxm())){
				sb.append(" and FKXM like '%"+s_fkxx.getFkxm()+"%'");
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
	 * �ÿ����
	 * @param con
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public int fkxxAdd(Connection con,Fkxx fkxx)throws Exception{
		String sql="insert into t_fkxx values(null,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, fkxx.getFkxm());
		pstmt.setString(2, fkxx.getSfzh());
		pstmt.setString(3, fkxx.getSfr());
		pstmt.setString(4, fkxx.getSfss());
		pstmt.setDate(5, new java.sql.Date(fkxx.getKssj().getTime()));//ת��sql.date
		pstmt.setDate(6, new java.sql.Date(fkxx.getJssj().getTime()));
		pstmt.setString(7, fkxx.getZt());
		pstmt.setString(8, fkxx.getLxfs());
		pstmt.setString(9, fkxx.getFwyy());
		
		return pstmt.executeUpdate();
	}
	
	/**
	 * ������Ϣ����
	 * @param con
	 * @param student
	 * @return
	 * @throws Exception
	 */

	public int fkxxUpdate(Connection con,Fkxx fkxx)throws Exception{
		String sql="update t_fkxx set FKXM=?,SFZH=?,SFR=?,SFSS=?,KSSJ=?,JSSJ=?,ZT=?,LXFS=?,FWYY=? where ID=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, fkxx.getFkxm());
		pstmt.setString(2, fkxx.getSfzh());
		pstmt.setString(3, fkxx.getSfr());
		pstmt.setString(4, fkxx.getSfss());
		pstmt.setDate(5, new java.sql.Date(fkxx.getKssj().getTime()));//ת��sql.date
		pstmt.setDate(6, new java.sql.Date(fkxx.getJssj().getTime()));
		pstmt.setString(7, fkxx.getZt());
		pstmt.setString(8, fkxx.getLxfs());
		pstmt.setString(9, fkxx.getFwyy());
		pstmt.setInt(10, fkxx.getId());
		return pstmt.executeUpdate();
	}
	
	/**
	 * �ÿ�ɾ��
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int fkxxDelete(Connection con,String id)throws Exception{
		String sql="delete from t_fkxx where ID=?";
		int i_id=Integer.valueOf(id);
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, i_id);
		return pstmt.executeUpdate();
	}
	
	/**
	 * ����������ѯ�ÿ�
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Fkxx loadFkxxById(Connection con, String id) throws Exception {
		String sql = "select * from t_fkxx where ID=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		int i_id=Integer.valueOf(id);
		pstmt.setInt(1, i_id);
		ResultSet rs = pstmt.executeQuery();
		Fkxx fkxx=new Fkxx();
		while (rs.next()) {
			fkxx.setFkxm(rs.getString("FKXM"));
			fkxx.setId(rs.getInt("ID"));
			fkxx.setSfzh(rs.getString("SFZH"));
			fkxx.setSfr(rs.getString("SFR"));
			fkxx.setSfss(rs.getString("SFSS"));
			fkxx.setKssj(rs.getDate("KSSJ"));
			fkxx.setJssj(rs.getDate("JSSJ"));
			fkxx.setZt(rs.getString("ZT"));
			fkxx.setLxfs(rs.getString("LXFS"));
			fkxx.setFwyy(rs.getString("FWYY"));
		}
		return fkxx;
	}
}
