
let count=0;
let cc=0;
$("#optionBtn").click(function(){
    
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
            $(".opt").addClass("option"+count);
            $(".opt").attr("data-count",count);
            let b= $(".opt").attr("data-count");
            $(".opt").removeClass("opt");
            
            count++;
            $(".nasss").on("change",".option"+b,function(){
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
                        console.log("parent:",a.parent());
                        a.parent().append(data1);
                        $(".opt").addClass("opti"+cc);
                        $(".opt").attr("data-count",cc);
                        let c= $(".opt").attr("data-count");
                        $(".opt").removeClass("opt");
                        cc++;
                        $(".nasss").on("change",".opti"+c,function(){
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
                                    ca.parent().append(data2);
                                }
                            })
                        })
                    }
                })
            })
            // .then((response)=>response.text()).then((res)=>{
            //     res.text().trim()
            // })
        }
    })
    
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

