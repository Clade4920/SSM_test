package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.omg.PortableInterceptor.ForwardRequest;

import bean.dao.GoodsDAO;
import bean.service.GoodsService;
import bean.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@Controller
public class GetAllGoods extends HttpServlet {

	@Autowired
	GoodsService goodsService;
	/**
	 * Constructor of the object.
	 */
	public GetAllGoods() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();

		String pageNo = request.getParameter("pageNo");
		int page = 1;
		if(pageNo != null){
			page = Integer.parseInt(pageNo);
		}

//		ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
//		//从容器中获取增强后的实例目标对象
//		GoodsService goodsService = (GoodsService) appCon.getBean("goodsService");
		ArrayList<GoodsVo> goodsList = goodsService.getGoodsByPage(page);
		int pageCount = goodsService.getPageCount();
		
		request.setAttribute("goodsList", goodsList);
		request.setAttribute("pageNo", page);
		request.setAttribute("pageCount", pageCount);
		
		String forward = "goodslist.jsp";
		
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
		
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		AutowireCapableBeanFactory factory = wac.getAutowireCapableBeanFactory();
		factory.autowireBean(this);
	}


}
