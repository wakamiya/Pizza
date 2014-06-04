package pizzawh;

import java.io.IOException;
import java.util.*;
 
import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
 
public class Edit2LinkDataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("no url...");
    }
 
    @Override
    protected void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        long id = Long.parseLong(req.getParameter("id"));
        String title = req.getParameter("title");
        String url = req.getParameter("url");
        String comment = req.getParameter("comment");
        PersistenceManagerFactory factory = PMF2.get();
        PersistenceManager manager = factory.getPersistenceManager();
        LinkData2 data = (LinkData2)manager.getObjectById(LinkData2.class,id);
        data.setTitle(title);
        data.setUrl(url);
        data.setComment(comment);
        manager.close();
        resp.sendRedirect("/index.html");
    }

}
