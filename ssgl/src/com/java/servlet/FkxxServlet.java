package com.java.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.java.dao.FkxxDao;
import com.java.dao.SsxxDao;
import com.java.dao.XsxxDao;
import com.java.model.Fkxx;
import com.java.model.PageBean;
import com.java.model.TSSXX;
import com.java.model.TXSXX;
import com.java.util.DateUtil;
import com.java.util.DbUtil;
import com.java.util.PageUtil;
import com.java.util.ResponseUtil;
import com.java.util.StringUtil;

public class FkxxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DbUtil dbUtil=new DbUtil();

	private FkxxDao fkxxDao=new FkxxDao();
    public FkxxServlet() {
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
		String id = request.getParameter("id");
		Connection con = null;
		try {
			con = dbUtil.getCon();
			JSONObject result = new JSONObject();
			fkxxDao.fkxxDelete(con, id);
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
		String id=request.getParameter("id");
		String fkxm=request.getParameter("fkxm");
		String sfzh=request.getParameter("sfzh");
		String sfr=request.getParameter("sfr");
		String sfss=request.getParameter("sfss");
		String kssj=request.getParameter("kssj");
		String jssj=request.getParameter("jssj");
		String zt=request.getParameter("zt");
		String lxfs=request.getParameter("lxfs");
		String fwyy=request.getParameter("fwyy");
		Fkxx fkxx=new Fkxx();
		
		fkxx.setFkxm(fkxm);
		
		fkxx.setSfzh(sfzh);
		fkxx.setSfr(sfr);
		fkxx.setSfss(sfss);
		Date d_kssj=DateUtil.parse(kssj, DateUtil.webFormat);
		
		fkxx.setKssj(d_kssj);
		Date d_jssj=DateUtil.parse(jssj, DateUtil.webFormat);
		
		
		fkxx.setJssj(d_jssj);
		fkxx.setZt(zt);
		fkxx.setLxfs(lxfs);
		fkxx.setFwyy(fwyy);
		Connection con=null;
		try{
			con=dbUtil.getCon();
			if(StringUtil.isNotEmpty(id)){ // 修改
				int i_id=Integer.valueOf(id);
				fkxx.setId(i_id);
				fkxxDao.fkxxUpdate(con, fkxx);
			}else{
				fkxxDao.fkxxAdd(con, fkxx);
			}
			response.sendRedirect("fkxx?action=list");
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
		String id=request.getParameter("id");
		if(StringUtil.isNotEmpty(id)){
			request.setAttribute("actionName", "访客信息修改");
			Connection con=null;
			try{
				con=dbUtil.getCon();
				Fkxx fkxx=fkxxDao.loadFkxxById(con, id);
				request.setAttribute("fkxx", fkxx);
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
			request.setAttribute("actionName", "访问信息添加");
		}
		request.setAttribute("mainPage", "fkxx/save.jsp");
		request.setAttribute("modeName", "访客信息管理");
		request.getRequestDispatcher("main.jsp").forward(request, response);
		
	}

	private void list(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		String page=request.getParameter("page");
		String s_fkxm=request.getParameter("s_fkxm");
		Fkxx s_fkxx=new Fkxx();
		if(StringUtil.isEmpty(page)){
			page="1";
			s_fkxx.setFkxm(s_fkxm);
			session.setAttribute("s_fkxx", s_fkxx);
		}else{
			s_fkxx=(Fkxx) session.getAttribute("s_fkxx");
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page),5);
		Connection con=null;
		try{
			con=dbUtil.getCon();
			List<Fkxx> fkxxList=fkxxDao.fkxxList(con, pageBean, s_fkxx);
			int total=fkxxDao.fkxxCount(con, s_fkxx);
			String pageCode=PageUtil.getPagation(request.getContextPath()+"/fkxx?action=list", total, Integer.parseInt(page), 5);
			request.setAttribute("pageCode", pageCode);
			request.setAttribute("modeName", "访客信息管理");
			request.setAttribute("fkxxList", fkxxList);
			request.setAttribute("mainPage", "fkxx/list.jsp");
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
