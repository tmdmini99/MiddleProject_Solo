$(".card").click(function(e){
    console.log(e.target.parentNode);
    location.href="./productDetail?productNum="+e.target.parentNode.getAttribute("data-num");
})