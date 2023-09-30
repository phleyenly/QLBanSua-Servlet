package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogic.HangSuaBL;
import businessLogic.LoaiSuaBL;
import businessLogic.SuaBL;
import javaBean.HangSua;
import javaBean.LoaiSua;
import javaBean.Sua;

/**
 * Servlet implementation class TimSuaServlet
 */
@WebServlet("/TimSuaServlet")
public class TimSuaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TimSuaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		// Thi sinh viet them cac lenh vao day de thuc hien
		// ???
		List<LoaiSua> dsls = LoaiSuaBL.docTatCa();
		List<HangSua> dshs = HangSuaBL.docTatCa();
		request.setAttribute("dsloai", dsls);
		request.setAttribute("dshang", dshs);

		request.getRequestDispatcher("timsua.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String maLoai, maHang, tenSua, tenLoai = "", tenHang = "";
		maLoai = request.getParameter("lstloaisua");
		maHang = request.getParameter("lsthangsua");
		tenSua = request.getParameter("txtTenSua");

		List<Sua> dsSua1 = SuaBL.TimTheoLoaiHangTen(maLoai, maHang, tenSua);
		List<LoaiSua> dsls = LoaiSuaBL.docTatCa();
		List<HangSua> dshs = HangSuaBL.docTatCa();
		for (LoaiSua loai : dsls) {
			if(loai.getMaLoaiSua().equals(maLoai)) {
				tenLoai = loai.getTenLoai();
			}
		}
		
		for (HangSua hang : dshs) {
			if(hang.getMaHangSua().equals(maHang)) {
				tenHang = hang.getTenHangSua();
			}
		}
		
		request.setAttribute("dsloai", dsls);
		request.setAttribute("dshang", dshs);
		request.setAttribute("dssua", dsSua1);
		request.setAttribute("tenLoai", tenLoai);
		request.setAttribute("tenHang", tenHang);
		request.getRequestDispatcher("timsua.jsp").forward(request, response);
	}

}
