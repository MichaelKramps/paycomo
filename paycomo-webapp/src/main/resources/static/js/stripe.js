var handler = StripeCheckout.configure({
  key: 'pk_test_3WEJFfd6Cixu6beZLDo4Zlef',
  image: 'https://stripe.com/img/documentation/checkout/marketplace.png',
  locale: 'auto',
  token: function(token) {
    // You can access the token ID with `token.id`.
    // Get the token ID to your server-side code for use.
    var cardData = {
       tokenId: token.id,
       object: token.object,
       card: {
           id: token.card.id,
           object: token.card.object,
           addressCity: token.card.address_city,
           addressCountry: token.card.address_country,
           addressLine1: token.card.address_line1,
           addressLine1Check: token.card.address_line1_check,
           addressLine2: token.card.address_line2,
           addressState: token.card.address_state,
           addressZip: token.card.address_zip,
           addressZipCheck: token.card.address_zip_check,
           brand: token.card.brand,
           country: token.card.country,
           cvcCheck: token.card.cvc_check,
           dynamicLast4: token.card.dynamic_last4,
           expMonth: token.card.exp_month,
           expYear: token.card.exp_year,
           funding: token.card.funding,
           last4: token.card.last4,
           name: token.card.name,
           tokenizationMethod: token.card.tokenization_method
       },
       clientIp: token.client_ip,
       created: token.created,
       email: token.email,
       livemode: token.livemode,
       type: token.type,
       used: token.used
   };

   console.log(cardData);

    $.ajax({
        type: "POST",
        url: "/stripe",
        contentType: "application/json",
        data: JSON.stringify(cardData)
    })
  }
});

document.getElementById('customButton').addEventListener('click', function(e) {
  // Open Checkout with further options:
  handler.open({
    name: 'Pay Como',
    description: '2 widgets',
    amount: 2000
  });
  e.preventDefault();
});

// Close Checkout on page navigation:
window.addEventListener('popstate', function() {
  handler.close();
});