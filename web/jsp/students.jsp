<%--
  Created by IntelliJ IDEA.
  User: 贺潇峰
  Date: 2022/1/6
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/students.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/other/font-awesome-4.7.0/css/font-awesome.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/student.js"></script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/js/json2.js"></script>
    <title>students</title>
</head>
<body>
    <header>
        <span class="headerTitle">首页 / 学生信息</span>
        <a><i class="fa fa-graduation-cap"></i></a>
    </header>
    <nav>
        <div class="searchContain" id="searchContain">
            <input type="text" placeholder="请输入姓名">
            <input type="text" placeholder="请输入学号">
            <input type="text" placeholder="请输入班级编号">
            <input type="text" placeholder="请输入班级名">
            <button id="search_btn"><i class="fa fa-search"></i></button>
        </div>
    </nav>
    <div class="middle">
        <div>
            <button id="add">
                <i class="fa fa-plus"></i>
                添加
            </button>
            <button id="download">
                <i class="fa fa-cloud-download"></i>
                导出
            </button>
            <span>共有数据：<a id='count'></a>条</span>
        </div>
    </div>
    <div class="addContain" id="addContain">
        <div class="addWrapper" id="addWrapper">
            <div>
                <span>添加学生</span>
                <i class="fa fa-times" onclick="document.getElementById('addContain').style.height='0'";></i>
            </div>
            <div><span>学号：</span><div><input type="text" class="stu" placeholder="请输入学号"></div></div>
            <div><span>姓名：</span><div><input type="text" class="stu" placeholder="请输入姓名"></div></div>
            <div>
                <span>性别：</span>
                <div>
                    <label><input type="radio" name="check" value="男" checked>
                        男</label>
                    <label><input type="radio" name="check" value="女">
                        女</label>
                </div>
            </div>
            <div><span>年龄：</span><div><input type="text" class="stu" placeholder="请输入年龄"></div></div>
            <div><span>电话：</span><div><input type="text" class="stu" placeholder="请输入电话"></div></div>
            <div><span>班级编号：</span><div><input type="text" class="stu" placeholder="请输入班级编号"></div></div>
            <div><span>班级名：</span><div><input type="text" class="stu" placeholder="请输入班级名"></div></div>
            <div><span>寝室编号：</span><div><input type="text" class="stu" placeholder="请输入寝室编号"></div></div>
            <div>
                <button id="suit">提交</button>
                <button id="reset">重置</button>
            </div>
        </div>
    </div>
    <div class="addContain modContain" id="modContain">
        <div class="addWrapper" id="modWrapper">
            <div>
                <span>修改学生信息</span>
                <i class="fa fa-times" onclick="document.getElementById('modContain').style.width='0';document.getElementById('modContain').style.minWidth='0'"></i>
            </div>
            <div><span>学号</span><div><input type="text" class="mod"></div></div>
            <div><span>姓名</span><div><input type="text" class="mod"></div></div>
            <div>
                <span>性别</span>
                <div>
                    <label><input type="radio" name="mod_check" value="男" checked>
                        男</label>
                    <label><input type="radio" name="mod_check" value="女">
                        女</label>
                </div>
            </div>
            <div><span>年龄</span><div><input type="text" class="mod"></div></div>
            <div><span>电话</span><div><input type="text" class="mod"></div></div>
            <div><span>班级编号</span><div><input type="text" class="mod"></div></div>
            <div><span>班级名</span><div><input type="text" class="mod"></div></div>
            <div><span>寝室编号</span><div><input type="text" class="mod"></div></div>
            <div>
                <button id="mod" onclick="modifyStudent(this);">修改</button>
            </div>
        </div>
    </div>
    <footer>
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>学号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>电话</th>
                <th>班级编号</th>
                <th>班级名</th>
                <th>寝室编号</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody id="tbody"></tbody>
        </table>
        <div class="page" id="page">
            <a>首页</a>
            <a>上一页</a>
            <span id="pageNum">
                <a></a>
                <a></a>
                <a></a>
            </span>
            <a>下一页</a>
            <a>末页</a>
            <span id="Num"></span>
            <span>跳转至</span>
            <input type="text" id="goto">
            页
            <button id="go">GO!</button>
        </div>
    </footer>
</body>
</html>