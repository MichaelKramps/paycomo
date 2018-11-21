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
                    /*number: $("#cardNumber").val(),
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

        $.ajax({
            type: "GET",
            url: '/requestFlexibleTokenKey',
            success: function (response) {
                getTokenizedCardNumber(response);
            }
        });



        var getTokenizedCardNumber = function(key){
            window.crypto.subtle.importKey(
                    "jwk",
                    {
                        kty: key.jwk.kty,
                        e: key.jwk.e,
                        n: key.jwk.n,
                        alg: "RSA-OAEP-256",
                        ext: true
                    },
                    { //these are the algorithm options
                        name: "RSA-OAEP",
                        hash: {name: "SHA-256"}
                    },
                    false, // key is not extractable
                    ["encrypt"] // key usage
                )
                .then(function(publicKey){
                    encryptCardWithPublicKey(key.keyId, publicKey);

                })
                .catch(function(err){
                    console.error(err);
                });
        };

        var encryptCardWithPublicKey = function(keyId, publicKey){
            console.log("array buffer");
            console.log(new TextEncoder().encode($("#cardNumber").val()));
            window.crypto.subtle.encrypt(
                {
                    name: "RSA-OAEP",
                },
                publicKey,
                new TextEncoder().encode($("#cardNumber").val())
            )
            .then(function(encryptedArrayBuffer){
                var encodedCard = new Uint8Array(encryptedArrayBuffer);
                console.log("encrypted array");
                console.log(encodedCard);

                getTokenFromCyberSource(keyId, new TextDecoder().decode(encodedCard));
            })
            .catch(function(err){
                console.error(err);
            });
        }

        var getTokenFromCyberSource = function(keyId, encodedCard){
            requestBody = {
                keyId: keyId,
                cardInfo: {
                    cardNumber: encodedCard,
                    cardExpirationMonth: $("#expiration").val().substring(5,7),
                    cardExpirationYear: $("#expiration").val().substring(0,4),
                    cardType: "001"
                }
            };

            $.ajax({
                type: "POST",
                url: "https://sandbox.api.visa.com/cybersource/payments/flex/v1/tokens?apikey=YBGSOBWEFWM92WLQUWLU21J4gj3HWPDvR5BoZToCYSUypqEsY",
                contentType: "application/json",
                data: JSON.stringify(requestBody),
                success: function(response){
                    console.log(response);
                }
            });
        }

//        $.ajax({
//            type: "POST",
//            url: '/requestSale',
//            contentType: 'application/json',
//            data: JSON.stringify(request),
//            success: function (response) {
//                console.log(response);
//            }
//        })
    });
});