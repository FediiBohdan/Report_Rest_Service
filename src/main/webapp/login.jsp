<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>
<form action="/login" method="post">
    <table style="width: 240px;">
        <tbody>
        <tr>
            <td style="width: 72.1094px;"><label for="loginField">Name: </label></td>
            <td style="width: 177px;"><input id="loginField" name="nickname" type="text" /></td>
        </tr>
        <tr>
            <td style="width: 72.1094px;"><label for="passwordField">Password: </label></td>
            <td style="width: 177px;"><input id="passwordField" name="password" type="password" /></td>
        </tr>
        <tr>
            <td style="text-align: center; width: 255.109px;" colspan="2"><input type="submit" value="Log in" /></td>
        </tr>
        </tbody>
    </table>
</form>
<form action="/register" method="post">
    <table style="width: 254px; height: 21px;">
        <tbody>
        <tr style="height: 21px;">
            <td style="text-align: center; width: 244px; height: 21px;" colspan="2"><input type="submit" value="Register" /></td>
        </tr>
        </tbody>
    </table>
</form>

</body>
</html>
