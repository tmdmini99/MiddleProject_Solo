
const frm = document.getElementById("frm");

let count=0;
let a= 
    '<div class="op">'
    +'OptionName:<input type="text" name="optionName">'
    +'OptionValue :<input type="text" name="optionValue">'
    //+'<button type="button" class="opv">벨류 추가</button>'
    +'<button type="button" class="opc">새로운 옵션</button>'
    +'<button type="button" class="opdd">옵션 삭제</button>'
    +'</div>'
    
    

$(".oi").click(function(){
    $(".opi").append(a);
    count++;
})

let va='<input type="text" name="optionValue">'
$(".op").click(function(){
    console.log("콘솔11111");
})

$(document).on("click",".opv",function(e){
    console.log("콘솔");
    
    $(this).before(va);
    
})

let na=
    '<div class="op offset-md-2">'
    +'OptionName:<input type="text" name="optionName">'
    +'OptionValue :<input type="text" name="optionValue">'
    //+'<button type="button" class="opv">벨류 추가</button>'
    +'<button type="button" class="opci">새로운 옵션</button>'
    +'<button type="button" class="opd">옵션 삭제</button>'
    +'</div>'
    
$(document).on("click",".opc",function(e){
    
    console.log("콘솔2");
    
    $(this).parent().append(na);
    
    
})
let nas=
    '<div class="op offset-md-4">'
    +'OptionName:<input type="text" name="optionName">'
    +'OptionValue :<input type="text" name="optionValue">'
   //+'<button type="button" class="opv">벨류 추가</button>'
   +'<button type="button" class="opdd">옵션 삭제</button>'
    +'</div>'
$(document).on("click",".opci",function(e){
   
    
    
    $(this).parent().append(nas);
    
   
})
$(document).on("click",'.opd',function(){
    

    $(this).parent().remove();
    
})
$(document).on("click",'.opdd',function(){
    if(count ==0){
        alert("옵션은 최소 한개이상 포함되어야합니다");
    }
    $(this).parent().remove();
    count--;
})
