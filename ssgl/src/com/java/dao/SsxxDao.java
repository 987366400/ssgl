package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.java.model.PageBean;
import com.java.model.TSSXX;
import com.java.util.StringUtil;

/**
 * Àﬁ…·Dao¿‡
 * @author Administrator
 *
 */
public class SsxxDao {

	/**
	 * Àﬁ…·–≈œ¢≤È—Ø
	 * @param con
	 * @param pageBean
	 * @param s_student
	 * @return
	 * @throws Exception
	 */
	public List<TSSXX> ssxxList(Connection con,PageBean pageBean,TSSXX s_ssxx)throws Exception{
		List<TSSXX> ssxxList=new ArrayList<TSSXX>();
		StringBuffer sb=new StringBuffer("select * from t_ssxx ");
		if(s_ssxx!=null){
			if(StringUtil.isNotEmpty(s_ssxx.getSsh())){
				sb.append(" and SSH like '%"+s_ssxx.getSsh()+"%'");
			}			
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			TSSXX ssxx=new TSSXX();
			ssxx.setCws(rs.getString("CWS"));
			ssxx.setJcqk(rs.getString("JCQK"));
			ssxx.setSsxh(rs.getInt("SSXH"));
			ssxx.setSsh(rs.getString("SSH"));
			ssxx.setSslx(rs.getString("SSLX"));
			ssxx.setXzrs(rs.getString("XZRS"));
			ssxx.setSsz(rs.getString("SSZ"));
			ssxx.setJcqk(rs.getString("JCQK"));
			ssxx.setSspf(rs.getString("SSPF"));
			ssxx.setSsdd(rs.getString("SSDD"));
			
			ssxxList.add(ssxx);
		}
		return ssxxList;
	}
	
	/**
	 * ≤È—Øº«¬º ˝
	 * @param con
	 * @param s_student
	 * @return
	 * @throws Exception
	 */
	public int ssxxCount(Connection con,TSSXX s_ssxx)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from t_ssxx ");
		if(s_ssxx!=null){
			if(StringUtil.isNotEmpty(s_ssxx.getSsh())){
				sb.append(" and SSH like '%"+s_ssxx.getSsh()+"%'");
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
	 * Àﬁ…·ÃÌº”
	 * @param con
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public int ssxxAdd(Connection con,TSSXX ssxx)throws Exception{
		String sql="insert into t_ssxx values(null,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, ssxx.getSsh());
		pstmt.setString(2, ssxx.getSslx());
		pstmt.setString(3, ssxx.getSsdd());
		pstmt.setString(4, ssxx.getCws());
		pstmt.setString(5, ssxx.getXzrs());
		pstmt.setString(6, ssxx.getSsz());
		pstmt.setString(7, ssxx.getJcqk());
		pstmt.setString(8, ssxx.getSspf());
		
		return pstmt.executeUpdate();
	}
	
	/**
	 * Àﬁ…·∏¸–¬
	 * @param con
	 * @param student
	 * @return
	 * @throws Exception
	 */

	public int ssxxUpdate(Connection con,TSSXX ssxx)throws Exception{
		String sql="update t_ssxx set SSH=?,SSLX=?,SSDD=?,CWS=?,XZRS=?,SSZ=?,JCQK=?,SSPF=? where SSXH=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, ssxx.getSsh());
		pstmt.setString(2, ssxx.getSslx());
		pstmt.setString(3, ssxx.getSsdd());
		pstmt.setString(4, ssxx.getCws());
		pstmt.setString(5, ssxx.getXzrs());
		pstmt.setString(6, ssxx.getSsz());
		pstmt.setString(7, ssxx.getJcqk());
		pstmt.setString(8, ssxx.getSspf());
		pstmt.setInt(9, ssxx.getSsxh());
		return pstmt.executeUpdate();
	}
	
	/**
	 * Àﬁ…·…æ≥˝
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int ssxxDelete(Connection con,String ssxh)throws Exception{
		String sql="delete from t_ssxx where SSXH=?";
		int i_ssxh=Integer.valueOf(ssxh);
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, i_ssxh);
		return pstmt.executeUpdate();
	}
	
	/**
	 * ∏˘æ›Àﬁ…·∫≈≤È—ØÀﬁ…·
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public TSSXX loadSsxxBySsxh(Connection con, String ssxh) throws Exception {
		String sql = "select * from t_ssxx where SSXH=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		int i_ssxh=Integer.valueOf(ssxh);
		pstmt.setInt(1, i_ssxh);
		ResultSet rs = pstmt.executeQuery();

		TSSXX ssxx=new TSSXX();
		
		while (rs.next()) {
			ssxx.setCws(rs.getString("CWS"));
			ssxx.setJcqk(rs.getString("JCQK"));
			ssxx.setSsxh(rs.getInt("SSXH"));
			ssxx.setSsh(rs.getString("SSH"));
			ssxx.setSslx(rs.getString("SSLX"));
			ssxx.setXzrs(rs.getString("XZRS"));
			ssxx.setSsz(rs.getString("SSZ"));
			ssxx.setJcqk(rs.getString("JCQK"));
			ssxx.setSspf(rs.getString("SSPF"));
			ssxx.setSsdd(rs.getString("SSDD"));
		}
		return ssxx;
	}
}
