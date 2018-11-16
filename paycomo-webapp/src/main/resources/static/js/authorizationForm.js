$(document).ready(function() {
    $("#authorizationForm").submit(function(e){
        e.preventDefault(e);
        var request = {
            orderInformation: {
                billTo: {
                    firstName: $("#firstName").val(),
                    lastName: $("#lastName").val(),
                    address1: $("#billingAddress").val(),
                    locality: $("#billingCity").val(),
                    administrativeArea: $("#billingState").val(),
                    postalCode: $("#billingZip").val(),
                    email: $("#billingEmail").val(),
                    country: "US"
                },
                amountDetails: {
                    totalAmount: $("#paymentAmount").val(),
                    currency: "USD"
                }
            },
            paymentInformation: {
                card: {
                    number: $("#cardNumber").val()/*,
                    expirationYear: $("#expiration").val().substring(0,4),
                    expirationMonth: $("#expiration").val().substring(5,7),
                    securityCode: $("#securityCode").val()*/
                },
                tokenizedCard: {
                    expirationYear: $("#expiration").val().substring(0,4),
                    expirationMonth: $("#expiration").val().substring(5,7),
                    securityCode: $("#securityCode").val()
                }
            }
        };
        $.ajax
        ({
            type: "POST",
            url: '/requestSale',
            contentType: 'application/json',
            data: JSON.stringify(request),
            success: function (response) {
                console.log(response);
            }
        })
    });
});