window.addEventListener('load',()=>{
    const formEdit = document.getElementById('formedit');
    const formDelete = document.getElementById('formdelete')
    const btnEditAll = document.querySelectorAll(".btnedit");
    const btnDeleteAll = document.querySelectorAll(".btndelete");
    btnEditAll.forEach(btn => clickHandler(btn, formEdit, '/admin/edit/', 'edit'  ))

    btnDeleteAll.forEach(btn => clickHandler(btn, formDelete, '/admin/delete/', 'delete'))

    function clickHandler(button, form, fUrl, iId){
        button.addEventListener('click',(e) => {
            e.preventDefault();
            let url = e.target.href;
            formatForm(url, form, fUrl, iId);
        })
    }


    async function formatForm(fetchUrl, form2, fUrl, iId){
       const res = await fetch(fetchUrl);
       const user = await res.json();
       console.log(user.id);
       setFormAction(form2, (fUrl + user.id));
       fillForm(iId, user.id, user.name, user.lastName, user.age, user.username, user.email)
    }

    function fillForm(iId, id, name, lastname, age,username, email){
        const inptId = document.getElementById(("inptId" + iId));
        const inptName = document.getElementById(("inptName" + iId));
        const inptLastName = document.getElementById(("inptLastName" + iId));
        const inptAge = document.getElementById(("inptAge" + iId));
        const inptUsername = document.getElementById(("inptUsername"+iId));
        const inptEmail = document.getElementById(("inptEmail"+iId));
        inptId.value = id;
        inptName.value = name;
        inptLastName.value = lastname;
        inptAge.value = age;
        inptUsername.value = username;
        inptEmail.value = email;
    }

    function setFormAction(form,url){
        form.action = url;
    }

})

console.log("js");