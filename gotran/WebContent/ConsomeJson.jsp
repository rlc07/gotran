<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<button onclick="teste();">clica</button>
</body>
<script type="text/javascript" src="resources/js/jquery.js"></script>
<script type="text/javascript">
function teste(){

	var id = 4;
$.ajax({
	type: 'GET',
	dataType: 'json',
	url: '/gotran/teste2.jsp',
	async: false,
	success: function(response)
	{
		if(response.length > 0){
			for(var i = 0; i < response.length; i++)
			{
				if(response[i].id_veiculo == 4){
					alert(response[i].id_veiculo + " , " + response[i].modelo + ","+response[i].img_veiculo);

					}
			}
		}
		
	},
	error: function (xhr,ajaxOptions,thrownError){
		alert(xhr.statusText);
		alert(xhr.responseText);
		alert(xhr.status);
		alert(thrownError);
	}
	});
}
</script>
</html>