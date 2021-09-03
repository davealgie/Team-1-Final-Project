(() => {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const id = urlParams.get('id');
    let container = document.querySelector("#card-group");

    if(id == null){
    function createCard(result){

        var div = document.createElement("div");
        div.setAttribute("class", "card");
        var para2 = document.createElement("p");
        para2.setAttribute("class", "id");
        para2.setAttribute("style", "font-size:10px");
        // para2.setAttribute("style", "margin-bottom:2px");
        para2.innerText = result[0];
        var para = document.createElement("a");
        para.setAttribute("class", "name");
        para.setAttribute("style", "margin-top: -1px")
        para.innerText = result[1];
        para.setAttribute('href', "artist.html?id=" + result[0]);
        div.appendChild(para2);
        div.appendChild(para);

        var hr = document.createElement("hr");
        hr.setAttribute("style", "height:1px;border-width:0;color:gray;background-color:gray; margin-top: -1px");
        div.appendChild(hr);
    
        for(var i = 0; i < result[2].length; i ++){
            var para = document.createElement("a");
            para.setAttribute("style", "font-size: 14px");
            para.innerText = result[2][i].name;
            para.setAttribute('href', "album.html?id=" + result[2][i].id);
            div.appendChild(para);
            let br = document.createElement("BR");
            div.appendChild(br);
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
                const table = createCard(data);
                container.appendChild(table);
                }
            })
            .catch(error => console.error(error))
            .finally(() => { console.log("All OK!"); });
  
        }

    simpleFetch();
    } else {
    
    function createCard(result){

        var div = document.createElement("div");
        div.setAttribute("class", "card");
        var para2 = document.createElement("p");
        para2.setAttribute("class", "id");
        para2.setAttribute("style", "font-size:10px");
        // para2.setAttribute("style", "margin-bottom:2px");
        para2.innerText = result.id;
        div.appendChild(para2);
        var para = document.createElement("a");
        para.setAttribute("class", "name");
        para.innerText = result.name;
        div.appendChild(para);
        var hr = document.createElement("hr");
        hr.setAttribute("style", "height:1px;border-width:0;color:gray;background-color:gray; margin-top: -1px");
        div.appendChild(hr);

        for(var i = 0; i < result.albums.length; i ++){
            var para = document.createElement("a");
            para.innerText = result.albums[i].name;
            para.setAttribute('href', "album.html?id=" + result.albums[i].artist.id);
            div.appendChild(para);
            let br = document.createElement("BR");
            div.appendChild(br);
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
                const table = createCard(data);
                container.appendChild(table);
            })
            .catch(error => console.error(error))
            .finally(() => { console.log("All OK!"); });
  
        }

        simpleFetch();
    }

})();