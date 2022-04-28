<%--
  Created by IntelliJ IDEA.
  User: 贺潇峰
  Date: 2022/1/15
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/other/font-awesome-4.7.0/css/font-awesome.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/tool.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
    <title>登录页面</title>
    <script type="text/javascript">
        window.onload=function (){
            let login=document.getElementById('login');
            let l=login.children[0];
            let register=document.getElementById('register');
            let r=register.children[0];
            let middle=document.getElementsByClassName('middle');
            let mid=document.getElementsByClassName('mid');
            let foot=document.getElementsByClassName('foot');
            let midL=document.getElementsByClassName('midL');
            let delay=0.4;
            login.onclick=function (){
                if(!hasClass(l,'charge')){
                    toggleClass(l,'charge');
                    toggleClass(r,'charge');
                }
                middle[1].style.display='none';
                middle[0].style.display='flex';
                foot[1].style.display='none';
                foot[0].style.display='flex';
                for(let i=0;i<mid.length;i++){
                    midL[i].style.opacity=0;
                    mid[i].style.animation='move 0.5s '+(delay*i)+'s'+' linear forwards';
                }
            }
            register.onclick=function (){
                if(!hasClass(r,'charge')){
                    toggleClass(l,'charge');
                    toggleClass(r,'charge');
                }
                middle[0].style.display='none';
                middle[1].style.display='flex';
                foot[0].style.display='none';
                foot[1].style.display='flex';
                for(let i=0;i<midL.length;i++){
                    mid[i].style.opacity=0;
                    midL[i].style.animation='move 0.5s '+(delay*i)+'s'+' linear forwards';
                }
            }
            let eye=document.getElementsByClassName('eye');
            let password=document.getElementsByClassName('password');
            for(let i=0;i<eye.length;i++){
                eye[i].i=i;
                eye[i].onclick=function (){
                    toggleClass(this,'fa-eye-slash');
                    toggleClass(this,'fa-eye');
                    if(hasClass(this,'fa-eye'))
                        password[this.i].type='text';
                    if(hasClass(this,'fa-eye-slash'))
                        password[this.i].type='password';
                }
            }
        }
        $(function(){
            let logBtn=document.getElementById('logBtn');
            let registerBtn=document.getElementById('registerBtn');
            let user=document.getElementsByClassName('user');
            let password=document.getElementsByClassName('password');
            logBtn.onclick=function (){
                $.ajax("/Dormitory/login",{
                    type: 'post',
                    dataType: "json",
                    data: {user: user[0].value,password: password[0].value},
                    success: function(data){
                        if(data==0){
                            window.location='jsp/main.jsp';
                        }
                        else if(data==1){
                            alert('用户名和密码错误！');
                        }
                        else if(data==2){
                            alert('当前用户已经登录');
                        }
                    },
                    error: function(){
                        alert('出错了！');
                    }
                });
            }
            registerBtn.onclick=function (){
                $.ajax("/Dormitory/registerBtn",{
                    type: 'post',
                    dataType: "json",
                    data: {user: user[1].value,password: password[1].value},
                    success: function(data){
                        if(data==0){
                            alert('注册成功！');
                        }
                        else if(data==1){
                            alert('用户名已存在！');
                        }
                    },
                    error: function(){
                        alert('出错了！');
                    }
                });
            }
        });
    </script>
</head>
<body>
    <div class="container">
        <div class="head">
            <div id="login">
                <a href="javascript:;" class="charge">Login</a>
            </div>
            <div id="p"></div>
            <div id="register">
                <a href="javascript:;">Register</a>
            </div>
        </div>
        <div class="middle">
            <div class="text mid">
                <i class="fa fa-user"></i>
                <input type="text" class="user">
            </div>
            <div class="text mid">
                <i class="fa fa-lock"></i>
                <input type="password" class="password">
                <i class="fa fa-eye-slash eye"></i>
            </div>
        </div>
        <div class="middle middleLeft">
            <div class="text midL">
                <i class="fa fa-eercast"></i>
                <input type="text" class="user">
            </div>
            <div class="text midL">
                <i class="fa fa-meetup"></i>
                <input type="password" class="password">
                <i class="fa fa-eye-slash eye"></i>
            </div>
        </div>
        <div class="foot">
            <div class="mid"><button id="logBtn" >login</button></div>
            <a href="javascript:;" class="mid">Forget?</a>
        </div>
        <div class="foot footLeft">
            <div class="midL"><button id="registerBtn">register</button></div>
            <a href="javascript:;" class="midL">Return</a>
        </div>
    </div>
</body>
</html>