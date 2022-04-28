//设置为全局变量，记录当前页数
var num=1;
//设置搜索框的变量
var sname="", sno="", classId="", className="";
//获取记录数
var count=0;
//根据记录数，可分为多少页
var pageNum=0;
$(function (){
    //获取记录数
    count=getMount();
    //根据记录数，可分为多少页
    pageNum=Math.ceil(count/6);
    //初始化
    setPage(num);
    //设置分页操作
    var page=document.getElementById("page");
    var page_aList=page.children;
    //首页
    page_aList[0].onclick=function(){
        if(num!=1){
            num=1;
            setPage(num);
            chargePage(num,pageNum);
        }
    }
    //上一页
    page_aList[1].onclick=function(){
        if(num>1){
            num-=1;
            setPage(num);
            chargePage(num,pageNum);
        }
    }
    //中间的数字栏
    chargePage(num,pageNum);
    //下一页
    page_aList[3].onclick=function(){
        if(num<pageNum){
            num+=1;
            setPage(num);
            chargePage(num,pageNum);
        }
    }
    //末页
    page_aList[4].onclick=function(){
        if(num!=pageNum&&pageNum!=0){
            num=pageNum;
            setPage(num);
            chargePage(num,pageNum);
        }
    }
    //输入跳转绑定函数
    var go=document.getElementById('go');
    go.onclick=function (){
        var gotoVal=document.getElementById('goto').value;
        for(var i=0;i<gotoVal.length;i++){
            if(gotoVal[i]<'0'||gotoVal[i]>'9'){
                alert('请输入正整数');
                return false;
            }
        }
        var gotoValue=parseInt(gotoVal);
        if(gotoValue>0&&gotoValue<=pageNum){
            setPage(gotoValue);
            num=gotoValue;
            chargePage(num,pageNum);
        }
        else{
            alert('请输入页码为1~'+pageNum);
        }
    }
    //搜索函数
    var search_List=document.getElementById('searchContain').children;
    var search_btn=document.getElementById('search_btn');
    search_btn.onclick=function (){
        sname=search_List[0].value;
        sno=search_List[1].value;
        classId=search_List[2].value;
        className=search_List[3].value;
        num=1;
        setPage(num);
        count=getMount();
        pageNum=Math.ceil(count/6);
        chargePage(num,pageNum);
    }
    //添加内容框函数
    var addContain=document.getElementById('addContain');
    document.getElementById('add').onclick=function (){
        addContain.style.height='100vh';
        addContain.style.backgroundColor='rgba(144, 142, 142, 0.5)';
    }
    //添加界面的提交按钮
    document.getElementById('suit').onclick=function (){
        var p=document.getElementsByClassName('stu');
        var check=document.getElementsByName('check');
        var sname=p[1].value, sno=p[0].value, classId=p[4].value, className=p[5].value;
        var ssex=check[0].checked?'男':'女', sage=p[2].value, sphone=p[3].value, dormitory=p[6].value;
        $.ajax("/Dormitory/addStudent", {
            type:"post",
            dataType:"json",
            data:{sno: sno,sname: sname,ssex: ssex,sage: sage,sphone: sphone,classId: classId,className: className,dormitory: dormitory},
            // 请求成功后的回调函数。
            success :function(data){
                //重新获取当前页
                setPage(num);
                //更新总记录数
                getMount();
                //更新末页，count不能获取到最新值，所以需要手动加一
                count+=1;
                pageNum=Math.ceil(count/6);
                alert('添加成功，当前记录'+count+'条');
            },
            // 请求出错时调用的函数
            error: function(){
                alert("发送失败");
            }
        });
    }
    //添加提交框重置
    document.getElementById('reset').onclick=function (){
        var p=document.getElementsByClassName('stu');
        for(var i=0;i<p.length;i++)p[i].value="";
    }
});
//获取总记录数
function getMount() {
    var m=0;
    $.ajax("/Dormitory/mount", {
        type:"post",
        dataType:"json",
        data:{sname: sname,sno: sno,classId: classId,className: className},
        //同步请求 ，true为异步请求data无法赋值给全局变量，所以修改为同步；
        async: false,
        // 请求成功后的回调函数。
        success :function(data){
            document.getElementById('count').innerHTML=data;
            document.getElementById('Num').innerHTML="共"+Math.ceil(data/6)+"页";
            m=data;
        }
    });
    return m;
}
//分页调整
function setPage(num){
    $.ajax("/Dormitory/import", {
        type:"post",
        dataType:"json",
        data:{num: num,sname: sname,sno: sno,classId: classId,className: className},
        // 请求成功后的回调函数。
        success :function(data){
            var item;
            $("#tbody").empty();//移除所有子元素
            $.each(data,function(i,student){
                item = setBody(student);
                //防止页数少于3时出现bug
                if(pageNum<=3){
                    chargePage(1,pageNum);
                }
                else{
                    chargePage(num,pageNum);
                }
                $("#tbody").append(item);
            });
        },
        // 请求出错时调用的函数
        error: function(){
            alert("发送失败");
        }
    });
}
//删除记录
function deleteStudent(obj){
    var par=obj.parentNode.parentNode;
    $.ajax("/Dormitory/deleteStudent", {
        type:"post",
        dataType:"json",
        data:{id: par.id},
        // 请求成功后的回调函数。
        success :function(data){
            //更新总记录数
            getMount();
            //更新末页，count不能获取到最新值，所以需要手动加一
            count-=1;
            pageNum=Math.ceil(count/6);
            if(pageNum<num) num=pageNum;
            //重新获取当前页
            setPage(num);
            alert('删除一条记录，当前剩余'+count+'条');
        },
        // 请求出错时调用的函数
        error: function(){
            alert("发送失败");
        }
    });
}
//修改记录框赋值
function modify(obj){
    //获取对应tr
    var par=obj.parentNode.parentNode;
    var tds=par.children;//获取所有td值
    //修改框
    var mods=document.getElementsByClassName('mod');
    var check=document.getElementsByName('mod_check');
    var modBtn=document.getElementById('mod');
    //弹出修改框
    modContain.style.width='100%';
    modContain.style.minWidth='1000px';
    //对修改框内容进行赋值
    modBtn.name=par.id;//将id值传递给修改提交按钮，方便modifyStudent中获取id
    for(var i=1;i<tds.length;i++){
        if(i>8)break;
        if(i<=2)mods[i-1].value=tds[i].textContent;
        else if(i==3&&tds[i].textContent=='女') check[1].checked=true;
        else if(i>3)mods[i-2].value=tds[i].textContent;
    }
}
//修改记录实际操作
function modifyStudent(obj){
    var id=parseInt(obj.name);
    var p=document.getElementsByClassName('mod');
    var check=document.getElementsByName('mod_check');
    var sname=p[1].value, sno=p[0].value, classId=p[4].value, className=p[5].value;
    var ssex=check[0].checked?'男':'女', sage=p[2].value, sphone=p[3].value, dormitory=p[6].value;
    $.ajax("/Dormitory/modStudent", {
        type:"post",
        dataType:"json",
        data:{id: id, sno: sno,sname: sname,ssex: ssex,sage: sage,sphone: sphone,classId: classId,className: className,dormitory: dormitory},
        // 请求成功后的回调函数。
        success :function(data){
            //重新获取当前页
            setPage(num);
            alert('第'+data+'条记录，修改成功');
        },
        // 请求出错时调用的函数
        error: function(){
            alert("发送失败");
        }
    });
}
//表格插入数据
function setBody(student) {
    var item = "<tr id=\""+student['id']+"\">"+
        "<td>"+student['id']+"</td>"+
        "<td>&nbsp"+student['sno']+"&nbsp</td>"+
        "<td>"+student['sname']+"</td>"+
        "<td>"+student['ssex']+"</td>"+
        "<td>"+student['sage']+"</td>"+
        "<td>&nbsp"+student['sphone']+"&nbsp</td>"+
        "<td>"+student['classId']+"</td>"+
        "<td>"+student['className']+"</td>"+
        "<td>"+student['dormitory']+"</td>"+
        "<td>"+"<i class='fa fa-pencil modify' onclick='modify(this);'></i>&nbsp;" +
        "&nbsp;<i class='fa fa-trash delete' onclick='deleteStudent(this);'></i>"+"</td>"+
        "</tr>";
    //设置当前页的数字标签颜色
    var p=document.getElementById('pageNum').children;
    for(var i=0;i<p.length;i++){
        p[i].style.color='';
        if(p[i].i==num){
            p[i].style.color='#FF6700';
        }
    }
    return item;
}
//pageNum中间栏的数字跳转页
function chargePage(num,pageNum){
    var pagesNum=document.getElementById('pageNum');
    var pages_aList=pagesNum.children;
    if(pageNum<3){
        charge(pages_aList,1,pageNum);
        return false;
    }
    if(num!=1&&num!=pageNum){
        charge(pages_aList,num-1,num+1);
    }
    else if(num==1){
        charge(pages_aList,num,num+2);
    }
    else if(num==pageNum){
        charge(pages_aList,pageNum-2,pageNum);
    }
}
function charge(pages_aList,start,end){
    var t=0;
    //初始化
    for(var i=0;i<3;i++){
        pages_aList[i].innerHTML='';
    }
    for(var i=start;i<=end;i++){
        pages_aList[t].innerHTML=i;
        pages_aList[t].i=i;
        pages_aList[t].onclick=function (){
            num=this.i;
            setPage(this.i);
        }
        t+=1;
    }
}