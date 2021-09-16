function addToCart(id) {
    var quantity = $('#qtyProduct').val()
    if(quantity == null){
        quantity = 0
    }
    $.ajax({
        type: "POST",
        url: "/them-vao-gio/"+id,
        data:{quantity: quantity},
        success: function(response) {
            $("#header_user").replaceWith( $(response).find("header"))
            $(".toast").toast({ delay: 1000 });
            $(".toast").toast('show')
        },
        error : function() {
            alert("Loi")
        }
    })
}
function removeItemCart(id) {
    $.ajax({
        type: "GET",
        url: "/xoa-san-pham-trong-gio-hang/"+id,
        dataType:"html",
        success: function(response) {
            $("#main_cart").replaceWith($(response).find(".main"))
        },
        error : function() {
            alert("Loi")
        }
    })
}
function updateCart() {
    const quantys = []
    $('.table-cart tbody tr').each(function () {
        var value = parseInt($(this).find('td #quanty').val())
        quantys.push(value)
    })
    console.log(quantys)
    $.ajax({
        type : 'POST',
        url : '/cap-nhat-gio',
        data : { myQuantys: quantys },
        traditional: true,
        success : function(response) {
            $("#main_cart").replaceWith($(response).find(".main"))
            $('#cart_dropdown').replaceWith($(response).find('#cart_dropdown'))
        },
        error : function() {
            alert("Loi")
        }
    })
}

function loadDetailOrder(orderId) {
    $.ajax({
        type : 'GET',
        url : "/tai-khoan/chi-tiet-don-hang/"+orderId,
        success : function(response) {
            $(".main-account").replaceWith($(response).find(".main-account"))
        },
        error : function() {
            alert("Loi")
        }
    })
}


$('#inputImage').on('change', function (event) {
    if (this.files && this.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#imgProduct').attr('src', e.target.result);
        }
        reader.readAsDataURL(this.files[0]);
    }
})

function showReviewProduct(id, name, img) {
    $('#idProduct').val(id)
    $('.review-product-info').find("span").replaceWith(name)
    $('.review-product-info').find("img").attr("src", "/resources/book_images/"+img)
    $('#reviewProduct').css("display", "block")
}

function closeReviewProduct() {
    $('#reviewProduct').css("display", "none")
}

function sendReviewProduct() {
    var rate = $("input[name='rate']:checked").val()
    var content = $('#contentReivew').val()
    var productId = $('#idProduct').val()
    $.ajax({
        type : 'POST',
        url : "/danh-gia",
        data :{content: content, rate: rate, productId: productId},
        success : function(response) {
            alert("Cảm ơn bạn đã đánh giá về sản phẩm")
        },
        error : function() {
            alert("Loi")
        }
    })
}




