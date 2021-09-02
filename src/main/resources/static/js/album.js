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
      para.innerText = result[1];
      para.setAttribute("class", "name");
      para.setAttribute('href', "album.html?id=" + result[0]);
      div.appendChild(para);
      var hr = document.createElement("hr");
      hr.setAttribute("style", "height:1px;border-width:0;color:gray;background-color:gray");
      div.appendChild(hr);

      for(var i = 0; i < result[3].length; i ++){
          var para = document.createElement("a");
          para.innerText = result[3][i].name;
          para.setAttribute('href', "tracks.html?id=" + result[3][i].id);
          div.appendChild(para);
          var hr = document.createElement("hr");
          hr.setAttribute("style", "height:1px;border-width:0;color:gray;background-color:gray");
          div.appendChild(hr);
      }

      if(result[2]!= null){
      var para = document.createElement("a");
      para.innerText = result[2].name;
      para.setAttribute('href', "artist.html?id=" + result[2].id);
      div.appendChild(para);
       }

    return div;
  }

  function simpleFetch(){
      const a = ["http://localhost:81/albums/read"];
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
        console.log(result);
        var div = document.createElement("div");
        div.setAttribute("class", "card");
        var para = document.createElement("a");
        para.innerText = result.name;
        para.setAttribute("class", "name");
        div.appendChild(para);
        var hr = document.createElement("hr");
        hr.setAttribute("style", "height:1px;border-width:0;color:gray;background-color:gray");
        div.appendChild(hr);
  
        for(var i = 0; i < result.tracks.length; i ++){
            var para = document.createElement("a");
            para.innerText = result.tracks[i].name;
            para.setAttribute('href', "tracks.html?id=" + result.tracks[i].id);
            div.appendChild(para);
            var hr = document.createElement("hr");
            hr.setAttribute("style", "height:1px;border-width:0;color:gray;background-color:gray");
            div.appendChild(hr);
        }
  
        if(result.artist!= null){
        var para = document.createElement("a");
        para.innerText = result.artist.name;
        para.setAttribute('href', "artist.html?id=" + result.artist.id);
        div.appendChild(para);
         }
  
      return div;
    }
  
    function simpleFetch(){
        const a = ["http://localhost:81/albums/read/" + id];
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