
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const searchTitle = urlParams.get('search');
    let container = document.querySelector("#card-group");

    if(searchTitle == null || searchTitle == ""){
 
    } else {
    var album = simpleFetch();

    var track = fetchTrack();

    var artist = fetchArtist();
    }


    function createCard(result){

        var div = document.createElement("div");
        div.setAttribute("class", "card");
        var para = document.createElement("a");
        para.setAttribute("class", "name");
        para.innerText = result.name;
        div.appendChild(para);
        var hr = document.createElement("hr");
        hr.setAttribute("style", "height:1px;border-width:0;color:gray;background-color:gray");
        div.appendChild(hr);
    
  
        for(var i = 0; i < result.tracks.length; i ++){
            var para = document.createElement("a");
            para.innerText = result.tracks[i].name;
            para.setAttribute('href', "tracks.html?id=" + result.tracks[i].id);
            div.appendChild(para);
            let br = document.createElement("BR");
            div.appendChild(br);
        }
  
  
  
      return div;
    }

    function createArtistCard(result){

        var div = document.createElement("div");
        div.setAttribute("class", "card");
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

    function createTrackCard(result){
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

        const a = ["http://localhost:81/albums/read-album/" + searchTitle];
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

        function fetchTrack(){

            const a = ["http://localhost:81/tracks/read-track/" + searchTitle];
                fetch(a)
                .then((response => {
                  if(response.status !== 200){
                    console.error(`status: ${response.status})`);
                    return;
                  }
                  return response.json();
                })) 
                .then(data => {
                    const table = createTrackCard(data);
                    container.appendChild(table);
                })
                .catch(error => console.error(error))
                .finally(() => { console.log("All OK!"); });
    
 
            }

        function fetchArtist(){

            const a = ["http://localhost:81/artists/read-artist/" + searchTitle];
                    fetch(a)
                    .then((response => {
                      if(response.status !== 200){
                        console.error(`status: ${response.status})`);
                        return;
                      }
                      return response.json();
                    })) 
                    .then(data => {
                        const table = createArtistCard(data);
                        container.appendChild(table);
                    })
                    .catch(error => console.error(error))
                    .finally(() => { console.log("All OK!"); });
 
                }
  