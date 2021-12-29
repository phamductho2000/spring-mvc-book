    function addToWishlist(id) {
        $.ajax({
            type: 'POST',
            url: "/them-vao-yeu-thich",
            data: {bId: id},
            success: function (response) {
                if (response == "NOT_LOGIN") {
                    $('#signin-modal').modal('show')
                }
                if (response == "EXIST") {
                    alert("Sản phẩm đã tồn tại trong yêu thích")
                }
                if (response == "SUCCESS") {
                    $("#myToastWishlist").toast({delay: 1000});
                    $("#myToastWishlist").toast('show')
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(jqXHR, errorThrown);
            }
        })
    }

    function removeItemWishlist(id) {
        $.ajax({
            type: "GET",
            url: "/tai-khoan/yeu-thich/xoa/" + id,
            dataType: "html",
            success: function (response) {
                $("#main-whishlist").replaceWith($(response).find("#main-whishlist"))
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(jqXHR, errorThrown);
            }
        })
    }



