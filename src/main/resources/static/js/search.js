function search(){
    searchLink = "/response.html?search=" + document.getElementById('searchField').value;
    window.location.href = searchLink;
    return false;
  }