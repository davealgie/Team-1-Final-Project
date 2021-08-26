(() => {

    let container = document.querySelector("#flex");
    let submitCreateBtn = document.querySelector("#createAlbum");
    let albumname = document.querySelector("#albumname");
    let cover = document.querySelector("#cover");
    let artistid = document.querySelector("#artistid");


    function createCard(header, result){

        var div = document.createElement("div");
        div.setAttribute("class", "card");
        var head = document.createElement("p");
        head.innerText = header[0];
        var para = document.createElement("a");
        para.innerText = result[1];
        para.setAttribute('href', "http://localhost:81/albums/view/" + result[0]);
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

            para.setAttribute('href', "http://localhost:81/track/" + result[3][i].id);
            div.appendChild(para);
        }


        var para = document.createElement("a");
        para.innerText = "Artist";
        para.setAttribute('href', "http://localhost:81/artists/read/1");
        div.appendChild(para);


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
  
  submitCreateBtn.addEventListener("click", (event) => {
    const data = {name: albumname.value, cover: cover.value, artist_id: artistid.value};

    console.log(data);

    fetch('http://localhost:81/albums/create', {
      method: 'POST', // or 'PUT'
      headers: {
        'Content-Type': 'application/json',
    },
      body: JSON.stringify(data),
    })
    .then(response => response.json())
    .then(data => {
      console.log('Success:', data);
    })
    .catch((error) => {
      console.error('Error:', error);
    });
    
    // window.location.reload();
  }, false);

})();