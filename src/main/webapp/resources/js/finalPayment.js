$(".finalPayment").click(function(){
    
    let ab=$(this);
    
   
  BootPay.request({
      price: ab.attr("data-total"),
 
      
      application_id : "64326d1b3049c8001a6f97c5",
 
      name: 'LinkMall', 
      pg: 'nicepay',
      method: '',
      show_agree_window: 0, 
      items: [
          {
              item_name: '나는 아이템', 
              qty: 1, 
              unique: '2', 
              price: 1, 
          }
      ],
      order_id: '1', 
  }).error(function (data) {
      
      console.log(data);
  }).cancel(function (data) {
      
      console.log(data);
  }).close(function (data) {
      
      console.log(data);
  }).done(function (data) {
    
    
    
    
    
    
    let a=[];
    console.log($(this).attr("data-cart"))
    
    $(".optionNum").each(function(){
        a.push($(this).val());
    })

    $.ajax({
        type:"POST",
        url : "./cartOrder",
        traditional:true,
        data :{
            nums : a
        },
        success : function(data){
            if(data>0){
                let b="결제가 완료되었습니다<br>"
                +'<a href="../product/productList">리스트로 돌아가기</a>'
                $(".cartLists").html(b);
            }
        }
    })
      console.log(data);
  });

    
  //실제 복사하여 사용시에는 모든 주석을 지운 후 사용하세요
  
  
    
    
    
    
    
    
    
    
    
    
})