
// (() => {
    let container = document.querySelector("#card-group");

    var id = getCookie("id");

    function getCookie(cname) {
        let name = cname + "=";
        let decodedCookie = decodeURIComponent(document.cookie);
        let ca = decodedCookie.split(';');
        for(let i = 0; i <ca.length; i++) {
          let c = ca[i];
          while (c.charAt(0) == ' ') {
            c = c.substring(1);
          }
          if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
          }
        }
        return "";
      }
    
    if(id == null || id == ""){
        heroPage();
    } else {
        console.log(id);
        simpleFetch(id);
        // heroPage();
    }

    let trackName = document.querySelector("#trackName");
    let playlistID = document.querySelector("#playlistID");
    let trackIDPlaylist = document.querySelector("#trackID"); // add to playlist
    let trackToPlaylistBtn = document.querySelector("#addTrackIDPlaylist");
    let trackToPlaylistByNameBtn = document.querySelector("#addTrackByName");

    let removePlaylistID = document.querySelector("#removeplaylistID");
    let removeTrackID = document.querySelector("#removetrackID"); // remove from playlist
    let removeTrackBtn = document.querySelector("#removeTrackBtn");

    let createTrackBtn = document.querySelector("#createTrack");
    let createTrackName = document.querySelector("#trackname");
    let createTrackLyrics = document.querySelector("#lyrics");  //CREATE TRACK elements
    let createTrackDuration = document.querySelector("#duration");
    let createTrackAlbumID = document.querySelector("#albumid");
    let createTrackGenreID = document.querySelector("#genreid");
    let deleteTrackBtn = document.querySelector("#deleteTrack"); // DELETE TRACK elements
    let deleteTrackID = document.querySelector("#deletetrackid");
    let updateTrackBtn = document.querySelector("#updateTrack");
    let updateTrackID = document.querySelector("#updateTrackID");
    let updateTrackName = document.querySelector("#updateTrackName");
    let updateTrackLyrics = document.querySelector("#updateTrackLyrics");  //UPDATE TRACK elements
    let updateTrackDuration = document.querySelector("#updateTrackDuration");
    let updateTrackAlbumID = document.querySelector("#updateTrackAlbumID");
    let updateTrackGenreID = document.querySelector("#updateTrackGenreID");


    let createAlbumBtn = document.querySelector("#createAlbumBtn");
    let createAlbumName = document.querySelector("#albumname");
    let createAlbumCover = document.querySelector("#cover");                    //CREATE ALBUM elements
    let createAlbumArtistID = document.querySelector("#artistid");
    let updateAlbumBtn = document.querySelector("#updateAlbum");
    let updateAlbumName = document.querySelector("#albumnameupdate");
    let updateAlbumID = document.querySelector("#albumidupdate");
    let updateAlbumCover = document.querySelector("#coverupdate");          //UPDATE ALBUM elements
    let updateAlbumArtistID = document.querySelector("#artistidupdate");
    let deleteAlbumBtn = document.querySelector("#deleteAlbum");     //DELETE ALBUM elements
    let deleteAlbumID = document.querySelector("#albumiddelete");


    let createArtistBtn = document.querySelector("#createArtist");                    //CREATE ARTIST elements
    let createArtistName = document.querySelector("#createName");
    let updateArtistBtn = document.querySelector("#updateArtist");                    //UPDATE ARTIST elements
    let updateArtistID = document.querySelector("#updateID");
    let updateArtistName = document.querySelector("#updateName");
    let deleteArtistBtn = document.querySelector("#deleteArtist");                    //DELETE ARTIST elements
    let deleteArtistID = document.querySelector("#deleteID");

    let createGenreBtn = document.querySelector("#createGenre");                  //CREATE GENRE elements
    let createGenreName = document.querySelector("#createGenreName");
    let createGenreDesc = document.querySelector("#createGenreDesc");
    let updateGenreBtn = document.querySelector("#updateGenre");                    //UPDATE GENRE elements
    let updateGenreID = document.querySelector("#updateGenreID");
    let updateGenreName = document.querySelector("#updateGenreName");
    let updateGenreDesc = document.querySelector("#updateGenreDesc");
    let deleteGenreBtn = document.querySelector("#deleteGenre");                    //DELETE GENRE elements
    let deleteGenreID = document.querySelector("#deleteGenreID");

    let createPlaylistBtn = document.querySelector("#createPlaylist");                  // PLAYLIST elements
    let updatePlaylistBtn = document.querySelector("#updatePlaylist");
    let deletePlaylistBtn = document.querySelector("#deletePlaylist");
    let updatePlaylistID = document.querySelector("#updatePlaylistID");
    let deletePlaylistID = document.querySelector("#deletePlaylistID");
    let createPlaylistName = document.querySelector("#createPlaylistName");
    let updatePlaylistName = document.querySelector("#updatePlaylistName");
    let createPlaylistDesc = document.querySelector("#createPlaylistDesc");
    let updatePlaylistDesc = document.querySelector("#updatePlaylistDesc");                    
    // let createPlaylistUserID = document.querySelector("#createPlaylistUserID");
    let updatePlaylistUserID = document.querySelector("#updatePlaylistUserID");
    let createPlaylistArtwork = document.querySelector("#createPlaylistArtwork");
    let updatePlaylistArtwork = document.querySelector("#updatePlaylistArtwork");

      //CREATE TRACK
  
    createTrackBtn.addEventListener("click", (event) => {
    const data = {name: createTrackName.value, duration: createTrackDuration.value, lyrics: createTrackLyrics.value, album_id: createTrackAlbumID.value, genre_id: createTrackGenreID.value};

    console.log(data);

    fetch('http://localhost:81/tracks/create', {
      method: 'POST', // or 'PUT'
      headers: {
        'Content-Type': 'application/json',
    },
      body: JSON.stringify(data),
    })
    .then(response => response.json())
    .then(data => {
      console.log('Success:', data);
      console.log(data.id);
      let msg = document.getElementById("success-track-create");
      msg.innerHTML = "New track created successfully!"
      if(createTrackAlbumID!=null){
        fetch('http://localhost:81/tracks/' + data.id + '/albums/' + createTrackAlbumID.value, {
            method: 'PUT', // or 'PUT'
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
        }
        if(createTrackGenreID!=null){
            fetch('http://localhost:81/tracks/' + data.id + '/genres/' + createTrackGenreID.value, {
                method: 'PUT', // or 'PUT'
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
            }
    })
    .catch((error) => {
      console.error('Error:', error);
    });
  }, false);

        //UPDATE TRACK

    updateTrackBtn.addEventListener("click", (event) => {
    const data = {name: updateTrackName.value, duration: updateTrackDuration.value, lyrics: updateTrackLyrics.value, album_id: updateTrackAlbumID.value, genre_id: updateTrackGenreID.value};

    console.log(data);

    fetch('http://localhost:81/tracks/update/' + updateTrackID.value, {
      method: 'POST', // or 'PUT'
      headers: {
        'Content-Type': 'application/json',
    },
      body: JSON.stringify(data),
    })
    .then(response => response.json())
    .then(data => {
      console.log('Success:', data);
      let msg = document.getElementById("success-track-update");
      msg.innerHTML = "Track updated successfully!"
      if(updateTrackAlbumID!=null){
        fetch('http://localhost:81/tracks/' + data.id + '/albums/' + updateTrackAlbumID.value, {
            method: 'PUT', // or 'PUT'
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
        }
        if(updateTrackGenreID!=null){
            fetch('http://localhost:81/tracks/' + data.id + '/genres/' + updateTrackGenreID.value, {
                method: 'PUT', // or 'PUT'
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
            }
    })
    .catch((error) => {
      console.error('Error:', error);      
    });

  }, false);

  //DELETE TRACK

  deleteTrackBtn.addEventListener("click", (event) => {

    fetch('http://localhost:81/tracks/delete/' + deleteTrackID.value, {
      method: 'DELETE', // or 'PUT'
    })
    .then(response => response.json())
    .then(data => {
      console.log('Success:', data);
      let msg = document.getElementById("success-track-delete");
      msg.innerHTML = "Track deleted successfully!"
    })
    .catch((error) => {
      console.error('Error:', error);
    });


  }, false);

        //CREATE ALBUM
  
        createAlbumBtn.addEventListener("click", (event) => {
            event.preventDefault();
            const data = {name: createAlbumName.value, cover: createAlbumCover.value, artist_id: createAlbumArtistID.value};
        
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
              if(createAlbumArtistID!=null){
                fetch('http://localhost:81/albums/' + data.id + '/artists/' + createAlbumArtistID.value, {
                    method: 'PUT', // or 'PUT'
                    headers: {
                      'Content-Type': 'application/json',
                  },
                    body: JSON.stringify(data),
                  })
                  .then(response => response.json())
                  .then(data => {
                    console.log('Success:', data);
                    console.log(data);
                    let msg = document.getElementById("success-album-create");
                    msg.innerHTML = "New Album created successfully!"
                  })
                  .catch((error) => {
                    console.error('Error:', error);
                  });
                 
                }
            })
            .catch((error) => {
              console.error('Error:', error);
            });
            
          }, false);
        
                //UPDATE ALBUM
        
            updateAlbumBtn.addEventListener("click", (event) => {
            const data = {name: updateAlbumName.value, cover: updateAlbumCover.value, artist_id: updateAlbumArtistID.value};
        
            console.log(data);
        
            fetch('http://localhost:81/albums/update/' + updateAlbumID.value, {
              method: 'POST', // or 'PUT'
              headers: {
                'Content-Type': 'application/json',
            },
              body: JSON.stringify(data),
            })
            .then(response => response.json())
            .then(data => {
              console.log('Success:', data);
              if(updateAlbumArtistID!=null){
                fetch('http://localhost:81/albums/' + updateAlbumID.value + '/artists/' + updateAlbumArtistID.value, {
                    method: 'PUT', // or 'PUT'
                    headers: {
                      'Content-Type': 'application/json',
                  },
                    body: JSON.stringify(data),
                  })
                  .then(response => response.json())
                  .then(data => {
                    console.log('Success:', data);
                    let msg = document.getElementById("success-album-update");
                    msg.innerHTML = "Album updated successfully!"
                  })
                  .catch((error) => {
                    console.error('Error:', error);
                  });
                }
            })
            .catch((error) => {
              console.error('Error:', error);      
            });
            
          }, false);
        
          //DELETE ALBUM
        
          deleteAlbumBtn.addEventListener("click", (event) => {
        
            fetch('http://localhost:81/albums/delete/' + deleteAlbumID.value, {
              method: 'DELETE', // or 'PUT'
            })
            .then(response => response.json())
            .then(data => {
              console.log('Success:', data);
              let msg = document.getElementById("success-album-delete");
              msg.innerHTML = "Album deleted successfully!"
            })
            .catch((error) => {
              console.error('Error:', error);
            });
        
        
          }, false);

              //CREATE ARTIST
  
            createArtistBtn.addEventListener("click", (event) => {
            const data = {name: createArtistName.value};
        
            console.log(data);
        
            fetch('http://localhost:81/artists/create', {
              method: 'POST', // or 'PUT'
              headers: {
                'Content-Type': 'application/json',
            },
              body: JSON.stringify(data),
            })
            .then(response => response.json())
            .then(data => {
              console.log('Success:', data);
              let msg = document.getElementById("success-artist-create");
              msg.innerHTML = "New Artist created successfully!"
            })
            .catch((error) => {
              console.error('Error:', error);
            });
            
          }, false);
        
                //UPDATE ARTIST
        
            updateArtistBtn.addEventListener("click", (event) => {
            const data = {name: updateArtistName.value};
        
            console.log(data);
        
            fetch('http://localhost:81/artists/update/' + updateArtistID.value, {
              method: 'POST', // or 'PUT'
              headers: {
                'Content-Type': 'application/json',
            },
              body: JSON.stringify(data),
            })
            .then(response => response.json())
            .then(data => {
              console.log('Success:', data);
              let msg = document.getElementById("success-artist-update");
              msg.innerHTML = "Artist updated successfully!"
            })
            .catch((error) => {
              console.error('Error:', error);      
            });
            
          }, false);
        
          //DELETE ARTIST
        
          deleteArtistBtn.addEventListener("click", (event) => {
        
            fetch('http://localhost:81/artists/delete/' + deleteArtistID.value, {
              method: 'DELETE', // or 'PUT'
            })
            .then(response => response.json())
            .then(data => {
              console.log('Success:', data);
              let msg = document.getElementById("success-artist-delete");
              msg.innerHTML = "Artist deleted successfully!"
            })
            .catch((error) => {
              console.error('Error:', error);
            });
        
        
          }, false);

                //CREATE GENRE
  
                createGenreBtn.addEventListener("click", (event) => {
                const data = {name: createGenreName.value, description: createGenreDesc.value};
                
                    console.log(data);
                
                    fetch('http://localhost:81/genres/create', {
                      method: 'POST', // or 'PUT'
                      headers: {
                        'Content-Type': 'application/json',
                    },
                      body: JSON.stringify(data),
                    })
                    .then(response => response.json())
                    .then(data => {
                      console.log('Success:', data);
                      let msg = document.getElementById("success-genre-create");
                      msg.innerHTML = "New genre created successfully!"
                    })
                    .catch((error) => {
                      console.error('Error:', error);
                    });
                    
                  }, false);
                
                        //UPDATE GENRE
                
                    updateGenreBtn.addEventListener("click", (event) => {
                    const data = {name: updateGenreName.value, description: updateGenreDesc.value};
                
                    console.log(data);
                
                    fetch('http://localhost:81/genres/update/' + updateGenreID.value, {
                      method: 'POST', // or 'PUT'
                      headers: {
                        'Content-Type': 'application/json',
                    },
                      body: JSON.stringify(data),
                    })
                    .then(response => response.json())
                    .then(data => {
                      console.log('Success:', data);
                      let msg = document.getElementById("success-genre-update");
                      msg.innerHTML = "Genre updated successfully!"
                    })
                    .catch((error) => {
                      console.error('Error:', error);      
                    });
                    
                  }, false);
                
                  //DELETE GENRE
                
                  deleteGenreBtn.addEventListener("click", (event) => {
                
                    fetch('http://localhost:81/genres/delete/' + deleteGenreID.value, {
                      method: 'DELETE', // or 'PUT'
                    })
                    .then(response => response.json())
                    .then(data => {
                      console.log('Success:', data);
                      let msg = document.getElementById("success-genre-delete");
                      msg.innerHTML = "Genre deleted successfully!"
                    })
                    .catch((error) => {
                      console.error('Error:', error);
                    });
                
                
                  }, false);

                  // CREATE PLAYLIST
  
            createPlaylistBtn.addEventListener("click", (event) => {
                    const data = {name: createPlaylistName.value, description: createPlaylistDesc.value, artwork: createPlaylistArtwork.value};
                    
                        console.log(data);
                    
                        fetch('http://localhost:81/playlists/create', {
                          method: 'POST', // or 'PUT'
                          headers: {
                            'Content-Type': 'application/json',
                        },
                          body: JSON.stringify(data),
                        })
                        .then(response => response.json())
                        .then(data => {
                          console.log('Success:', data);
                          if(id!=null){
                            fetch('http://localhost:81/playlists/' + data.id + '/users/' + id, {
                                method: 'PUT', // or 'PUT'
                                headers: {
                                  'Content-Type': 'application/json',
                              },
                                body: JSON.stringify(data),
                              })
                              .then(response => response.json())
                              .then(data => {
                                console.log('Success:', data);
                                let msg = document.getElementById("success-playlist-create");
                                msg.innerHTML = "New playlist created successfully!"
                              })
                              .catch((error) => {
                                console.error('Error:', error);
                              });
                            }
                        })
                        .catch((error) => {
                          console.error('Error:', error);
                        });
                        
                      }, false);
                    
                            //UPDATE PLAYLIST
                    
                        updatePlaylistBtn.addEventListener("click", (event) => {
                        const data = {name: updatePlaylistName.value, description: updatePlaylistDesc.value, artwork: updatePlaylistArtwork.value};
                    
                        console.log(data);
                    
                        fetch('http://localhost:81/genres/update/' + updatePlaylistID.value, {
                          method: 'POST', // or 'PUT'
                          headers: {
                            'Content-Type': 'application/json',
                        },
                          body: JSON.stringify(data),
                        })
                        .then(response => response.json())
                        .then(data => {
                          console.log('Success:', data);
                          if(updatePlaylistUserID!=null){
                          fetch('http://localhost:81/playlists/' + updatePlaylistID.value + '/users/' + updatePlaylistUserID.value, {
                            method: 'PUT', // or 'PUT'
                            headers: {
                              'Content-Type': 'application/json',
                          },
                            body: JSON.stringify(data),
                          })
                          .then(response => response.json())
                          .then(data => {
                            console.log('Success:', data);
                            let msg = document.getElementById("success-playlist-update");
                            msg.innerHTML = "Playlist updated successfully!"
                          })
                          .catch((error) => {
                            console.error('Error:', error);
                                });
                            }
                        })
                        .catch((error) => {
                          console.error('Error:', error);      
                        });
                        
                      }, false);
                    
                      //DELETE PLAYLIST
                    
                      deletePlaylistBtn.addEventListener("click", (event) => {
                    
                        fetch('http://localhost:81/playlists/delete/' + deletePlaylistID.value, {
                          method: 'DELETE', // or 'PUT'
                        })
                        .then(response => response.json())
                        .then(data => {
                          console.log('Success:', data);
                          let msg = document.getElementById("success-playlist-delete");
                          msg.innerHTML = "Playlist deleted successfully!"
                        })
                        .catch((error) => {
                          console.error('Error:', error);
                        });
                    
                    
                      }, false);

                      trackToPlaylistBtn.addEventListener("click", (event) => {
                             addToPlaylist(trackIDPlaylist.value, playlistID.value);
                      }, false);

                      trackToPlaylistByNameBtn.addEventListener("click", (event) => {
                          addToPlaylistByName(playlistID.value, trackName.value);
                    }, false);

                    removeTrackBtn.addEventListener("click", (event) => {
                        removeFromPlaylist(removeTrackID.value, removePlaylistID.value);
                    }, false);

                    
                    function removeFromPlaylist(trackid, playlistid){
    
                        fetch('http://localhost:81/playlists/' + playlistid + '/track-remove/' + trackid, {
                                method: 'PUT', // or 'PUT'
                          })
                           .then(response => response.json())
                           .then(data => {
                            console.log('Success:', data);
                            })
                              .catch((error) => {
                                console.error('Error:', error);
                              });
                            
                    }

                    // Add to playlist by ID

                    function addToPlaylist(trackid, playlistid){
    
                        fetch('http://localhost:81/playlists/' + playlistid + '/tracks/' + trackid, {
                                method: 'PUT', // or 'PUT'
                          })
                           .then(response => response.json())
                           .then(data => {
                            console.log('Success:', data);
                            })
                              .catch((error) => {
                                console.error('Error:', error);
                              });
                            
                    }

                    // Add to playlist by name

                    function addToPlaylistByName(playlist, track1){

                        fetch('http://localhost:81/playlists/' + playlist + '/track-name/' + track1, {
                            method: 'PUT', // or 'PUT'
                          })
                          .then(response => response.json())
                          .then(data => {
                            console.log('Success:', data);
                          })
                          .catch((error) => {
                            console.error('Error:', error);
                          });

                    }


                      function createCard(result){
                        console.log(result);

                        var div = document.createElement("div");
                        div.setAttribute("class", "card");
                        var head10 = document.createElement("p");
                        head10.setAttribute("class", "name");
                        head10.innerText = result[1];
                        div.appendChild(head10);
                        var hr = document.createElement("hr");
                        hr.setAttribute("style", "height:1px;border-width:0;color:gray;background-color:gray");
                        div.appendChild(hr);


                        for(var i = 0; i < result[2].length; i ++){
                            var para = document.createElement("a");
                            para.innerText = result[2][i].name;
                            // para.setAttribute('href', "http://localhost:81/tracks/read/" + result[2][i].id);
                            para.setAttribute('href', "tracks.html?id=" + result[2][i].id);
                            para.setAttribute("style", "font-size: 14px");
                            div.appendChild(para);
                            let br = document.createElement("BR");
                            div.appendChild(br);
                        }
                
                      return div;
                    }

            
                
                    function simpleFetch(id){
                        fetch("http://localhost:81/playlists/readByUser/" + id)
                            .then((response => {
                              if(response.status !== 200){
                                console.error(`status: ${response.status})`);
                                return;
                              }
                              return response.json();
                            })) 
                            .then(data => {
                                const result = data.map(({id, name, tracks}) => [id, name, tracks]);
                                console.log(result);
                                for (data of result) {
                                const table = createCard(data);
                                container.appendChild(table);
                                }
                            })
                            .catch(error => console.error(error))
                            .finally(() => { console.log("All OK!"); });
                        }

                        function heroPage(){

                        let imageDiv = document.createElement("div");
                        imageDiv.setAttribute("class", "banner");
                        let textDiv = document.createElement("div");  
                        textDiv.setAttribute("class", "banner-text-div");
                        let text = document.createElement("h1");
                        text.setAttribute("class", "bannerText")    
                        textDiv.appendChild(text);
                        imageDiv.appendChild(textDiv);
                        container.appendChild(imageDiv);


                        }
                    
// })();