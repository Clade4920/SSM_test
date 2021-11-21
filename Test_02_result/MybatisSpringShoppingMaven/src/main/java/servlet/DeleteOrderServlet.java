package servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import service.OrderService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@WebServlet("/deleteOrder")
public class DeleteOrderServlet extends HttpServlet {

    @Autowired
    OrderService orderService;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        AutowireCapableBeanFactory factory = wac.getAutowireCapableBeanFactory();
        factory.autowireBean(this);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        Integer orderId = Integer.parseInt(request.getParameter("orderid"));
        Integer rst = orderService.deleteOrderById(orderId);

        String rstPage = "showAllOrders";

        String orderOperationResult = null;
        if(rst != 1){
             orderOperationResult = "删除订单出错!";

        }else{
             orderOperationResult = "删除订单成功!";

        }
        request.setAttribute("orderOperationResult",orderOperationResult);
        request.getRequestDispatcher(rstPage).forward(request,response);


    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
