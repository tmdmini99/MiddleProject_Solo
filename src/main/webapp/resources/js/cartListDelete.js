$(document).on('click',".cartDeleteBtn",function(){
    $.ajax({
        type:"POST",
        url : "./cartDelete",
        data :{
            num : $(this).attr("data-num")
        },
        success : function(data2){
            $(".cartLists").html(data2);
        }
    })

})
$(document).on('click',".cartDeleteBtns",function(){
    let cartDeleteIndex=[];
    $(".checkd").each(function(){
        if($(this).prop("checked")){
            console.log($(this).val());
            cartDeleteIndex.push($(this).val());
        }
    })
    $.ajax({
        type:"POST",
        url : "./cartDeletes",
        traditional:true,
        data :{
            nums : cartDeleteIndex
        },
        success : function(data){
            $(".cartLists").html(data);
        }
    })
})

$(document).on("click",".cartUpdate",function(){
    
    let a= '<input type="text" class="count" value="'+ $(this).attr("data-count")+'">'
    let b='<button type="button" data-count="'+$(this).attr("data-count")+'" data-num="'+$(this).attr("data-num")+'" class="btn btn-outline-info cartUpdateEnd">변경</button>';
    $(this).parent().prev().prev().prev().html(a);
    $(this).parent().html(b);
})
$(document).on("click",".cartUpdateEnd",function(){
    console.log("count",$(".count").val());
    console.log("num",$(this).attr("data-num"));
    $.ajax({
        type:"POST",
        url : "./cartUpdate",
        data :{
            count : $(".count").val(),
            num : $(this).attr("data-num")
        },
        success : function(data){
            $(".cartLists").html(data);
        }
    })
})




// let checkAll=document.getElementById("checkAll");
// let checka=document.getElementsByClassName("checkd");
// checkAll.addEventListener("click",function(){
//     for(let i of checka){
//         i.checked=checkAll.checked;
//     }
// })
// for(let i of checka){
    
//     i.addEventListener("click",function(){
//         let result = true;
//         for(let j of checka){
//             if(!j.checked){
//                 result=j.checked;
//                 break;
//             }
//         }
//         checkAll.checked=result;
//     })
   
// }

$(document).on("click","#checkAll",function(){
    if($("#checkAll").prop("checked")){
        $(".checkd").each(function(index,item){
            $(item).prop("checked",true);
        })
    }else{
        $(".checkd").each(function(index,item){
            $(item).prop("checked",false);
        })
    }
    
    
})


$(document).on("click",".checkd",function(){
    let result = true;
    $(".checkd").each(function(index,item){
        if(!$(item).prop("checked")){
            console.log("check")
            result = false;
            return false;
        }
           
        
    })
    $("#checkAll").prop("checked",result);
})
