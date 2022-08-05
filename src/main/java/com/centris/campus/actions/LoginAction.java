package com.centris.campus.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONObject;

import com.centris.campus.delegate.LoginBD;

public class LoginAction extends Action {
	private static final Logger logger = Logger.getLogger(LoginAction.class);
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("Starting");
		try {
			String username=request.getParameter("username");
			System.out.println("username "+username);
			String password=request.getParameter("password");
			System.out.println("password "+password);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.info("Ending");
		
		return mapping.findForward("success");
	}
}
