class App {
    serverService = new ServerService();

    constructor(url) {
        this.serverService.mainurl(url);
    }

    async start() {
        const tablAllUsers = document.getElementById('all');
        const allUsersBtn = document.getElementById("home-tab");
        await this.generateTable(tablAllUsers).then(() => console.log("all"));
        allUsersBtn.addEventListener('click', async ()=>{
            await this.generateTable(tablAllUsers).then(() => console.log("all"));
        })


        const profileTab = document.getElementById('profile-tab');
        const newUserTab = document.getElementById('newUserTab');
        profileTab.addEventListener('click', async (e) => {
            e.preventDefault();
            console.log('new active');
            this.newForm(newUserTab)
        })

        const btnNew = document.getElementById("btnNew");
        btnNew.addEventListener('click',async (e)=>{
            e.preventDefault();
            e.stopPropagation();
            let controller = new AbortController();
            const user = User.userFromFrom('newUser');
            const res = await this.serverService.saveUser(user);
            const userOUT = res.json();
            console.log(userOUT);
            this.newForm(newUserTab);
        })
    }

    async generateTable(el) {
        await this.showAllUsers()
            .then((table) => el.innerHTML = table)
            .then(async () => {
                this.addEditFunction('.btnedit');
                this.addDeleteFunction('.btndelete');
                const btnSubmitEdit = document.querySelector('.btnSubmitEdit');
                btnSubmitEdit.addEventListener('click', async (e) => {
                    const userForm = User.userFromFrom('edit').toJSON();
                    const put = await this.serverService.putUser(userForm);
                    const users = await put.json();
                    console.log(users);
                })
                const btnDelete =  document.querySelector('.deleteBtn');
                console.log(btnDelete);
                btnDelete.addEventListener('click',async (e)=>{
                    const userForm = User.userFromFrom('delete');
                    await this.serverService.deleteUser(userForm.id);
                })
                this.modalEdit(el);
                this.modalDelete(el);
            })
    }

    modalEdit(el) {
        const modalEdit = document.querySelector('#editModal');
        modalEdit.addEventListener('hidden.bs.modal', async () => {
            const users = await this.serverService.findAll();
            await this.generateTable(el);
        })
    }

    modalDelete(el){
        const modalDelete = document.querySelector('#deleteModal');
        modalDelete.addEventListener('hidden.bs.modal', async () =>{
            const users = await this.serverService.findAll();
            await this.generateTable(el)
        })
    }


    async showAllUsers() {
        const all = await this.serverService.findAll();
        return new Table(all).createTable();
    }

    addEditFunction(selector) {
        const elems = document.querySelectorAll(selector);
        elems.forEach(btn => {
            btn.addEventListener('click', async (e) => {
                e.preventDefault();
                console.log('edit')
                let id = (e.target).dataset.id;
                console.log(id);
                const formEdit = await this.serverService.findById(id).then(user => {
                    return new Form('edit', 'edit', 'edit', user.id, user.name, user.lastName, user.age, user.email, user.username, '').createForm();
                })
                const modal = document.querySelector('#editModal').querySelector(".modal-body");
                modal.innerHTML = formEdit;
            })
        })
    }

    addDeleteFunction(selector) {
        const elems = document.querySelectorAll(selector);
        elems.forEach(btn => {
            btn.addEventListener('click', async (e) => {
                e.preventDefault();
                let id = (e.target).dataset.id;
                const user = await this.serverService.findById(id);
                const formDelete = new Form('delete', 'delete', 'delete', user.id, user.name, user.lastName, user.age, user.email, user.username, 'disabled').createForm();
                const modalEditBody = document.getElementById("deleteModal").querySelector(".modal-body");
                modalEditBody.innerHTML = formDelete;
            })
        })
    }

    newForm(el){
       el.innerHTML = new Form('newUser',
            'newUser',
            'new',
            '',
            '',
            '',
            0,
            '',
            '',
            '').createForm();
    }
}