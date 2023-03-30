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

// const fileList = document.getElementById("fileList");
// const btn = document.getElementById("btn");




let clickCount=0;
let max=1;
let param='files';
let idx=0;

function setName(p){
    param=p;
}

function setMax(m){
    max=m;
}
function setCount(c){
    clickCount=c;
}


$("#fileList").on("click",".del",function(){
    clickCount--;
    $(this).parent().remove();

}) 
    


    


//update
    $(".deleteCheck").click(function(){
        if($(this).prop("checked")){
            let result = confirm("파일이 영구 삭제됩니다");
            let ch = $(this);
            if(result){
                //아직 ajax안에 들어가지 않았기때문에 $(".deleteCheck")객체 자기 자신
                let fileNum = $(this).val();
                //ajax 안에 있는 $(this)는 ajax 객체 자기 자신
                $.ajax({
                    type:'POST',
                    url:'./productFileDelete',
                    data:{
                        fileNum: fileNum
                    },
                    success:function(response){
                        if(response.trim()>0){
                            alert("삭제 완료");
                            //this : ajax 객체 자기자신
                            ch.parent().parent().remove();
                            console.log(ch);
                            clickCount--;
                        }else{
                            alert("삭제 실패<br> 관리자 문의 필요!");
                        }
                    },
                    error:function(){

                    }

                })
               
             }
        }
        else{
            
            if(clickCount==5){
                console.log(idx);
                
                idx--;
                $("#del"+idx).remove();
                return;
            }
           
            clickCount++;
        
        }
    });






$("#btn3").click(()=>{
    

    if(clickCount>=max){
                alert("파일 추가는"+max+"만큼만 가능합니다");
                return;
                
        }
            
    clickCount++;
    let child ='<div class="mb-3 input-group" id="del'+idx+'">';
    child=child+'<input type="file" class="form-control" name="'+param+'">'
    child=child+'<button type="button" class="del btn btn-outline-danger" data-id="del'+idx+'">X</button></div>'
    $("#fileList").append(child);

    idx++;
});



