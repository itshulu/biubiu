package sl.itcast.servlet.frontend;

import sl.itcast.entity.Food;
import sl.itcast.factory.BeanFactory;
import sl.itcast.service.Impl.FoodService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author 舒露
 */
@WebServlet(name = "ClientCartServlet", urlPatterns = "/ClientCartServlet")
public class ClientCartServlet extends HttpServlet {
    private FoodService foodService = BeanFactory.getInstance("foodService", FoodService.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        HttpSession session = request.getSession();
        String tableId = (String) session.getAttribute("tableId");
        @SuppressWarnings("unchecked")
        List<Food> list = (List<Food>) session.getAttribute(tableId);
        Food food = foodService.findById(id);
        list.add(food);
        response.sendRedirect(this.getServletContext().getContextPath() + "/ShowClientCarServlet");
    }
}
