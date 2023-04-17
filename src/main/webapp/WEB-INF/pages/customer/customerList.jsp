<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>

<section id="customers">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Customer List</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>Number</th>
                                <th>Customer Name</th>                                
                                <th>Email</th>
                                <th>Phone</th>
                                <th>Balance</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Iteramos cada elemento de la lista de clientes -->
                            <c:forEach var="customer" items="${customers}" varStatus="status" >
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${customer.name} ${customer.lastName}</td>
                                    <td>${customer.email}</td>
                                    <td>${customer.phone}</td>
                                    <td><fmt:formatNumber value="${customer.balance}" type="currency"/> </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletController?action=edit&idCustomer=${customer.idCustomer}"
                                           class="btn btn-warning">
                                            <i class="fa-solid fa-user-pen"></i></i> Edit
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>        
            </div>      

            <!--Inicio Tarjetas para los totales-->
            <div class="col-md-3">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>Total Balance</h3>
                        <h6 class="display-6">
                            <fmt:formatNumber value="${totalBalance}" type="currency" />
                        </h6>
                    </div>
                </div>

                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Total Customers</h3>
                        <h4 class="display-4">
                            <i class="fa-solid fa-user-plus"></i> ${totalCustomers}
                        </h4>
                    </div>
                </div>        
            </div>
            <!--Fin Tarjetas para los totales-->
        </div>
    </div>
</section>

<jsp:include page="/WEB-INF/pages/customer/addCustomer.jsp"/>