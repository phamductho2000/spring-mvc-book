
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
        $('.review-product-info').find("img").attr("src", "/resources/book_images/" + img)
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
            type: 'POST',
            url: "/danh-gia",
            data: {content: content, rate: rate, productId: productId},
            success: function (response) {
                alert("Cảm ơn bạn đã đánh giá về sản phẩm")
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(jqXHR, errorThrown);
            }
        })
    }

    $(document).on('input', '#inputImgReviewProduct', function () {
        var elem = document.createElement("img");
        elem.setAttribute("src", "/resources/book_images/147144.png");
        elem.setAttribute("height", "40px");
        elem.setAttribute("width", "40px");
        elem.setAttribute("alt", "#");
        $('#list-image-review').append(elem)

    })







