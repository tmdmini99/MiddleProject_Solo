$(document).on('click',".cartDeleteBtn",function(){
    $.ajax({
        type:"POST",
        url : "./cartDelete",
        data :{
            index : $(this).attr("data-index")
        },
        success : function(data2){
            $(".cartLists").html(data2);
        }
    })

})