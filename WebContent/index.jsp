<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>API</title>
<script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	/* const serverPath = 'http://localhost:8787/';
	 const access_token = '';
	 */
	//模拟Get请求
	function ajaxRequestGet(uri) {
		/* var server = serverPath;
		var url = server + uri; */
		var url = uri;
		$.ajax({
			type : 'GET',
			contentType : 'application/json',
			dataType : 'json',
			url : url,
			success : function(response) {
				console.log(response);
			},
			error : function() {
				console.log('Ajax请求失败！');
			}
		});
	}

	//模拟Post请求
	function ajaxRequestPost(uri, data) {
	/* 	var server = serverPath;
		var url = server + uri; */
		var url = uri;
		$.ajax({
			type : 'POST',
			contentType: 'application/json;charset=UTF-8',//此句话需要配合 json序列化方法使用
			dataType : 'json',
			data : JSON.stringify(data),
			url : url,
			success : function(response) {
				console.log(response);
			},
			error : function(response) {
				console.log('Ajax error');
				console.log(response);
			}
		});
	}

	$(function() {
		$("#testGetAward").click(function() {
			ajaxRequestGet("award/get");
		});
		
		$("#testAddAward").click(function() {
			var data = { "awdID": "3", "name": "挑战杯", "gradeName": "1", "grade": "1" };
			ajaxRequestPost("award/add", data);
		});
		
		$("#testDeleteAward").click(function() {
			ajaxRequestGet("award/delete?awdID=8a0eb5665f39fe67015f39fed40e0000");
		});
		
		$("#testModifyAward").click(function() {
			 var data = { 'awdID': '8a0eb5665f3a6644015f3a666c6c0000', 'name': '修改后的"互联网+"创新创业大赛', 'gradeName': '2', 'grade': '2' }
             ajaxRequestPost('award/modify', data);
		});

	})
</script>
</head>
<body>
	<h4>奖项管理接口</h4>
	<input type="button" value="api/award/get" id="testGetAward" />
	<br>
	<br>
	<input type="button" value="api/award/add" id="testAddAward" />
	<br>
	<br>
	<input type="button" value="api/award/delete" id="testDeleteAward" />
	<br>
	<br>
	<input type="button" value="api/award/modify" id="testModifyAward" />



</body>
</html>