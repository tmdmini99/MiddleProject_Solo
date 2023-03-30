
let count=0;
let cc=0;
let cu=0;
let co=0;

$("#optionBtn").click(function(){
    // if(co==1){
    //     alert("옵션 선택을 완료해주세요");
    //     return;
    // }
    let ab=$(this).prev();
    co++;
    console.log($("#optionBtn").attr("data-productNum"))
    console.log($("#optionBtn").attr("data-optionNum"))
    $.ajax({
        type :"POST",
        url : "./productOptionList",
        data :{
            productNum :$("#optionBtn").attr("data-productNum"),
            ref : 0,
            depth : 0

        },
        success :function(data){
            

            console.log("data :",data);
            
            $(".nasss").append(data);
            ab.children(".cartss").addClass("options");
            ab.children(".cartss").children(".opt").addClass("option");
            $(".opt").attr("data-count",count);
            let b= $(".opt").attr("data-count");
            //$(".opt").removeClass("opt");
            
            count++;
            // $(".nasss").on("change",".option"+b,function(){
            //     console.log("콘솔");
            //     console.log("value :",$(this).val());
            //     let a= $(this)
            //     $.ajax({
            //         type:"POST",
            //         url : "./productOptionList",
            //         data :{
            //             productNum :$("#optionBtn").attr("data-productNum"),
            //             ref : a.val(),
            //             depth : 1
            
            //         },
            //         success :function(data1){
            //             console.log("data1:",data1);
            //             console.log("this:",a);
            //             console.log("parent:",a.parent().next());

            //                 a.next().remove();
                        
                        
            //             a.parent().append(data1);
            //             $(".opt").addClass("opti"+cc);
            //             $(".opt").attr("data-count",cc);
            //             let c= $(".opt").attr("data-count");
            //            //$(".opt").removeClass("opt");
            //             cc++;
            //             $(".nasss").on("change",".opti"+c,function(){
            //                 let ca = $(this)
            //                 $.ajax({
            //                     type:"POST",
            //                     url : "./productOptionList",
            //                     data :{
            //                         productNum :$("#optionBtn").attr("data-productNum"),
            //                         ref : $(this).val(),
            //                         depth : 2
                        
            //                     },
            //                     success : function(data2){
            //                         ca.next().remove();
            //                         //ca.parent().next().remove(data2);
            //                         data2 = data2+'<input class="form-control text-center me-3" id="productEa" type="num" value="1" style="max-width: 3rem"  name="productEa"/>'
            //                         +'<button type="button" class="delc btn btn-outline-danger">옵션 삭제</button>'
            //                         ca.parent().append(data2);
            //                         co--;
            //                     }
            //                 })
            //             })
            //         }
            //     })
            // })
            // .then((response)=>response.text()).then((res)=>{
            //     res.text().trim()
            // })
        }
    })
    
})
$(".nasss").on("change",".option",function(){
    console.log("콘솔");
    console.log("value :",$(this).val());
    let a= $(this)
    $.ajax({
        type:"POST",
        url : "./productOptionList",
        data :{
            productNum :$("#optionBtn").attr("data-productNum"),
            ref : a.val(),
            depth : 1

        },
        success :function(data1){
            console.log("data1:",data1);
            console.log("this:",a);
            console.log("parent:",a.parent().next());

            a.next().remove();
            a.parent().append(data1);
            a.next().children(".opt").addClass("opti");
            $(".opt").attr("data-count",cc);
            let c= $(".opt").attr("data-count");
           //$(".opt").removeClass("opt");
            cc++;
            
        }
    })
})
$(".nasss").on("change",".opti",function(){
    let ca = $(this)
    $.ajax({
        type:"POST",
        url : "./productOptionList",
        data :{
            productNum :$("#optionBtn").attr("data-productNum"),
            ref : $(this).val(),
            depth : 2

        },
        success : function(data2){
            ca.nextAll().remove();
            //ca.parent().next().remove(data2);
            data2 = data2+'<input class="form-control text-center me-3 productEa" type="num" value="1" style="max-width: 3rem"  name="productEa"/>'
            +'<button type="button" class="delc btn btn-outline-danger">옵션 삭제</button>'
            
            ca.parent().append(data2);
        }
    })
})

$(".nasss").on("click",".delc",function(){
    console.log("del :",$(this).parent().parent().parent());
    
    $(this).parent().parent().remove();
})


{/* <div>
    <select class="form-select option1" name="categoryNum">
            <option  value="0" >${list[0].optionName} 선택</option>
            <c:forEach items="${list}" var="op">
                <option value="${op.optionNum}">${op.optionValue}</option>
            </c:forEach>
    </select>
    </div> */}


// $(".modal-body").on("click",function(){
//     console.log("콘솔");
//     console.log("value :",$(this).val());
// })

$("#deleteModal").click(function(){
   
 console.log($("#productNum").val());
    $("#delfrm").submit();
    $("#closeModal").click();
    
})
