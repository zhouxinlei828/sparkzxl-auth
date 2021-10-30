/**
 * ajax获取json
 * @param type 请求类型：post，get
 * @param url 请求路径
 * @param data json数据
 * @returns
 */
function loadingAjaxJsonData(type, url, data) {
    if (type === 'post' || type === 'POST') {
        data = JSON.stringify(data);
    }
    let jsonObj = {};
    $.ajax({
        type: type,
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        data: data,
        cache: false,
        timeout: 10000,
        url: url,
        async: false,
        success: function (result) {
            jsonObj = result;
        },
        error: function (xhr) {
            Qmsg.error({
                content: "读取数据失败",
                timeout: 1000
            });
        }
    });
    return jsonObj;
}
