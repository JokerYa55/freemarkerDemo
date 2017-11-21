<html>
=======================
===  County List   ====
=======================
<table>
<#list countries as country>
	<tr>
		<td>${country_index + 1}.</td> 
		<td>${country}</td>
	</tr>
</#list>
</table>
<table>
<#list users as user>
	<tr>
		<td>${user_index + 1}</td>
		<td>${user.id}</td>
	</tr>
</#list>
</table>
</html>