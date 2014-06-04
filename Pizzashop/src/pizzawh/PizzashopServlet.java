package pizzawh;

import java.io.*;
import java.util.*;
 
import javax.jdo.*;
import javax.servlet.http.*;
 



@SuppressWarnings("serial")
public class PizzashopServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			
		throws IOException {
	        PersistenceManagerFactory factory = PMF2.get();
	        PersistenceManager manager = factory.getPersistenceManager();
	        resp.setCharacterEncoding("UTF-8");
	        resp.setContentType("text/html");
	        req.setCharacterEncoding("utf-8");
	        String param1 = req.getParameter("id");
	        PrintWriter out = resp.getWriter();
	        List<LinkData2> list = null;
	        if (param1 == null || param1 ==""){
	            String query = "select from " + LinkData2.class.getName();
	            try {
	                list = (List<LinkData2>)manager.newQuery(query).execute();
	            } catch(JDOObjectNotFoundException e){}
	        } else {
	            try {
	                LinkData2 data = (LinkData2)manager.getObjectById(LinkData2.class,Long.parseLong(param1));
	                list = new ArrayList();
	                list.add(data);
	            } catch(JDOObjectNotFoundException e){}
	        }
	        String res = "[";
	        
	        if (list != null){
	            for(LinkData2 data:list){
	                res += "{id:" + data.getId() + ",url:'" + data.getUrl() + "',title:'" +
	                    data.getTitle() + "',date:'" + data.getDatetime() +
	                    "',comment:'" + data.getComment() + "'},";
	            }
	        }
	        res += "]";
	        out.println(res);
	        manager.close();
	}
}
