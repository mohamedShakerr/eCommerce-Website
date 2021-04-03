<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Modal -->
<div class="modal fade" id="edirProdModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" style="background-color: #5c636a">
                <h5 class="modal-title" style="color: white">Edit Product</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <!--                    <span aria-hidden="true">×</span>-->
                    <i class="fas fa-window-close" style="color: white"></i>
                </button>
            </div>
            <div class="modal-body">
                <form class="form-horizontal form-material mx-2">
                    <div class="form-group">
                        <label class="col-md-12">Product Name</label>
                        <div class="col-md-12">
                            <input type="text" value="${myProduct.productName}" class="form-control form-control-line">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-12">Price</label>
                        <div class="col-md-12">
                            <input type="text" value="${myProduct.productPrice}"
                                   class="form-control form-control-line">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-12">Quantity</label>
                        <div class="col-md-12">
                            <input type="text" placeholder="50"
                                   value="${myProduct.quantity}" class="form-control form-control-line">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-12">Description</label>
                        <div class="col-md-12">
                            <textarea rows="5" class="form-control" style="resize: none">
                                <c:out value="${myProduct.description}" />
                            </textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer" style="background-color: #5c636a">
                <button type="button" class="btn btn-danger"  style="color: white" data-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-primary">Update Product</button>
            </div>
        </div>
    </div>
</div>