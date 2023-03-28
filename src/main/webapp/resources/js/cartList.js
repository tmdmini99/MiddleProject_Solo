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
            index : cartDeleteIndex
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
