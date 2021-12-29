<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<main class="main">
    <nav aria-label="breadcrumb" class="breadcrumb-nav border-0 mb-0">
        <div class="container">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="/trang-chu">Trang chử</a></li>
                <li class="breadcrumb-item"><a href="/lien-he">Liên hệ</a></li>
            </ol>
        </div><!-- End .container -->
    </nav><!-- End .breadcrumb-nav -->

    <div class="page-content">
        <div class="mb-5 google-map">
            <c:if test="${contact.link_map != null}">
                ${contact.link_map}
            </c:if>
            <c:if test="${contact.link_map == null}">
                <iframe src="" width="600" height="450" style="border:0; background-color: #5a6268" allowfullscreen="" loading="lazy"></iframe>
            </c:if>
        </div><!-- End #map -->
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="contact-box text-center">
                        <h3>Địa chỉ cửa hàng</h3>

                        <address>${contact.address}</address>
                    </div><!-- End .contact-box -->
                </div><!-- End .col-md-4 -->

                <div class="col-md-4">
                    <div class="contact-box text-center">
                        <h3>Liên hệ</h3>

                        <div><a href="mailto:#">${contact.email}</a></div>
                        <div><a href="tel:#">+${contact.phone}</a></div>
                    </div><!-- End .contact-box -->
                </div><!-- End .col-md-4 -->

                <div class="col-md-4">
                    <div class="contact-box text-center">
                        <h3>Social</h3>

                        <div class="social-icons social-icons-color justify-content-center">
                            <a href="${contact.link_fb}" class="social-icon social-facebook" title="Facebook" target="_blank"><i class="icon-facebook-f"></i></a>
                            <a href="${contact.link_twitter}" class="social-icon social-twitter" title="Twitter" target="_blank"><i class="icon-twitter"></i></a>
                            <a href="${contact.link_insta}" class="social-icon social-instagram" title="Instagram" target="_blank"><i class="icon-instagram"></i></a>
                            <a href="${contact.link_youtube}" class="social-icon social-youtube" title="Youtube" target="_blank"><i class="icon-youtube"></i></a>
                        </div><!-- End .soial-icons -->
                    </div><!-- End .contact-box -->
                </div><!-- End .col-md-4 -->
            </div><!-- End .row -->

            <hr class="mt-3 mb-5 mt-md-1">
<%--            <div class="touch-container row justify-content-center">--%>
<%--                <div class="col-md-9 col-lg-7">--%>
<%--                    <div class="text-center">--%>
<%--                        <h2 class="title mb-1">Gửi thắc mắc cho chúng tôi</h2><!-- End .title mb-2 -->--%>
<%--                        <br>--%>
<%--                    </div><!-- End .text-center -->--%>

<%--                    <form action="#" class="contact-form mb-2">--%>
<%--                        <div class="row">--%>
<%--                            <div class="col-sm-4">--%>
<%--                                <label for="cname" class="sr-only">Name</label>--%>
<%--                                <input type="text" class="form-control" id="cname" placeholder="Tên" required>--%>
<%--                            </div><!-- End .col-sm-4 -->--%>

<%--                            <div class="col-sm-4">--%>
<%--                                <label for="cemail" class="sr-only">Email</label>--%>
<%--                                <input type="email" class="form-control" id="cemail" placeholder="Email" required>--%>
<%--                            </div><!-- End .col-sm-4 -->--%>

<%--                            <div class="col-sm-4">--%>
<%--                                <label for="cphone" class="sr-only">Phone</label>--%>
<%--                                <input type="tel" class="form-control" id="cphone" placeholder="Số điện thoại">--%>
<%--                            </div><!-- End .col-sm-4 -->--%>
<%--                        </div><!-- End .row -->--%>

<%--                        <label for="csubject" class="sr-only">Subject</label>--%>
<%--                        <input type="text" class="form-control" id="csubject" placeholder="Tiêu đề">--%>

<%--                        <label for="cmessage" class="sr-only">Message</label>--%>
<%--                        <textarea class="form-control" cols="30" rows="4" id="cmessage" required placeholder="Nội dung"></textarea>--%>

<%--                        <div class="text-center">--%>
<%--                            <button type="submit" class="btn btn-outline-primary-2 btn-minwidth-sm">--%>
<%--                                <span>GỬI</span>--%>
<%--                                <i class="icon-long-arrow-right"></i>--%>
<%--                            </button>--%>
<%--                        </div><!-- End .text-center -->--%>
<%--                    </form><!-- End .contact-form -->--%>
<%--                </div><!-- End .col-md-9 col-lg-7 -->--%>
<%--            </div><!-- End .row -->--%>
        </div><!-- End .container -->
    </div><!-- End .page-content -->
</main><!-- End .main -->

