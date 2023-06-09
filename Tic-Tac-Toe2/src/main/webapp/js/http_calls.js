function log_out(){
    $.ajax({
        url: "Logout",
        method: 'GET',
        success: function (){
            $(location).prop("href","index.jsp");
        }
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

function getUserTurnSymbol(action,id,callBackFunction){
    $.ajax({
        url: 'UserServlet',
        method: 'GET',
        data: {action: action,id: id},
        success: function (response){
            callBackFunction(response)
        }
    });
}


function pollForUpdates(action,callBackFunction) {
    const intervalID = setInterval(function() {
        $.ajax({
            url: 'GameServlet',
            method: 'GET',
            data: {action: action},
            success: function (response){
                callBackFunction(response,intervalID)
            }
        });
    }, 1000);
}

function make_move(action,cell_id,symb){
    $.ajax({
        url: "GameServlet",
        method: 'POST',
        data: {action:action,id:cell_id,symb:symb}
    })
}