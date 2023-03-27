let abc = true;
$(".cartBtn").click(function(){
    console.log("cart");
    let orderNum=[];
    $(".options").each(function(index,item){
        $(item).find(".opt").each(function(i,it){
           if($(it).val() == 0){
            alert("옵션을 선택해주세요");
            abc= false;
            return false;
           }
            console.log("it :",$(it).val());
            
            
        })
        if(abc == false){
            return false;
        }
        console.log("------------------");
    })
    if(abc == true){
        $(".options").each(function(index,item){
            $(item).find(".opt").each(function(i,it){
                orderNum.push($(it).val());

            })
            let ea = $(".productEa").val();
            $.ajax({
                type:"POST",
                url : "./cartAdd",
                traditional:true,
                data :{
                    orderNum :orderNum,
                    productNum :$("#optionBtn").attr("data-productNum"),
                    productEa : ea
        
                },
                success : function(data2){
                    
                }
            })
        })
    }
    
    
    
    
})