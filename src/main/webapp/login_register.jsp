<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>
<form method="post" action="login-or-register">
    <table>
        <tr>
            <td><label for="loginField">Name: </label></td>
            <td><input id="loginField" type="text" name="login"></td>
        </tr>

        <tr>
            <td><label for="passwordField">Password: </label></td>
            <td><input id="passwordField" type="password" name="password"></td>
        </tr>

        <tr>
            <td colspan="2" style="text-align: center"><input type="submit" value="Log in"></td>
        </tr>

        <tr>
            <td colspan="2" style="text-align: center"><input type="submit" value="Register"></td>
        </tr>
    </table>

</form>
</body>
</html>
