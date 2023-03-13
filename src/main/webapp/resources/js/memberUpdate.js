const memberId = document.getElementById("memberID");
const divId =document.getElementById("divId");
const memberPw = document.getElementById("memberPw");
const memberPw1 = document.getElementById("memberPw1");

let checks=[true,true,true,true,true,true];

memberPw.addEventListener("blur",function(){
    console.log("pw");
    if(memberPw.value.length<4 || memberPw.value.length>12){
        memberPw.classList.add("is-invalid");
        memberPw.classList.remove("is-valid");
        $("#pwCom").attr("class","invalid-feedback");
        $("#pwCom").text("PW는 4~12글자 이내로작성 가능합니다");
        checks[4]=false;
        
    }else{
        
        memberPw.classList.add("is-valid");
        memberPw.classList.remove("is-invalid");
        $("#pwCom").attr("class","valid-feedback");
        $("#pwCom").text("PW를 사용할수 있습니다");
        checks[4]=true;
        
    }
})
memberPw.addEventListener("change",function(){
    memberPw1.classList.add("is-invalid");
    memberPw1.classList.remove("is-valid");
    memberPw1.value="";
    $("#pwCom1").attr("class","invalid-feedback");
    $("#pwCom1").text("PW를 다시 입력하세요");
    checks[5]=false;
});
memberPw1.addEventListener("blur",function(){
    if(memberPw.value == memberPw1.value){
        memberPw1.classList.add("is-valid");
        memberPw1.classList.remove("is-invalid");
        $("#pwCom1").attr("class","valid-feedback");
        $("#pwCom1").text("PW가 일치합니다");
        checks[5]=true;
    }else{
        memberPw1.classList.add("is-invalid");
        memberPw1.classList.remove("is-valid");
        $("#pwCom1").attr("class","invalid-feedback");
        $("#pwCom1").text("PW가 일치하지않습니다");
        checks[5]=false;
    }
})


$("#memberName").blur(function(){
    if($("#memberName").val().length>0){
        checks[0]=true;
    }
    else{
        checks[0]=false;
    }
})
$("#memberAddress").blur(function(){
    if($("#memberAddress").val().length>0){
        checks[1]=true;
    }
    else{
        checks[1]=false;
    }
})
$("#memberPhone").blur(function(){
    if($("#memberPhone").val().length>0){
        checks[2]=true;
    }
    else{
        checks[2]=false;
    }
})
$("#memberEmail").blur(function(){
    if($("#memberEmail").val().length>0){
        checks[3]=true;
    }
    else{
        checks[3]=false;
    }
})
$("#btn1").click(function(){
    console.log(checks.includes("false"));
    if(!checks.includes(false)){
        console.log("성공");
        $("#frm").submit();
    }
    else{
        console.log("실패");
        alert("모든 사항을 입력하세요");
    }
})


