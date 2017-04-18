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

import com.java.dao.XsxxDao;
import com.java.model.PageBean;
import com.java.model.TXSXX;
import com.java.model.TYHB;
import com.java.util.DbUtil;
import com.java.util.PageUtil;
import com.java.util.ResponseUtil;
import com.java.util.StringUtil;
public class XsxxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DbUtil dbUtil=new DbUtil();
	private XsxxDao xsxxDao=new XsxxDao();
    public XsxxServlet() {
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
		}else if("showInfo".equals(action)){
			this.showInfo(request,response);
		}
	}

	private void showInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Object object=session.getAttribute("currentYhb");
		TYHB yhb=(TYHB)object;
		String xh=yhb.getDlm();
		if(StringUtil.isNotEmpty(xh)){
			request.setAttribute("actionName", "个人信息查看");
			Connection con=null;
			try{
				con=dbUtil.getCon();
				TXSXX xsxx=xsxxDao.loadXsxxByXh(con, xh);
				request.setAttribute("xsxx", xsxx);
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
			request.setAttribute("actionName", "学生信息添加");
		}
		request.setAttribute("mainPage", "xsxx/save.jsp");
		request.setAttribute("modeName", "学生信息管理");
		request.getRequestDispatcher("main.jsp").forward(request, response);
		
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		String xh = request.getParameter("xh");
		Connection con = null;
		try {
			con = dbUtil.getCon();
			JSONObject result = new JSONObject();
			xsxxDao.xsxxDelete(con, xh);
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
		String xh=request.getParameter("xh");
		String xm=request.getParameter("xm");
		String xb=request.getParameter("xb");
		String mz=request.getParameter("mz");
		String cs=request.getParameter("cs");
		String zy=request.getParameter("zy");
		String jtdz=request.getParameter("jtdz");
		String yzbm=request.getParameter("yzbm");
		String sfzhm=request.getParameter("sfzhm");
		String jzxm=request.getParameter("jzxm");
		String ssh=request.getParameter("ssh");
		String sjh=request.getParameter("sjh");
		String bz=request.getParameter("bz");
		TXSXX xsxx=new TXSXX();
		xsxx.setXm(xm);
		xsxx.setXb(xb);
		xsxx.setMz(mz);
		xsxx.setCs(cs);
		xsxx.setZy(zy);
		xsxx.setJtdz(jtdz);
		xsxx.setYzbm(yzbm);
		xsxx.setSfzhm(sfzhm);
		xsxx.setJzxm(jzxm);
		xsxx.setSsh(ssh);
		xsxx.setSjh(sjh);
		xsxx.setBz(bz);
		Connection con=null;
		try{
			con=dbUtil.getCon();
			if(StringUtil.isNotEmpty(xh)){ // 修改
				xsxx.setXh(xh);
				xsxxDao.xsxxUpdate(con, xsxx);
			}else{
				xsxxDao.xsxxAdd(con, xsxx);
			}
			response.sendRedirect("xsxx?action=list");
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
		String xh=request.getParameter("xh");
		if(StringUtil.isNotEmpty(xh)){
			request.setAttribute("actionName", "学生信息修改");
			Connection con=null;
			try{
				con=dbUtil.getCon();
				TXSXX xsxx=xsxxDao.loadXsxxByXh(con, xh);
				request.setAttribute("xsxx", xsxx);
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
			request.setAttribute("actionName", "学生信息添加");
		}
		request.setAttribute("mainPage", "xsxx/save.jsp");
		request.setAttribute("modeName", "学生信息管理");
		request.getRequestDispatcher("main.jsp").forward(request, response);
		
	}

	private void list(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		String page=request.getParameter("page");
		String s_xm=request.getParameter("s_xm");
		TXSXX s_xsxx=new TXSXX();
		
		if(StringUtil.isEmpty(page)){
			page="1";
			s_xsxx.setXm(s_xm);
			session.setAttribute("s_xsxx", s_xsxx);
		}else{
			s_xsxx=(TXSXX) session.getAttribute("s_xsxx");
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page),5);
		Connection con=null;
		try{
			con=dbUtil.getCon();
			List<TXSXX> xsxxList=xsxxDao.xsxxList(con, pageBean, s_xsxx);
			int total=xsxxDao.xsxxCount(con, s_xsxx);
			String pageCode=PageUtil.getPagation(request.getContextPath()+"/xsxx?action=list", total, Integer.parseInt(page), 5);
			request.setAttribute("pageCode", pageCode);
			request.setAttribute("modeName", "学生信息管理");
			request.setAttribute("xsxxList", xsxxList);
			request.setAttribute("mainPage", "xsxx/list.jsp");
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
