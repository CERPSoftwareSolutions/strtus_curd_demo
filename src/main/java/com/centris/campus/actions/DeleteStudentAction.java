package com.centris.campus.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONObject;

import com.centris.campus.delegate.StudentBD;

public class DeleteStudentAction extends Action{
	private static final Logger logger = Logger.getLogger(EditStudentAction.class);
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.info("Starting");
		try {
			String studentId=request.getParameter("primaryId"); 
			String remarks=request.getParameter("remarks"); 
			
			String status=new StudentBD().deleteStudent(studentId,remarks);
			
			JSONObject object = new JSONObject();
			object.put("status", status);
			response.getWriter().print(object);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.info("Ending");
		return null;
	}
}
