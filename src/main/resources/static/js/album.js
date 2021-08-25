(() => {

    let container = document.querySelector("#flex");



    function createCard(header, result){

        var div = document.createElement("div");
        div.setAttribute("class", "card");
        var head = document.createElement("p");
        head.innerText = header[0];
        var para = document.createElement("a");
        para.innerText = result[1];
        para.setAttribute('href', "http://localhost:8082/albums/read/" + result[0]);
        var head2 = document.createElement("p");
        head2.innerText = header[1];

        // var a = document.createElement('a');
        // var linkText = document.createTextNode("my title text");
        // a.appendChild(linkText);
        // a.title = "my title text";
        // a.href = "http://example.com";
        // document.body.appendChild(a);

        div.appendChild(head);
        div.appendChild(para);
        div.appendChild(head2);
    

        for(var i = 0; i < result[3].length; i ++){
            var para = document.createElement("a");
            para.innerText = result[3][i].name;
            para.setAttribute('href', "http://localhost:8082/tracks/read/" + result[3][i].id);
            div.appendChild(para);
        }


        var para = document.createElement("a");
        para.innerText = "Artist";
        para.setAttribute('href', "http://localhost:8082/artists/read/1");
        div.appendChild(para);


      return div;
    }

    function simpleFetch(){
        const a = ["http://localhost:8082/albums/read"];
            fetch(a)
            .then((response => {
              if(response.status !== 200){
                console.error(`status: ${response.status})`);
                return;
              }
              return response.json();
            })) 
            .then(data => {
                const result = data.map(({id, name, artist, tracks}) => [id, name, artist, tracks]);
                for (data of result) {
                const table = createCard(header, data);
                container.appendChild(table);
                }
            })
            .catch(error => console.error(error))
            .finally(() => { console.log("All OK!"); });
  
        }
    const header = ["NAME", "TRACKS", "ARTIST"];
    simpleFetch();

})();