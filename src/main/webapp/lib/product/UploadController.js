function upload(type){
    var formData = new FormData($("#image-" + type)[0]);
    $.ajax({
        url: 'http://localhost:8180/livesales/service/rest/image/upload/',
        type: 'POST',
        data: formData,
        async: false,
        success: function (data) {
            alert("Code: " + data.code + " ID: " + data.result);
        },
        cache: false,
        contentType: false,
        processData: false
    });
}