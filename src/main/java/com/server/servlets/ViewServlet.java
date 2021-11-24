package com.server.servlets;

import com.server.model.AgendaBean;
import com.server.model.ModelAg;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;


public class ViewServlet extends HttpServlet {

  //static Logger log = Logger.getLogger(ViewServlet.class);

  public void doPost(HttpServletRequest req, HttpServletResponse res)
          throws ServletException, IOException {
    //log.debug(print(req));

    HttpSession session = req.getSession();
    AgendaBean ab = (AgendaBean) session.getAttribute("ab");
    //log.debug("ab: " + ab + "|" + print(req));

    if (ab == null) {
      //log.debug("");
      req.getRequestDispatcher("/index.jsp").forward(req, res);
    } else {

      String sir = req.getParameter("sir");
      String cauta = req.getParameter("cauta");
      String addContact = req.getParameter("addContact");
      String upload = req.getParameter("upload");
      String care = req.getParameter("care");
      String download = req.getParameter("download");
      String urgent = req.getParameter("urgent");
      String help = req.getParameter("help");
      String opId = req.getParameter("opId");
      String longPage = req.getParameter("longPage");


      ab.setSir(sir);
      ab.setCare(care);
      ab.setUrgent(urgent);
      ab.setLongPage(longPage);
      ab.setOpId(opId);
      req.setAttribute("ab", ab);

      RequestDispatcher rdView = req.getRequestDispatcher("/WEB-INF/jsp/View.jsp");
      RequestDispatcher rdAddContact = req.getRequestDispatcher("/WEB-INF/jsp/AddContact.jsp");
      RequestDispatcher rdEditContact = req.getRequestDispatcher("/WEB-INF/jsp/EditContact.jsp");
      RequestDispatcher rdHelp = req.getRequestDispatcher("/WEB-INF/jsp/Help.jsp");
      RequestDispatcher rdUpload = req.getRequestDispatcher("/WEB-INF/jsp/Upload.jsp");

      if (addContact != null) {
        //log.debug("");
        rdAddContact.forward(req, res);

      } else if (upload != null) {
        //log.debug("");
        rdUpload.forward(req, res);

      } else if (download != null) {
        //log.debug("");
        ModelAg.doDownload(ab, res);
        rdView.forward(req, res);

      } else if (help != null) {
        //log.debug("");
        rdHelp.forward(req, res);

      } else if (cauta != null) {
        ModelAg.doCauta(ab);
        //log.debug("");
        rdView.forward(req, res);

      } else if (!ModelAg.isEmpty(ab.opId) && ab.opId.charAt(0) == 'E') {
        edit(ab);
        //log.debug("");
        rdEditContact.forward(req, res);

      } else if (!ModelAg.isEmpty(ab.opId) && "AZDUF".indexOf(ab.opId.charAt(0)) != -1) {
        sets(ab);
        //log.debug("");
        rdView.forward(req, res);

      } else if (!ModelAg.isEmpty(ab.opId) && "Pp".indexOf(ab.opId.charAt(0)) != -1) {
        page(ab);
        //log.debug("");
        rdView.forward(req, res);
      } else {
        rdView.forward(req, res);
      }
    }
  }

  public void doGet(HttpServletRequest req, HttpServletResponse res)
          throws ServletException, IOException {
    doPost(req, res);
  }

  private void page(AgendaBean ab) {
    ab.setCurrentPage(ab.opId.substring(1));
    ModelAg.doCauta(ab);
  }

  public void edit(AgendaBean ab) {
    for (HashMap<String, Object> hm : ab.resCauta) {
      if (!ab.opId.substring(1).equals((String) hm.get("id"))) {
        continue;
      }
      ab.contact = hm.get("head") + "\n" + hm.get("body");
      //log.debug(ab.contact);
      break;
    }
  }

  public void sets(AgendaBean ab) {
    //log.debug("");
    ModelAg.doSets(ab);
    ModelAg.doCauta(ab);
  }

  private String print(HttpServletRequest req) {
    String res = "";
    for (Enumeration<String> e = req.getParameterNames(); e.hasMoreElements();) {
      String n = e.nextElement();
      res += n + "=" + req.getParameter(n) + "&";
    }
    return res += req.getQueryString();
  }
}
