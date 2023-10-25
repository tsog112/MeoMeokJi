<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.google.gson.reflect.TypeToken"%>
<%@page import="test1.RestaurantInfo"%>
<%@page import="test1.searchApi"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.List"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>맛집 검색</title>
</head>
<body>
    <h1>맛집 검색</h1>
    <form method="get" action="">
        <input type="text" name="query" placeholder="맛집 검색어 입력">
        <input type="submit" value="검색">
    </form>

    <%
	String query = "음식점";
	query += request.getParameter("query");
	if (query != null && !query.isEmpty()) {
    	searchApi search = new searchApi();
    	search.setQuery(query);
    	List<RestaurantInfo> restaurantList = search.searchRestaurants();

    	// 검색 결과를 Result.jsp에 전달
    	request.setAttribute("restaurantList", restaurantList);
	}
    %>
</body>
</html>