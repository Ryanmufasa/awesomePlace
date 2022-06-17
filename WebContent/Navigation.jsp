<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<style>
    	.nav{
			position:relative;
			width:100px;
			height:100%;
			background-color:gray;
		}
		a {
			left:50%;
			top:50%;
			margin:0;
		}
    	#adminNav{
    		position:fixed;
    	}
   	#adminNav>div{
			position:relative;
			text-align:center;
			height:80px;
			width:100px;
		}
	</style>
<nav>
	<div id="adminNav">
		<div style="background-color:red;">
			<a href="*">문의목록</a>
		</div>
		<div style="background-color:orange;">
			<a href="*">회원목록</a>
		</div>
		<div style="background-color:yellow;">
			<a href="*">호스팅목록</a>
		</div>
	</div>
</nav>

