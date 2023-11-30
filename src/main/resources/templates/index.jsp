<%@ page language="java" contentType="text/html;
charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" />
<title>ログイン画面</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
    crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <div class="card card-container">
            <img id="profile-img" class="profile-img-card"
                src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
            <p id="profile-name" class="profile-name-card"></p>
            <form class="form-signin" method="post" action="LoginServlet">
                <span id="reauth-email" class="reauth-email"></span>
                <input
                    type="email" id="inputEmail" class="form-control"
                    placeholder="Email address" name="user-id" required autofocus>
                <input
                    type="password" id="inputPassword" class="form-control"
                    placeholder="Password" name="password" required>
                <button class="btn btn-lg btn-primary btn-block btn-signin"
                    type="submit" value="signin">ログイン</button>
            </form>
            <!-- /form -->
            <a href="#" class="forgot-password"> パスワードを忘れた方はこちら </a>
        </div>
        <!-- /card-container -->
    </div>
    <!-- /container -->
    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
        crossorigin="anonymous"></script>
</body>
</html>