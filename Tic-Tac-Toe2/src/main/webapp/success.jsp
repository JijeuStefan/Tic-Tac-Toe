<%@ page import="com.example.tictactoe2.Domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Tic-Tac-Toe</title>
    <link rel="stylesheet" type="text/css" href="success.css">
    <script src="https://kit.fontawesome.com/61e4c47e6d.js" crossorigin="anonymous"></script>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/http_calls.js"></script>
</head>
<body>
<div id="header">
    <span id="log_out"><i class="fa-solid fa-right-from-bracket"></i> Logout</span>
</div>
<div id="content">
    <div id="announcer">
        <% User user = (User) session.getAttribute("user");
            out.println("Welcome " + user.getUsername() +" !");
        %>
        <div id="game_status">
        </div>
    </div>
    <div id="game">
        <span id="waiting">Waiting for the second player to login...</span>
        <table id="game_table" >
            <tr>
                <td><button class="select-button" id="0"></button></td>
                <td><button class="select-button" id="1"></button></td>
                <td><button class="select-button" id="2"></button></td>
            </tr>
            <tr>
                <td><button class="select-button" id="3"></button></td>
                <td><button class="select-button" id="4"></button></td>
                <td><button class="select-button" id="5"></button></td>
            </tr>
            <tr>
                <td><button class="select-button" id="6"></button></td>
                <td><button class="select-button" id="7"></button></td>
                <td><button class="select-button" id="8"></button></td>
            </tr>
        </table>
    </div>
</div>
<script>
    $(document).ready(function (){
        $("#log_out").click(function () {
            log_out();
            make_move('reset');
        })

        get_sessions(function (response){
            if ($.trim(response) === '1') {
                $('#waiting').show();
                $('#game_table').hide();
            } else if ($.trim(response) === '2') {
                $('#waiting').hide();
                $('#game_table').show();

                pollForUpdates('table',function (response){
                    for (let i = 0; i < 9; i ++){
                        $("#"+i).html(response[i].symbol);
                    }
                })

                pollForUpdates('status',function (response){
                    getUserTurnSymbol('symbol',<%=user.getId()%>,function (symbol){
                    if ($.trim(response)) {
                        if ($.trim(response) === "X" || $.trim(response) === "O") {
                            if ($.trim(symbol) === $.trim(response))
                                $("#game_status").html("You won!");
                            else
                                $("#game_status").html("You lost!");
                        } else
                            $("#game_status").html("Game is a draw!");
                        setTimeout(function() {
                            make_move('reset');
                            $("#game_status").html("");
                        }, 5000);
                    }})
                })
            }
        })

        $(".select-button").click(function (){
            if ($(this).is(':empty')){
                const cell_id = $(this).attr('id');
                getUserTurnSymbol('symbol',<%=user.getId()%>,function (symbol){
                    getUserTurnSymbol('turn',<%=user.getId()%>,function (turn){
                        if ($.trim(turn) === 'true') {
                            make_move('move',cell_id, $.trim(symbol));
                            $("#"+cell_id).html($.trim(symbol));
                        }
                        else
                            alert('Not your turn!');
                    })
                })
            }});

    })
</script>
</body>
</html>