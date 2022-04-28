function hasClass(obj,typ){
    var p=new RegExp("\\b"+typ+"\\b");
    return p.test(obj.className);
}
function addClass(obj,typ){
    if(!hasClass(obj,typ)){
        obj.className+=" "+typ;
    }
}
function deleteClass(obj,typ){
    var reg=new RegExp("\\b"+typ+"\\b");
    obj.className=obj.className.replace(typ,'');
}
function toggleClass(obj,typ){
    if(!hasClass(obj,typ)){
        addClass(obj,typ);
    }
    else deleteClass(obj,typ);
}

//移动的js函数
function move(obj,sty,endValue,speed,callback){
    clearInterval(obj.timer);
    var current=parseInt(getComputedStyle(obj,null)[sty]);
    if(current>endValue)
        speed=-speed;
    obj.timer=setInterval(function (){
        current=parseInt(getComputedStyle(obj,null)[sty]);
        var startValue=current+speed;
        //如果已经到达终点
        if((speed>0&&startValue>endValue)||(speed<0&&startValue<endValue)){
            startValue=endValue;
        }
        obj.style[sty]=startValue+"px";
        if(startValue==endValue){
            clearInterval(obj.timer);
            callback&&callback();
        }
    },1);
}