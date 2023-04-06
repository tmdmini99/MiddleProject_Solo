$(document).on('click',".cartDeleteBtn",function(){
    $.ajax({
        type:"POST",
        url : "./cartDelete",
        data :{
            num : $(this).attr("data-num")
        },
        success : function(data2){
            $(".cartLists").html(data2);
        }
    })

})
$(document).on('click',".cartDeleteBtns",function(){
    let cartDeleteIndex=[];
    $(".checkd").each(function(){
        if($(this).prop("checked")){
            console.log($(this).val());
            cartDeleteIndex.push($(this).val());
        }
    })
    $.ajax({
        type:"POST",
        url : "./cartDeletes",
        traditional:true,
        data :{
            nums : cartDeleteIndex
        },
        success : function(data){
            $(".cartLists").html(data);
        }
    })
})

$(document).on("click",".cartUpdate",function(){
    
    let a= '<input type="text" class="count" value="'+ $(this).attr("data-count")+'">'
    let b='<button type="button" data-count="'+$(this).attr("data-count")+'" data-num="'+$(this).attr("data-num")+'" class="btn btn-outline-info cartUpdateEnd">변경</button>';
    $(this).parent().prev().prev().prev().html(a);
    $(this).parent().html(b);
})
$(document).on("click",".cartUpdateEnd",function(){
    console.log("count",$(".count").val());
    console.log("num",$(this).attr("data-num"));
    $.ajax({
        type:"POST",
        url : "./cartUpdate",
        data :{
            count : $(".count").val(),
            num : $(this).attr("data-num")
        },
        success : function(data){
            $(".cartLists").html(data);
        }
    })
})




// let checkAll=document.getElementById("checkAll");
// let checka=document.getElementsByClassName("checkd");
// checkAll.addEventListener("click",function(){
//     for(let i of checka){
//         i.checked=checkAll.checked;
//     }
// })
// for(let i of checka){
    
//     i.addEventListener("click",function(){
//         let result = true;
//         for(let j of checka){
//             if(!j.checked){
//                 result=j.checked;
//                 break;
//             }
//         }
//         checkAll.checked=result;
//     })
   
// }

$(document).on("click","#checkAll",function(){
    if($("#checkAll").prop("checked")){
        $(".checkd").each(function(index,item){
            $(item).prop("checked",true);
        })
    }else{
        $(".checkd").each(function(index,item){
            $(item).prop("checked",false);
        })
    }
    
    
})


$(document).on("click",".checkd",function(){
    let result = true;
    $(".checkd").each(function(index,item){
        if(!$(item).prop("checked")){
            console.log("check")
            result = false;
            return false;
        }
           
        
    })
    $("#checkAll").prop("checked",result);
})

$(document).on('click', ".cartBuyBtns", function () { // 장바구니 구매 버튼 클릭 시 실행되는 함수
    let cartBuyIndex = []; // 선택한 상품의 옵션 번호를 저장할 배열
    let cartIndex = []; // 선택한 상품의 장바구니 번호를 저장할 배열
    $(".checkd").each(function () { // checkd 클래스를 가진 요소들을 반복문으로 순회
        if ($(this).prop("checked")) { // 만약 해당 요소가 체크되어 있다면
            console.log($(this).attr("data-optionNum")); // 해당 요소의 data-optionNum 속성값을 콘솔에 출력
            cartBuyIndex.push($(this).attr("data-optionNum")); // 해당 요소의 data-optionNum 속성값을 cartBuyIndex 배열에 추가
            cartIndex.push($(this).attr("data-num")); // 해당 요소의 data-num 속성값을 cartIndex 배열에 추가
        }
    })
    location.href = "./cartOrder?optionNums=" + cartBuyIndex + "&nums=" + cartIndex // 선택한 상품의 옵션 번호와 장바구니 번호를 쿼리스트링으로 cartOrder 페이지로 전달
    // $.ajax({ // ajax를 이용한 비동기 통신
    //     type:"POST", // 전송 방식은 POST
    //     url : "./cartOrder", // 요청할 url은 ./cartOrder
    //     traditional:true, // 배열을 전송할 때 jQuery의 기본 방식으로 전송하기 위해 traditional 속성을 true로 설정
    //     data :{ // 전송할 데이터
    //         optionNums : cartBuyIndex, // 선택한 상품의 옵션 번호를 담은 배열
    //         nums : cartIndex // 선택한 상품의 장바구니 번호를 담은 배열
    //     },
    //     success : function(data){ // 통신이 성공했을 때 실행되는 함수
    //         alret("주문이 완료되었습니다"); // 주문이 완료되었다는 알림창 출력
    //         location.href="../product/productList" // 상품 목록 페이지로 이동
    //     }
    // })
})

// 클릭 이벤트 리스너 등록
$(".inc").click(function () {
    // 클릭한 요소를 변수 a에 저장
    let a = $(this)
    // AJAX 요청
    $.ajax({
        type: "POST",
        url: "./cartM",
        traditional: true,
        // 전송할 데이터 설정
        data: {
            num: $(this).attr("data-num"), // data-num 속성값
            count: ($(this).prev().val() * 1 + 1) // 이전 형제 요소의 값에 1을 더한 값
        },
        // 요청이 성공했을 때 실행할 콜백 함수
        success: function (data) {
            // 이전 형제 요소의 값을 1 증가시킴
            a.prev().val((a.prev().val() * 1 + 1))
            // 현재 요소의 부모 요소의 부모 요소의 다음 요소의 텍스트를 변경함
            a.parent().parent().next().text(((a.prev().val())) * (a.attr("data-price")))
        }
    })
    // 콘솔에 출력
    console.log(($(this).prev().val() * 1 + 1));

})


$(".dec").click(function(){
    let a = $(this)
    $.ajax({
        type:"POST",
        url : "./cartP",
        traditional:true,
        data :{
            num : $(this).attr("data-num"),
            count : $(this).next().val()-1
        },
        success : function(data){
            a.next().val(a.next().val()-1)
            a.parent().parent().next().text((a.next().val())*(a.attr("data-price")))
        }
    })
    
})