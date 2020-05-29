new Vue({
    el:"#file_information",
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
    method:function () {
    }
})