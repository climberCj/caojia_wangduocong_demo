/**
 * 公共js，放一些公用的js方法
 */
(function($,ctx){
    window.EXAM = window.EXAM || {};
    //获取项目根路劲
    EXAM.getPath = function(){
        var pathname = document.location.pathname;
        var index = pathname.substr(1).indexOf("/");
        var result = pathname.substr(0,index+1);
        return result;
    };
})(jQuery,window);