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

import com.java.dao.BxxxDao;
import com.java.model.Bxxx;
import com.java.model.PageBean;
import com.java.model.TXSXX;
import com.java.model.TYHB;
import com.java.util.DateUtil;
import com.java.util.DbUtil;
import com.java.util.PageUtil;
import com.java.util.ResponseUtil;
import com.java.util.StringUtil;

public class BxxxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DbUtil dbUtil=new DbUtil();

	private BxxxDao bxxxDao=new BxxxDao();
    public BxxxServlet() {
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
		}else if("ybxlb".equals(action)){
			this.ybxlb(request, response);
		}
	}

	private void ybxlb(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Object object=session.getAttribute("currentYhb");
		TYHB yhb=(TYHB)object;
		String xh=yhb.getDlm();
		if(StringUtil.isNotEmpty(xh)){
			request.setAttribute("actionName", "已报修列表");
			Connection con=null;
			try{
				con=dbUtil.getCon();
				List<Bxxx> ybxlbList=bxxxDao.loadYbxlbByXh(con,xh);
				request.setAttribute("ybxlbList", ybxlbList);
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
			request.setAttribute("actionName", "已报修信息");
		}
		request.setAttribute("mainPage", "bxxx/ybxlb.jsp");
		request.setAttribute("modeName", "报修信息查看");
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		Connection con = null;
		try {
			con = dbUtil.getCon();
			JSONObject result = new JSONObject();
			bxxxDao.bxxxDelete(con, id);
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
		String bxss=request.getParameter("bxss");
		String bxnr=request.getParameter("bxnr");
		String lxfs=request.getParameter("lxfs");
		String bxdd=request.getParameter("bxdd");
		String bxr=request.getParameter("bxr");
		String bxzt=request.getParameter("bxzt");
		String bxsj=request.getParameter("bxsj");
		Bxxx bxxx=new Bxxx();
		bxxx.setBxss(bxss);
		bxxx.setBxnr(bxnr);
		bxxx.setLxfs(lxfs);
		bxxx.setBxdd(bxdd);
		bxxx.setBxr(bxr);
		bxxx.setBxzt(bxzt);
		Date d_bxsj=DateUtil.parse(bxsj, DateUtil.webFormat);
		bxxx.setBxsj(d_bxsj);
		Connection con=null;
		try{
			con=dbUtil.getCon();
			if(StringUtil.isNotEmpty(id)){ // 修改
				int i_id=Integer.valueOf(id);
				bxxx.setId(i_id);
				bxxxDao.bxxxUpdate(con, bxxx);
			}else{
				bxxxDao.bxxxAdd(con, bxxx);
			}
			response.sendRedirect("bxxx?action=list");
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
			request.setAttribute("actionName", "报修信息修改");
			Connection con=null;
			try{
				con=dbUtil.getCon();
				Bxxx bxxx=bxxxDao.loadBxxxById(con, id);
				
				request.setAttribute("bxxx", bxxx);
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
			request.setAttribute("actionName", "报修信息添加");
		}
		request.setAttribute("mainPage", "bxxx/save.jsp");
		request.setAttribute("modeName", "报修信息管理");
		request.getRequestDispatcher("main.jsp").forward(request, response);
		
	}

	private void list(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		String page=request.getParameter("page");
		String s_bxr=request.getParameter("s_bxr");
		Bxxx s_bxxx=new Bxxx();
		if(StringUtil.isEmpty(page)){
			page="1";
			s_bxxx.setBxr(s_bxr);
			session.setAttribute("s_bxxx", s_bxxx);
		}else{
			s_bxxx=(Bxxx) session.getAttribute("s_bxxx");
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page),5);
		Connection con=null;
		try{
			con=dbUtil.getCon();
			List<Bxxx> bxxxList=bxxxDao.bxxxList(con, pageBean, s_bxxx);
			int total=bxxxDao.bxxxCount(con, s_bxxx);
			String pageCode=PageUtil.getPagation(request.getContextPath()+"/bxxx?action=list", total, Integer.parseInt(page), 5);
			request.setAttribute("pageCode", pageCode);
			request.setAttribute("modeName", "报修信息管理");
			request.setAttribute("bxxxList", bxxxList);
			request.setAttribute("mainPage", "bxxx/list.jsp");
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
