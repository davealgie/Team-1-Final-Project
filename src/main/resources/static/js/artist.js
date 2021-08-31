(() => {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const id = urlParams.get('id');
    let container = document.querySelector("#flex");


    console.log(id);
    if(id == null){
    function createCard(header, result){

        var div = document.createElement("div");
        div.setAttribute("class", "card");
        var head = document.createElement("p");
        head.innerText = header[0];
        var para = document.createElement("a");
        para.innerText = result[1];
        para.setAttribute('href', "artist.html?id=" + result[0]);

        // var a = document.createElement('a');
        // var linkText = document.createTextNode("my title text");
        // a.appendChild(linkText);
        // a.title = "my title text";
        // a.href = "http://example.com";
        // document.body.appendChild(a);

        div.appendChild(head);
        div.appendChild(para);
    
        var head = document.createElement("p");
        head.innerText = header[1];
        div.appendChild(head);

        for(var i = 0; i < result[2].length; i ++){
            var para = document.createElement("a");
            para.innerText = result[2][i].name;
            para.setAttribute('href', "artist.html" + result[2][i].id);
            div.appendChild(para);
        }



      return div;
    }

    function simpleFetch(){
        const a = ["http://localhost:81/artists/read"];
            fetch(a)
            .then((response => {
              if(response.status !== 200){
                console.error(`status: ${response.status})`);
                return;
              }
              return response.json();
            })) 
            .then(data => {
                const result = data.map(({id, name, albums}) => [id, name, albums]);
                for (data of result) {
                const table = createCard(header, data);
                container.appendChild(table);
                }
            })
            .catch(error => console.error(error))
            .finally(() => { console.log("All OK!"); });
  
        }
    const header = ["NAME", "ALBUMS"];
    simpleFetch();
    } else {
    
    function createCard(header, result){
        console.log(result);
        var div = document.createElement("div");
        div.setAttribute("class", "card");
        var head = document.createElement("p");
        head.innerText = header[0];
        var para = document.createElement("a");
        para.innerText = result.name;
        para.setAttribute('href', "artist.html?id=" + result[0]);

        div.appendChild(head);
        div.appendChild(para);
    
        var head = document.createElement("p");
        head.innerText = header[1];
        div.appendChild(head);

        for(var i = 0; i < result.albums.length; i ++){
            var para = document.createElement("a");
            para.innerText = result.albums[i].name;
            // para.setAttribute('href', "artist.html" + result[2][i].id);
            div.appendChild(para);
        }



      return div;
    }

    function simpleFetch(){
        const a = ["http://localhost:81/artists/read/" + id];
            fetch(a)
            .then((response => {
              if(response.status !== 200){
                console.error(`status: ${response.status})`);
                return;
              }
              return response.json();
            })) 
            .then(data => {
                // const result = Object.keys(data).map(({id, name, albums}) => [id, name, albums]);
                // for (data of result) {
                const table = createCard(header, data);
                container.appendChild(table);
                // }
            })
            .catch(error => console.error(error))
            .finally(() => { console.log("All OK!"); });
  
        }

        const header = ["NAME", "ALBUMS"];
        simpleFetch();
    }

})();