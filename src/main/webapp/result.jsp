<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <meta charset="UTF-8">
    <title>Search Result</title>
</head>

<body>
      <!-- Nav Bar -->
      <nav class="navbar navbar-dark bg-black">
        <div class="container">
          <span class="navbar-brand mb-0 h1"><img src="img/greet.gif" width="154" height="55"></span>
           <a href="logout" class="btn btn-outline-danger" role="button">Logout</a>
        </div>
      </nav>

      <!-- Profile Page -->
      <div class="col-lg-8 mx-auto p-3 py-md-5">
        <header class="d-flex align-items-center pb-3 mb-5 border-bottom">
          <span class="fs-4"><Strong>Hello, Happy to See you</Strong></span>
          <br>
        </header>

    <!--Business Logic-->

            <%
                // retrieve your list from the request, with casting
                if(request.getAttribute("searchResult")!=null)
                 {
                  ArrayList<String> list = (ArrayList<String>) request.getAttribute("searchResult");
                  Iterator iterator = list.iterator();
                  // print the information about every category of the list
                  while(iterator.hasNext())
                   {
                      //out.println(iterator.next());
                      ArrayList searchResult = (ArrayList)iterator.next();

            %>
            <div class="card col-10">
            <section class="vh-70" style="background-color: black;bg-light">
                        <div class="container py-5 h-100">
                          <div class="row d-flex justify-content-center align-items-center h-100">
                            <div class="col col-xl-10">
                              <div class="card mb-5" style="border-radius: 15px;">
                                <div class="card-body p-4">
                                  <div class="row">
                                    <div class="col-9">
                                       <h3 class="mb-3">
                                         <%= searchResult.get(1)%>
                                         <%= searchResult.get(2)%>
                                       </h3>
                                    </div>
                                    <div class="col-1"</div>
                                  </div>

                                   <p class="small mb-0"><i class="far fa-star fa-lg"></i> <span class="mx-2">|</span> Email:
                                    <strong>
                                      <%= searchResult.get(8)%>
                                    </strong>
                                  </p>
                                  <p class="small mb-0"><i class="far fa-star fa-lg"></i> <span class="mx-2">|</span> Phone:
                                    <strong>
                                      <%=searchResult.get(7)%>
                                    </strong>
                                  </p>
                                  <hr class="my-4">
                                  <div class="d-flex justify-content-start align-items-center">

                                    <p class="mb-0 text-uppercase"><i class="fas fa-cog me-2"></i> <span class="text-muted small">
                                        <%= searchResult.get(3)%>
                                      </span></p>
                                    <p class="mb-0 text-uppercase"><i class="fas fa-link ms-4 me-2"></i><span
                                        class="text-muted small">
                                        <%= searchResult.get(4)%>
                                      </span></p>
                                    <p class="mb-0 text-uppercase"><i class="fas fa-ellipsis-h ms-4 me-2"></i><span
                                        class="text-muted small">
                                        <%= searchResult.get(5)%>
                                      </span></p>
                                    <p class="mb-0 text-uppercase"><i class="fas fa-ellipsis-h ms-4 me-2"></i> <span
                                       class="text-muted small">
                                       <%= searchResult.get(6)%>
                                       </span></p>

                                    <p class="mb-0 text-uppercase"><i class="fas fa-ellipsis-h ms-4 me-2"></i> <span
                                       class="text-muted small">
                                       <%= searchResult.get(0)%>
                                       </span></p>
                                       <%
                                            }// while closed
                                           }// if closed
                                           else
                                            {
                                               System.out.println("Not found");
                                             }
                                       %>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </section>
                   <div class="card-body">
                   </div>
              </div>
        </div>
    </div>
</body>

</html>