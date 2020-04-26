//显示提示信息
showMsg();
//Loading页面
document.onreadystatechange=function () {
          if (document.readyState=="complete"){
               loadingFade();
          }
}


function cleanError() {
     var errorMsg=document.getElementById("error_msg");
     errorMsg.innerHTML="";
}
function delUserAjax(obj) {
     var aa=document.getElementById('tr_'+obj);
     aa.remove();
     var ajax=new XMLHttpRequest();
     ajax.open('get',context_path+'/delbyajax.do?user_id='+obj,true);
     ajax.send();
}
function checkUserName() {
     var account=document.getElementById('account_input');
     var xmlHttpRequest=new XMLHttpRequest();
     xmlHttpRequest.open('get',context_path+'/cheklquser.do?user_login='+account.value,true);
     xmlHttpRequest.send();
     xmlHttpRequest.onreadystatechange=function () {
               if(xmlHttpRequest.readyState==4){
                    if (xmlHttpRequest.status==200){
                         var msg=xmlHttpRequest.responseText;
                         document.getElementById('error_msg').innerHTML=msg;
                    }
               }
     }

}
function confirmPassword() {
     var p1=document.getElementById('passwd_input_1').value;
     var p2=document.getElementById('passwd_input_2').value;
     if(p1!=p2)
          document.getElementById('error_msg').innerHTML="密码不一致！";
}
function showMsg() {
     document.getElementById('error_msg').innerHTML=error_msg;
}

function loadingFade() {
     var opacity=1;
     //var loadingPage=document.getElementById('loading');
     var loadingBackground=document.getElementById('loading_bg');
     var time=setInterval(function () {
          if (opacity<=0){
               clearInterval(time);
               //loadingPage.remove();
               $('#loading').remove();
          }

          loadingBackground.style.opacity=opacity;
          opacity-=0.4;
     },100);


}