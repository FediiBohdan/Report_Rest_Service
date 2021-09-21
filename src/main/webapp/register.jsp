<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>
<form method="post" action="/register">
<table style="width: 559px; height: 469px;">
<tbody>
<tr>
<td style="width: 210.375px;"><label for="nickname">nickname: </label></td>
<td style="width: 332.625px;"><input id="nickname" name="nickname" type="text" /></td>
</tr>
<tr>
<td style="width: 210.375px;"><label for="name">name: </label></td>
<td style="width: 332.625px;"><input id="name" name="name" type="text" /></td>
</tr>
<tr>
<td style="width: 210.375px;"><label for="surname">surname: </label></td>
<td style="width: 332.625px;"><input id="surname" name="surname" type="text" /></td>
</tr>
<tr>
<td style="width: 210.375px;"><label for="secondname">secondname: </label></td>
<td style="width: 332.625px;"><input id="secondname" name="secondname" type="text" /></td>
</tr>
<tr>
<td style="width: 210.375px;"><label for="mail">mail: </label></td>
<td style="width: 332.625px;"><input id="mail" name="mail" type="text" /></td>
</tr>
<tr>
<td style="width: 210.375px;"><label for="password">password: </label></td>
<td style="width: 332.625px;"><input id="password" name="password" type="text" /></td>
</tr>
<tr>
<td style="text-align: center; width: 549px;" colspan="2"><input type="submit" value="Register" /></td>
</tr>
</tbody>
</table>
</form>
</body>
</html>
