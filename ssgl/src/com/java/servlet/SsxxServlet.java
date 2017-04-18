package com.java.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.java.dao.SsxxDao;
import com.java.dao.XsxxDao;
import com.java.model.PageBean;
import com.java.model.TSSXX;
import com.java.model.TXSXX;
import com.java.util.DbUtil;
import com.java.util.PageUtil;
import com.java.util.ResponseUtil;
import com.java.util.StringUtil;

public class SsxxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DbUtil dbUtil=new DbUtil();
	private SsxxDao ssxxDao=new SsxxDao();

    public SsxxServlet() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	this.doPost(request, response);
	}
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
		String action=request.getParameter("action");
		if("list".equals(action)){
			this.list(request, response);
		}else if("preSave".equals(action)){
			this.preSave(request, response);
		}else if("save".equals(action)){
			this.save(request, response);
		}else if("delete".equals(action)){
			this.delete(request, response);
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		String ssxh = request.getParameter("ssxh");
		Connection con = null;
		try {
			con = dbUtil.getCon();
			JSONObject result = new JSONObject();
			ssxxDao.ssxxDelete(con, ssxh);
			result.put("success", true);
			ResponseUtil.write(result, response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	private void save(HttpServletRequest request, HttpServletResponse response) {
		String ssxh=request.getParameter("ssxh");
		String ssh=request.getParameter("ssh");
		String sslx=request.getParameter("sslx");
		String ssdd=request.getParameter("ssdd");
		String cws=request.getParameter("cws");
		String xzrs=request.getParameter("xzrs");
		String ssz=request.getParameter("ssz");
		String jcqk=request.getParameter("jcqk");
		String sspf=request.getParameter("sspf");
		TSSXX ssxx=new TSSXX();
		ssxx.setCws(cws);
		ssxx.setJcqk(jcqk);
		ssxx.setSsh(ssh);
		ssxx.setSslx(sslx);
		ssxx.setXzrs(xzrs);
		ssxx.setSsz(ssz);
		ssxx.setJcqk(jcqk);
		ssxx.setSsdd(ssdd);
		ssxx.setSspf(sspf);
		Connection con=null;
		try{
			con=dbUtil.getCon();
			if(StringUtil.isNotEmpty(ssxh)){ // 修改
				int i_ssxh=Integer.valueOf(ssxh);
				ssxx.setSsxh(i_ssxh);
				ssxxDao.ssxxUpdate(con, ssxx);
			}else{
				ssxxDao.ssxxAdd(con, ssxx);
			}
			response.sendRedirect("ssxx?action=list");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

	private void preSave(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String ssxh=request.getParameter("ssxh");
		if(StringUtil.isNotEmpty(ssxh)){
			request.setAttribute("actionName", "宿舍信息修改");
			Connection con=null;
			try{
				con=dbUtil.getCon();
				TSSXX ssxx=ssxxDao.loadSsxxBySsxh(con, ssxh);
				request.setAttribute("ssxx", ssxx);
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else{
			request.setAttribute("actionName", "宿舍信息添加");
		}
		request.setAttribute("mainPage", "ssxx/save.jsp");
		request.setAttribute("modeName", "宿舍信息管理");
		request.getRequestDispatcher("main.jsp").forward(request, response);
		
	}

	private void list(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		String page=request.getParameter("page");
		String s_ssh=request.getParameter("s_ssh");
		TSSXX s_ssxx=new TSSXX();
		
		if(StringUtil.isEmpty(page)){
			page="1";
			s_ssxx.setSsh(s_ssh);
			session.setAttribute("s_ssxx", s_ssxx);
		}else{
			s_ssxx=(TSSXX) session.getAttribute("s_ssxx");
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page),5);
		Connection con=null;
		try{
			con=dbUtil.getCon();
			List<TSSXX> ssxxList=ssxxDao.ssxxList(con, pageBean, s_ssxx);
			int total=ssxxDao.ssxxCount(con, s_ssxx);
			String pageCode=PageUtil.getPagation(request.getContextPath()+"/ssxx?action=list", total, Integer.parseInt(page), 5);
			request.setAttribute("pageCode", pageCode);
			request.setAttribute("modeName", "宿舍信息管理");
			request.setAttribute("ssxxList", ssxxList);
			request.setAttribute("mainPage", "ssxx/list.jsp");
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
