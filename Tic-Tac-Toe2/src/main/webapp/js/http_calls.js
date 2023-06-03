function make_move(cell_id,symb,callBackFunction){
    $.ajax({
        type: "POST",
        url: "GameServlet",
        data: {id:cell_id,symb:symb},
        success: function (response){
            callBackFunction(response)
        }
    })
}

function pollForUpdates(callBackFunction) {
    setInterval(function() {
        $.ajax({
            url: 'GameServlet',
            method: 'GET',
            success: function (response){
                callBackFunction(response)
            },
            error: function(xhr, status, error) {
                alert("Ajax Polling Error!");
            }
        });
    }, 3000);
}