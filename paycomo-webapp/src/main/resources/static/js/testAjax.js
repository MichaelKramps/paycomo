$(document).ready(function() {
    $("form").submit(function(e){
        e.preventDefault(e);
        var request = {request: $("#request").val()};
        $.ajax
        ({
            type: "POST",
            url: '/testFormSubmission',
            contentType: 'application/json',
            data: JSON.stringify(request),
            success: function (response) {
                console.log(response);
            }
        })
    });
});