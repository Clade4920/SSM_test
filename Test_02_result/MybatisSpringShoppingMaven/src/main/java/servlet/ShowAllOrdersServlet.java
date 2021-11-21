package servlet;

import bean.vo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import service.CartService;
import service.ItemService;
import service.OrderService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@WebServlet("/showAllOrders")
public class ShowAllOrdersServlet extends HttpServlet {
    @Autowired
    OrderService orderService;


    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        AutowireCapableBeanFactory factory = wac.getAutowireCapableBeanFactory();
        factory.autowireBean(this);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        request.setAttribute("orderList",orderService.findAllOrders());

        request.getRequestDispatcher("orderList.jsp").forward(request,response);


    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
