
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">      
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-1.7.1.min.js" type="text/javascript"></script>
        <title>Tìm kiếm sữa</title>
    </head>  
    <body>
        <%@include file="view/header.jsp" %>    
        <div id="content">
            <div id="content_left">
                <div id="menu_left">
                    <%@include file="view/menu.jsp" %>
                </div>
                <div>                    
                    <img src="images/animation_ecard.gif" alt=""/>
                    <img src="images/animation_milk.gif" alt=""/>
                </div>
            </div>            
            <div id="content_right" style="background-color: khaki;">
                <div style="width: 100%; text-align: center;">
                    <h1>Tìm kiếm thông tin sữa</h1>
                    <form name="frmtim" action="TimSuaServlet" method="post">
                        <label>Loại sữa</label>
                        <select name="lstloaisua">
                            <c:forEach items="${dsloai}" var="loai">
                                <option value="${loai.maLoaiSua}" ${param.lstloaisua eq loai.maLoaiSua?'selected':''}>${loai.tenLoai}</option>
                            </c:forEach>                              
                        </select>            
                        <label>Hãng sữa</label>
                        <select name="lsthangsua">
                            <c:forEach items="${dshang}" var="hang">  
                                <option value="${hang.maHangSua}" ${param.lsthangsua eq hang.maHangSua?'selected':''}>${hang.tenHangSua}</option>
                            </c:forEach>
                        </select>
                        <br><br>
                        <label>Tên sữa</label> <input type="text" name="txtTenSua" value="${param.txtTenSua}" /> <input type="submit" name="btn" value="Tìm kiếm" />
                    </form>                    
                </div>                
                <c:if test="${dssua!=null}" >
                    <h2>Có ${fn:length(dssua)} sản phẩm '${tenLoai}' của hãng '${tenHang}' được tìm thấy theo từ khóa '${param.txtTenSua}'</h2>
                    <table border="1">              
                        <tbody>
                            <c:forEach items="${dssua}" var="s">
                                <tr>
                                    <td colspan="2"><h3 style="color: blue;text-align: center;">${s.tenSua}</h3></td>              
                                </tr>
                                <tr>
                                    <td><img style="width: 150px;" src="images/${s.hinh}" alt=""/></td>            
                                    <td>
                                        <h3>Thành phần dinh dưỡng</h3>
                                        <p>${s.tpDinhDuong}</p>
                                        <h3>Lợi ích</h3>
                                        <p>${s.loiIch}</p>
                                        <h3>Trọng lượng: <span>${s.trongLuong} gr</span> - Đơn giá: <span>${s.donGia} vnđ</span></h3>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
            </div>            
        </div>
        <div class="clear"></div>  
        <%@include file="view/footer.jsp" %>
    </body>        
</html>