package servlet;

import bean.vo.GoodsVo;
import bean.vo.Item;
import bean.vo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import service.GoodsService;
import service.OrderService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@WebServlet("/addOrder")
public class AddOrderServlet extends HttpServlet {

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
        HttpSession session = request.getSession(false);
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        Order newOrder = new Order();
        newOrder.setItems(cart);

        String rstPage = "";
        int rst = orderService.saveOrder(newOrder);
        if(rst > 0)
            rstPage = "showCart";

        request.setAttribute("orderOperationResult","订单添加成功！！！");
        request.getRequestDispatcher(rstPage).forward(request,response);

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

}
