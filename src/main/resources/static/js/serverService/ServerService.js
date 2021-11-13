class ServerService{
    url = '';
    constructor() {
    }
    mainurl(value) {
        this.url = value;
    }

    async findAll(){
        try{
            return (await fetch(this.url)).json();
        }catch (e){
            console.error(e);
        }
    }

    async findById(id){
        try {
            let url = this.url
            return (await fetch(this.url+id)).json();
        }catch (e){
            console.error(e);
        }
    }

    async putUser(user){
        try {
            return (await  fetch(this.url,{method: 'PUT',
                                        headers: {
                                            'Content-type': 'application/json; charset=UTF-8'
                                        },
                                        body: JSON.stringify(user)
                                        }))
        }catch (e){
            console.error(e);
        }
    }

    async saveUser(user){
        try{
           return (await fetch(this.url,{
                method:"POST",
               headers: {
                   'Content-type': 'application/json; charset=UTF-8'
               },
                body: JSON.stringify(user)
            }))
        }catch (e){
            console.error(e);
        }
    }

    async deleteUser(id){
        try{
            await fetch(this.url+id,{
                method:"DELETE"
            })
        }catch (e){
            console.error(e);
        }
    }

}


