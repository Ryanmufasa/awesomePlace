package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ServiceInterface {

	void execute(HttpServletRequest request, HttpServletResponse response);

	

}
