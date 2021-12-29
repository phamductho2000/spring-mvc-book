$(document).ready(function () {
    'use strict';

    pagination()

    function pagination(){
        var url = new URL(window.location.href)
        var totalPage = $('#totalPage').val()
        var currentPage = $('#currentPage').val()
        $('#pagination').twbsPagination('destroy')
        $('#pagination').twbsPagination({
            totalPages: totalPage,
            startPage: currentPage,
            hideOnlyOnePage: true,
            onPageClick: function (event, page) {
                url.searchParams.set('page', page)
                $.ajax({
                    type: "GET",
                    url: url,
                    success: function (response) {
                        $('.products.mb-3').replaceWith($(response).find('.products.mb-3'))
                        window.history.pushState("obj", "", url)
                        scrollToTop()
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        console.log(jqXHR, errorThrown);
                    }
                })
            }
        })
    }

    $('.checkMoney').each(function () {
        $(this).on('click', function () {
            if ($(this).prop("checked")) {
                var string = $(this).attr('id').toString()
                var range = string.replace('range', '')
                var url = new URL(window.location.href)
                url.searchParams.set('price_range', range)
                url.searchParams.set('page', 1)
                filterProduct(url)
                $('.checkMoney').prop("checked", false)
                $(this).prop("checked", true)
            } else {
                var url = new URL(window.location.href)
                url.searchParams.delete('price_range')
                filterProduct(url)
            }
        })
    });

    $('.button-sort').each(function () {
        $(this).on('click', function () {
            if($(this).hasClass('button-active')){
                var url = new URL(window.location.href)
                url.searchParams.delete('sort')
                $(this).removeClass('button-active')
                filterProduct(url)
            } else {
                $('.button-sort').removeClass('button-active')
                let option = $(this).attr('id')
                $(this).addClass('button-active')
                var url = new URL(window.location.href)
                url.searchParams.set('sort', option)
                url.searchParams.set('page', 1)
                filterProduct(url)
            }
        })
    });

    $('input[type=checkbox][name=checkBoxPub]').change(function () {
        if ($(this).prop("checked")) {
            var id = $(this).val()
            var url = new URL(window.location.href)
            url.searchParams.set('publisher', id)
            url.searchParams.set('page', 1)
            filterProduct(url)
            $('.checkPublisher').prop("checked", false)
            $(this).prop("checked", true)
            return
        } else {
            var url = new URL(window.location.href)
            url.searchParams.delete('publisher')
            filterProduct(url)
        }
    })

    function filterProduct(url) {
        $.ajax({
            type: 'GET',
            url: url,
            success: function (response) {
                $('.products.mb-3').replaceWith($(response).find('.products.mb-3'))
                $('#page_navigation').replaceWith($(response).find('#page_navigation'))
                window.history.pushState("obj", "", url)
                pagination()
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(jqXHR, errorThrown);
            },
        })
    }

    function scrollToTop() {
        $('html, body').animate({
            'scrollTop': 0
        }, 800);
    }

})