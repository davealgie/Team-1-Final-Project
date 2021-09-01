(() => {
    let container = document.querySelector("#flex");

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
    let createPlaylistUserID = document.querySelector("#createPlaylistUserID");
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
                    const data = {name: createPlaylistName.value, users_user_id: createPlaylistUserID.value,  description: createPlaylistDesc.value, artwork: createPlaylistArtwork.value};
                    
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
                          if(createPlaylistUserID!=null){
                            fetch('http://localhost:81/playlists/' + data.id + '/users/' + createPlaylistUserID.value, {
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
                        const data = {name: updatePlaylistName.value, users_user_id: updatePlaylistUserID.value,  description: updatePlaylistDesc.value, artwork: updatePlaylistArtwork.value};
                    
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


                      function createCard(header, result){
                        console.log(result);
                        var div = document.createElement("div");
                        div.setAttribute("class", "card");
                        var head10 = document.createElement("p");
                        head10.innerText = result[1];
                        div.appendChild(head10);

                        for(var i = 0; i < result[2].length; i ++){
                            var para = document.createElement("a");
                            para.innerText = result[2][i].name;
                            // para.setAttribute('href', "http://localhost:81/tracks/read/" + result[2][i].id);
                            para.setAttribute('href', "tracks.html?id=" + result[2][i].id);
                            div.appendChild(para);
                        }
                
                        // var btndiv = document.createElement("div");
                        // btndiv.setAttribute("class", "btn-group");
                        // var btn = document.createElement("button");
                        // btn.setAttribute("type", "button");
                        // btn.setAttribute("class", "btn btn-secondary dropdown-toggle");
                        // btn.setAttribute("data-toggle", "dropdown");
                        // btn.setAttribute("data-display", "static");
                        // btn.innerText = "Update Playlist";
                        // var dropdiv = document.createElement("div");
                        // dropdiv.setAttribute("class", "dropdown-menu dropdown-menu-right dropdown-menu-lg-left")
                        // var btn1 = document.createElement("button");
                        // btn1.setAttribute("class", "dropdown-item");
                        // btn1.setAttribute("type", "button");
                        // btn1.setAttribute("data-toggle", "modal");
                        // btn1.setAttribute("data-target", "#addTrack");
                        // btn1.innerText = "Add Track";
                        // var btn2 = document.createElement("button");
                        // btn2.setAttribute("class", "dropdown-item");
                        // btn2.setAttribute("type", "button");
                        // btn2.setAttribute("data-toggle", "modal");
                        // btn2.setAttribute("data-target", "#removeTrack");
                        // btn2.innerText = "Remove Track";


                        // var addmodal = document.createElement("div");
                        // addmodal.setAttribute("class", "modal fade");
                        // addmodal.setAttribute("id", "addTrack");
                        // addmodal.setAttribute("tabindex", "-1");
                        // addmodal.setAttribute("aria-labelledby", "exampleModalLabel");
                        // addmodal.setAttribute("aria-hidden", "true");
                        // var modaldialog = document.createElement("div");
                        // modaldialog.setAttribute("class", "modal-dialog");
                        // addmodal.appendChild(modaldialog);
                        // var modaldialog2 = document.createElement("div");
                        // modaldialog2.setAttribute("class", "modal-content");
                        // modaldialog.appendChild(modaldialog2);
                        // var modaldialog3 = document.createElement("div");
                        // modaldialog3.setAttribute("class", "modal-header");
                        // modaldialog2.appendChild(modaldialog3); //line 322
                        // var h5 = document.createElement("h5");
                        // h5.setAttribute("class", "modal-title");
                        // h5.setAttribute("id", "exampleModalLabel");
                        // h5.innerText = "Add Track";
                        // modaldialog3.appendChild(h5);
                        // var buttonClose = document.createElement("button");
                        // buttonClose.setAttribute("type", "button");
                        // buttonClose.setAttribute("class", "close");
                        // buttonClose.setAttribute("data-dismiss", "modal");
                        // buttonClose.setAttribute("aria-label", "close");
                        // var areaSpan = document.createElement("span");
                        // areaSpan.setAttribute("aria-hidden", "true");
                        // buttonClose.appendChild(areaSpan);
                        // modaldialog3.appendChild(buttonClose);
                        // var modalBody = document.createElement("div");
                        // modalBody.setAttribute("class", "modal-body");
                        // modaldialog2.appendChild(modalBody);
                        // var form = document.createElement("form");
                        // form.setAttribute("class", "log-in");
                        // modalBody.appendChild(form);
                        // var inputGroupmb = document.createElement("div");
                        // inputGroupmb.setAttribute("class", "input-groub mb-3");
                        // form.appendChild(inputGroupmb);
                        // var inputPrepend = document.createElement("div");
                        // inputPrepend.setAttribute("class", "input-group-prepend");
                        // inputGroupmb.appendChild(inputPrepend);
                        // var spanLabel = document.createElement("span");
                        // spanLabel.setAttribute("class", "input-group-text");
                        // spanLabel.setAttribute("id", "inputGroup-sizing-default");
                        // spanLabel.textContent = "Track-ID";
                        // inputPrepend.appendChild(spanLabel);
                        // var idinput = document.createElement("input");
                        // idinput.setAttribute("id", "addTrackToID");
                        // idinput.setAttribute("type", "number");
                        // idinput.setAttribute("class", "form-control");
                        // idinput.setAttribute("aria-label", "Sizing example input");
                        // idinput.setAttribute("aria-describedby", "inputGroup-sizing-default");
                        // inputGroupmb.appendChild(idinput);
                        // var modalFooter = document.createElement("div");
                        // modalFooter.setAttribute("class", "modal-footer");
                        // modalBody.appendChild(modalFooter);
                        // var para5 = document.createElement("p");
                        // para5.setAttribute("class", "card-text");
                        // modalFooter.appendChild(para5);
                        // var closeForm = document.createElement("button");
                        // closeForm.setAttribute("class", "btn btn-secondary");
                        // closeForm.setAttribute("data-dismiss", "modal")
                        // closeForm.innerText = "Close";
                        // var addButton = document.createElement("button");
                        // addButton.setAttribute("class", "btn btn-primary");
                        // addButton.onclick = function() {
                        //     let trackinputID = document.querySelector("#addTrackToID");
                        //     fetch('http://localhost:81/playlists/' + result[0] + '/tracks/' + trackinputID.value, {
                        //         method: 'PUT', // or 'PUT'
                        //       })
                        //       .then(response => response.json())
                        //       .then(data => {
                        //         console.log('Success:', data);
                        //       })
                        //       .catch((error) => {
                        //         console.error('Error:', error);
                        //       });
                        // }
                        // addButton.innerText = "Add";
                        // modalFooter.appendChild(closeForm);
                        // modalFooter.appendChild(addButton);
                        // div.appendChild(addmodal);
                        // var addmodal = document.createElement("div");
                        // addmodal.setAttribute("class", "modal fade");
                        // addmodal.setAttribute("id", "removeTrack");
                        // addmodal.setAttribute("tabindex", "-1");
                        // addmodal.setAttribute("aria-labelledby", "exampleModalLabel");
                        // addmodal.setAttribute("aria-hidden", "true");
                        // var modaldialog = document.createElement("div");
                        // modaldialog.setAttribute("class", "modal-dialog");
                        // addmodal.appendChild(modaldialog);
                        // var modaldialog2 = document.createElement("div");
                        // modaldialog2.setAttribute("class", "modal-content");
                        // modaldialog.appendChild(modaldialog2);
                        // var modaldialog3 = document.createElement("div");
                        // modaldialog3.setAttribute("class", "modal-header");
                        // modaldialog2.appendChild(modaldialog3); //line 322
                        // var h5 = document.createElement("h5");
                        // h5.setAttribute("class", "modal-title");
                        // h5.setAttribute("id", "exampleModalLabel");
                        // h5.innerText = "Remove Track";
                        // modaldialog3.appendChild(h5);
                        // var buttonClose = document.createElement("button");
                        // buttonClose.setAttribute("type", "button");
                        // buttonClose.setAttribute("class", "close");
                        // buttonClose.setAttribute("data-dismiss", "modal");
                        // buttonClose.setAttribute("aria-label", "close");
                        // var areaSpan = document.createElement("span");
                        // areaSpan.setAttribute("aria-hidden", "true");
                        // buttonClose.appendChild(areaSpan);
                        // modaldialog3.appendChild(buttonClose);
                        // var modalBody = document.createElement("div");
                        // modalBody.setAttribute("class", "modal-body");
                        // modaldialog2.appendChild(modalBody);
                        // var form = document.createElement("form");
                        // form.setAttribute("class", "log-in");
                        // modalBody.appendChild(form);
                        // var inputGroupmb = document.createElement("div");
                        // inputGroupmb.setAttribute("class", "input-groub mb-3");
                        // form.appendChild(inputGroupmb);
                        // var inputPrepend = document.createElement("div");
                        // inputPrepend.setAttribute("class", "input-group-prepend");
                        // inputGroupmb.appendChild(inputPrepend);
                        // var spanLabel = document.createElement("span");
                        // spanLabel.setAttribute("class", "input-group-text");
                        // spanLabel.setAttribute("id", "inputGroup-sizing-default");
                        // spanLabel.textContent = "Track-ID";
                        // inputPrepend.appendChild(spanLabel);
                        // var idinput = document.createElement("input");
                        // idinput.setAttribute("id", "removeTrackID");
                        // idinput.setAttribute("type", "number");
                        // idinput.setAttribute("class", "form-control");
                        // idinput.setAttribute("aria-label", "Sizing example input");
                        // idinput.setAttribute("aria-describedby", "inputGroup-sizing-default");
                        // inputGroupmb.appendChild(idinput);
                        // var modalFooter = document.createElement("div");
                        // modalFooter.setAttribute("class", "modal-footer");
                        // modalBody.appendChild(modalFooter);
                        // var para5 = document.createElement("p");
                        // para5.setAttribute("class", "card-text");
                        // modalFooter.appendChild(para5);
                        // var closeForm = document.createElement("button");
                        // closeForm.setAttribute("class", "btn btn-secondary");
                        // closeForm.setAttribute("data-dismiss", "modal")
                        // closeForm.innerText = "Close";
                        // var addButton = document.createElement("button");
                        // addButton.setAttribute("class", "btn btn-primary");
                        // addButton.setAttribute("id", "removeTrackButton");
                        // addButton.innerText = "Remove";
                        // modalFooter.appendChild(closeForm);
                        // modalFooter.appendChild(addButton);

                        // div.appendChild(addmodal);
                        // dropdiv.appendChild(btn1);
                        // dropdiv.appendChild(btn2);
                        // btndiv.appendChild(dropdiv);
                        // btndiv.appendChild(btn);
                        // div.appendChild(btndiv);

                    //     function addToPlaylist(trackid, playlistid){
                    
                    //         // console.log(idinput.value);
    
                    //         fetch('http://localhost:81/playlists/' + playlistid + '/tracks/' + trackid, {
                    //             method: 'DELETE', // or 'PUT'
                    //           })
                    //           .then(response => response.json())
                    //           .then(data => {
                    //             console.log('Success:', data);
                    //           })
                    //           .catch((error) => {
                    //             console.error('Error:', error);
                    //           });
                            
                    // }

                      return div;
                    }

            
                
                    function simpleFetch(){
                        fetch("http://localhost:81/playlists/read")
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
                                const table = createCard(header, data);
                                container.appendChild(table);
                                }
                            })
                            .catch(error => console.error(error))
                            .finally(() => { console.log("All OK!"); });
                        }
                    const header = ["NAME", "TRACKS"];
                    simpleFetch();

})();