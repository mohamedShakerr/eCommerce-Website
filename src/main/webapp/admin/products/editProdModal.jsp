<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Modal -->
<div class="modal fade" id="editProdModal">
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
                            <input type="text" value="" class="form-control form-control-line">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-12">Price</label>
                        <div class="col-md-12">
                            <input type="text" value=""
                                   class="form-control form-control-line">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-12">Quantity</label>
                        <div class="col-md-12">
                            <input type="text" placeholder="50"
                                   value="" class="form-control form-control-line">
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="col-sm-12">Category</label>
                        <div class="col-sm-12">
                            <select class="form-select shadow-none form-control-line">
                                <option>cables</option>
                                <option>cards</option>
                                <option>consoles</option>
                                <option>games</option>
                                <option>headsets</option>
                                <option>joysticks</option>
                                <option>thumbsticks</option>
                                <option>vr</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="form-label col-md-12">Main Image</label>
                        <div class="col-md-12">
                            <input type="file" accept="image/*"
                                   class="form-control form-control-sm" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="form-label col-md-12">Albums</label>
                        <div class="col-md-12">
                            <input type="file" accept="image/*"
                                   class="form-control form-control-sm" multiple>
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



<%--                    <div class="mb-3">--%>
<%--                        <label for="formFileSm" class="form-label">main image</label>--%>
<%--                        <input class="form-control form-control-sm" id="formFileSm" type="file">--%>
<%--                    </div>--%>
                </form>
            </div>
            <div class="modal-footer" style="background-color: #5c636a">
                <button type="button" class="btn btn-danger"  style="color: white" data-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-primary">Update Product</button>
            </div>
        </div>
    </div>
</div>