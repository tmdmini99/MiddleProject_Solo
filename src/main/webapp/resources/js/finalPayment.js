$(".finalPayment").click(function(){
    let a=[];
    console.log($(this).attr("data-cart"))
    
    $(".optionNum").each(function(){
        a.push($(this).val());
    })

    $.ajax({
        type:"POST",
        url : "./cartOrder",
        traditional:true,
        data :{
            nums : a
        },
        success : function(data){
            if(data>0){
                let b="결제가 완료되었습니다<br>"
                +'<a href="../product/productList">리스트로 돌아가기</a>'
                $(".cartLists").html(b);
            }
        }
    })
})