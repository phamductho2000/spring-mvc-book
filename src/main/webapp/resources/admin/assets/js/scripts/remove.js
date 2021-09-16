$(function () {
    $('#pagination').twbsPagination('destroy')
    var url = ""
    var totalPage = $('#totalPage').val()
    var currentPage = $('#currentPage').val()
    if(window.location.href.includes("order")){
        url = "/admin/order"
    }
    if(window.location.href.includes("category")){
        url = "/admin/category"
    }
    if(window.location.href.includes("publisher")){
        url = "/admin/publisher"
    }
    if(window.location.href.includes("book")){
        url = "/admin/book"
    }
    if(window.location.href.includes("user")){
        url = "/admin/user"
    }
    $('#pagination').twbsPagination({
        totalPages:  totalPage,
        startPage: currentPage,
        hideOnlyOnePage:true,
        onPageClick: function (event, page) {
            $.ajax({
                type: "GET",
                url: url+"?page="+page,
                success: function(response) {
                    $('table').replaceWith($(response).find('table'))
                    window.history.pushState("", "", url+"?page="+page)
                },
                error: function () {

                }
            })
        }
    })
})

$("#removeBooks").click(function() {
        var current_url = window.location.href
        const ids = []
        var table = document.getElementById("Datatable")
        for (var i = 1, row; row = table.rows[i]; i++) {
            if ($(row).find(".checkId").prop('checked') == true) {
                var id = row.cells[1].innerHTML
                ids.push(id)
            }
        }
        if(ids.length == 0){
            alert("Bạn chưa chọn sản phẩm nào")
        }
        else{
            $.ajax({
                type : 'POST',
                url : '/admin/book/removeByIds',
                data : {currentUrl : current_url, ids : ids},
                traditional: true,
                success: function(response) {
                    $('table').replaceWith($(response).find('table'))
                },
                error: function () {

                }
            })
        }
    })

//product
function removeBook(id) {
    if (confirm("Bạn có chắc chắn muốn xóa?")) {
        var url = "/admin/book/remove"
        var current_url = window.location.href
        $.ajax({
            type: "POST",
            url: url,
            data:{currentUrl : current_url, id : id},
            success: function(response) {
                $('table').replaceWith($(response).find('table'))
            },
            error: function () {

            }
        })
    } else {

    }
}
//order
function removeOrder(id) {
    if (confirm("Bạn có chắc chắn muốn xóa?")) {
        var url = "/admin/order/remove"
        var current_url = window.location.href
        $.ajax({
            type: "POST",
            url: url,
            data:{currentUrl : current_url, id : id},
            success: function(response) {
                $('table').replaceWith($(response).find('table'))
            },
            error: function () {

            }
        })
    } else {

    }
}

//category
function removeCategory(id) {
    if (confirm("Bạn có chắc chắn muốn xóa?")) {
        var url = "/admin/category/remove"
        var current_url = window.location.href
        $.ajax({
            type: "POST",
            url: url,
            data:{currentUrl : current_url, id : id},
            success: function(response) {
                $('table').replaceWith($(response).find('table'))
            },
            error: function () {

            }
        })
    } else {

    }
}
//publisher
function removePublisher(id) {
    if (confirm("Bạn có chắc chắn muốn xóa?")) {
        var url = "/admin/publisher/remove"
        var current_url = window.location.href
        $.ajax({
            type: "POST",
            url: url,
            data:{currentUrl : current_url, id : id},
            success: function(response) {
                $('table').replaceWith($(response).find('table'))
            },
            error: function () {

            }
        })
    } else {

    }
}
//customer
function removeCustomer(id) {
    if (confirm("Bạn có chắc chắn muốn xóa?")) {
        var url = "/admin/customer/remove"
        var current_url = window.location.href
        $.ajax({
            type: "POST",
            url: url,
            data:{currentUrl : current_url, id : id},
            success: function(response) {
                $('table').replaceWith($(response).find('table'))
            },
            error: function () {

            }
        })
    } else {

    }
}
//removeVoucher
function removeVoucher(id) {
    if (confirm("Bạn có chắc chắn muốn xóa?")) {
        var url = "/admin/voucher/remove"
        var current_url = window.location.href
        $.ajax({
            type: "POST",
            url: url,
            data:{currentUrl : current_url, id : id},
            success: function(response) {
                $('table').replaceWith($(response).find('table'))
            },
            error: function () {

            }
        })
    } else {

    }
}
//
$('#inputImage').on('change', function (event) {
    if (this.files && this.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#imgProduct').attr('src', e.target.result);
        }
        reader.readAsDataURL(this.files[0]);
    }
})


