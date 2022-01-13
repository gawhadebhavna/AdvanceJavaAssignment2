<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<body style="background: url(img/login.jpg); background-size:cover;background-attachment:fixed">

    <!-- Nav Bar -->
    <nav class="navbar navbar-dark bg-black">
        <div class="container">
            <span class="navbar-brand mb-0 h1"><img src="img/greet.gif" width="154" height="55"></span>
            <a href="registration.jsp" class="btn btn-outline-success" role="button">Sign Up</a>
        </div>
    </nav>

    <!--Login Form-->

    <div class="container">
        <div class="row">
            <!--1st Col -->
            <div class="col">
            </div>

            <!--2nd Col -->
            <div class="col">
                <main class="form-signin">
                    <form action="login" class="pt-5" METHOD="post">
                        <h1 class="h3 mb-3 fw-normal">Member Login</h1>
                        <div></div>

                        <div class="form-floating bg-black">
                            <input type="email" class="form-control" name="email" placeholder="name@example.com" style="background-color:black">
                            <label for="floatingInput">Email address</label>
                        </div>
                        <div class="form-floating">
                            <input type="password" class="form-control" name="password" placeholder="Password" style="background-color:black">
                            <label for="floatingPassword">Password</label>
                            <span style="color:red;">
                            <%
                                if(null!=request.getAttribute("Msg")) {
                                 out.println(request.getAttribute("Msg"));
                                }
                            %>
                            </span>

                        </div>
                        <br>
                        <button class="w-50 btn btn-small btn-primary" type="submit">Sign in</button>
                        <p class="mt-5 mb-3 text-muted">&copy; 2021</p>
                    </form>
                </main>
            </div>

            <!--3rd Col -->
            <div class="col">
            </div>
        </div>
    </div>
</body>

</html>