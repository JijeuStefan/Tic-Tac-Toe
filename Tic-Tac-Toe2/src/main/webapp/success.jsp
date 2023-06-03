<%@ page import="com.example.tictactoe2.Domain.User" %>
<%@ page import="com.example.tictactoe2.Controller.Listener.SessionListener" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Title</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="success.css">
    <script src="https://kit.fontawesome.com/61e4c47e6d.js" crossorigin="anonymous"></script>
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
            <table id="game-table">
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
                $.ajax({
                   type: "GET",
                   url: "login",
                   data: {}
                });
            });

            $(".select-button").click(function (){
                const cell_id = $(this).attr('id');
                if ($(this).is(':empty')){
                    $(this).html('S');
                }

            });
        });
    </script>
</body>
</html>
