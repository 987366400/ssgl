package com.java.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.dao.TYHBDao;
import com.java.model.TYHB;
import com.java.util.DbUtil;
import com.java.util.StringUtil;

/**
 * �û�Servlet��
 * @author Administrator
 *
 */
public class YhbServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DbUtil dbUtil=new DbUtil();
	private TYHBDao yhbDao=new TYHBDao();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action=request.getParameter("action"); // ��ȡ��������
		if("login".equals(action)){
			this.login(request, response);
		}else if("logout".equals(action)){
			this.logout(request, response);
		}
	}
	
	/**
	 * ��¼��֤
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void login(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		String dlm=request.getParameter("dlm");
		String dlmm=request.getParameter("dlmm");
		String yhsf=request.getParameter("yhsf");
		
		String error="";
		if(StringUtil.isEmpty(dlm)){
			error="�û�������Ϊ�գ�";
		}else if(StringUtil.isEmpty(dlmm)){
			error="���벻��Ϊ�գ�";
		}else if(StringUtil.isEmpty(yhsf)){
			error="��ѡ���û����ͣ�";
		}
		TYHB yhb=new TYHB();
		yhb.setDlm(dlm);
		yhb.setDlmm(dlmm);
		yhb.setYhsf(yhsf);
		if(StringUtil.isNotEmpty(error)){
			request.setAttribute("yhb", yhb);
			request.setAttribute("error", error);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		Connection con=null;
		TYHB currentYhb=null;
		try{
			con=dbUtil.getCon();
			if("����Ա".equals(yhsf.trim())){
				currentYhb=yhbDao.login(con, yhb);
			}else if("��ʦ".equals(yhsf.trim())){
				currentYhb=yhbDao.login(con, yhb);
			}else if("ѧ��".equals(yhsf.trim())){
				currentYhb=yhbDao.login(con, yhb);
			}
			
			if(currentYhb==null){
				error="�û������������";
				request.setAttribute("yhb", yhb);
				request.setAttribute("error", error);
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}else{
				HttpSession session=request.getSession();
				session.setAttribute("currentYhb", currentYhb);
				response.sendRedirect("main.jsp");
			}
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
	
	/**
	 * ��ȫ�˳�
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void logout(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.getSession().invalidate();
		response.sendRedirect("login.jsp");
	}
	
	

}
