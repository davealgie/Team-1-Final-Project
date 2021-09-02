(() => {


    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const id = urlParams.get('id');
    let container = document.querySelector("#card-group");

    if(id == null){
    function createCard(result){
        console.log(result);
        var div = document.createElement("div");
        div.setAttribute("class", "card");
        var para = document.createElement("a");
        para.setAttribute("class", "name");
        para.innerText = result[1];
        para.setAttribute('href', "tracks.html?id=" + result[0]);
        div.appendChild(para);
        var hr = document.createElement("hr");
        hr.setAttribute("style", "height:1px;border-width:0;color:gray;background-color:gray");
        div.appendChild(hr);
       

    if(result[4]!=null){
        var para = document.createElement("p");
        para.innerText = result[4];
        para.setAttribute("style", "font-size: 14px");
        div.appendChild(para);
        var hr = document.createElement("hr");
        hr.setAttribute("style", "height:1px;border-width:0;color:gray;background-color:gray; margin-top: -1px");
        div.appendChild(hr);
    }

    if(result[3]!= null){
        var para2 = document.createElement("p");
        para2.innerText = result[3].name;
        // div.appendChild(head2);
        div.appendChild(para2);
        var hr = document.createElement("hr");
        hr.setAttribute("style", "height:1px;border-width:0;color:gray;background-color:gray");
        div.appendChild(hr);
    }
    if(result[2]!= null){    
        var para3 = document.createElement("a");
        para3.innerText = result[2].name;
        para3.href = "album.html?id=" + result[2].id;
        div.appendChild(para3);
        var hr = document.createElement("hr");
        hr.setAttribute("style", "height:1px;border-width:0;color:gray;background-color:gray");
        div.appendChild(hr);
  
    if(result[2].artist!= null){    
        var para = document.createElement("a");
        para.innerText = result[2].artist.name;
        para.setAttribute('href', "artist.html?id=" + result[2].artist.id);
        // div.appendChild(head);
        div.appendChild(para);
        var hr = document.createElement("hr");
        hr.setAttribute("style", "height:1px;border-width:0;color:gray;background-color:gray");
        div.appendChild(hr);
    }
    }
      return div;
    }

    function simpleFetch(){
        const a = ["http://localhost:81/tracks/read"];
            fetch(a)
            .then((response => {
              if(response.status !== 200){
                console.error(`status: ${response.status})`);
                return;
              }
              return response.json();
            })) 
            .then(data => {
                const result = data.map(({id, name, album, genre, lyrics}) => [id, name, album, genre, lyrics]);
                for (data of result) {
                const table = createCard( data);
                // console.log(data);
                container.appendChild(table);
                }
            })
            .catch(error => console.error(error))
            .finally(() => { console.log("All OK!"); });
  
        }
    simpleFetch();
    } else {

        function createCard(result){
            console.log(result);
            var div = document.createElement("div");
            div.setAttribute("class", "card");
            var para = document.createElement("a");
            para.setAttribute("class", "name");
            para.innerText = result.name;
            para.setAttribute('href', "tracks.html?id=" + result[0]);
            div.appendChild(para);
            var hr = document.createElement("hr");
            hr.setAttribute("style", "height:1px;border-width:0;color:gray;background-color:gray");
            div.appendChild(hr);


        if(result.lyrics!= null){
            var para = document.createElement("p");
            para.innerText = result.lyrics;
            para.setAttribute("style", "font-size: 14px");
            div.appendChild(para);
            var hr = document.createElement("hr");
            hr.setAttribute("style", "height:1px;border-width:0;color:gray;background-color:gray; margin-top: -1px");
            div.appendChild(hr);
        }
    
        if(result.genre!= null){
            var para2 = document.createElement("p");
            para2.innerText = result.genre.name;
            div.appendChild(para2);
            var hr = document.createElement("hr");
            hr.setAttribute("style", "height:1px;border-width:0;color:gray;background-color:gray; margin-top: -1px");
            div.appendChild(hr);
        }
    
        if(result.album!= null){    
            var para3 = document.createElement("a");
            para3.innerText = result.album.name;
            para3.href = "album.html?id=" + result.album.id;
            div.appendChild(para3);
            var hr = document.createElement("hr");
            hr.setAttribute("style", "height:1px;border-width:0;color:gray;background-color:gray; margin-top: -1px");
            div.appendChild(hr);
      
        if(result.album.artist!= null){    
            var para = document.createElement("a");
            para.innerText = result.album.artist.name;
            para.setAttribute('href', "artist.html?id=" + result.album.artist.id);
            div.appendChild(para);
        }
        }
    
          return div;
        }
    
        function simpleFetch(){
            const a = ["http://localhost:81/tracks/read/" + id];
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