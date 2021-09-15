function  confirmdelet(index){
    var con;
    console.log(index);
    con = confirm();
    if (con == true){
        location.href = "delet?index=" + index;
    } else {
        return;
    }
}
function update(index){
    location.href = "update?index=" + index;
}
