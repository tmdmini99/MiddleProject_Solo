
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


$("#btn").click(function(){
    let a=[];
    $(".checkd").each(function(index,item){
        console.log($(item).val());
        a.push($(item).val());
    })
    $.ajax({
        type:"POST",
        url : "./memberRole",
        traditional:true,
        data :{
            ids : a
        },
        success : function(data){
            if(data>0){
                location.href="./memberStatus"
            }
        }
    })
})

