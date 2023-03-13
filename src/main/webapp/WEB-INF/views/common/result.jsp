<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	let mes = '${message}';
    if(mes !=""){
        alert(mes);
    }
    location.href="${url}";
</script>