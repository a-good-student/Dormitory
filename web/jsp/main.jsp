<%--
  Created by IntelliJ IDEA.
  User: 贺潇峰
  Date: 2022/1/6
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/other/font-awesome-4.7.0/css/font-awesome.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/tool.js"></script>
    <title>主界面</title>
    <style type="text/css">
        nav .containRight{
            flex-grow: 1;
            background-color: #fff;
        }
        nav .containRight iframe{
            width: 100%;
            height: 100%;
        }
        body{
            user-select: none;
        }
        nav .containLeft>div:last-child{
            transition: all 0.2s;
            border: 0;
        }
        nav .containLeft>div:last-child a:after{
            content: "";
        }
        nav .containLeft>div:last-child a{
            margin: 0;
        }
        nav .containLeft>div:last-child{
            text-align: center;
        }
        nav .containLeft>div:last-child i{
            color: rgba(179, 177, 176, 0.5);
            margin: 0;
        }
        nav .containLeft>div:last-child i:hover{
            color: #FF6700;
        }
    </style>
    <script type="text/javascript">
        window.onload=function (){
            fold();
            //给展示栏div绑定折叠单击事件
            function fold(){
                var containLeft=document.getElementById('containLeft');
                var lists=containLeft.children;
                var open=lists[0];
                //最后那个div属于侧边栏的开关，不需要添加折叠单击事件
                for(var i=0;i<lists.length-1;i++){
                    var pre=lists[i].children[0];
                    pre.onclick=function (){
                        toggleMenu(this.parentNode,'collapsed');
                        if(this.parentNode!==open&&!hasClass(open,'collapsed')){
                            toggleMenu(open,'collapsed');
                        }
                        open=this.parentNode;
                    }
                }
            }
            //切换菜单的折叠和显示状态
            function toggleMenu(obj){
                //切换前获取此时高度
                var begin=obj.offsetHeight;
                //切换par
                toggleClass(obj,'collapsed');//现在这个的用处就是用来获取高度了
                //切换后的高度
                var end=obj.offsetHeight;
                //要实现动态效果，需要将元素先重置为begin
                obj.style.height=begin+"px";
                //而后执行动画效果
                move(obj,'height',end,1,function (){
                    //因为内敛样式的优先级最高，完成功能后保留没有意义，还会影响下一步操作，所以需要将他删除
                    obj.style.height='';
                });
            }
            //控制展示栏伸缩
            var taskLeft=document.getElementsByClassName('fa-chevron-circle-left')[0];
            var taskRight=document.getElementsByClassName('fa-chevron-circle-right')[0];
            taskLeft.onclick=function (){
                var containLeft=document.getElementById('containLeft');
                var divs=containLeft.children;
                containLeft.style.width="40px";
                this.style.display='none';
                taskRight.style.display='';
                for(var i=0;i<divs.length;i++){
                    divs[i].style.width="40px";
                    divs[i].children[0].onclick=null;
                    //将打开的下拉框关闭，防止出现bug
                    if(!hasClass(divs[i],'collapsed')){
                        toggleClass(divs[i],'collapsed');
                    }
                }
            }
            taskRight.onclick=function (){
                var containLeft=document.getElementById('containLeft');
                var divs=containLeft.children;
                containLeft.style.width="200px";
                this.style.display='none';
                taskLeft.style.display='';
                for(var i=0;i<divs.length;i++){
                    divs[i].style.width="100%";
                    var t=divs[i].children;
                    fold();
                }
            }
        }
    </script>
</head>
<body>
<%
    if(session.getAttribute("admin")==null){
        response.getWriter().write("您没有登录,2秒后跳转到登录界面");
        response.setHeader("refresh","2;URL=../index.jsp");
%>
<%}else{%>
    <header>
        <div  class="projectName">
            <a href="javascript:;">宿舍管理系统</a>
        </div>
        <i class="fa fa-tasks" id="task"></i>
        <div class="projectTitle">
            <div class="userTools">
                <ul>
                    <a href="javascript:;" class="username">
                        <i class="fa fa-user-circle"></i>
                        <span><%=session.getAttribute("user") %></span>
                        <i class="fa fa-sort-desc"></i>
                    </a>
                    <li style="--x:0">
                        <a href="../html/css名片.html" target="iframe">
                            <i class="fa fa-user"></i> 个人中心
                        </a>
                    </li>
                    <li style="--x:1">
                        <a href="javascript:;">
                            <i class="fa fa-vimeo"></i> 升级VIP
                        </a>
                    </li>
                    <li style="--x:2">
                        <a href="./注销.jsp">
                            <i class="fa fa-sign-out"></i> 注销
                        </a>
                    </li>
                </ul>
            </div>
            <span>首页</span>
        </div>
    </header>
    <nav>
        <div class="containLeft" id="containLeft">
            <div class="collapsed">
                <a href="javascript:;">
                    <i class="fa fa-user-o"></i>
                    <span>学生管理</span>
                </a>
                <ul>
                    <li><a href="./students.jsp" target="iframe">学生信息</a></li>
                </ul>
            </div>
            <div class="collapsed">
                <a href="javascript:;">
                    <i class="fa fa-bookmark-o"></i>
                    <span>班级管理</span>
                </a>
                <ul>
                    <li><a href="./class.jsp" target="iframe">班级列表</a></li>
                </ul>
            </div>
            <div class="collapsed">
                <a href="javascript:;">
                    <i class="fa fa-table"></i>
                    <span>宿舍管理</span>
                </a>
                <ul>
                    <li><a href="./dorm.jsp" target="iframe">宿舍列表</a></li>
                    <li><a href="./repair.jsp" target="iframe">维修登记</a></li>
                </ul>
            </div>
            <div class="collapsed">
                <a href="javascript:;">
                    <i class="fa fa-file-text-o"></i>
                    <span>卫生管理</span>
                </a>
                <ul>
                    <li><a href="./dormHealth.jsp" target="iframe">宿舍卫生</a></li>
                    <li><a href="./studentHealth.jsp" target="iframe">学生卫生</a></li>
                </ul>
            </div>
            <div class="collapsed">
                <a href="javascript:;">
                    <i class="fa fa-users"></i>
                    <span>访客管理</span>
                </a>
                <ul>
                    <li><a href="./visitor.jsp" target="iframe">访客列表</a></li>
                </ul>
            </div>
            <div class="collapsed">
                <a href="javascript:;">
                    <i class="fa fa-user-md"></i>
                    <span>管理员管理</span>
                </a>
                <ul>
                    <li><a href="./administrator.jsp" target="iframe">管理员列表</a></li>
                </ul>
            </div>
            <div>
                <a href="javascript:;" id="clos">
                    <i class="fa fa-chevron-circle-left" title="关闭"></i>
                    <i class="fa fa-chevron-circle-right" title="打开" style="display: none"></i>
                </a>
            </div>
        </div>
        <div class="containRight">
            <iframe name="iframe" src="../html/css名片.html"></iframe>
        </div>
    </nav>
    <footer>
        <div>copyright Ⓒ2021-2022 版权所有</div>
    </footer>
<%}%>
</body>
</html>