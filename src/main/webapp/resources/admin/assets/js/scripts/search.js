    $('#limitShowOption').on('change', function () {
        var limit = $(this).val()
        var url = new URL(window.location.href)
        url.searchParams.set('page', 1)
        url.searchParams.set('limit', limit)
        search(url)
    })

    function scrollToTop() {
        $('html, body').animate({
            'scrollTop': 0
        }, 800);
    }

    function searchReport() {
        window.history.pushState('', '', '/admin/report/search')
        var url = new URL(window.location.href)
        var id = $('#idOrder').val()
        var status = $('#statusOrder').val()
        var startDate = $('#startDate').val()
        var endDate = $('#endDate').val()
        url.searchParams.set('id', id)
        url.searchParams.set('status', status)
        url.searchParams.set('startDate', startDate)
        url.searchParams.set('endDate', endDate)
        url.searchParams.set('limit', 10)
        search(url)
    }

    function searchReportByCurrentMonth() {
        window.history.pushState('', '', '/admin/report/search')
        var url = new URL(window.location.href)
        url.searchParams.set('optionDate', 'CURRENT_MONTH')
        url.searchParams.set('limit', 10)
        search(url)
    }

    function searchReportByCurrentDay() {
        window.history.pushState('', '', '/admin/report/search')
        var url = new URL(window.location.href)
        url.searchParams.set('optionDate', 'TODAY')
        url.searchParams.set('limit', 10)
        search(url)
    }

    function searchReportByPreviousDay() {
        window.history.pushState('', '', '/admin/report/search')
        var url = new URL(window.location.href)
        url.searchParams.set('optionDate', 'YESTERDAY')
        url.searchParams.set('limit', 10)
        search(url)

    }

    function searchReportByPreviousMonth() {
        window.history.pushState('', '', '/admin/report/search')
        var url = new URL(window.location.href)
        url.searchParams.set('optionDate', 'PREVIOUS_MONTH')
        url.searchParams.set('limit', 10)
        search(url)
    }

    function searchOrder() {
        window.history.pushState('', '', '/admin/order/search')
        var url = new URL(window.location.href)
        var id = $('#idOrder').val()
        var status = $('#statusOrder').val()
        var startDate = new Date($('#startDate').val())
        var endDate = new Date($('#endDate').val())
        url.searchParams.set('id', id)
        url.searchParams.set('status', status)
        url.searchParams.set('startDate', startDate)
        url.searchParams.set('endDate', endDate)
        url.searchParams.set('limit', 10)
        search(url)
    }

    function searchBook() {
        window.history.pushState('', '', '/admin/book/search')
        var url = new URL(window.location.href)
        var key = $('#nameOrId').val()
        var status = $('#s_status').val()
        var cateId = $('#s_cateId').val()
        var publId = $('#s_publId').val()
        url.searchParams.set('name', key)
        url.searchParams.set('status', status)
        url.searchParams.set('category_id', cateId)
        url.searchParams.set('publisher_id', publId)
        url.searchParams.set('limit', 10)
        search(url)
    }

    function searchCustomer() {
        window.history.pushState('', '', '/admin/customer/search')
        var url = new URL(window.location.href)
        var key = $('#inputCustomerName').val()
        url.searchParams.set('name', key)
        url.searchParams.set('limit', 10)
        search(url)
    }

    function searchCategory() {
        window.history.pushState('', '', '/admin/category/search')
        var url = new URL(window.location.href)
        var key = $('#inputCategoryName').val()
        url.searchParams.set('name', key)
        url.searchParams.set('limit', 10)
        search(url)
    }

    function searchPublisher() {
        window.history.pushState('', '', '/admin/publisher/search')
        var url = new URL(window.location.href)
        var name = $('#inputPublisherName').val()
        var address = $('#inputPublisherAddress').val()
        url.searchParams.set('name', name)
        url.searchParams.set('address', address)
        url.searchParams.set('limit', 10)
        search(url)

    }

    function searchVoucher() {
        window.history.pushState('', '', '/admin/voucher/search')
        var url = new URL(window.location.href)
        var code = $('#codeVoucher').val()
        var discount = $('#discountVoucher').val()
        var status = $('#statusVoucher').val()
        var expiration = $('#expirationDateVoucher').val()
        url.searchParams.set('code', code)
        url.searchParams.set('discount', discount)
        url.searchParams.set('status', status)
        url.searchParams.set('expiration', expiration)
        url.searchParams.set('limit', 10)
        search(url)

    }

    function searchUser() {
        window.history.pushState('', '', '/admin/user/search')
        var url = new URL(window.location.href)
        var key = $('#inputKeyUser').val()
        var status = $('#statusUser').val()
        var role = $('#roleUser').val()
        url.searchParams.set('name', key)
        url.searchParams.set('role', role)
        url.searchParams.set('status', status)
        url.searchParams.set('limit', 10)
        search(url)

    }

    function search(url) {
        $.ajax({
            type: "GET",
            url: url,
            success: function(response) {
                $('table').replaceWith($(response).find('table'))
                $('#page_navigation').replaceWith($(response).find('#page_navigation'))
                window.history.pushState("obj", "", url)
                pagination()
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(jqXHR, errorThrown);
            },
        })
    }

    function pagination() {
        $('#pagination').twbsPagination('destroy')
        var url = new URL(window.location.href)
        var totalPage = $('#totalPage').val()
        var currentPage = $('#currentPage').val()
        $('#pagination').twbsPagination({
            totalPages:  totalPage,
            startPage: currentPage,
            hideOnlyOnePage:true,
            onPageClick: function (event, page) {
                url.searchParams.set('page', page)
                $.ajax({
                    type: "GET",
                    url: url,
                    success: function(response) {
                        $('table').replaceWith($(response).find('table'))
                        window.history.pushState("", "", url)
                        scrollToTop()
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        console.log(jqXHR, errorThrown);
                    }
                })
            }
        })
    }
