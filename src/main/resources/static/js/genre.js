(() => {
  const queryString = window.location.search;
  const urlParams = new URLSearchParams(queryString);
  const id = urlParams.get('id');
  let container = document.querySelector("#card-group");
  var styles = {
    "background-color": "lightgray",
    "width": "3rem",
    "height": "2rem",
    "margin-left": "9.5rem",
    "border": "1px solid green",
};

  if(id == null){
    function createCard(header, result){

        var div = document.createElement("div");
        div.setAttribute("class", "card");
        div.setAttribute("style", "max-width:18rem");
        div.setAttribute("style", "min-width:6rem");
        var head = document.createElement("p");
        head.innerText = header[0];
        var para = document.createElement("a");
        para.innerText = result[1];
        para.setAttribute('href', "genres.html?id=" + result[0]);
      
        var link = document.createElement("button");

        Object.assign(link.style,styles);
  
        link.innerHTML = "View";
        
        div.appendChild(head);
        div.appendChild(para);
    
        var head = document.createElement("p");
        head.innerText = header[1];
        div.appendChild(head);
     

        for(var i = 0; i < result[2].length; i ++){
            var para = document.createElement("a");
            para.innerText = result[2][i].name;
            para.setAttribute('href', "tracks.html?id=" + result[2][i].id);
            div.appendChild(para);
        }

        div.appendChild(link);
      return div;

    }

    function simpleFetch(){
        const a = ["http://localhost:81/genres/read"];
            fetch(a)
            .then((response => {
              if(response.status !== 200){
                console.error(`status: ${response.status})`);
                return;
              }
              return response.json();
            })) 
            .then(data => {
                const result = data.map(({id, name, tracks}) => [id, name, tracks]);
                for (data of result) {
                const table = createCard(header, data);
                container.appendChild(table);
                }
            })
            .catch(error => console.error(error))
            .finally(() => { console.log("All OK!"); });
  
        }
    const header = ["NAME", "TRACKS"];
    simpleFetch();

      } else {

        function createCard(header, result){

          var div = document.createElement("div");
          div.setAttribute("class", "card");
          var head = document.createElement("p");
          head.innerText = header[0];
          var para = document.createElement("a");
          para.innerText = result.name;

          div.appendChild(head);
          div.appendChild(para);
      
          var head = document.createElement("p");
          head.innerText = header[1];
          div.appendChild(head);
  
          for(var i = 0; i < result.tracks.length; i ++){
              var para = document.createElement("a");
              para.innerText = result.tracks[i].name;
              para.setAttribute('href', "tracks.html?id=" + result.tracks[i].id);
              div.appendChild(para);
          }
  
  
  
        return div;
      }
  
      function simpleFetch(){
          const a = ["http://localhost:81/genres/read/" + id];
              fetch(a)
              .then((response => {
                if(response.status !== 200){
                  console.error(`status: ${response.status})`);
                  return;
                }
                return response.json();
              })) 
              .then(data => {
                  // const result = data.map(({id, name, tracks}) => [id, name, tracks]);
                  // for (data of result) {
                  const table = createCard(header, data);
                  container.appendChild(table);
                  // }
              })
              .catch(error => console.error(error))
              .finally(() => { console.log("All OK!"); });
    
          }
      const header = ["NAME", "TRACKS"];
      simpleFetch();

      }

})();