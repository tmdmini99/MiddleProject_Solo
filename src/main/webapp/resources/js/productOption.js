
const frm = document.getElementById("frm");

let count=1;
let jsoncount=1;
let count1 = 1;
    
    

$(".oi").click(function(){
    count++;
    count1++;
    let a= 
    '<div class="op">'
    +'OptionName:<input type="text" name="optionName" class="'+count1+'">'
    +'OptionValue :<input type="text" name="optionValue" class="idx'+count+'">'
    +'<button type="button" class="opc" data-count="'+ count +'" data-name="'+count1+'">새로운 옵션</button>'
    +'<button type="button" class="opdd">옵션 삭제</button>'
    +'</div>'
    $(".opi").append(a);
})

let va='<input type="text" name="optionValue">'


$(document).on("click",".opv",function(e){
    
    
    $(this).before(va);
    
})


$("#frm").on("click",".opc",function(e){
    let na=
    '<div class="op offset-md-2">'
    +'OptionName:<input type="text" name="optionName" class="'+10*$(this).attr('data-name')+'">'
    +'OptionValue :<input type="text" name="optionValue" class="idx'+ 10*$(this).attr('data-count') +'">'
    +'<button type="button" class="opci" data-count="'+ 10*$(this).attr('data-count') +'" data-name="'+10*$(this).attr('data-name')+'">새로운 옵션</button>'
    +'<button type="button" class="opd">옵션 삭제</button>'
    +'</div>'
    $(this).parent().append(na);
})


$("#frm").on("click",".opci",function(e){
    let nas=
    '<div class="op offset-md-4">'
    +'OptionName:<input type="text" name="optionName" class="'+10*$(this).attr('data-name')+'">'
    +'OptionValue :<input type="text" name="optionValue" class="idx'+ 10*$(this).attr('data-count') +'">'
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
    
    
    console.log("con :"+$(".opci").attr("data-count"));
    
    // let ar = document.getElementsByClassName($(".opci").attr("data-count"));
    // for(let ari of ar){
    //     console.log(ari.value);
    // }
    
    
    
    let jsonarq = []
    
    
    for(let i=1; i<=count; i++){
        let json1 ={};
        console.log("id"+$(".idx"+i).val());
        let json2={}
        let json3={}
        let jsonar = []
        $(".idx"+i*10).each(function(){
            console.log("id2"+$(this).val())
            
            jsonar.push($(this).val())
            let jsonArr = []  
            console.log("name1 :"+$("."+i*10).val())
           $(".idx"+i*100).each(function(){
                 
                jsonArr.push($(this).val())
                console.log("id3"+$(this).val())
                console.log("name2 :"+$("."+i*100).val())
                
                
            })
            json3["optionName"] = $("."+i*100).val()
            json3["optionValues"] =jsonArr
            

           
            

    })
            json2["optionName"] = $("."+i*10).val()
            json2["optionValues"] =jsonar
            json2["sub"] =json3     
    json1={
        "optionName" : $("."+i).val(),
        "optionValue": $(".idx"+i).val(),
        "sub" : json2
    }
    console.log(json1)
    jsonarq.push(json1);
}
    console.log(jsonarq);
    
    let sj = [{"optionName" : "dd", "optionValue" : "11", "sub":{"optionName" : "dd", "optionValue" : "11"}}]
    alert("확인");
    $("#json1").val(JSON.stringify(jsonarq));
    $("#frm").submit();
})
