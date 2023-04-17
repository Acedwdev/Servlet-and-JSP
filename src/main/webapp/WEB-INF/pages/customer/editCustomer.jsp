<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/459ac70d11.js" crossorigin="anonymous"></script>

        <title>Edit Customer Information</title>
    </head>
    <body>
        <!--Cabecero-->
        <jsp:include page="/WEB-INF/pages/body/header.jsp"/>

        <form action="${pageContext.request.contextPath}/ServletController?action=update&idCustomer=${customer.idCustomer}"
              method="POST" class="was-validated">

            <!--Botones de Navegacion -->
            <jsp:include page="/WEB-INF/pages/body/editNavButton.jsp"/>

            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Edit Customer</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="name">Name</label>
                                        <input class="form-control" name="name" required value="${customer.name}">
                                        <!--<h:inputText class="form-control" name="name" required value="${customer.name}"/>-->
                                    </div>
                                    <div class="form-group">
                                        <label for="lastName">Last Name</label>
                                        <input type="text" class="form-control" name="lastName" required value="${customer.lastName}"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="email">Email</label>
                                        <input type="email" class="form-control" name="email" required value="${customer.email}">
                                    </div>
                                    <div class="form-group">
                                        <label for="phone">Phone</label>
                                        <input type="tel" class="form-control" name="phone" required value="${customer.phone}">
                                    </div>
                                    <div class="form-group">
                                        <label for="balance">Balance</label>
                                        <input type="number" class="form-control" name="balance" required value="${customer.balance}" step="any">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

        </form>

        <!--Pie de Pagina-->
        <jsp:include page="/WEB-INF/pages/body/footer.jsp"/>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js" integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js" integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ" crossorigin="anonymous"></script>
    </body>
</html>
