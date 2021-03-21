// ========= Preloader
window.onload = function() {
    window.setTimeout(fadeout, 500);
}

function fadeout() {
    document.querySelector('.preloader').style.opacity = '0';
    document.querySelector('.preloader').style.display = 'none';
}

// ========= main-menu 11  activation
let mobileMenuOpen11 = document.querySelector('.mobile-menu-open-11');
let mobileMenuClose11 = document.querySelector('.close-mobile-menu-11');
let navbarSidebar11 = document.querySelector('.navbar-sidebar-11');
let overlay11 = document.querySelector('.overlay-11');
// ========= main-menu 11  activation
let menuToggle11 = document.querySelector('.menu-style-11 .menu-toggle');
menuToggle11.addEventListener('click', () => {
    menuToggle11.classList.toggle('active');
})
mobileMenuOpen11.addEventListener('click', () => {
    navbarSidebar11.classList.add('open');
    overlay11.classList.add('open')
})
mobileMenuClose11.addEventListener('click', () => {
    navbarSidebar11.classList.remove('open');
    overlay11.classList.remove('open')
})
overlay11.addEventListener('click', () => {
    navbarSidebar11.classList.remove('open');
    overlay11.classList.remove('open')
})

//======== tiny slider for header-4-active
tns({
    autoplay: true,
    autoplayButtonOutput: false,
    mouseDrag: true,
    gutter: 0,
    container: ".header-4-active",
    center: true,
    nav: true,
    controls: false,
    speed: 400,
    controlsText: [
        '<i class="lni lni-arrow-left-circle"></i>',
        '<i class="lni lni-arrow-right-circle"></i>',
    ],
    responsive: {
        0: {
            items: 1,
        },
    }
});

// =========== select-color-6 active
selectColor6 = document.querySelectorAll("#select-color-6 li");
for (var i = 0; i < selectColor6.length; i++) {
    selectColor6[i].onclick = function() {
        var el = selectColor6[0];
        while (el) {
            if (el.tagName === "LI") {
                el.classList.remove("active");
            }
            el = el.nextSibling;
        }
        this.classList.add("active");
    };
}

// =========== select-item-6 active
selectItem6 = document.querySelectorAll("#select-item-6 .single-item");
for (var i = 0; i < selectItem6.length; i++) {
    selectItem6[i].onclick = function() {
        var el = selectItem6[0];
        while (el) {
            if (el.tagName === "DIV") {
                el.classList.remove("active");
            }
            el = el.nextSibling;
        }
        this.classList.add("active");
    };
}

//====== counter up 
var cu = new counterUp({
    start: 0,
    duration: 2000,
    intvalues: true,
    interval: 100,
    append: " ",
});
cu.start();