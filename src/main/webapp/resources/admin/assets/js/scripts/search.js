function searchReportByCurrentMonth() {
    var url = "/admin/report/current-month"
    $.ajax({
        type: "GET",
        url: url,
        success: function(response) {
            console.log(response)
            var totalPage = $(response).find('#totalPage').val()
            var currentPage = $(response).find('#currentPage').val()
            $('table').replaceWith($(response).find('table'))
            // window.history.pushState("", "", url)
            $('#pagination').twbsPagination('destroy')
            $('#pagination').twbsPagination({
                totalPages:  totalPage,
                startPage: currentPage,
                hideOnlyOnePage:true,
                onPageClick: function (event, page) {
                    $.ajax({
                        type: "POST",
                        url: url,
                        data:{nameOrId: key, categoryId: cateId, publisherId: publId, page: page},
                        success: function(response) {
                            $('table').replaceWith($(response).find('table'))
                            window.history.pushState("", "", url+"?page="+page)
                        }
                    })
                }
            })
        },
        error: function () {
            alert("Lỗi")
        }
    })
}

function searchReportByCurrentDay() {
    var url = "/admin/report/today"
    $.ajax({
        type: "GET",
        url: url,
        success: function(response) {
            console.log(response)
            var totalPage = $(response).find('#totalPage').val()
            var currentPage = $(response).find('#currentPage').val()
            $('table').replaceWith($(response).find('table'))
            // window.history.pushState("", "", url)
            $('#pagination').twbsPagination('destroy')
            $('#pagination').twbsPagination({
                totalPages:  totalPage,
                startPage: currentPage,
                hideOnlyOnePage:true,
                onPageClick: function (event, page) {
                    $.ajax({
                        type: "POST",
                        url: url,
                        data:{nameOrId: key, categoryId: cateId, publisherId: publId, page: page},
                        success: function(response) {
                            $('table').replaceWith($(response).find('table'))
                            window.history.pushState("", "", url+"?page="+page)
                        }
                    })
                }
            })
        },
        error: function () {
            alert("Lỗi")
        }
    })
}

function searchReportByPreviousDay() {
    var url = "/admin/report/previous-day"
    $.ajax({
        type: "GET",
        url: url,
        success: function(response) {
            console.log(response)
            var totalPage = $(response).find('#totalPage').val()
            var currentPage = $(response).find('#currentPage').val()
            $('table').replaceWith($(response).find('table'))
            // window.history.pushState("", "", url)
            $('#pagination').twbsPagination('destroy')
            $('#pagination').twbsPagination({
                totalPages:  totalPage,
                startPage: currentPage,
                hideOnlyOnePage:true,
                onPageClick: function (event, page) {
                    $.ajax({
                        type: "POST",
                        url: url,
                        data:{nameOrId: key, categoryId: cateId, publisherId: publId, page: page},
                        success: function(response) {
                            $('table').replaceWith($(response).find('table'))
                            window.history.pushState("", "", url+"?page="+page)
                        }
                    })
                }
            })
        },
        error: function () {
            alert("Lỗi")
        }
    })
}

function searchReportByPreviousMonth() {
    var url = "/admin/report/previous-month"
    $.ajax({
        type: "GET",
        url: url,
        success: function(response) {
            console.log(response)
            var totalPage = $(response).find('#totalPage').val()
            var currentPage = $(response).find('#currentPage').val()
            $('table').replaceWith($(response).find('table'))
            // window.history.pushState("", "", url)
            $('#pagination').twbsPagination('destroy')
            $('#pagination').twbsPagination({
                totalPages:  totalPage,
                startPage: currentPage,
                hideOnlyOnePage:true,
                onPageClick: function (event, page) {
                    $.ajax({
                        type: "POST",
                        url: url,
                        data:{nameOrId: key, categoryId: cateId, publisherId: publId, page: page},
                        success: function(response) {
                            $('table').replaceWith($(response).find('table'))
                            window.history.pushState("", "", url+"?page="+page)
                        }
                    })
                }
            })
        },
        error: function () {
            alert("Lỗi")
        }
    })
}

function searchOrder(url) {
    var id = $('#idOrder').val()
    var status = $('#statusOrder').val()
    var startDate = $('#startDate').val()
    var endDate = $('#endDate').val()
    $.ajax({
        type: "POST",
        url: url,
        data: {id: id, status: status, startDate: startDate, endDate: endDate, page: 1},
        success: function(response) {
            $('table').replaceWith($(response).find('table'))
        },
        error: function () {
            alert("Lỗi")
        }
    }).done(function () {
        var totalPage = $(response).find('#totalPage').val()
        var currentPage = $(response).find('#currentPage').val()
        $('#pagination').twbsPagination('destroy')
        $('#pagination').twbsPagination({
            totalPages:  totalPage,
            startPage: currentPage,
            hideOnlyOnePage:true,
            onPageClick: function (event, page) {
                $.ajax({
                    type: "POST",
                    url: url,
                    data: {id: id, status: status, startDate: startDate, endDate: endDate, page: page},
                    success: function(response) {
                        $('table').replaceWith($(response).find('table'))
                        window.history.pushState("", "", url+"?page="+page)
                    }
                })
            }
        })
    })
}

function searchBook() {
    var url = "/admin/book/search"
    var key = $('#nameOrId').val()
    var statusBook = $('#s_status').val()
    var cateId = $('#s_cateId').val()
    var publId = $('#s_publId').val()
    $.ajax({
        type: "POST",
        url: url,
        data:{nameOrId: key, statusBook: statusBook, categoryId: cateId, publisherId: publId, page: 1},
        success: function(response) {
            var totalPage = $(response).find('#totalPage').val()
            var currentPage = $(response).find('#currentPage').val()
            $('table').replaceWith($(response).find('table'))
            window.history.pushState("", "", url)
            $('#pagination').twbsPagination('destroy')
            $('#pagination').twbsPagination({
                totalPages:  totalPage,
                startPage: currentPage,
                hideOnlyOnePage:true,
                onPageClick: function (event, page) {
                    $.ajax({
                        type: "POST",
                        url: url,
                        data:{nameOrId: key, statusBook: statusBook, categoryId: cateId, publisherId: publId, page: page},
                        success: function(response) {
                            $('table').replaceWith($(response).find('table'))
                            window.history.pushState("", "", url+"?page="+page)
                        }
                    })
                }
            })
        },
        error: function () {
            alert('Loi')
        }
    })
}

function searchCustomer() {
    var url = "/admin/customer/search"
    var key = $('#inputCustomerName').val()
    $.ajax({
        type: "POST",
        url: url,
        data:{key: key, page: 1},
        success: function(response) {
            $('table').replaceWith($(response).find('table'))
            window.history.pushState("", "", url)
        },
        error: function () {

        }
    }).done(function () {
        var totalPage = $(response).find('#totalPage').val()
        var currentPage = $(response).find('#currentPage').val()
        $('#pagination').twbsPagination('destroy')
        $('#pagination').twbsPagination({
            totalPages:  totalPage,
            startPage: currentPage,
            hideOnlyOnePage:true,
            onPageClick: function (event, page) {
                $.ajax({
                    type: "POST",
                    url: url,
                    data:{key: key, page: 1},
                    success: function(response) {
                        $('table').replaceWith($(response).find('table'))
                        window.history.pushState("", "", url+"?page="+page)
                    }
                })
            }
        })
    })
}

function searchCategory() {
    var url = "/admin/category/search"
    var key = $('#inputCategoryName').val()
    $.ajax({
        type: "POST",
        url: url,
        data:{key: key, page: 1},
        success: function(response) {
            $('table').replaceWith($(response).find('table'))
            window.history.pushState("", "", url)
        },
        error: function () {

        }
    }).done(function () {
        var totalPage = $(response).find('#totalPage').val()
        var currentPage = $(response).find('#currentPage').val()
        $('#pagination').twbsPagination('destroy')
        $('#pagination').twbsPagination({
            totalPages:  totalPage,
            startPage: currentPage,
            hideOnlyOnePage:true,
            onPageClick: function (event, page) {
                $.ajax({
                    type: "POST",
                    url: url,
                    data:{key: key, page: page},
                    success: function(response) {
                        $('table').replaceWith($(response).find('table'))
                        window.history.pushState("", "", url+"?page="+page)
                    }
                })
            }
        })
    })
}

function searchPublisher() {
    var url = "/admin/publisher/search"
    var name = $('#inputPublisherName').val()
    var address = $('#inputPublisherAddress').val()
    $.ajax({
        type: "POST",
        url: url,
        data:{name: name, address: address, page: 1},
        success: function(response) {
            $('table').replaceWith($(response).find('table'))
            window.history.pushState("", "", url)
        },
        error: function () {

        }
    }).done(function () {
        var totalPage = $(response).find('#totalPage').val()
        var currentPage = $(response).find('#currentPage').val()
        $('#pagination').twbsPagination('destroy')
        $('#pagination').twbsPagination({
            totalPages:  totalPage,
            startPage: currentPage,
            hideOnlyOnePage:true,
            onPageClick: function (event, page) {
                $.ajax({
                    type: "POST",
                    url: url,
                    data:{name: name, address: address, page: page},
                    success: function(response) {
                        $('table').replaceWith($(response).find('table'))
                        window.history.pushState("", "", url+"?page="+page)
                    }
                })
            }
        })
    })
}



