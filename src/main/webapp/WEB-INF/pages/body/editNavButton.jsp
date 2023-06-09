<section id="actions" class="py-4 mb-4 bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <a href="index.jsp" class="btn btn-ligth btn-block">
                    <i class="fas fa-arrow-left"></i> Back to Customers Control
                </a>
            </div>
            <div class="col-md-3">
                <button type="submit" class="btn btn-success btn-block">
                    <i class="fas fa-check"></i> Save Changes
                </button>
            </div>
            <div class="col-md-3">
                <a href="${pageContext.request.contextPath}/ServletController?action=delete&idCustomer=${customer.idCustomer}"
                   class="btn btn-danger btn-block">
                    <i class="fas fa-trash"></i> Delete Customer
                </a>
            </div>
        </div>
    </div>
</section>