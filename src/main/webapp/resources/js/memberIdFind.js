
$("#btn").click(function(){
    console.log($("#emailFind").val())
    fetch("./memberIdFind",{
        method:"post",
        headers :{
            "Content-type": "application/x-www-form-urlencoded"
        },
        body:"email="+$("#emailFind").val()
        
    }).then((response)=>response.text()).then((res)=>{
        console.log(res.trim()!=null)
        if(res.trim()!=""){
            $("#findId").html(res.trim());
            let button ='<a href="./memberLogin" class="btn btn-primary">로그인 페이지로 돌아가기</a>';
            $("#findId").append(button);
        }else{
            alert("등록되지 않은 ID입니다")
        }
    })
})