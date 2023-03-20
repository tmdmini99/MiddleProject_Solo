
const frm = document.getElementById("frm");

let count=1;
let jsoncount=1;

    
    

$(".oi").click(function(){
    count++;
    let a= 
    '<div class="op">'
    +'OptionName:<input type="text" name="optionName" class="id'+ 1 +'">'
    +'OptionValue :<input type="text" name="optionValue" class="idx'+count+'">'
    +'<button type="button" class="opc" data-count="'+ count +'">새로운 옵션</button>'
    +'<button type="button" class="opdd">옵션 삭제</button>'
    +'</div>'
    $(".opi").append(a);
})

let va='<input type="text" name="optionValue">'
$(".op").click(function(){
    
})

$(document).on("click",".opv",function(e){
    
    
    $(this).before(va);
    
})


$("#frm").on("click",".opc",function(e){
    let na=
    '<div class="op offset-md-2">'
    +'OptionName:<input type="text" name="optionName">'
    +'OptionValue :<input type="text" name="optionValue" class="'+ 10*$(this).attr('data-count') +'">'
    +'<button type="button" class="opci" data-count="'+ 10*$(this).attr('data-count') +'">새로운 옵션</button>'
    +'<button type="button" class="opd">옵션 삭제</button>'
    +'</div>'
    $(this).parent().append(na);
})


$("#frm").on("click",".opci",function(e){
    let nas=
    '<div class="op offset-md-4">'
    +'OptionName:<input type="text" name="optionName">'
    +'OptionValue :<input type="text" name="optionValue" class="'+ 10*$(this).attr('data-count') +'">'
    +'<button type="button" class="opd">옵션 삭제</button>'
    +'</div>'   
    
    
    $(this).parent().append(nas);
    
   
})
$(document).on("click",'.opd',function(){
    

    $(this).parent().remove();
    
})
$(document).on("click",'.opdd',function(){
    if(count ==1){
        alert("옵션은 최소 한개이상 포함되어야합니다");
        return;
    }
    $(this).parent().remove();
    count--;
})
$("#btn").click(function(){
    let ar = $(".idx2").val();
    
    let jsonArr = [{"optionName" : $("#idx1").val(), "optionValue" : $(".idx2").val(),sub:[{"optionName":"size","optionValue":128},{"optionName":"size","optionValue":64}]}
]


    $("#json1").val(JSON.stringify(jsonArr));
    $("#frm").submit();
})