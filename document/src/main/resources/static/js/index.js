$(function () {
    /**
     * 修改文件内容
     */
    $(".file-edit").click (function () {
        var $this = $("#textFile");
        var file = $("#file-edit");
        if ($this.val().trim() === "无文件")
        {
            $.messager.alert ("消息", "没有选择文件，请选择文件！", "error");
            return false;
        } else {
            if ($this.attr("readonly") === "readonly") {
                $this.removeAttr("readonly");
                file.html("<i class='glyphicon glyphicon-edit'></i>&nbsp;只读");
            } else {
                $this.attr("readonly", true);
                file.html("<i class='glyphicon glyphicon-edit'></i>&nbsp;编辑");
            }
        }
    });

    /**
     * 上传文件
     */
    $(".submit").click(function () {
        var formData = new FormData();
        var file = $("#file")[0].files[0];
        formData.append("file", file);
        var url = "/upala/file/upload";
        var fileText = $("#textFile");
        $.ajax({
            url: url,
            type: "post",
            data: formData,
            cache : false,
            contentType : false,
            processData : false,
            dataType:"json",
            success:function (data) {
                $(".file-title").text(data.title);
                fileText.title = data.title;
                if ("" === data.status)
                {
                    fileText.text("文件内容为空！");
                } else
                {
                    fileText.text(data.status);
                }
            }
        });
    });

    /**
     * 检测字符串
     * @param param
     * @returns {boolean}
     */
    function checkString (param)
    {
        return param === "";
    }

    /**
     * 保存文件
     */
    $(".file-save").click (function () {
        var content = $("#textFile").val().trim();
        var title = $(".file-title").val();
        if (content === "无文件" && checkString(title))
        {
            $.messager.alert("消息", "文件内容为空！", "error");
            return false;
        }
        var param = {"content":content, "title":title};
        alert (JSON.stringify(param));
        var url = "/upala/file/saveFile";
        $.ajax({
            url: url,
            type: "post",
            data: param,
            dataType: "json",
            success:function (data)
            {
                alert (data);
            }
        });
    });

});