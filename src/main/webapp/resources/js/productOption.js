$(".op").on("click",".opv",function(){
    console.log("콘솔");
    let va='<input type="text" name="optionValue">'
    $(this).before(va);
})
let last = 0;
let m =2;
$(".op").on("click",".opc",function(){
    if(last ==2){
        alert("옵션은 최대 3개까지만 가능합니다");
        return;
    }
    console.log("콘솔2");
    let na='<div class="op offset-md-'+m+'">'
    +'OptionName:<input type="text" name="optionName">'
    +'OptionValue :<input type="text" name="optionValue">'
    +'<button type="button" class="opv">벨류 추가</button>'
    +'<button type="button" class="opc">새로운 옵션</button>'
    +'</div>'
    $(this).last().after(na);
    m +=2;
    last++;
})
$(".oi").click(function(){
    let a= '<div class="op">'
	
    +'<div>'
    +'OptionName:<input type="text" name="optionName">'
    +'OptionValue :<input type="text" name="optionValue">'
    +'<button type="button" class="opv">벨류 추가</button>'
    +'<button type="button" class="opc">새로운 옵션</button>'
    +'</div>'
    +'</div>'
    $(".op").after(a);
})