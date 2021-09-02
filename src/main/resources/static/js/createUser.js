//create user elements
document.querySelector("#createSubmit").addEventListener("click", (event) => {
    let full_name = document.querySelector("#full_name").value;
    let username = document.querySelector("#username").value;
    let password = document.querySelector("#passwordUser").value;
    createUser(full_name, username, password);
    let msg = document.getElementById("success-create");
    msg.innerHTML = "New user created successfully!"
  })
  
  //log-in user elements
  document.querySelector("#loginSubmit").addEventListener("click", (event) => {
    document.querySelector("#full_name").value;
    let username = document.querySelector("#usernameLogin").value;
    let password = document.querySelector("#passwordLogin").value;
    login(username, password);
  })
  
  
  function createUser(full_name, username, password) {
    const data = {full_name: full_name, user_name: username, password: password};
    console.log(data);
    fetch("http://localhost:81/users/create", {
        method: 'post',
        headers: {
          "Content-type": "application/json"
        },
        body: JSON.stringify(data)
      })
      .then(function (data) {
        console.log('Success', data);
      })
      .catch(function (error) {
        console.log('Request failed', error);
      });
  }
  
  function login(username, password) {

      fetch("http://localhost:81/users/read-name/" + username)
          .then((response => {
            if(response.status !== 202){
              console.error(`status: ${response.status}`);
              document.getElementById("loginAlert").innerHTML = "Login Failed!";
              return;
            }
            return response.json();
          })) 
          .then(data => checkUser(data, password))
          .catch(error => console.error(error))
          .finally(() => { console.log("All OK!"); });
  }

  function checkUser(data, password){
          console.log(data);
            if(data.length == 0){
              document.getElementById("loginAlert").innerHTML = "User Not Found!";
              return;
            }
            var fullname;
            var userID = data.id;
            for(var key in data){
              if(key == "full_name"){
               fullname = data[key];
              }
              if(key == "password"){
                if(password == data[key]){
                  document.cookie = "username="+ fullname + ";" + "path=/";
                  document.cookie = "id=" + userID + ";" + "path=/";
                  document.getElementById("loginAlert").innerHTML = "Successfully Logged In!";
                  console.log(fullname);
                  console.log(userID);
                  return;
                }
                else {
                  document.getElementById("loginAlert").innerHTML = "Login Unsuccessful!";
                  return;
                }
              }
            }
  }
  