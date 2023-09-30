
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">      
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-1.7.1.min.js" type="text/javascript"></script>
        <title>Trang chủ</title>
        <style>
            #content_left img{
                width:100%;
            }
        </style>
    </head>  
    <body>
        <%@include file="view/header.jsp" %>       
        <div id="content">
            <div id="content_left">
                <div>
                    <img src="images/Logo_30nam.gif" alt=""/>
                    <img src="images/Thoitiet1.jpg" alt=""/>
                    <img src="images/pic_functional.jpg" alt=""/>
                    <img src="images/pic_km.jpg" alt=""/>
                    <img src="images/Logo_CauChuyenVinamilk.gif" alt=""/>
                </div>
            </div>
            <div id="menu">
                <%@include file="view/menu.jsp" %>
            </div>
            <div id="content_right">
                <div id="content_right_left">
                </div>
                <div id="content_right_right">
                </div>
            </div>            
        </div>
        <div class="clear"></div>  
        <%@include file="view/footer.jsp" %>
    </body>        
</html>
<script>
    $(document).ready(function(){
        var urlnav=window.location.href.substr(window.location.href.lastIndexOf("/")+1);
        if(urlnav.lastIndexOf("indexServlet")<0)
            urlnav="indexServlet?page=1";         
        else{
            if(urlnav.lastIndexOf("mahs")>0) {               
                if(urlnav.lastIndexOf("page")<0)
                    urlnav+="&page=1";
            }
            else if(urlnav.lastIndexOf("mals")>0) {               
                if(urlnav.lastIndexOf("page")<0)
                    urlnav+="&page=1";
            }
            else if(urlnav.lastIndexOf("page")<0){
                urlnav+="?page=1";
            }
            
        }
    
	$("a").each(function(index, element) {
            if($(this).attr("href")===urlnav )
            {
		$(this).addClass("current");
                $(this).removeAttr("href");
            }
        });      
    });
</script>