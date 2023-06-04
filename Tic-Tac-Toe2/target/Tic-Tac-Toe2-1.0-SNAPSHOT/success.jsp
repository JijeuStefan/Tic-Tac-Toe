<%@ page import="com.example.tictactoe2.Domain.User" %>
<%@ page import="com.example.tictactoe2.Listener.SessionListener" %>
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
    </div>
    <div id="game">
        <span id="waiting">Waiting for the second player to login...</span>
        <table id="game-table" >
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
        })

        get_sessions(function (response,intervalID){
            if ($.trim(response) === '2') {
                $('#waiting').hide();
                $('#game-table').show();

                clearInterval(intervalID);

                pollForUpdates(function (response){
                    for (let i = 0; i < 9; i ++){
                        $("#"+i+"").html(response[i].symbol);
                    }
                })
            }
        })

        $(".select-button").click(function (){
            if ($(this).is(':empty')){


                <%--$.ajax({--%>
                <%--    url: 'UserServlet',--%>
                <%--    method: 'GET',--%>
                <%--    data: {id: <%=user.getId()%>},--%>
                <%--    success: function (response){--%>
                <%--        user_move(response)--%>
                <%--    }--%>
                <%--})--%>

                const cell_id = $(this).attr('id');
                const symbol = '<%= user.getSymbol()%>';
                make_move(cell_id, symbol, function (response) {
                    if ($.trim(response)) {
                        if ($.trim(response) === "X" || $.trim(response) === "O") {
                            if (symbol === $.trim(response))
                                alert('You won!');
                            else
                                alert('You lost!');
                        } else
                            $("#announcer").append('Game is a draw!');
                    }
                });
                $(this).html(symbol);

            }
        });

    })
</script>
</body>
</html>