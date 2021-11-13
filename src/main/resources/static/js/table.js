class Table {
    constructor(userlist) {
        this.userList = userlist;
    }


    createTable() {
        return `
    <div class="card me-3">
        <div class="card-header">
            All Users
        </div>
        <div class="border border-light p-2">
            <table class="table caption-top  border-2 bg-white table-hover" id="utable">
                <thead class="">
                <tr>
                    <th>ID</th>
                    <th>FirstName</th>
                    <th>LastName</th>
                    <th>Age</th>
                    <th>Email</th>
                    <th>Username</th>
                    <th>Role</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                     <tbody>
                           ${this.tbody(this.userList)}
                     </tbody>
                <tfoot>

                </tfoot>
            </table>
        </div>
    </div>
`;
    }


    tbody() {
        let body = '';
        this.userList.forEach(user => {
            body += this.tableRow(user.id, user.name, user.lastName, user.age, user.email, user.username, user.roleList)
        })
        let modal = new Modal('editModal','Edit user', "", 'btn btn-success btnSubmitEdit', "", "Edit").createModal();
        body += modal;
        let modalDelete = new Modal('deleteModal', 'Delete user', '', 'btn btn-danger deleteBtn', '', 'Delete').createModal();
        body += modalDelete;
        return body;
    }


    tableRow(getId,getName,getLastName,getAge, getEmail, getUsername, roleList){
        return `<tr>
                <td>${getId}</td>
                <td>${getName}</td>
                <td>${getLastName}</td>
                <td>${getAge}</td>
                <td>${getEmail}</td>
                <td>${getUsername}</td>
                <td>
                    ${this.showRole(roleList)}                   
                </td>
                <td>
                    <button 
                     class="btn btn-success btnedit"
                     data-bs-toggle="modal"
                     data-id = ${getId}
                     data-bs-target="#editModal"
               >Edit
                    </button>
                </td>
                <td>
                    <button 
                       class="btn btn-danger btndelete"
                       type="button" class="btn btn-danger" data-bs-toggle="modal"
                       data-id = ${getId}
                       data-bs-target="#deleteModal">Delete
                    </button>
                </td>
    </tr>
`;
    }

    showRole(roles){
        let list = '';
        roles.forEach(role =>{
            list +=`<span>${role.authority} </span>`;
        })
        return list;
    }
}