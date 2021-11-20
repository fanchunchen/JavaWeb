<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%@include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        window.onload = function () {
            const count = document.querySelectorAll(".count");
            for (let i = 0; i < count.length; i++) {
                count[i].addEventListener("change", () => {
                    // console.log(count[i].value)
                    if (confirm("你确定将" + count[i].getAttribute("name") + "的数量改为" + count[i].value) + "吗?") {
                        location.href = "http://localhost:8080/JavaWeb_war_exploded/cartServlet?action=updateCount&count=" + count[i].value + "&id=" + count[i].getAttribute("id");
                    } else {
                        count[i].value = 1;
                    }

                })
            }
        }
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>
    <%@include file="/pages/common/login_success_menu.jsp" %>
</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>
        <c:if test="${empty sessionScope.cart}">
            <tr>
                <td colspan="5"><a href="index.jsp">购物车为空,请先添加商品再来!</a></td>

            </tr>
        </c:if>
        <c:if test="${not empty sessionScope.cart}">
            <c:forEach items="${sessionScope.cart.items}" var="cartItem">

                <tr>
                    <td>${cartItem.value.name}</td>
                    <td><input style="width:80px" class="count" type="text" value="${cartItem.value.count}"
                               name="${cartItem.value.name}" id="${cartItem.value.id}" }></td>
                    <td>${cartItem.value.price}</td>
                    <td>${cartItem.value.totalPrice}</td>
                    <td><a href="cartServlet?action=deleteItem&id=${cartItem.value.id}">删除</a></td>
                </tr>
            </c:forEach>


        </c:if>


    </table>
    <c:if test="${not empty sessionScope.cart}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a href="cartServlet?action=clear">清空购物车</a></span>
            <span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
        </div>
    </c:if>>


</div>

<%@include file="/pages/common/footer.jsp" %>
</body>
</html>