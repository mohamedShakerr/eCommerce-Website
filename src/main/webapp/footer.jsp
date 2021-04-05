<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!--====== Footer Style 5 Part Start ======-->
<section class="footer-style-5 pt-70 pb-100" style="background-color:#FAFAFA ">
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="footer-about mt-30">
                    <div class="desktop-logo text-center">
                        <a href="${pageContext.request.contextPath}">
                            <span class="shop-logo">
                                    <h3 style="color: #4726CA">
                                        <i class="fab fa-playstation"></i>
                                        <i class="fas fa-gamepad"></i>
                                    </h3>
                                </span>
                            <span class="shop-logo-text" >
                                    <h4 style="color: #4726CA">Unity</h4>
                            </span>
                        </a>
                    </div>

                    <p>Made with &copy; at <a href="#0">2021 by JETS G.M.W.SH. All Rights Reserved.</a>.</p>
                    <ul class="footer-social">
                        <li><a href="#0"><i class="lni lni-facebook-filled"></i></a></li>
                        <li><a href="#0"><i class="lni lni-twitter-filled"></i></a></li>
                        <li><a href="#0"><i class="lni lni-linkedin-original"></i></a></li>
                        <li><a href="#0"><i class="lni lni-instagram-original"></i></a></li>
                        <li><a href="#0"><i class="lni lni-whatsapp"></i></a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="footer-link-widget">
                    <div class="footer-link">
                        <h5 class="footer-title">My Account</h5>
                        <ul class="link">
                            <li><a href="${pageContext.request.contextPath}/profile">Profile</a></li>
                            <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
                        </ul>
                    </div>
                    <div class="footer-link">
                        <h5 class="footer-title">Information</h5>

                        <ul class="link">
                            <li><a href="${pageContext.request.contextPath}/aboutus">About Us</a></li>
                            <li><a href="${pageContext.request.contextPath}/contactus">Contact Us</a></li>
                        </ul>
                    </div>
                    <div class="footer-link">
                        <h5 class="footer-title">Categories</h5>

                        <ul class="link">
                            <li><a href="${pageContext.request.contextPath}/shop?cat=1">Consoles</a></li>
                            <li><a href="${pageContext.request.contextPath}/shop?cat=3">Joysticks</a></li>
                            <li><a href="${pageContext.request.contextPath}/shop?cat=2">Games</a></li>
                            <li><a href="${pageContext.request.contextPath}/shop?cat=4">VR</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-lg-3">
                <div class="footer-widget-subscribe">
                    <h5 class="footer-title">Stay in the loop</h5>
                    <p>Be the first to know when new products drop and get behind-the-scenes content straight.</p>

                    <div class="subscribe-form">
                        <form action="#">
                            <div class="single-form form-default">
                                <label>Enter your email address</label>
                                <div class="form-input">
                                    <input type="text" placeholder="user@email.com">
                                    <i class="mdi mdi-account"></i>
                                    <button class="main-btn primary-btn"><span class="mdi mdi-send"></span></button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!--====== Footer Style 5 Part Ends ======-->
<button onclick="topFunction()" id="myBtn" title="Go to top"><i class="fas fa-arrow-up"></i></button>

<style>
    #myBtn {
        display: none; /* Hidden by default */
        position: fixed; /* Fixed/sticky position */
        bottom: 20px; /* Place the button at the bottom of the page */
        right: 30px; /* Place the button 30px from the right */
        z-index: 99; /* Make sure it does not overlap */
        border: none; /* Remove borders */
        outline: none; /* Remove outline */
        background-color: #542DED; /* Set a background color */
        color: white; /* Text color */
        cursor: pointer; /* Add a mouse pointer on hover */
        padding: 10px; /* Some padding */
        font-size: 20px; /* Increase font size */
        border-radius: 50%;
        width: 50px;
        height: 50px;
        text-align:center;
    }

    #myBtn:hover {
        background-color: #260ba7; /* Add a dark-grey background on hover */
    }
</style>
<script>
    mybutton = document.getElementById("myBtn");

    // When the user scrolls down 20px from the top of the document, show the button
    window.onscroll = function() {scrollFunction()};

    function scrollFunction() {
        if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
            mybutton.style.display = "block";
        } else {
            mybutton.style.display = "none";
        }
    }

    // When the user clicks on the button, scroll to the top of the document
    function topFunction() {
        document.body.scrollTop = 0; // For Safari
        document.documentElement.scrollTop = 0; // For Chrome, Firefox, IE and Opera
    }
</script>
