
function tableRow(getId,getName,getLastName,getAge, getEmail, getUsername, roleList){
    return `<tr>
                <td>${getId}</td>
                <td>${getName}</td>
                <td>${getLastName}</td>
                <td>${getAge}</td>
                <td>${getEmail}</td>
                <td>${getUsername}</td>
                <td>
                    ${showRole(roleList)}                   
                </td>
                <td>
                    <a href="/api/user/${getId}"
                     class="btn btn-success btnedit"
                     data-bs-toggle="modal"
                     data-bs-target="#edit">Edit
                    </a>
                </td>
                <td>
                    <a href="/api/user/${getId}"
                       class="btn btn-danger btndelete"
                       type="button" class="btn btn-danger" data-bs-toggle="modal"
                       data-bs-target="#delete">Delete
                    </a>
                </td>
    </tr>
`;
}

function showRole(roles){
    let list = '';
    roles.forEach(role =>{
        list +=`<span>${role.authority} </span>`;
    })
    return list;
}