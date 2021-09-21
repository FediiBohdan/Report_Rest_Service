<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>
<form action="/register-confirm" method="post">
    <table style="width: 264px; height: 469px;">
        <tbody>
        <tr>
            <td style="width: 94.5938px;"><label for="nickname">nickname: </label></td>
            <td style="width: 177px;"><input id="nickname" name="nickname" type="text" /></td>
        </tr>
        <tr>
            <td style="width: 94.5938px;"><label for="name">name: </label></td>
            <td style="width: 177px;"><input id="name" name="name" type="text" /></td>
        </tr>
        <tr>
            <td style="width: 94.5938px;"><label for="surname">surname: </label></td>
            <td style="width: 177px;"><input id="surname" name="surname" type="text" /></td>
        </tr>
        <tr>
            <td style="width: 94.5938px;"><label for="secondname">secondname: </label></td>
            <td style="width: 177px;"><input id="secondname" name="secondname" type="text" /></td>
        </tr>
        <tr>
            <td style="width: 94.5938px;"><label for="mail">mail: </label></td>
            <td style="width: 177px;"><input id="mail" name="mail" type="text" /></td>
        </tr>
        <tr>
            <td style="width: 94.5938px;"><label for="password">password: </label></td>
            <td style="width: 177px;"><input id="password" name="password" type="text" /></td>
        </tr>
        <tr>
            <td style="text-align: center; width: 277.594px;" colspan="2"><input type="submit" value="Register" /></td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
