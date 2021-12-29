

    function addToCart(id) {
        var quantity = $('#qtyProduct').val()
        if (quantity == null) {
            quantity = 0
        }
        $.ajax({
            type: "POST",
            url: "/them-vao-gio/" + id,
            data: {quantity: quantity},
            success: function (response) {
                $("#header_user").replaceWith($(response).find("header"))
                $("#myToast").toast({delay: 1000});
                $("#myToast").toast('show')
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(jqXHR, errorThrown);
            }
        })
    }

    function removeItemCart(id) {
        $.ajax({
            type: "GET",
            url: "/xoa-san-pham-trong-gio-hang/" + id,
            dataType: "html",
            success: function (response) {
                $("#main_cart").replaceWith($(response).find(".main"))
                $("#header_user").replaceWith($(response).find("header"))
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(jqXHR, errorThrown);
            }
        })
    }

    function removeItemCartDropDown(id) {
        $.ajax({
            type: "GET",
            url: "/xoa-san-pham-trong-gio-hang/" + id,
            dataType: "html",
            success: function (response) {
                $("#header_user").replaceWith($(response).find("header"))
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(jqXHR, errorThrown);
            }
        })
    }

    function updateCart() {
        const quantys = []
        $('.table-cart tbody tr').each(function () {
            var value = parseInt($(this).find('td #quanty').val())
            quantys.push(value)
        })
        $.ajax({
            type: 'POST',
            url: '/cap-nhat-gio',
            data: {myQuantys: quantys},
            traditional: true,
            success: function (response) {
                $("#main_cart").replaceWith($(response).find(".main"))
                $('#cart_dropdown').replaceWith($(response).find('#cart_dropdown'))
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(jqXHR, errorThrown);
            }
        })
    }

    function applyVoucher() {
        var code = $('#voucher').val()
        $.ajax({
            type: 'POST',
            url: "/ap-dung-voucher",
            data: {code: code},
            success: function (response) {
                $('.page-content').replaceWith($(response).find('.page-content'))
                $('#btnApplyVoucher').css("display", "none")
                $('#btnDisableVoucher').css("display", "block")
                $('#voucher').val(code)
                $('#voucher').attr("readonly", true);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(jqXHR, errorThrown);
            }
        })
    }




