//Ajax全局配置
$.ajaxSetup({
    beforeSend: function () {
        // Handle the beforeSend event
        // showWiatModal();
    },
    //type: "POST", //用 POST 代替默认 GET 方法
    cache: false, //禁止AJAX缓存，开发模式下设置为false
    timeout: 60000, //请求超市时间（1分钟）
    statusCode: {
        404: function () {
            alert('页面不存在');
        },
        500: function () {
            alert('服务器内部错误');
        },
        405: function () {
            alert('没有权限');
        },
        301: function (data, textStatus) { // session超时，或者用户未登录，跳转到登录页面

            alert("登录超时，请重新登录！");
            window.location.href = getRootPath() + '/index.html';
            /*setTimeout(function () {
             window.location.href = bashPath + '/index';
             }, 2000);*/
        }
    },
    complete: function () {
        // debugger;
        // swal.close();
    }
});

/**
 * 获得项目路径
 * @returns {*}
 */
function getRootPath() {
    var strFullPath = window.document.location.href;
    var preFix;
    if (strFullPath.indexOf("http://") > -1) {
        preFix = "http://";
    } else {
        preFix = "https://";
    }
    strFullPath = strFullPath.replace(preFix, "");
    var baseUrl = $("#basePath").val();
    var applicationPath = baseUrl.substring(0, baseUrl.length - 1);
    var strMain = strFullPath.substring(0, strFullPath.indexOf("/"));
    return preFix + strMain + applicationPath;
    // var strFullPath = window.document.location.href;
    // var strPath = window.document.location.pathname;
    // var pos = strFullPath.indexOf(strPath);
    // var prePath = strFullPath.substring(0, pos);
    // var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
    // return (prePath + postPath);
}