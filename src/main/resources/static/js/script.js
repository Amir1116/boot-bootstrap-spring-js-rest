window.addEventListener('load',()=>{
     (new App('/api/users/')).start().then(r => console.log("start"));
})