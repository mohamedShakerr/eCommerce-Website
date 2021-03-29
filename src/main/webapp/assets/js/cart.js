$(document).ready( function(){
    updateCartTotal()
    updateCartCount();
});

function incProdQty(prodId, prodPrice){
    var prodCountInput = $("#item-"+prodId+"-qty-input");

    if( (parseInt(prodCountInput.val())+1) == 11 ){
        return;
    }

    $.ajax({
        url:"cartedit?edit=inc&prodId="+prodId,
        method:"POST",
        success(data){
            if(data === "success"){
                updateCartTotal();
                updateCartCount();
                prodCountInput.val( ( parseInt(prodCountInput.val())+1) );
                $("#total-item-price-"+prodId).text(  parseInt(prodCountInput.val()) * prodPrice );
                $("#item-qty-"+prodId).text( prodCountInput.val() );
            }else{

            }
        }
    });
}
function decProdQty(prodId, prodPrice){
    var prodCountInput = $("#item-"+prodId+"-qty-input");

    if( (parseInt(prodCountInput.val())-1) == 0 ){
        return ;
    }

    $.ajax({
        url:"cartedit?edit=dec&prodId="+prodId,
        method:"POST",
        success(data){
            if(data === "success"){
                updateCartTotal();
                updateCartCount();
                prodCountInput.val( ( parseInt(prodCountInput.val())-1) );
                $("#total-item-price-"+prodId).text(  parseInt(prodCountInput.val()) * prodPrice );
                $("#item-qty-"+prodId).text( prodCountInput.val() );
            }else{

            }
        }
    });
}

function deleteProduct(prodId){


    $.ajax({
        url:"cartedit?edit=delete&prodId="+prodId,
        method:"POST",
        success(data){
            if(data === "success"){
                //Update Cart Total
                updateCartTotal();
                updateCartCount();
                var deletedProd = $("#table-row-"+prodId);
                deletedProd.remove();
            }else{

            }
        }
    });
}

function updateCartTotal(){
    $.ajax({
        url:"cartedit?edit=updateTotal",
        method:"POST",
        success(data){
            $("#cart-total-price").text(data);
        }
    });
}

function updateCartCount(){
    $.ajax({
        url:"cartedit?edit=countTotal",
        method:"POST",
        success(data){
            $("#cart-count").text(data);
        }
    });
}
