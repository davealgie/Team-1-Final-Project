(() => {

    let container = document.querySelector("#flex");
    let submitCreateBtn = document.querySelector("#createAlbumBtn");
    let albumname = document.querySelector("#albumname");
    let cover = document.querySelector("#cover");
    let artistid = document.querySelector("#artistid");

    let submitUpdateBtn = document.querySelector("#updateAlbum");
    let albumnameupdate = document.querySelector("#albumnameupdate");
    let albumid = document.querySelector("#albumid");
    let coverupdate = document.querySelector("#coverupdate");
    let artistidupdate = document.querySelector("#artistidupdate");


    let submitDeleteBtn = document.querySelector("#deleteAlbum");
    let albumiddelete = document.querySelector("#albumiddelete");

    function createCard(header, result){
        console.log(result);
        var div = document.createElement("div");
        div.setAttribute("class", "card");
        var head10 = document.createElement("p");
        head10.innerText = result[0];
        var head = document.createElement("p");
        head.innerText = header[0];
        var para = document.createElement("a");
        para.innerText = result[1];
        para.setAttribute('href', "http://localhost:81/albums/read/" + result[0]); 
        var head2 = document.createElement("p");
        head2.innerText = header[1];

        // var a = document.createElement('a');
        // var linkText = document.createTextNode("my title text");
        // a.appendChild(linkText);
        // a.title = "my title text";
        // a.href = "http://example.com";
        // document.body.appendChild(a);
        div.appendChild(head10);
        div.appendChild(head);
        div.appendChild(para);
        div.appendChild(head2);


        for(var i = 0; i < result[3].length; i ++){
            var para = document.createElement("a");
            para.innerText = result[3][i].name;

            para.setAttribute('href', "http://localhost:81/tracks/read/" + result[3][i].id);
            div.appendChild(para);
        }

        if(result[2]!= null){
        var head2 = document.createElement("p");
        head2.innerText = header[2];
        div.appendChild(head2);

        var para = document.createElement("a");
        para.innerText = result[2].name;
        para.setAttribute('href', "http://localhost:81/artists/read/1");
        div.appendChild(para);
      }

      return div;
    }

//loops through and extracts data from json, assigns it to variables
function cardData(dataData){
  for (let dataRecord of dataData){
      singleIterationCheck = 0;
      for (value in dataRecord){
          if (typeof dataRecord[value] === 'object'){
            if (singleIterationCheck != 0){
            } else {
              let id = dataRecord.id;
              let image = dataRecord.cover;
              let title = dataRecord.name;
              let description = dataRecord.artist.name;
              let buttonText = "View";
              let buttonLink = "albumview.html?id="+id;
              let artistLink = "artistalbums.html?id=" + dataRecord.artist.id;
              createCard(id, image, title, description, buttonText, buttonLink, artistLink);
              singleIterationCheck++;
            }
          }
      }
  }
}

//clones a hidden html card, attaches data, and appends to html
function createCard(id, image, title, description, buttonText, buttonLink, artistLink){
  let cards = document.querySelector("div.showcards");
  let cloneCard = document.querySelector("div.card").cloneNode(true);
  cloneCard.id = ("card" + id);
  cloneCard.querySelector("img").src=(image);
  cloneCard.querySelector("#imagelink").href=(buttonLink);
  cloneCard.querySelector("#titlelink").innerHTML = (title);
  cloneCard.querySelector("#titlelink").href = (buttonLink);
  cloneCard.querySelector("#textlink").innerHTML = (description);
  cloneCard.querySelector("#textlink").href = (artistLink);
  cloneCard.querySelector("#button").innerHTML = (buttonText);
  cloneCard.querySelector("#button").href = (buttonLink);
  cards.appendChild(cloneCard);
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
                const table = createCard(header, data);
                container.appendChild(table);
                }
            })
            .catch(error => console.error(error))
            .finally(() => { console.log("All OK!"); });
  
        }
    const header = ["NAME", "TRACKS", "ARTIST"];
    simpleFetch();

      //CREATE
  
  // submitCreateBtn.addEventListener("click", (event) => {
  //   const data = {name: albumname.value, cover: cover.value, artist_id: artistid.value};

  //   console.log(data);

  //   fetch('http://localhost:81/albums/create', {
  //     method: 'POST', // or 'PUT'
  //     headers: {
  //       'Content-Type': 'application/json',
  //   },
  //     body: JSON.stringify(data),
  //   })
  //   .then(response => response.json())
  //   .then(data => {
  //     console.log('Success:', data);
  //   })
  //   .catch((error) => {
  //     console.error('Error:', error);
  //   });
    
  //   // window.location.reload();
  // }, false);

  //       //UPDATE

  // submitUpdateBtn.addEventListener("click", (event) => {
  //   const data = {name: albumnameupdate.value, cover: coverupdate.value, artist_id: artistidupdate.value};

  //   console.log(data);

  //   fetch('http://localhost:81/albums/update/' + albumid.value, {
  //     method: 'POST', // or 'PUT'
  //     headers: {
  //       'Content-Type': 'application/json',
  //   },
  //     body: JSON.stringify(data),
  //   })
  //   .then(response => response.json())
  //   .then(data => {
  //     console.log('Success:', data);
  //   })
  //   .catch((error) => {
  //     console.error('Error:', error);      
  //   });
    
  //   // window.location.reload();
  // }, false);

  // //DELETE 

  // submitDeleteBtn.addEventListener("click", (event) => {

  //   fetch('http://127.0.0.1:81/albums/delete/' + albumiddelete.value, {
  //     method: 'DELETE', // or 'PUT'
  //   })
  //   .then(response => response.json())
  //   .then(data => {
  //     console.log('Success:', data);
  //   })
  //   .catch((error) => {
  //     console.error('Error:', error);
  //   });


  // }, false);

})();