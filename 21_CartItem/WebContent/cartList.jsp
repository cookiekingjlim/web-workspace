<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
</head>
<body>
	<h1>장바구니</h1>
	<a href="itemList.do">쇼핑 계속하기</a>
	<table border="1">
		<thead>
		<tr>
			<th>번호</th>
			<th>상품이미지</th>
			<th>상품명</th>
			<th>상품가격</th>
			<th>수량</th>
			<th><button onclick="deleteStorage()">삭제</button></th>
		</tr>
		</thead>
			<tbody></tbody>
			<tfoot>
			<tr>
			<td colspan="6">총 결제금액 : <span id="resultTotal"></span></td>
			</tr>
			</tfoot>
	</table>
	
	<script>
	let amount = 1; // 클릭할 때마다 변하므로 전역 변수로 지정
	let totalPrice = 0;
	refreshPage();
	
	$('.up').on('click', function(){	// 이미지 키를 아이디로 지정하면 안돼:아이디는 각각 접근해야하므로 -> class로 지정
		$(this).next().html(eval($(this).next().html())+1);
		amount = $(this).next().html();	// 바뀐 수량을 담아놓고
	//	alert('up!');
		totalPrice += eval($(this).parent().prev().html());	// 수량에서(화살표 이미지) 가격에 접근해서 합계
		$('#resultTotal').html(totalPrice);
	});
	$('.down').on('click', function(){
		if(amount > 1) {
			$(this).prev().html(eval($(this).prev().html())-1);
			amount = $(this).prev().html();
		totalPrice -= eval($(this).parent().prev().html());
		$('#resultTotal').html(totalPrice);
		}
		
	//alert('down!');
	});
	
	function refreshPage() {
			let html ='';
			let count = 0;
		for(let key in localStorage){
			if(key === 'length') break;	// -> cart-로 시작하는 것만 가지고 오는 걸 볼 수 있어
			console.log(key);
			const data = localStorage.getItem(key).split(",");
			console.log(data);	//-> 나눠서 배열로 가져온 것을 tbody에 뿌려야함
			html += '<tr>'+
						'<td>'+ ++count + '</td>' + // 번호에 해당하는 게 추가됨
						'<td><img src='+ data[2] +' width=150 height=150></td>'+ 	// 이미지를 받을 건데 데이터의 2번째에 해당하는 부분에 url
						'<td>'+data[0]+'</td>'+
						'<td>'+data[1]+'</td>'+
						'<td>'+
						'<img src=img/up.jpg width=10 height=10 style=cursor:pointer; class=up>'+
						'<div>'+ amount +'</div>'+
						'<img src=img/down.jpg width=10 height=10 style=cursor:pointer; class=down>'+
						'</td>'+
						'<td><input value='+key+' type=checkbox class=deleteItem></td>'+
					'</tr>';
				totalPrice += eval(data[1]);	// 문자라 이대로 더하면 안돼->eval()사용
		}
		$('tbody').append(html);	// 포문을 통해서 더해진 게 나중에 이렇게 들어감
		$('#resultTotal').html(totalPrice);
	}
	
	function deleteStorage() {
		const check = document.querySelectorAll(".deleteItem");
		console.log(check);
		for(let i = 0; i<check.length; i++){
			if(check[i].checked === true){
				localStorage.removeItem(check[i].value);
				location.reload();
			}
		}
		
	}
	</script>
</body>
</html>