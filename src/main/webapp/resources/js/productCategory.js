const btn =document.getElementById("btn");
const btn1 =document.getElementById("btn1");
let count =0;

btn.addEventListener("click",function(){
    
    if(count==1){
        alert("카테고리는 최대 2개까지만 가능합니다");
        return;
    }

    let ar ='<div><select class="form-select" name="categoryNum">'
			+'<option value="2" >컴퓨터</option>'
			+'<option value="3">노트북</option>'
			+'<option value="4">모니터</option>'
			+'<option value="5">휴대폰</option>'
			+'<option value="6">TV</option>'
			+'<option value="7">냉장고</option>'
			+'<option value="8">에어컨</option>'
			+'<option value="9">공기청정기</option>'
            +'</select><button type="button" class="btn btn-outline-danger del">카테고리 삭제</button></div>'
    
    
    
    
    $("#btn").before(ar);

    

    count++;
    
})
$("#catdiv").on("click",".del",function(e){
    if(count==0){
        alert("카테고리는 최소 하나이상 포함되어야 합니다");
    }else{
    $(this).parent().remove();
    count--;
}
})