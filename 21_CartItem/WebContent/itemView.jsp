<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${item.itemName}의 정보</h1>
	<p id="title">
	<span>조회수 : ${item.count}</span>
	<!-- data-xx : 속성 지정할 때.. -->
	<button id="cartInsert" data-id="${item.itemId}" value="${item.itemName}, ${item.price},${item.pictureUrl}">장바구니 담기</button>
	<a href="cartList.jsp">장바구니 확인</a>
	<a href="itemList.do">상품 목록 확인</a>
	</p>
	
	<div id="desc">
		<img alt="" src="${item.pictureUrl}">
		<div id="content">
			<p>종류 : ${item.itemName}</p>
			<p>가격 : ${item.price}</p>
			<p>설명 : ${item.description}</p>
		</div>
	</div>
	
	<script>
	 	$('#cartInsert').click(function(){
	 		// localStorage.setItem
	 		//localStorage.setItem('cart-'+$(this).attr('data-id'), $(this).val());
	 		// 값이 제대로 오나 확인하기 위해
	 		console.log($(this).attr('data-id'));
	 		console.log($(this).val());
	 		//alert('장바구니에 담겨짐');
	 	});
	</script>
</body>
</html>