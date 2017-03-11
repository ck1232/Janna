<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript">
$(function(){
	var sql = '${sqlStatement}';
	console.log(sql);
	$("#sqlStatement").val(sql);
})

</script>


<form action="<c:url value="/query" />" method="post">
	<input type="hidden" id="token" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <b>SQL statement:</b><br>
    <textarea id = "sqlStatement" name="sqlStatement" cols=60 rows=8></textarea>
    <br>
    <br>
    <input type="submit" value="Execute" />
</form>

<b>SQL result:</b><br>
 <table cellpadding="5" border="1">
   ${message}
 </table>