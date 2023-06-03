function make_move(cell_id,symb){
    $.ajax({
        type: "POST",
        url: "move",
        data: {id:cell_id,symb:symb}
    })
}