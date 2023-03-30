$(".card").click(function(e){
    console.log(e.target.parentNode.parentNode);
    location.href="./productDetail?productNum="+e.target.parentNode.parentNode.getAttribute("data-num");
})