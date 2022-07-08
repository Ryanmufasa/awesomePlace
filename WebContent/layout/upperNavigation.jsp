<!-- https://github.com/Ryanmufasa/awesomePlace/issues/28 작성자: 이명진 -->
<%@page import="java.awt.print.Printable"%>
<%@page import="hashtag.HashtagVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="${contextPath }/resources/css/UpperNav.css?v=<%=System.currentTimeMillis() %>" rel="stylesheet">
    
   <% MemberDAO dao = MemberDAO.getInstance(); 
   	ArrayList<HashtagVO> tagList = dao.getHashtag();
   	request.setAttribute("tagList", tagList);
   %>
	<div class="upperNav">
		<div class="LD">
			<button id="LScroll">&lt;</button>
		</div>
				<div class="CD">
						<c:forEach var="tagList" items="${tagList}">
							<button id="tags">#${tagList.tag_name }</button>
						</c:forEach>
				</div>
		<div class="RD">
			<button id="RScroll">&gt;</button>
		</div>
	</div>
