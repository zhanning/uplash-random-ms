var previewUrl = "";
$(function(){
   random_image();
})

function random_image(){
    var url = "/image/url";
    $.ajax({
        url: url,
        data: {},
        dataType: "text",
        type: "POST",
        success: function (data) {
            $("#image_url").text(data);
            $("#image_show").attr("src",data);
        },
        error: function () {
        }
    });
}
/*
* 下载图片
* */
function nowUrl(){
    return  $("#image_url").text();
}


function download() {

    var imgurl = nowUrl();
    if (imgurl == "" || imgurl == null || imgurl == undefined) {
        alert("正在加载，请稍等");
    } else {
        location.href = "image/download?url=" + imgurl;
    }
}

/*
*   保存图片
 */

function save() {
    $.ajax({
        url: "image/save",
        data: {url: nowUrl()},
        dataType: "json",
        type: "POST",
        success: function (data) {
            alert(data.msg);
        },
        error: function () {
            alert("保存失败，请重试");
        }

    });
}


