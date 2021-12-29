//remove products
$("#removeBooks").click(function() {
    var url = "/admin/book/removeByIds"
    AbstractRemoveMany(url)
})
//remove product
function removeBook(id) {
    var url = "/admin/book/remove"
    AbstractRemove(url, id)
}

//remove order
function removeOrder(id) {
    var url = "/admin/order/remove"
    AbstractRemove(url, id)
}

//remove category
function removeCategory(id) {
    var url = "/admin/category/remove"
    AbstractRemove(url, id)
}
//remove categories
$("#removeCategories").click(function() {
    var url = "/admin/category/removeByIds"
    AbstractRemoveMany(url)
})

//remove publisher
function removePublisher(id) {
    var url = "/admin/publisher/remove"
    AbstractRemove(url, id)
}
//remove publishers
$("#removePublishers").click(function() {
    var url = "/admin/publisher/removeByIds"
    AbstractRemoveMany(url)
})

//remove customer
function removeCustomer(id) {
    var url = "/admin/customer/remove"
    AbstractRemove(url, id)
}
//remove customers
$("#removeCustomers").click(function() {
    var url = "/admin/customer/removeByIds"
    AbstractRemoveMany(url)
})

//remove voucher
function removeVoucher(id) {
    var url = "/admin/voucher/remove"
    AbstractRemove(url, id)
}
//remove vouchers
$("#removeVouchers").click(function() {
    var url = "/admin/voucher/removeByIds"
    AbstractRemoveMany(url)
})


//abstract remove
function AbstractRemove(url, id) {
    if (confirm("Bạn có chắc chắn muốn xóa?")) {
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

function AbstractRemoveMany(url) {
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
        alert("Bạn chưa chọn mục nào")
    }
    else{
        if (confirm("Bạn có chắc chắn muốn xóa "+ids.length+" mục đã chọn ?")) {
            $.ajax({
                type: 'POST',
                url: url,
                data: {currentUrl: current_url, ids: ids},
                traditional: true,
                success: function (response) {
                    $('table').replaceWith($(response).find('table'))
                },
                error: function () {
                    alert("Fail")
                }
            })
        }
    }
}

function checkAll(){

    if ($('#checkAll').prop('checked')) {
        $('.input-check').prop('checked', true);
    } else {
        $('.input-check').prop('checked', false);
    }
}




