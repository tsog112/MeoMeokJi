<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
 <form action="RegisterServlet1" method="post" onsubmit="return validateForm()">
        ID: <input type="text" name="id" required><br>
        비밀번호: <input type="password" name="password" id="password" required><br>
        비밀번호확인: <input type="password" name="passwordcheck" id="passwordcheck" required><br>
        이메일: <input type="email" name="email" required><br>
        닉네임: <input type="text" name="nickname" required><br>
        <input type="submit" value="가입">
       
    </form>
    
 <p id="passwordMismatch" style="color: red; display: none;">비밀번호가 일치하지 않습니다.</p>
<script>
function validateForm() {
    var password = document.getElementById("password").value;
    var passwordcheck = document.getElementById("passwordcheck").value;

    if (password !== passwordcheck) {
        document.getElementById("passwordMismatch").style.display = "block";
        return false; // 폼 제출을 막음
    } else {
        document.getElementById("passwordMismatch").style.display = "none";
        return true; // 폼 제출을 허용
    }
}
</script>
</body>
</html>