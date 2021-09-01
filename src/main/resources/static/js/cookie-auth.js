document.querySelector('button[id="logOutBtn"]').addEventListener("click", function (stop) {
    deleteCookie("username", "/");
  })
  
  function deleteCookie(name, path) {
    if (get_cookie(name)) {
      document.cookie = name + "=" +
        ((path) ? ";path=" + path : "") +
        ";expires=Thu, 01 Jan 1970 00:00:01 GMT";
      console.log("log out successfully");
      window.location.href = "index.html";
    }
  }
  
  function get_cookie(name) {
    return document.cookie.split(';').some(c => {
      return c.trim().startsWith(name + '=');
    });
  }
  function get_cookie_value(name) {
    const value = `; ${document.cookie}`;
    const parts = value.split(`; ${name}=`);
    if (parts.length === 2) return parts.pop().split(';').shift();
  }

let user = document.cookie;
console.log(user)
var userBtn = document.getElementById("userLoggedInBtn");
var guestBtn = document.getElementById("guestLoggedInBtn");
var userSection = document.getElementById("guestLoggedInSection");


//if user logged in then change hidden button
if(user!= ""){
    guestBtn.style.display = "none";
    userBtn.style.display = "block";
    userSection.style.display = "flex";

}
else{
    guestBtn.style.display = "block";
    userBtn.style.display = "none";
    userSection.style.display = "none";
}