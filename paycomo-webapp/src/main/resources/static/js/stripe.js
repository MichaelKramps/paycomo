var handler = StripeCheckout.configure({
  key: 'pk_test_3WEJFfd6Cixu6beZLDo4Zlef',
  image: 'https://stripe.com/img/documentation/checkout/marketplace.png',
  locale: 'auto',
  token: function(token) {
    // You can access the token ID with `token.id`.
    // Get the token ID to your server-side code for use.
    $.ajax({
        type: "POST",
        url: "/stripe",
        data: token
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