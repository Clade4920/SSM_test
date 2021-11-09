package servlet;

import bean.service.GoodsService;
import bean.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ModifyGoodsServlet", value = "/ModifyGoodsServlet")
@Controller
public class ModifyGoodsServlet extends HttpServlet {
    @Autowired
    GoodsService goodsService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String goodsId = request.getParameter("goodsId");
        GoodsVo goodsVo = new GoodsVo();
        goodsVo.setGoodsId(goodsId);

//        ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
//        GoodsService goodsDAO = (GoodsService) appCon.getBean("goodsService");

        String type = request.getParameter("action");
        if (type.equalsIgnoreCase("增加")){
            String goodsName = request.getParameter("goodsName");
            float price = Float.parseFloat(request.getParameter("price"));
            goodsVo.setGoodsName(goodsName);
            goodsVo.setPrice(price);

            goodsService.add_goods(goodsVo);

        }else if (type.equalsIgnoreCase("删除")){
            goodsService.delete_goods(goodsVo.getGoodsId());

        }else if (type.equalsIgnoreCase("修改")){
            String goodsName = request.getParameter("goodsName");
            float price = Float.parseFloat(request.getParameter("price"));
            goodsVo.setGoodsName(goodsName);
            goodsVo.setPrice(price);

            goodsService.modify_goods(goodsVo);

        }else if (type.equalsIgnoreCase("查找")){
            goodsVo = goodsService.find_goods(goodsId);
            request.setAttribute("goodsVo",goodsVo);
            String forward = "find_goods.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(forward);
            rd.forward(request, response);

        }

        if(!type.equalsIgnoreCase("取消")){
            response.sendRedirect("getAllGoods");
        }

    }
}
