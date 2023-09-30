
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">      
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-1.7.1.min.js" type="text/javascript"></script>
        <title>Sữa bán chạy</title>
    </head>  
    <body>
        <%@include file="view/header.jsp" %>    
        <div id="content">
            <div id="content_left"> 
                <div id="menu_left">
                    <%@include file="view/menu.jsp" %>
                </div>
                <div id="menu_left">
                    <h3 style="margin: 0px;">Danh mục sữa bán chạy</h3>
                    <ul style="list-style: circle;">                       
                        <c:forEach items="${dssua}" var="s" >
                            <li><a href="SuaBanChayServlet?ma=${s.maSua}">${s.tenSua}</a></li>                            
                        </c:forEach>
                    </ul>
                </div>
                <div>                    
                    <img src="images/animation_ecard.gif" alt=""/>
                    <img src="images/animation_milk.gif" alt=""/>
                </div>
                
            </div>            
            <div id="content_right">                
                <h1 style="color: orange; text-align: center;">${sua.tenSua}</h1>
                <img src="images/${sua.hinh}" alt="" style="float: left"/>
                <div id="thongtin">
                    <p><b>Thành phần dinh dưỡng</b></p>
                    <p>${sua.tpDinhDuong}</p>
                    <p><b>Lợi ích</b></p>
                    <p>${sua.loiIch}</p>
                    <p id="trongluong"><b>Trọng lượng: </b>${sua.trongLuong} gr-<b>Đơn giá: </b>${sua.donGia} vnđ</p>
                    <a href="IndexServlet">Home</a>
                </div>
            </div>            
        </div>
        <div class="clear"></div>  
        <%@include file="view/footer.jsp" %>
    </body>        
</html>