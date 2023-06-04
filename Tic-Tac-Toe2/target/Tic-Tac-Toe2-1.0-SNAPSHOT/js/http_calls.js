function log_out(){
    $.ajax({
        type: "GET",
        url: "Login",
        data: {}
    });
}


function get_sessions(callBackFunction){
    const intervalID = setInterval(function () {
        $.ajax({
            url: 'SessionServlet',
            method: 'GET',
            success: function (response) {
                callBackFunction(response,intervalID)
            }
        });
    }, 1000);
}

function getUserTurn(id,callBackFunction){
    $.ajax({
        url: 'UserServlet',
        method: 'GET',
        data: {id: id},
        success: function (response){
            callBackFunction(response)
        }
    });
}


function pollForUpdates(callBackFunction) {
    const intervalID = setInterval(function() {
        $.ajax({
            url: 'GameServlet',
            method: 'GET',
            success: function (response){
                callBackFunction(response,intervalID)
            }
        });
    }, 1000);
}

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