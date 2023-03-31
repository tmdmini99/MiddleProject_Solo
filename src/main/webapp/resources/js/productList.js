$(".card").click(function(e){
    console.log(e.target.parentNode.parentNode);
    location.href="./productDetail?productNum="+$(this).attr("data-num");
})