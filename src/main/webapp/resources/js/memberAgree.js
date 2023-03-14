let checkAll=document.getElementById("checkAll");
let checka=document.getElementsByClassName("checkd");
let check1=document.getElementById("check1");
let check2=document.getElementById("check2");
let check3=document.getElementById("check3");
const agree = document.getElementById("agree");

checkAll.addEventListener("click",function(){
    for(let i of checka){
        i.checked=checkAll.checked;
    }
})
for(let i of checka){
    
    i.addEventListener("click",function(){
        let result = true;
        for(let j of checka){
            if(!j.checked){
                result=j.checked;
                break;
            }
        }
        checkAll.checked=result;
    })
   
}


agree.addEventListener("click",function(){

    if(checkAll.checked){
        //alert('약관 동의함');
        location.href="./memberJoin";
    }else{
        alert('약관 동의 필요');
    }
});



