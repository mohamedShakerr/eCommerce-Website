$(function() {

    var owner = $('#owner');
    var cardNumber = $('#cardNumber');
    var cardNumberField = $('#card-number-field');
    var CVV = $("#cvv");
    var mastercard = $("#mastercard");
    var confirmButton = $('#confirm-purchase');
    var visa = $("#visa");
    var amex = $("#amex");

    // Use the payform library to format and validate
    // the payment fields.

    cardNumber.payform('formatCardNumber');
    CVV.payform('formatCardCVC');


    cardNumber.keyup(function () {

        amex.removeClass('transparent');
        visa.removeClass('transparent');
        mastercard.removeClass('transparent');

        if ($.payform.validateCardNumber(cardNumber.val()) == false) {
            cardNumberField.addClass('has-error');
        } else {
            cardNumberField.removeClass('has-error');
            cardNumberField.addClass('has-success');
        }

        if ($.payform.parseCardType(cardNumber.val()) == 'visa') {
            mastercard.addClass('transparent');
            amex.addClass('transparent');
        } else if ($.payform.parseCardType(cardNumber.val()) == 'amex') {
            mastercard.addClass('transparent');
            visa.addClass('transparent');
        } else if ($.payform.parseCardType(cardNumber.val()) == 'mastercard') {
            amex.addClass('transparent');
            visa.addClass('transparent');
        }
    });

    confirmButton.click(function (e) {

        e.preventDefault();

        var isCardValid = $.payform.validateCardNumber(cardNumber.val());
        var isCvvValid = $.payform.validateCardCVC(CVV.val());

        if (owner.val().length < 5) {
            document.getElementById("ownerNameError").innerHTML = "Wrong owner name";
            document.getElementById("ownerNameError").style.display = "block";
        } else {
            document.getElementById("ownerNameError").innerHTML = "";
            document.getElementById("ownerNameError").style.display = "none";
        }

        if (!isCardValid) {
            document.getElementById("cardNumberError").innerHTML = "Wrong card number";
            document.getElementById("cardNumberError").style.display = "block";
        } else {
            document.getElementById("cardNumberError").innerHTML = "";
            document.getElementById("cardNumberError").style.display = "none";
        }


        if (!isCvvValid) {
            document.getElementById("CVVError").innerHTML = "Wrong CVV";
            document.getElementById("CVVError").style.display = "block";
        } else {
            document.getElementById("CVVError").innerHTML = "";
            document.getElementById("CVVError").style.display = "none";
        }
        var money = document.getElementById("money").value;
        if (money <= 0) {
            document.getElementById("moneyError").innerHTML = "Invalid value";
            document.getElementById("moneyError").style.display = "block";
        } else {
            document.getElementById("moneyError").innerHTML = "";
            document.getElementById("moneyError").style.display = "none";
        }
        if (isCardValid && isCvvValid && owner.val().length >= 5 && money >= 0) {
            // Everything is correct. Add your form submission code here.
            var cardData = {
                cardnumber: cardNumber.val(),
                cvv: CVV.val(),
                money: money
            };

            $.post("CreditCardServlet", cardData, function (data) {
                //var response = jQuery.parseJSON(data);
                location.replace("profile?userid=1");

            });
        }
    });
});
