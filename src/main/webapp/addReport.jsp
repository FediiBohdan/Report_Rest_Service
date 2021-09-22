<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<html>
<body>

<form method="post" action="/insert-report">
    <br>
    <label for="messageField">Report text:</label><br>
    <textarea name="message" id="messageField" cols="50" rows="10"> </textarea>
    <br>
    <input type="submit" value="Add">
</form>

</body>
</html>
