new Vue({
    el:".mid_files",
    data:{
        currentPath: "/",
        files: [],
    },
    mounted(){
        axios
            .get("api/loading")
            .then(
                response => (this.files = response.data)
            )
            .catch(function(error){
                alert(error);
            })
    },
    methods:{
        showDiv:function(){
            $(".upload_div").css("display","inline-block");
        }
    }
})

new Vue({
    el:".upload_region",
    data:{
    },
    methods:{
        drag: function(e){
            const files_list = e.dataTransfer.files;
            e.preventDefault();
            var f = new window.FormData();
            if(e.type == "drop"){

                let i = 0, len = files_list.length;
                for(; i < len; i++) {
                    f.append('upload_file',  files_list[i]);
                }
                console.log(f.get("upload_file"))
                axios
                    .post("/api/document/upload.document",{
                            upload_file: e
                    },
                        {
                            headers: {'Content-Type': 'multipart/form-data'}
                        },
                        function () {
                        console.log(e.dataTransfer.files)
                        })
                    .catch(function (error) {
                        console.log(error)
                    })
                    .finally(function(){
                        console.log(f.get("upload_file"));
                    })
                /*[].forEach.call(files_list,function(current,index,arr){
                    let fileRead = new FileReader();
                    fileRead.readAsDataURL(current);
                    console.log(fileRead);
                    fileRead.addEventListener('load',function(){
                        axios
                            .get("/api/document/upload.document",{
                                params:{
                                    upload_file:fileRead,
                                    currentPath:"/"
                                }
                            })
                            .catch(function (error) {
                                console.log(error)
                            })
                    })
                })*/
            }
        }
    },
    mounted: function (){
        let _this = document.getElementById("upload_region");
        _this.addEventListener('dragenter',this.drag,false);
        _this.addEventListener('dragover',this.drag,false);
        _this.addEventListener('dragleave',this.drag,false);
        _this.addEventListener('drop',this.drag,false);

    }

})