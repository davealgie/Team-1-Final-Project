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
      var para2 = document.createElement("p");
      para2.setAttribute("class", "id");
      para2.setAttribute("style", "font-size:10px");
      // para2.setAttribute("style", "margin-bottom:2px");
      para2.innerText = result[0];
      var imgDiv = document.createElement("div");
      imgDiv.setAttribute("class", "imgHolder");
      var img = document.createElement("img");
      img.setAttribute("id", "albumcover");
      img.src = result[4];
      imgDiv.appendChild(img)
      div.appendChild(para2);
      div.appendChild(imgDiv);

      var para = document.createElement("a");
      para.innerText = result[1];
      para.setAttribute("class", "name");
      para.setAttribute('href', "album.html?id=" + result[0]);
      div.appendChild(para);
      var hr = document.createElement("hr");
      hr.setAttribute("style", "height:1px;border-width:0;color:gray;background-color:gray; margin-top: -1px");
      div.appendChild(hr);

      for(var i = 0; i < result[3].length; i ++){
          var para = document.createElement("a");
          para.innerText = result[3][i].name;
          para.setAttribute('href', "tracks.html?id=" + result[3][i].id);
          para.setAttribute("style", "font-size: 14px");
          div.appendChild(para);
          // var hr = document.createElement("hr");
          // hr.setAttribute("style", "height:1px;border-width:0;color:gray;background-color:gray; margin-top: -1px");
          // div.appendChild(hr);
          let br = document.createElement("BR");
          div.appendChild(br);
      }

      if(result[2]!= null){
          var hr = document.createElement("hr");
          hr.setAttribute("style", "height:1px;border-width:0;color:gray;background-color:gray; margin-top: -1px");
          div.appendChild(hr);
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
              const result = data.map(({id, name, artist, tracks, cover}) => [id, name, artist, tracks, cover]);
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
        var para2 = document.createElement("p");
        para2.setAttribute("class", "id");
        para2.setAttribute("style", "font-size:10px");
        // para2.setAttribute("style", "margin-bottom:2px");
        para2.innerText = result.id;
        div.appendChild(para2);
        var imgDiv = document.createElement("div");
        imgDiv.setAttribute("class", "imgHolder");
        var img = document.createElement("img");
        img.setAttribute("id", "albumcover");
        img.src = result.cover;
        imgDiv.appendChild(img)
        div.appendChild(imgDiv);
        var para = document.createElement("a");
        para.innerText = result.name;
        para.setAttribute("class", "name");
        div.appendChild(para);
        var hr = document.createElement("hr");
        hr.setAttribute("style", "height:1px;border-width:0;color:gray;background-color:gray; margin-top: -1px");
        div.appendChild(hr);
  
        for(var i = 0; i < result.tracks.length; i ++){
            var para = document.createElement("a");
            para.innerText = result.tracks[i].name;
            para.setAttribute('href', "tracks.html?id=" + result.tracks[i].id);
            para.setAttribute("style", "font-size: 14px");
            div.appendChild(para);
            let br = document.createElement("BR");
            div.appendChild(br);
        }
  
        if(result.artist!= null){
          var hr = document.createElement("hr");
          hr.setAttribute("style", "height:1px;border-width:0;color:gray;background-color:gray; margin-top: -1px");
          div.appendChild(hr);
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